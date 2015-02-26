package com.example.springsessiondemo.config.redis;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class Initializer extends AbstractHttpSessionApplicationInitializer {
    public Initializer() {
        super(HttpSessionConfig.class);
    }
}
