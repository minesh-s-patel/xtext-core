/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IFeatureInfo
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.tests.XtextInjectorProvider
import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtextInjectorProvider)
class GrammarConstraintProviderFeatureTest {

	@Inject ValidationTestHelper validator
	@Inject ParseHelper<Grammar> parser
	@Inject IGrammarConstraintProvider constraintProvider

	@Test def void simple() {
		val actual = '''
			Rule: val=ID; 
		'''.toFeatureInfo
		val expected = '''
			Rule_Rule{
			  val[1,1]
			}
		'''
		assertEquals(expected, actual)
	}

	@Test def void optional() {
		val actual = '''
			Rule: {Rule} val=ID?; 
		'''.toFeatureInfo
		val expected = '''
			Rule_Rule{
			  val[0,1]
			}
		'''
		assertEquals(expected, actual)
	}

	@Test def void multi() {
		val actual = '''
			Rule: val=ID+; 
		'''.toFeatureInfo
		val expected = '''
			Rule_Rule{
			  val[1,*]
			}
		'''
		assertEquals(expected, actual)
	}

	@Test def void optionalMulti() {
		val actual = '''
			Rule: {Rule} val=ID*; 
		'''.toFeatureInfo
		val expected = '''
			Rule_Rule{
			  val[0,*]
			}
		'''
		assertEquals(expected, actual)
	}

	@Test def void twoToThree() {
		val actual = '''
			Rule: val+=ID val+=ID val+=ID?; 
		'''.toFeatureInfo
		val expected = '''
			Rule_Rule{
			  val[2,3]
			}
		'''
		assertEquals(expected, actual)
	}
	
	@Test def void twoDoubleLoop() {
		val actual = '''
			Rule: {Rule} (val1+=ID val2+=ID)*; 
		'''.toFeatureInfo
		val expected = '''
			Rule_Rule{
			  val1[0,*]
			  val2[0,*]
			}
		'''
		assertEquals(expected, actual)
	}
	
	@Test def void zeroToThree() {
		val actual = '''
			Rule: (val1+=ID | val2+=ID | val3+=ID) (val1+=ID | val2+=ID) val1+=ID; 
		'''.toFeatureInfo
		val expected = '''
			Rule_Rule{
			  val1[1,3]
			  val2[0,2]
			  val3[0,1]
			}
		'''
		assertEquals(expected, actual)
	}
	
	@Test def void unordered() {
		val actual = '''
			Rule: val1+=ID & val2+=ID; 
		'''.toFeatureInfo
		val expected = '''
			Rule_Rule{
			  val1[0,*]
			  val2[0,*]
			}
		'''
		assertEquals(expected, actual)
	}
	
	@Test def void complex1() {
		val actual = '''
			Rule: 'a' val1+=ID 'b'
			  (
			    ('c' val2+=ID)?
			    & ('d' val3+=ID)?
			    & ('e' val4+=ID)?
			  )
			  ('f' val5+=ID*)?
			  ('g' val6+=ID*)?
			  'h';
		'''.toFeatureInfo
		val expected = '''
			Rule_Rule{
			  val1[1,1]
			  val2[0,*]
			  val3[0,*]
			  val4[0,*]
			  val5[0,*]
			  val6[0,*]
			}
		'''
		assertEquals(expected, actual)
	}
	
	@Test def void complex2() {
		val actual = '''
			Rule: {Rule} (val1+=ID | 'a')
			  (val2+=ID & 'b')
			  ('c' | val1+=ID);
		'''.toFeatureInfo
		val expected = '''
			Rule_Rule{
			  val1[0,2]
			  val2[0,*]
			}
		'''
		assertEquals(expected, actual)
	}
	
	def assertEquals(String expected, String actual)
	{
		val expectedM = expected?.replaceAll(System.lineSeparator, "\n");
		val actualM = actual?.replaceAll(System.lineSeparator, "\n");
		Assert.assertEquals(expectedM, actualM)
	}

	def String toFeatureInfo(CharSequence grammarString) {
		val grammar = parser.parse('''
			grammar org.eclipse.xtext.serializer.GrammarConstraintProviderFeatureTestLanguage with org.eclipse.xtext.common.Terminals
			
			generate GrammarConstraintProviderFeatureTest "http://www.eclipse.org/2010/tmf/xtext/GrammarConstraintProviderFeatureTestLanguage"
			
			«grammarString»
		''')
		validator.assertNoErrors(grammar)
		val constraints = constraintProvider.getConstraints(grammar).values.map[value]
		return constraints.map[name + "{\n  " + features.map[asString].join("\n  ") + "\n}"].join("\n") + "\n"
	}

	def String asString(IFeatureInfo it) {
		val upper = if(upperBound == IGrammarConstraintProvider.MAX) "*" else upperBound
		return feature.name + "[" + lowerBound + "," + upper + "]";
	}
}
