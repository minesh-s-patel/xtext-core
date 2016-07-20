/*
 * generated by Xtext
 */
package org.eclipse.xtext.xtext.ecoreInference;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.common.TerminalsStandaloneSetup;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.UnassignedRuleCallTestLanguagePackage;

@SuppressWarnings("all")
public class UnassignedRuleCallTestLanguageStandaloneSetupGenerated implements ISetup {

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new UnassignedRuleCallTestLanguageRuntimeModule());
	}
	
	public void register(Injector injector) {
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		IResourceServiceProvider serviceProvider = injector.getInstance(IResourceServiceProvider.class);
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("unassignedrulecalltestlanguage", resourceFactory);
		IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("unassignedrulecalltestlanguage", serviceProvider);
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2009/tmf/xtext/UnassignedRuleCallTest")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2009/tmf/xtext/UnassignedRuleCallTest", UnassignedRuleCallTestLanguagePackage.eINSTANCE);
		}
	}
}