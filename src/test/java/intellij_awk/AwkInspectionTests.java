package intellij_awk;

import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class AwkInspectionTests extends BasePlatformTestCase {

  private final Inspection unusedFunctionParam =
      new Inspection(
          new AwkInspectionUnusedFunctionParam(), AwkInspectionUnusedFunctionParam.QUICK_FIX_NAME);

  private final Inspection unusedFunction =
      new Inspection(new AwkInspectionUnusedFunction(), AwkInspectionUnusedFunction.QUICK_FIX_NAME);

  private final Inspection unusedGlobalVariable =
      new Inspection(
          new AwkInspectionUnusedGlobalVariable(),
          AwkInspectionUnusedGlobalVariable.QUICK_FIX_NAME);

  private final Inspection unresolvedFunctionCall =
      new Inspection(
          new AwkInspectionUnresolvedFunction(), AwkInspectionUnresolvedFunction.QUICK_FIX_NAME);
  private final Inspection unresolvedInclude =
      new Inspection(new AwkInspectionUnresolvedInclude(), null);

  private final Inspection duplicateFunction =
      new Inspection(new AwkInspectionDuplicateFunction(), null);

  private final Inspection declareLocal =
      new Inspection(
          new AwkInspectionDeclareLocalVariable(),
          AwkInspectionDeclareLocalVariable.QUICK_FIX_NAME);

  private final Inspection enforceGlobalVarNaming =
      new Inspection(
          new AwkInspectionEnforceGlobalVariableNaming(),
          AwkInspectionEnforceGlobalVariableNaming.QUICK_FIX_NAME);

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

  public void testUnusedFunctionParamNoProblem1() {
    checkByFileNoProblemAtCaret(unusedFunctionParam);
  }

  public void testUnusedFunction1() {
    checkByFile(unusedFunction);
  }

  public void testUnusedFunction2Recursive() {
    checkByFile(unusedFunction);
  }

  public void testUsedFunctionFileOutsideProject() {
    checkByFileNoProblemAtCaret(unusedFunction, true);
  }

  public void testUnusedGlobalVar1_0() {
    checkByFile(unusedGlobalVariable);
  }

  public void testUnusedGlobalVar1_1() {
    checkByFile(unusedGlobalVariable);
  }

  public void testUnusedGlobalVar2_0() {
    checkByFile(unusedGlobalVariable);
  }

  public void testUnusedGlobalVar2_1() {
    checkByFile(unusedGlobalVariable);
  }

  public void testUnusedGlobalVar2_2() {
    checkByFile(unusedGlobalVariable);
  }

  public void testUnusedGlobalVar3() {
    checkByFile(unusedGlobalVariable);
  }

  public void testUnusedGlobalVar4() {
    checkByFile(unusedGlobalVariable);
  }

  public void testUnusedGlobalVarNoProblem1() {
    checkByFileNoProblemAtCaret(unusedGlobalVariable);
  }

  public void testUnusedGlobalVarNoProblem2() {
    checkByFileNoProblemAtCaret(unusedGlobalVariable);
  }

  public void testUnusedGlobalVarNoProblem3() {
    checkByFileNoProblemAtCaret(unusedGlobalVariable);
  }

  public void testUnusedGlobalVarNoProblem4() {
    checkByFileNoProblemAtCaret(unusedGlobalVariable);
  }

  public void testUnusedGlobalVarNoProblem5() {
    checkByFileNoProblemAtCaret(unusedGlobalVariable);
  }

  public void testUnusedGlobalVarNoProblem6() {
    checkByFileNoProblemAtCaret(unusedGlobalVariable);
  }

  public void testDeclareLocal1_0() {
    checkByFile(declareLocal);
  }

  public void testDeclareLocal1_1() {
    // checks that we only report on first same variable occurrence
    checkByFileNoProblemAtCaret(declareLocal);
  }

  public void testDeclareLocal2_0() {
    checkByFile(declareLocal);
  }

  public void testDeclareLocal2_1() {
    checkByFile(declareLocal);
  }

  public void testDeclareLocal2_2() {
    checkByFile(declareLocal);
  }

  public void testDeclareLocal2_3() {
    checkByFile(declareLocal);
  }

  public void testDeclareLocal2_4() {
    checkByFile(declareLocal);
  }

  public void testDeclareLocalNoProblem1() {
    checkByFileNoProblemAtCaret(declareLocal);
  }

  public void testDeclareLocalNoProblem2() {
    checkByFileNoProblemAtCaret(declareLocal);
  }

  public void testDupFunctionsNotReportedUnused() {
    // dup functions should not imply unused
    checkByFileNoProblemAtCaret(unusedFunction);
  }

  public void testDupFunctions1() {
    checkByFile(duplicateFunction);
  }

  public void testDupFunctions2() {
    checkByFile(duplicateFunction);
  }

  public void testUnresolvedFunctionCall1() {
    checkByFile(unresolvedFunctionCall);
  }

  public void testUnresolvedFunctionCall2() {
    checkByFileNoProblemAtCaret(unresolvedFunctionCall);
  }

  public void testUnresolvedFunctionCall3() {
    checkByFileNoProblemAtCaret(unresolvedFunctionCall);
  }

  public void testUnresolvedFunctionCall4() {
    checkByFile(unresolvedFunctionCall);
  }

  public void testUnresolvedInclude1() {
    checkByFile(unresolvedInclude);
  }

  public void testUnresolvedIncludeNoProblem1() {
    myFixture.configureByText("resolved.awk", "");
    checkByFileNoProblemAtCaret(unresolvedInclude);
  }

  public void testUnresolvedIncludeNoProblem2() {
    myFixture.configureByText("resolved.awk", "");
    checkByFileNoProblemAtCaret(unresolvedInclude);
  }

  public void testEnforceGlobalVarNaming1() {
    checkByFile(enforceGlobalVarNaming);
  }

  public void testEnforceGlobalVarNaming2() {
    checkByFile(enforceGlobalVarNaming);
  }

  public void testEnforceGlobalVarNaming3() {
    checkByFile(enforceGlobalVarNaming);
  }

  @Override
  protected String getTestDataPath() {
    return "src/test/testData/inspection";
  }

  private void checkByFileNoProblemAtCaret(Inspection inspection) {
    checkByFileNoProblemAtCaret(inspection, false);
  }

  private void checkByFileNoProblemAtCaret(Inspection inspection, boolean fileOutsideProject) {
    String testName = getTestName(true) + ".awk";
    if (fileOutsideProject) {
      Path testSource = Path.of(getTestDataPath(), testName);
      VirtualFile beforeFileTmp;
      try {
        // 1. We can't just configure by virtual file in place, because test run will overwrite test
        // file by removing the <caret>
        // 2. So we create temp file but with path "temp://src/../testName" which appears to be out
        // of project dir "temp://src"
        beforeFileTmp =
            myFixture
                .getTempDirFixture()
                .createFile("../" + testName, Files.readString(testSource));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      myFixture.configureFromExistingVirtualFile(beforeFileTmp);
    } else {
      myFixture.configureByFile(testName);
    }

    myFixture.enableInspections(inspection.inspection);

    List<HighlightInfo> highlightInfos = myFixture.doHighlighting();

    int caretOffset = myFixture.getCaretOffset();

    Optional<HighlightInfo> highlightInfoAtCaretOpt =
        highlightInfos.stream()
            .filter(
                highlightInfo ->
                    highlightInfo.startOffset <= caretOffset
                        && highlightInfo.endOffset >= caretOffset)
            .findAny();

    highlightInfoAtCaretOpt.ifPresent(
        highlightInfo -> fail("Should be no error, but was: " + highlightInfo.getDescription()));
  }

  private void checkByFile(Inspection inspection) {
    String before = getTestName(true) + ".awk";
    myFixture.configureByFile(before);

    myFixture.enableInspections(inspection.inspection);
    List<HighlightInfo> highlightInfos = myFixture.doHighlighting();
    assertFalse(
        "Inspection '" + inspection.quickFixName + "' must show, but is absent",
        highlightInfos.isEmpty());

    if (inspection.quickFixName != null) {
      // Get the quick fix action for comparing references inspection and apply it to the file
      final IntentionAction action = myFixture.findSingleIntention(inspection.quickFixName);
      assertNotNull(action);
      myFixture.launchAction(action);

      String after = before.replace(".awk", "After.awk");
      myFixture.checkResultByFile(after, true);
    }
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
