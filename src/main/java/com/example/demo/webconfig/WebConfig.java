package com.example.demo.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/convertFilePdf/**") // Ajusta la ruta a tus endpoints
                .allowedOrigins("**") // Orígenes permitidos
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("*"); // Cabeceras permitidas (o especifica las necesarias)
                //.allowCredentials(true); // Si necesitas enviar cookies o credenciales (con cuidado!)
    }
}
