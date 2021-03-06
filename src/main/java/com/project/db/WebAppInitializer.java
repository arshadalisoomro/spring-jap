package com.project.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext context) {
    	XmlWebApplicationContext rootContext = 
        		new XmlWebApplicationContext();
        rootContext.setConfigLocation("/WEB-INF/spring/root-context.xml");
        
        context.addListener(new ContextLoaderListener(rootContext));
 
        // Create the dispatcher servlet's Spring application context
        XmlWebApplicationContext servletContext = 
        		new XmlWebApplicationContext();
        servletContext.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
         
        // add the dispatcher servlet and map it to /
        ServletRegistration.Dynamic dispatcher = 
        		context.addServlet("springDispatcher", new DispatcherServlet(servletContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
         
    }

}
