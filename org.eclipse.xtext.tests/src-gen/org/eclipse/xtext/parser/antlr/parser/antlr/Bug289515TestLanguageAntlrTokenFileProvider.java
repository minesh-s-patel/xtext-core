/*
 * generated by Xtext
 */
package org.eclipse.xtext.parser.antlr.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class Bug289515TestLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug289515TestLanguage.tokens");
	}
}