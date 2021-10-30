package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    AppConfig appConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println(appConfig.getFileStorageLocation());
        registry.addResourceHandler(appConfig.getCustomUrlLocation())
                .addResourceLocations("file:./uploadFiles/")
                .setCacheControl(CacheControl.maxAge(3600,TimeUnit.HOURS));
    }
}
