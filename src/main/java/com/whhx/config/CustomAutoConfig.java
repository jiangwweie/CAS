package com.whhx.config;

import com.whhx.handler.Customhandler;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlan;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlanConfigurer;
import org.apereo.cas.authentication.AuthenticationHandler;
import org.apereo.cas.authentication.principal.DefaultPrincipalFactory;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.services.ServicesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jiangwei
 * @Date: 2019-05-29
 * @Desc:
 */
@Configuration("CustomAuthConfig")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class CustomAutoConfig implements AuthenticationEventExecutionPlanConfigurer {

    @Autowired
    private CasConfigurationProperties casProperties;

    @Autowired
    @Qualifier("servicesManager")
    private ServicesManager servicesManager;

    @Bean
    public AuthenticationHandler myAuthenticationHandler() {
        final Customhandler handler = new Customhandler(Customhandler.class.getSimpleName(), servicesManager, new DefaultPrincipalFactory(), 10);
        return handler;
    }

    @Override
    public void configureAuthenticationExecutionPlan(AuthenticationEventExecutionPlan plan) {
        plan.registerAuthenticationHandler(myAuthenticationHandler());
    }
}