package com.example.WhiskyApp.config;

import com.example.WhiskyApp.interceptor.AppVersionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AppVersionInterceptor versionInterceptor;

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
                .addResourceLocations("file:/your/path/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Alle Endpunkte
                .allowedOrigins("*") // Achtung: Nur für Tests ALLES erlauben
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // HTTP Methoden
                .allowedHeaders("*") // Alle Header zulassen
                .exposedHeaders("Authorization") // Falls du Tokens zurückgibst
                .allowCredentials(false); // Ohne Cookies
    }
}