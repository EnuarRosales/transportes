package com.CGDJ6.transportes;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig  implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry  registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/images/**")
        .addResourceLocations("file:/nyjhbwglsioynilgbwwx.supabase.co/storage/v1/object/public/tranportescgdj6/imagenes/");

    }
}
