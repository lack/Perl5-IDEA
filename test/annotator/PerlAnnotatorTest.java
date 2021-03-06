/*
 * Copyright 2015-2017 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package annotator;

import base.PerlLightCodeInsightFixtureTestCase;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.perl5.lang.perl.idea.configuration.settings.PerlSharedSettings;
import com.perl5.lang.perl.idea.inspections.*;

/**
 * Created by hurricup on 09.11.2016.
 */
public class PerlAnnotatorTest extends PerlLightCodeInsightFixtureTestCase {
  @Override
  protected String getTestDataPath() {
    return "testData/annotator/perl";
  }

  public void testVariableShadowingInspection() {doTest(PerlVariableShadowingInspection.class);}

  public void testUnusedLexicalVariableInspection() {doTest(PerlUnusedLexicalVariableInspection.class);}

  public void testUnresolvedVariableInspection() {doTest(PerlUnresolvedVariableInspection.class);}

  public void testUnusedGlobalVariableInspection() {doTest(PerlUnusedGlobalVariableInspection.class);}

  public void testFileLevelVariableInspection() {doTest(PerlFileLevelVariableInspection.class);}

  public void testBuiltInVariableRedeclarationInspection() {doTest(PerlBuiltinVariableRedeclarationInspection.class);}

  public void testUseStrictInspection() {doTest(PerlUseStrictInspection.class);}

  public void testUseWarningsInspection() {doTest(PerlUseWarningsInspection.class);}

  public void testUnusedTypeGlobInspection() {doTest(PerlUnusedTypeGlobInspection.class);}

  public void testUnusedSubInspection() {doTest(PerlUnusedSubInspection.class);}

  public void testUnresolvedSubInspection() {doTest(PerlUnresolvedSubInspection.class);}

  public void testSimpleMainResolutionTrue() {doTestSimpleMainResolution(true);}

  public void testSimpleMainResolutionFalse() {doTestSimpleMainResolution(false);}

  private void doTestSimpleMainResolution(boolean optionValue) {
    PerlSharedSettings.getInstance(getProject()).SIMPLE_MAIN_RESOLUTION = optionValue;
    doTest(PerlMultipleSubDefinitionsInspection.class);
  }

  public void testMultipleSubsDefinitionsInspection() {doTest(PerlMultipleSubDefinitionsInspection.class);}

  public void testMultipleSubsDeclarationsInspection() {doTest(PerlMultipleSubDeclarationsInspection.class);}

  public void testRedundantNamespaceInspection() {doTest(PerlRedundantNamespaceInspection.class);}

  public void testUnresolvedPackageFileInspection() {doTest(PerlUnresolvedPackageFileInspection.class);}

  public void testUnresolvedNamespaceInspection() {doTest(PerlUnresolvedNamespaceInspection.class);}

  public void testMultipleNamespaceDefinitionInspection() {doTest(PerlMultipleNamespaceDefinitionsInspection.class);}

  public void testClashedNamespacesInspection() {doTest(PerlClashedNamespacesInspection.class);}

  public void testUnresolvedLabelInspection() {doTest(PerlUnresolvedLabelInspection.class);}

  public void testIdentifierInspection() {
    initWithFileSmart();
    getFile().getVirtualFile().setCharset(CharsetToolkit.US_ASCII_CHARSET);
    myFixture.enableInspections(PerlIdentifierInspection.class);
    myFixture.checkHighlighting(true, false, false);
  }

  public void testFancyMethodCall() {doTest(PerlFancyMethodCallInspection.class);}

  public void testMooseAttributesDeprecation() {doDeprecationTest();}

  public void testNsRecursiveInheritance1() {doTest(PerlNamespaceRecursiveInheritanceInspection.class);}

  public void testNsRecursiveInheritance2() {doTest(PerlNamespaceRecursiveInheritanceInspection.class);}

  public void testNsRecursiveInheritance3() {doTest(PerlNamespaceRecursiveInheritanceInspection.class);}

  public void testNamespaceDeprecation() {doDeprecationTest();}

  public void testMojoAttrsDeprecation() {doDeprecationTest();}

  public void testMojoHelperDeprecation() {doDeprecationTest();}

  public void testConstants() {
    doTest();
  }

  public void testIncorrectConstants() { doTest();}

  public void testExceptionClass() {doTest();}

  public void testDeprecations() {
    doDeprecationTest();
  }

  public void testExceptionClassAliasDeprecation() {
    doDeprecationTest();
  }

  public void testClassAccessorDeprecation() {
    doDeprecationTest();
  }

  public void testExceptionClassDeprecation() {
    doDeprecationTest();
  }

  public void testUnresolvedBuiltIns() {
    doTest(PerlUnresolvedSubInspection.class);
  }

  private void doTest() {
    initWithFileSmart();
    myFixture.checkHighlighting(true, true, true);
  }

  private void doDeprecationTest() {
    doTest(PerlDeprecatedInspection.class);
  }

  private void doTest(Class clazz) {
    initWithFileSmart();
    myFixture.enableInspections(clazz);
    myFixture.checkHighlighting(true, false, false);
  }
}
