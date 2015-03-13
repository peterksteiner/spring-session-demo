package com.example.springsessiondemo.config;

import java.util.Collections;

import javax.servlet.ServletContext;
import javax.servlet.SessionTrackingMode;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.example.springsessiondemo.listener.InvalidateHttpSessionListener;

public class WebApp extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {
        super.registerDispatcherServlet(servletContext);
        servletContext.addListener(new InvalidateHttpSessionListener());
        servletContext.setSessionTrackingModes(Collections.<SessionTrackingMode>emptySet());
    }

    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackages = {
            "com.example.springsessiondemo.controller",
            "com.example.springsessiondemo.exception",
            "com.example.springsessiondemo.config.redis"
    })
    public static class WebAppConfig {
    }
}
