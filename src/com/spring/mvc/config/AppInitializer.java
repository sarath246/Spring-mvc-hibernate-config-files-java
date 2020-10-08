package com.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {
				
				AppContext.class
		};
		
		//return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {
			
			WebMvcConfig.class
		};
		//return null;
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {
			
			"/"
		};
		
		//return null;
	}

}
