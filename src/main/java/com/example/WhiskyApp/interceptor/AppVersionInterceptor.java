package com.example.WhiskyApp.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AppVersionInterceptor implements HandlerInterceptor {

    @Value("${app.min-version}")
    private String minVersion;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientVersion = request.getHeader("X-App-Version");

        if (clientVersion == null || isOutdated(clientVersion, minVersion)) {
            response.sendError(426, "App version outdated. Please update.");
            return false;
        }

        return true;
    }

    private boolean isOutdated(String clientVersion, String minVersion) {
        String[] clientParts = clientVersion.split("\\.");
        String[] minParts = minVersion.split("\\.");

        for (int i = 0; i < Math.max(clientParts.length, minParts.length); i++) {
            int client = i < clientParts.length ? Integer.parseInt(clientParts[i]) : 0;
            int min = i < minParts.length ? Integer.parseInt(minParts[i]) : 0;

            if (client < min) return true;
            if (client > min) return false;
        }

        return false;
    }
}