package intellij_awk;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static intellij_awk.psi.AwkTypes.*;

%%

%{
  public AwkLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class AwkLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R

COMMENT=#.* | (\\\n)
BUILTIN_FUNC_NAME=atan2|cos|sin|exp|log|sqrt|int|rand|srand|gsub|index|length|match|split|sprintf|sub|substr|tolower|toupper|close|fflush|system
BUILTIN_FUNC_NAME_GAWK=asort|asorti|gensub|patsplit|strtonum|mktime|strftime|systime|and|compl|lshift|or|rshift|xor|isarray|typeof|bindtextdomain|dcgettext|dcngettext
BUILTIN_FUNC_NAME_ZAWK=char_at|last_part|parse|rparse|match|hex|bf_insert|bf_contains|join_fields|join_csv|join_tsv|strtonum|trim|truncate|capitalize|uncapitalize|camel_case|kebab_case|snake_case|title_case|isint|isnum|mask|pad|pad_start|pad_end|strcmp|words|repeat|default_if_empty | append_if_missing | prepend_if_missing | remove_if_begin | remove_if_end | double_quote | quote |escape|escape_csv|escape_tsv|url|data_url|shlex|path|semver|pairs|record|message|flags|tuple|variant|parse_array|func|uuid|ulid|snowflake|seq|uniq|asort|_max|_min|_sum|_mean|_join|abs|floor|ceil|round|min|max|fend|mkbool|int|float|to_json|from_json|to_csv|from_csv|encode|decode|digest|hmac|jwt|dejwt|encrypt|decrypt|kv_get|kv_put|kv_delete|kv_clear|local_ip|http_get|http_post|s3_get|s3_put|publish|sqlite_query|sqlite_execute|mysql_query|mysql_execute|datetime|version|whoami|os|arch|os_family|pwd|user_home|read_all|write_all|var_dump|log_debug|log_info|log_warn|log_error
NUMBER=( \d+ | (\d* \. \d+) | (\d+ \. \d*) ) ([eE] [+-]? \d+)?
STRING=([\"]([^\"\n\\]|\\.|\\\n)*[\"])
ERE="/"((\[\^?\/)|[^\\\n/]|(\\[^\n]))*"/"
TYPED_ERE=@{ERE}
NEWLINE=\r\n|\n
NS_PART=[a-zA-Z_]+[a-zA-Z_\d]*::
SPECIAL_VAR_NAME      = {NS_PART}? (ARGC|ARGV|CONVFMT|ENVIRON|FILENAME|FNR|FS|NF|NR|OFMT|OFS|ORS|RLENGTH|RS|RSTART|SUBSEP)
SPECIAL_VAR_NAME_GAWK = {NS_PART}? (BINMODE|FIELDWIDTHS|FPAT|IGNORECASE|LINT|PREC|ROUNDMODE|TEXTDOMAIN|ARGIND|ERRNO|FUNCTAB|PROCINFO|RT|SYMTAB)
VAR_NAME              = {NS_PART}? [a-zA-Z_]+[a-zA-Z_\d]*
//LIVEPREVIEWWS=[ \t]*(\\\n)*
WHITE_SPACE=[ \t]+

%state AFTER_BEGIN_END
%state AFTER_AT
%state DIV_POSSIBLE

%%
// In AWK the '{' should go on the same line with BEGIN/END
<AFTER_BEGIN_END> {
  {WHITE_SPACE}            { return WHITE_SPACE; }
  "{"                      { yybegin(YYINITIAL); return LBRACE; }
}

<AFTER_AT> {
  "namespace"              { yybegin(YYINITIAL); return NAMESPACE; }
  "include"                { yybegin(YYINITIAL); return INCLUDE; }
  "load"                   { yybegin(YYINITIAL); return LOAD; }
  {VAR_NAME}          /\(  { yybegin(YYINITIAL); return VAR_NAME; }
}

<YYINITIAL, DIV_POSSIBLE, AFTER_AT> {
  {WHITE_SPACE}            { return WHITE_SPACE; }

  "BEGINFILE" /\(?         { yybegin(AFTER_BEGIN_END); return BEGINFILE; }
  "ENDFILE"   /\(?         { yybegin(AFTER_BEGIN_END); return ENDFILE; }
  "BEGIN"     /\(?         { yybegin(AFTER_BEGIN_END); return BEGIN; }
  "END"       /\(?         { yybegin(AFTER_BEGIN_END); return END; }
  "break"     /\(?         { yybegin(YYINITIAL); return BREAK; }
  "continue"  /\(?         { yybegin(YYINITIAL); return CONTINUE; }
  "delete"    /\(?         { yybegin(YYINITIAL); return DELETE; }
  "do"        /\(?         { yybegin(YYINITIAL); return DO; }
  "else"      /\(?         { yybegin(YYINITIAL); return ELSE; }
  "exit"      /\(?         { yybegin(YYINITIAL); return EXIT; }
  "for"       /\(?         { yybegin(YYINITIAL); return FOR; }
  "function"  /\(?         { yybegin(YYINITIAL); return FUNCTION; }
  "func"      /\(?         { yybegin(YYINITIAL); return FUNCTION; }
  "if"        /\(?         { yybegin(YYINITIAL); return IF; }
  "in"        /\(?         { yybegin(YYINITIAL); return IN; }
  "nextfile"  /\(?         { yybegin(YYINITIAL); return NEXTFILE; }
  "next"      /\(?         { yybegin(YYINITIAL); return NEXT; }
  "print"     /\(?         { yybegin(YYINITIAL); return PRINT; }
  "printf"    /\(?         { yybegin(YYINITIAL); return PRINTF; }
  "return"    /\(?         { yybegin(YYINITIAL); return RETURN; }
  "while"     /\(?         { yybegin(YYINITIAL); return WHILE; }
  "switch"    /\(?         { yybegin(YYINITIAL); return SWITCH; }
  "case"                   { yybegin(YYINITIAL); return CASE; }
  "default"                { yybegin(YYINITIAL); return DEFAULT; }
  "getline"   /\(?         { yybegin(DIV_POSSIBLE); return GETLINE; }
  "+="                     { yybegin(YYINITIAL); return ADD_ASSIGN; }
  "-="                     { yybegin(YYINITIAL); return SUB_ASSIGN; }
  "*="                     { yybegin(YYINITIAL); return MUL_ASSIGN; }
  "/="                     { yybegin(YYINITIAL); return DIV_ASSIGN; }
  "%="                     { yybegin(YYINITIAL); return MOD_ASSIGN; }
  "^="                     { yybegin(YYINITIAL); return POW_ASSIGN; }
  "||"                     { yybegin(YYINITIAL); return OR; }
  "&&"                     { yybegin(YYINITIAL); return AND; }
  "!~"                     { yybegin(YYINITIAL); return NO_MATCH; }
  "=="                     { yybegin(YYINITIAL); return EQ; }
  "<="                     { yybegin(YYINITIAL); return LE; }
  ">="                     { yybegin(YYINITIAL); return GE; }
  "!="                     { yybegin(YYINITIAL); return NE; }
  "++"                     { yybegin(YYINITIAL); return INCR; }
  "--"                     { yybegin(YYINITIAL); return DECR; }
  ">>"                     { yybegin(YYINITIAL); return APPEND; }
  "$"                      { yybegin(YYINITIAL); return DOLLAR; }
  "["                      { yybegin(YYINITIAL); return LBRACKET; }
  "]"                      { yybegin(DIV_POSSIBLE); return RBRACKET; }
  "{"                      { yybegin(YYINITIAL); return LBRACE; }
  "}"                      { yybegin(YYINITIAL); return RBRACE; }
  "("                      { yybegin(YYINITIAL); return LPAREN; }
  ")"                      { yybegin(DIV_POSSIBLE); return RPAREN; }
  ","                      { yybegin(YYINITIAL); return COMMA; }
  ";"                      { yybegin(YYINITIAL); return SEMICOLON; }
  "<"                      { yybegin(YYINITIAL); return LT; }
  ">"                      { yybegin(YYINITIAL); return GT; }
  "+"                      { yybegin(YYINITIAL); return ADD; }
  "-"                      { yybegin(YYINITIAL); return SUB; }
  "*"                      { yybegin(YYINITIAL); return MUL; }
  "/"                      { yybegin(YYINITIAL); return DIV; }
  "%"                      { yybegin(YYINITIAL); return MOD; }
  "^"                      { yybegin(YYINITIAL); return POW; }
  "~"                      { yybegin(YYINITIAL); return MATCH; }
  "|&"                     { yybegin(YYINITIAL); return PIPE_AMP; }
  "|"                      { yybegin(YYINITIAL); return PIPE; }
  "!"                      { yybegin(YYINITIAL); return NOT; }
  "?"                      { yybegin(YYINITIAL); return QUESTION; }
  ":"                      { yybegin(YYINITIAL); return COLON; }
  "="                      { yybegin(YYINITIAL); return ASSIGN; }
  "@"                      { yybegin(AFTER_AT); return AT; }

  {COMMENT}                     { return COMMENT; }
  {NUMBER}                      { yybegin(DIV_POSSIBLE); return NUMBER; }
  {STRING}                      { yybegin(DIV_POSSIBLE); return STRING; }
  {TYPED_ERE}                   { yybegin(YYINITIAL); return TYPED_ERE; }
  {NEWLINE}                     { yybegin(YYINITIAL); return NEWLINE; }
  {BUILTIN_FUNC_NAME}      /\(? { yybegin(YYINITIAL); return BUILTIN_FUNC_NAME; }
  {BUILTIN_FUNC_NAME_GAWK} /\(? { yybegin(YYINITIAL); return BUILTIN_FUNC_NAME_GAWK; }
  {BUILTIN_FUNC_NAME_ZAWK} /\(? { yybegin(YYINITIAL); return BUILTIN_FUNC_NAME_ZAWK; }
  {VAR_NAME}               /\(  { yybegin(YYINITIAL); return FUNC_NAME; }
  {SPECIAL_VAR_NAME}            { yybegin(DIV_POSSIBLE); return SPECIAL_VAR_NAME; }
  {SPECIAL_VAR_NAME_GAWK}       { yybegin(DIV_POSSIBLE); return SPECIAL_VAR_NAME_GAWK; }
  {VAR_NAME}                    { yybegin(DIV_POSSIBLE); return VAR_NAME; }
//  {LIVEPREVIEWWS}          { return LIVEPREVIEWWS; }

}

<YYINITIAL> {
  {ERE}                         { return ERE; }
}

[^] { return BAD_CHARACTER; }
