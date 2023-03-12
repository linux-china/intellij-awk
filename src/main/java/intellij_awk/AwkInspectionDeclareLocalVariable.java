package intellij_awk;

import com.intellij.codeInspection.*;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import intellij_awk.psi.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

/**
 *
 *
 * <ul>
 *   <li>Always define locals starting with a lower case letter
 *   <li>Always define globals as MixedCase starting an Uppercase letter
 * </ul>
 */
public class AwkInspectionDeclareLocalVariable extends LocalInspectionTool {

  private static final DeclareAsLocalParamQuickFix declareAsLocalParamQuickFix =
      new DeclareAsLocalParamQuickFix();
  public static final String QUICK_FIX_NAME = "Declare as local variable";

  @Override
  public @NotNull PsiElementVisitor buildVisitor(
      @NotNull ProblemsHolder holder, boolean isOnTheFly) {
    return new AwkVisitor() {
      @Override
      public void visitItem(@NotNull AwkItem awkItem) {
        if (awkItem.getFunction() != null) {
          AwkParamList paramList = awkItem.getParamList();

          List<AwkUserVarName> paramNameList =
              paramList == null ? List.of() : paramList.getUserVarNameList();

          Set<String> paramNames =
              paramNameList.stream().map(PsiNamedElement::getName).collect(Collectors.toSet());

          List<PsiElement> varsInFuncBody = AwkUtil.findUserVars(awkItem.getAction());

          Set<String> seen = new HashSet<>();

          for (PsiElement psiElement : varsInFuncBody) {
            String varName = psiElement.getText();

            if (Util.startsWithLowercaseLetter(varName)
                && !paramNames.contains(varName)
                && !seen.contains(varName)
                && isNotDeclaredAsGlobalVar(psiElement)) {
              seen.add(varName);
              holder.registerProblem(
                  psiElement,
                  "Variable '"
                      + varName
                      + "' name starts with lowercase, so this variable should be local",
                  ProblemHighlightType.WARNING,
                  declareAsLocalParamQuickFix);
            }
          }
        }
      }
    };
  }

  private boolean isNotDeclaredAsGlobalVar(PsiElement psiElement) {
    PsiReference reference = psiElement.getReference();
    PsiElement refTarget;
    return reference == null
        || (refTarget = reference.resolve()) == null
        || !((AwkUserVarNameMixin) refTarget).isDeclaration();
  }

  private static class DeclareAsLocalParamQuickFix implements LocalQuickFix {

    @Override
    public @IntentionFamilyName @NotNull String getFamilyName() {
      return QUICK_FIX_NAME;
    }

    @Override
    public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
      AwkUserVarNameMixin varName = (AwkUserVarNameMixin) descriptor.getPsiElement();

      AwkItem awkItem = AwkUtil.findParent(varName, AwkItem.class);

      AwkParamList paramList = awkItem.getParamList();

      if (paramList != null) {
        String paramsAsText = paramListAsText(paramList);
        String newParamsAsText =
            paramsAsText
                + (paramsAsText.contains("   ") || paramsAsText.contains("\\") ? "," : ",   ")
                + varName.getName();
        AwkParamList newParamList =
            AwkElementFactory.createParamList(varName.getProject(), newParamsAsText);
        paramList.replace(newParamList);
      } else {
        AwkParamList newParamList =
            AwkElementFactory.createParamList(varName.getProject(), varName.getName());
        PsiElement e = awkItem.getFirstChild();
        while (AwkUtil.isNotType(e = e.getNextSibling(), AwkTypes.LPAREN))
          ;
        awkItem.addAfter(newParamList, e);
        awkItem.addAfter(AwkElementFactory.createWhiteSpaces(varName.getProject(), 3), e);
      }
    }

    private String paramListAsText(AwkParamList paramList) {
      StringBuilder sb = new StringBuilder(paramList.getText());
      PsiElement e = paramList;
      while (AwkUtil.isNotType(e = e.getPrevSibling(), AwkTypes.LPAREN)) {
        // also include any whitespaces before param list: `function f(   x,y,z)` -> "   x,y,z"
        sb.insert(0, e.getText());
      }
      return sb.toString();
    }
  }
}
