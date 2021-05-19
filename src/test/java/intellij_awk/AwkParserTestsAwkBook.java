package intellij_awk;

import com.intellij.testFramework.ParsingTestCase;
import org.jetbrains.annotations.NotNull;

public class AwkParserTestsAwkBook extends ParsingTestCase {
  public AwkParserTestsAwkBook() {
    super("parser/awk_book", "awk", new AwkParserDefinition());
  }

  @Override
  protected String getTestDataPath() {
    return "src/test/testData";
  }

  @Override
  protected @NotNull String getTestName(boolean lowercaseFirstLetter) {
    return super.getTestName(lowercaseFirstLetter).toLowerCase();
  }

  /*
  awk -F';' '{ printf "public void testTest%s() { ensureOnlyParsingNoErrors(); }\n", $1 }' awk_book.txt
   */
  public void testTest0() { ensureOnlyParsingNoErrors(); }
  public void testTest1() { ensureOnlyParsingNoErrors(); }
  public void testTest2() { ensureOnlyParsingNoErrors(); }
  public void testTest3() { ensureOnlyParsingNoErrors(); }
  public void testTest4() { ensureOnlyParsingNoErrors(); }
  public void testTest5() { ensureOnlyParsingNoErrors(); }
  public void testTest6() { ensureOnlyParsingNoErrors(); }
  public void testTest7() { ensureOnlyParsingNoErrors(); }
  public void testTest8() { ensureOnlyParsingNoErrors(); }
  public void testTest9() { ensureOnlyParsingNoErrors(); }
  public void testTest10() { ensureOnlyParsingNoErrors(); }
  public void testTest11() { ensureOnlyParsingNoErrors(); }
  public void testTest12() { ensureOnlyParsingNoErrors(); }
  public void testTest13() { ensureOnlyParsingNoErrors(); }
  public void testTest14() { ensureOnlyParsingNoErrors(); }
  public void testTest15() { ensureOnlyParsingNoErrors(); }
  public void testTest16() { ensureOnlyParsingNoErrors(); }
  public void testTest17() { ensureOnlyParsingNoErrors(); }
  public void testTest18() { ensureOnlyParsingNoErrors(); }
  public void testTest19() { ensureOnlyParsingNoErrors(); }
  public void testTest20() { ensureOnlyParsingNoErrors(); }
  public void testTest21() { ensureOnlyParsingNoErrors(); }
  public void testTest22() { ensureOnlyParsingNoErrors(); }
  public void testTest23() { ensureOnlyParsingNoErrors(); }
  public void testTest24() { ensureOnlyParsingNoErrors(); }
  public void testTest25() { ensureOnlyParsingNoErrors(); }
  public void testTest26() { ensureOnlyParsingNoErrors(); }
  public void testTest27() { ensureOnlyParsingNoErrors(); }
  public void testTest28() { ensureOnlyParsingNoErrors(); }
  public void testTest29() { ensureOnlyParsingNoErrors(); }
  public void testTest30() { ensureOnlyParsingNoErrors(); }
  public void testTest31() { ensureOnlyParsingNoErrors(); }
  public void testTest32() { ensureOnlyParsingNoErrors(); }
  public void testTest33() { ensureOnlyParsingNoErrors(); }
  public void testTest34() { ensureOnlyParsingNoErrors(); }
  public void testTest35() { ensureOnlyParsingNoErrors(); }
  public void testTest36() { ensureOnlyParsingNoErrors(); }
  public void testTest37() { ensureOnlyParsingNoErrors(); }
  public void testTest38() { ensureOnlyParsingNoErrors(); }
  public void testTest39() { ensureOnlyParsingNoErrors(); }
  public void testTest40() { ensureOnlyParsingNoErrors(); }
  public void testTest41() { ensureOnlyParsingNoErrors(); }
  public void testTest42() { ensureOnlyParsingNoErrors(); }
  public void testTest43() { ensureOnlyParsingNoErrors(); }
  public void testTest44() { ensureOnlyParsingNoErrors(); }
  public void testTest45() { ensureOnlyParsingNoErrors(); }
  public void testTest46() { ensureOnlyParsingNoErrors(); }
  public void testTest47() { ensureOnlyParsingNoErrors(); }
  public void testTest48() { ensureOnlyParsingNoErrors(); }
  public void testTest49() { ensureOnlyParsingNoErrors(); }
  public void testTest50() { ensureOnlyParsingNoErrors(); }
  public void testTest51() { ensureOnlyParsingNoErrors(); }
  public void testTest52() { ensureOnlyParsingNoErrors(); }
  public void testTest53() { ensureOnlyParsingNoErrors(); }
  public void testTest54() { ensureOnlyParsingNoErrors(); }
  public void testTest55() { ensureOnlyParsingNoErrors(); }
  public void testTest56() { ensureOnlyParsingNoErrors(); }
  public void testTest57() { ensureOnlyParsingNoErrors(); }
  public void testTest58() { ensureOnlyParsingNoErrors(); }
  public void testTest59() { ensureOnlyParsingNoErrors(); }
  public void testTest60() { ensureOnlyParsingNoErrors(); }
  public void testTest61() { ensureOnlyParsingNoErrors(); }
  public void testTest62() { ensureOnlyParsingNoErrors(); }
  public void testTest63() { ensureOnlyParsingNoErrors(); }
  public void testTest64() { ensureOnlyParsingNoErrors(); }
  public void testTest65() { ensureOnlyParsingNoErrors(); }
  public void testTest66() { ensureOnlyParsingNoErrors(); }
  public void testTest67() { ensureOnlyParsingNoErrors(); }
  public void testTest68() { ensureOnlyParsingNoErrors(); }
  public void testTest69() { ensureOnlyParsingNoErrors(); }
  public void testTest70() { ensureOnlyParsingNoErrors(); }
  public void testTest71() { ensureOnlyParsingNoErrors(); }
  public void testTest72() { ensureOnlyParsingNoErrors(); }
  public void testTest73() { ensureOnlyParsingNoErrors(); }
  public void testTest74() { ensureOnlyParsingNoErrors(); }
  public void testTest75() { ensureOnlyParsingNoErrors(); }
  public void testTest76() { ensureOnlyParsingNoErrors(); }
  public void testTest77() { ensureOnlyParsingNoErrors(); }
  public void testTest78() { ensureOnlyParsingNoErrors(); }
  public void testTest79() { ensureOnlyParsingNoErrors(); }
  public void testTest80() { ensureOnlyParsingNoErrors(); }
  public void testTest81() { ensureOnlyParsingNoErrors(); }
  public void testTest82() { ensureOnlyParsingNoErrors(); }
  public void testTest83() { ensureOnlyParsingNoErrors(); }
  public void testTest84() { ensureOnlyParsingNoErrors(); }
  public void testTest85() { ensureOnlyParsingNoErrors(); }
  public void testTest86() { ensureOnlyParsingNoErrors(); }
  public void testTest87() { ensureOnlyParsingNoErrors(); }
  public void testTest88() { ensureOnlyParsingNoErrors(); }
  public void testTest89() { ensureOnlyParsingNoErrors(); }
  public void testTest90() { ensureOnlyParsingNoErrors(); }
  public void testTest91() { ensureOnlyParsingNoErrors(); }
  public void testTest92() { ensureOnlyParsingNoErrors(); }
  public void testTest93() { ensureOnlyParsingNoErrors(); }
  public void testTest94() { ensureOnlyParsingNoErrors(); }
  public void testTest95() { ensureOnlyParsingNoErrors(); }
  public void testTest96() { ensureOnlyParsingNoErrors(); }
  public void testTest97() { ensureOnlyParsingNoErrors(); }
  public void testTest98() { ensureOnlyParsingNoErrors(); }
  public void testTest99() { ensureOnlyParsingNoErrors(); }
  public void testTest100() { ensureOnlyParsingNoErrors(); }
  public void testTest101() { ensureOnlyParsingNoErrors(); }
  public void testTest102() { ensureOnlyParsingNoErrors(); }
  public void testTest103() { ensureOnlyParsingNoErrors(); }
  public void testTest104() { ensureOnlyParsingNoErrors(); }
  public void testTest105() { ensureOnlyParsingNoErrors(); }
  public void testTest106() { ensureOnlyParsingNoErrors(); }
  public void testTest107() { ensureOnlyParsingNoErrors(); }
  public void testTest108() { ensureOnlyParsingNoErrors(); }
  public void testTest109() { ensureOnlyParsingNoErrors(); }
  public void testTest110() { ensureOnlyParsingNoErrors(); }
  public void testTest111() { ensureOnlyParsingNoErrors(); }
  public void testTest112() { ensureOnlyParsingNoErrors(); }
  public void testTest113() { ensureOnlyParsingNoErrors(); }
  public void testTest114() { ensureOnlyParsingNoErrors(); }
  public void testTest115() { ensureOnlyParsingNoErrors(); }
  public void testTest116() { ensureOnlyParsingNoErrors(); }
  public void testTest117() { ensureOnlyParsingNoErrors(); }
  public void testTest118() { ensureOnlyParsingNoErrors(); }
  public void testTest119() { ensureOnlyParsingNoErrors(); }
  public void testTest120() { ensureOnlyParsingNoErrors(); }
  public void testTest121() { ensureOnlyParsingNoErrors(); }
  public void testTest122() { ensureOnlyParsingNoErrors(); }
  public void testTest123() { ensureOnlyParsingNoErrors(); }
  public void testTest124() { ensureOnlyParsingNoErrors(); }
  public void testTest125() { ensureOnlyParsingNoErrors(); }
  public void testTest126() { ensureOnlyParsingNoErrors(); }
  public void testTest127() { ensureOnlyParsingNoErrors(); }
  public void testTest128() { ensureOnlyParsingNoErrors(); }
  public void testTest129() { ensureOnlyParsingNoErrors(); }
  public void testTest130() { ensureOnlyParsingNoErrors(); }
  public void testTest131() { ensureOnlyParsingNoErrors(); }
  public void testTest132() { ensureOnlyParsingNoErrors(); }
  public void testTest133() { ensureOnlyParsingNoErrors(); }
  public void testTest134() { ensureOnlyParsingNoErrors(); }
  public void testTest135() { ensureOnlyParsingNoErrors(); }
  public void testTest136() { ensureOnlyParsingNoErrors(); }
  public void testTest137() { ensureOnlyParsingNoErrors(); }
  public void testTest138() { ensureOnlyParsingNoErrors(); }
  public void testTest139() { ensureOnlyParsingNoErrors(); }
  public void testTest140() { ensureOnlyParsingNoErrors(); }
  public void testTest141() { ensureOnlyParsingNoErrors(); }
  public void testTest142() { ensureOnlyParsingNoErrors(); }
  public void testTest143() { ensureOnlyParsingNoErrors(); }
  public void testTest144() { ensureOnlyParsingNoErrors(); }
  public void testTest145() { ensureOnlyParsingNoErrors(); }
  public void testTest146() { ensureOnlyParsingNoErrors(); }
  public void testTest147() { ensureOnlyParsingNoErrors(); }
  public void testTest148() { ensureOnlyParsingNoErrors(); }
  public void testTest149() { ensureOnlyParsingNoErrors(); }
  public void testTest150() { ensureOnlyParsingNoErrors(); }
  public void testTest151() { ensureOnlyParsingNoErrors(); }
  public void testTest152() { ensureOnlyParsingNoErrors(); }
  public void testTest153() { ensureOnlyParsingNoErrors(); }
  public void testTest154() { ensureOnlyParsingNoErrors(); }
  public void testTest155() { ensureOnlyParsingNoErrors(); }
  public void testTest156() { ensureOnlyParsingNoErrors(); }
  public void testTest157() { ensureOnlyParsingNoErrors(); }
  public void testTest158() { ensureOnlyParsingNoErrors(); }
  public void testTest159() { ensureOnlyParsingNoErrors(); }
  public void testTest160() { ensureOnlyParsingNoErrors(); }
  public void testTest161() { ensureOnlyParsingNoErrors(); }
  public void testTest162() { ensureOnlyParsingNoErrors(); }
  public void testTest163() { ensureOnlyParsingNoErrors(); }
  public void testTest164() { ensureOnlyParsingNoErrors(); }
  public void testTest165() { ensureOnlyParsingNoErrors(); }
  public void testTest166() { ensureOnlyParsingNoErrors(); }
  public void testTest167() { ensureOnlyParsingNoErrors(); }
  public void testTest168() { ensureOnlyParsingNoErrors(); }
  public void testTest169() { ensureOnlyParsingNoErrors(); }
  public void testTest170() { ensureOnlyParsingNoErrors(); }
  public void testTest171() { ensureOnlyParsingNoErrors(); }
  public void testTest172() { ensureOnlyParsingNoErrors(); }
  public void testTest173() { ensureOnlyParsingNoErrors(); }
  public void testTest174() { ensureOnlyParsingNoErrors(); }
  public void testTest175() { ensureOnlyParsingNoErrors(); }
  public void testTest176() { ensureOnlyParsingNoErrors(); }
  public void testTest177() { ensureOnlyParsingNoErrors(); }
  public void testTest178() { ensureOnlyParsingNoErrors(); }
  public void testTest179() { ensureOnlyParsingNoErrors(); }
  public void testTest180() { ensureOnlyParsingNoErrors(); }
  public void testTest181() { ensureOnlyParsingNoErrors(); }
  public void testTest182() { ensureOnlyParsingNoErrors(); }
  public void testTest183() { ensureOnlyParsingNoErrors(); }
  public void testTest184() { ensureOnlyParsingNoErrors(); }
  public void testTest185() { ensureOnlyParsingNoErrors(); }
  public void testTest186() { ensureOnlyParsingNoErrors(); }
  public void testTest187() { ensureOnlyParsingNoErrors(); }
  public void testTest188() { ensureOnlyParsingNoErrors(); }
  public void testTest189() { ensureOnlyParsingNoErrors(); }
  public void testTest190() { ensureOnlyParsingNoErrors(); }
  public void testTest191() { ensureOnlyParsingNoErrors(); }
  public void testTest192() { ensureOnlyParsingNoErrors(); }
  public void testTest193() { ensureOnlyParsingNoErrors(); }
  public void testTest194() { ensureOnlyParsingNoErrors(); }
  public void testTest195() { ensureOnlyParsingNoErrors(); }
  public void testTest196() { ensureOnlyParsingNoErrors(); }
  public void testTest197() { ensureOnlyParsingNoErrors(); }
  public void testTest198() { ensureOnlyParsingNoErrors(); }
  public void testTest199() { ensureOnlyParsingNoErrors(); }

  private void ensureOnlyParsingNoErrors() {
    doTest(false);
    ensureNoErrorElements();
  }
}