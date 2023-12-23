[![Stand With Ukraine](https://raw.githubusercontent.com/vshymanskyy/StandWithUkraine/main/banner-direct-single.svg)](https://stand-with-ukraine.pp.ua)

# intellij-awk

[![Unit Tests](https://github.com/xonixx/intellij-awk/actions/workflows/run-tests.yml/badge.svg)](https://github.com/xonixx/intellij-awk/actions/workflows/run-tests.yml)

The missing IntelliJ IDEA language support plugin for [AWK](https://en.wikipedia.org/wiki/AWK)
  
![](screenshot1.png "Awk IDE")

## Motivation

- At the moment there ~~is~~was no AWK plugin for IDEA, which ~~is~~was a pity.
- Help me develop [some](https://github.com/xonixx/makesure) [of](https://github.com/xonixx/gron.awk) [my](https://github.com/xonixx/fhtagn) own projects in AWK.
- Interested to sharpen my Java skills and learn some IDEA internals.

## Goals v0.0.1 \[done]

- [x] Support basic AWK code highlighting
- Support basic AWK code navigations 
  - [x] show structure
  - [x] go to declaration
  - [x] find usages
- Support completion
  - [x] function names 
  - [x] variable names 
  - [x] keywords 
- [x] Support only POSIX subset (aka BWK), w/o Gawk additions (this can be added later)
- Refactoring support
  - [x] rename variable
  - [x] rename function
- [x] Basic auto-format

## Goals v0.2.0 \[done]

- [x] Add GAWK parsing mode

## Goals v0.3.0 \[done]

- [x] Enforce variable naming convention (the idea taken from [How I Write AWK Code](https://github.com/ttv1/aok/blob/master/docs/codingtips.md#debugging-tools))
  - [x] `name` for local
  - [x] `Name` for global
- [x] Showing parameter hints for functions (Ctrl-P)
- [x] Showing documentation for built-in functions
- [x] Showing documentation for built-in variables (`NR`/`NF`/etc.)
    
## Parser quirks
               
Please note, due to very ad-hoc nature of AWK syntax (namely some inherent ambiguities in its grammar) the implemented IntelliJ IDEA AWK parser has some minor limitations.

More details in [parser_quirks.md](doc/parser_quirks.md)

## Implementation details

The chosen approach to variables resolution described in [variables_resolution.md](doc/variables_resolution.md) 

## Useful links

- BWK https://github.com/onetrueawk/awk
- [Custom language support JetBrains tutorial](https://plugins.jetbrains.com/docs/intellij/custom-language-support.html)
- [Grammar-Kit tutorial](https://github.com/JetBrains/Grammar-Kit/blob/master/TUTORIAL.md)
- [JFlex manual](https://www.jflex.de/manual.html)
- Grammar:
    - [AWK Grammar in Yacc from BWK](https://github.com/onetrueawk/awk/blob/master/awkgram.y)
    - [AWK Grammar in Yacc from Gawk](http://git.savannah.gnu.org/cgit/gawk.git/tree/awkgram.y)
    - https://slebok.github.io/zoo/#awk
        - [EBNF Grammar](https://github.com/slebok/zoo/blob/master/zoo/awk/manual/fetched/src.grammar.txt)
        - https://pubs.opengroup.org/onlinepubs/7908799/xcu/awk.html#tag_000_000_108_016
    - [AWK.sublime-syntax](https://github.com/JohnNilsson/awk-sublime/blob/master/AWK.sublime-syntax)
        - [Explanation](https://www.sublimetext.com/docs/3/syntax.html)
- Some other language plugins
    - [Zig](https://github.com/ice1000/intellij-zig) `Kotlin`
    - [Solidity](https://github.com/intellij-solidity/intellij-solidity) `Kotlin`
    - [D language](https://github.com/intellij-dlanguage/intellij-dlanguage) `Java` `Kotlin`
    - [Haxe](https://github.com/HaxeFoundation/intellij-haxe) `Java`
    - [Erlang](https://github.com/ignatov/intellij-erlang) `Java` 
    - [Elixir](https://github.com/KronicDeth/intellij-elixir) `Kotlin` `Java`
    - [Rust](https://github.com/intellij-rust/intellij-rust) `Kotlin`
    - [Bash](https://github.com/BashSupport/BashSupport) `Java`
    - [Zephir](https://github.com/zephir-lang/idea-plugin) `Kotlin`
    - [IDEA sh](https://github.com/JetBrains/intellij-community/tree/master/plugins/sh) `Java`
    - [IDEA properties](https://github.com/JetBrains/intellij-community/tree/master/plugins/properties) `Java` 
