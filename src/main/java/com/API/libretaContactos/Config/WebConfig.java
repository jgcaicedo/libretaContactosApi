package com.API.libretaContactos.Config;

// Importa las clases necesarias para configurar el comportamiento de la aplicación Spring.
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// La anotación @Configuration indica que esta clase contiene definiciones de beans que el contenedor de Spring manejará.

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // Sobrescribe el método addCorsMappings para personalizar la configuración de CORS (Cross-Origin Resource Sharing).
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Define los mapeos de CORS permitidos para la aplicación.
        // Aquí se permite el acceso a todos los endpoints (/**) desde el origen http://localhost:4200.
        // También se especifican los métodos HTTP permitidos.
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
