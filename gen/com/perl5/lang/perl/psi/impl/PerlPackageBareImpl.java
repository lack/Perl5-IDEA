// This is a generated file. Not intended for manual editing.
package com.perl5.lang.perl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.perl5.lang.perl.lexer.PerlElementTypes.*;
import com.perl5.lang.perl.psi.*;

public class PerlPackageBareImpl extends PerlNamedElementImpl implements PerlPackageBare {

  public PerlPackageBareImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PerlVisitor) ((PerlVisitor)visitor).visitPackageBare(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getPerlPackageBuiltIn() {
    return findChildByType(PERL_PACKAGE_BUILT_IN);
  }

  @Override
  @Nullable
  public PsiElement getPerlPackageBuiltInDeprecated() {
    return findChildByType(PERL_PACKAGE_BUILT_IN_DEPRECATED);
  }

  @Override
  @Nullable
  public PsiElement getPerlPackageBuiltInPragma() {
    return findChildByType(PERL_PACKAGE_BUILT_IN_PRAGMA);
  }

  @Override
  @Nullable
  public PsiElement getPerlPackageUser() {
    return findChildByType(PERL_PACKAGE_USER);
  }

  public String getName() {
    return PerlPsiImpUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return PerlPsiImpUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return PerlPsiImpUtil.getNameIdentifier(this);
  }

}
