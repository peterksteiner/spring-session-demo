package com.example.springsessiondemo.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InvalidateHttpSessionListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.invalidate();
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
    }
}
