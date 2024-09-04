package com.example.shawerma_cloud.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class WebConfig implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry controllerRegistry){
        controllerRegistry.addViewController("/").setViewName("home");
    }
}
