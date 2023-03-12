package intellij_awk.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import intellij_awk.AwkReferenceIncludePath;
import intellij_awk.AwkUtil;
import javax.swing.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AwkIncludePathMixin extends AwkNamedElementImpl implements AwkIncludePath {
  public AwkIncludePathMixin(@NotNull ASTNode node) {
    super(node);
  }

  public PsiElement setName(String newName) {
    String currentIncludePath = AwkUtil.stringValue(getText());
    String[] parts = currentIncludePath.split("/");
    parts[parts.length - 1] = newName;
    String realNewName = String.join("/", parts);
    return replaceNameNode(AwkElementFactory.createIncludePath(getProject(), realNewName));
  }

  @Override
  public PsiReference getReference() {
    return new AwkReferenceIncludePath(this, getNameTextRange());
  }

  @Override
  public @Nullable Icon getIcon(int flags) {
    return null;
  }
}
