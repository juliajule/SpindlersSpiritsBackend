package com.example.WhiskyApp.config;

import com.example.WhiskyApp.interceptor.AppVersionInterceptor;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AppVersionInterceptor versionInterceptor;

    @Value("${image.upload.dir}")
    private String imageDir;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(versionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/**")
                .excludePathPatterns("/images/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/images/**")
                .addResourceLocations("file:" + imageDir);
    }
}