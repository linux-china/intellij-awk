package intellij_awk;

import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

import java.util.List;

public class AwkInspectionTests extends BasePlatformTestCase {

  private final Inspection unusedFunctionParam =
      new Inspection(
          new AwkInspectionUnusedFunctionParam(), AwkInspectionUnusedFunctionParam.QUICK_FIX_NAME);

  private final Inspection unusedFunction =
      new Inspection(new AwkInspectionUnusedFunction(), AwkInspectionUnusedFunction.QUICK_FIX_NAME);

  private final Inspection declareLocalInspection =
      new Inspection(new AwkInspectionVariablesNaming(), AwkInspectionVariablesNaming.QUICK_FIX_DECLARE_LOCAL);

  public void testUnusedFunctionParam1() {
    checkByFile(unusedFunctionParam);
  }

  public void testUnusedFunctionParam2_0() {
    checkByFile(unusedFunctionParam);
  }

  public void testUnusedFunctionParam2_1() {
    checkByFile(unusedFunctionParam);
  }

  public void testUnusedFunctionParam3_0() {
    checkByFile(unusedFunctionParam);
  }

  public void testUnusedFunctionParam3_1() {
    checkByFile(unusedFunctionParam);
  }

  public void testUnusedFunctionParam4() {
    checkByFile(unusedFunctionParam);
  }

  public void testUnusedFunction1() {
    checkByFile(unusedFunction);
  }

  public void testDeclareLocal1() {
    checkByFile(declareLocalInspection);
  }

  public void testDeclareLocal2_0() {
    checkByFile(declareLocalInspection);
  }

  public void testDeclareLocal2_1() {
    checkByFile(declareLocalInspection);
  }

  public void testDeclareLocal2_2() {
    checkByFile(declareLocalInspection);
  }

  @Override
  protected String getTestDataPath() {
    return "src/test/testData/inspection";
  }

  private void checkByFile(Inspection inspection) {
    String before = getTestName(true) + ".awk";
    String after = before.replace(".awk", "After.awk");
    myFixture.configureByFile(before);

    myFixture.enableInspections(inspection.inspection);
    List<HighlightInfo> highlightInfos = myFixture.doHighlighting();
    assertFalse(highlightInfos.isEmpty());
    // Get the quick fix action for comparing references inspection and apply it to the file
    final IntentionAction action = myFixture.findSingleIntention(inspection.quickFixName);
    assertNotNull(action);
    myFixture.launchAction(action);

    myFixture.checkResultByFile(after, true);
  }

  private static class Inspection {
    final LocalInspectionTool inspection;
    final String quickFixName;

    Inspection(LocalInspectionTool inspection, String quickFixName) {
      this.inspection = inspection;
      this.quickFixName = quickFixName;
    }
  }
}