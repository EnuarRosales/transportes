package com.CGDJ6.transportes;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig  implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry  registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
<<<<<<< HEAD
        registry.addResourceHandler("/images/**")
        .addResourceLocations("file:/nyjhbwglsioynilgbwwx.supabase.co/storage/v1/object/public/tranportescgdj6/imagenes/");
=======
        registry.addResourceHandler("/images/**").addResourceLocations("https//nyjhbwglsioynilgbwwx.supabase.co/storage/v1/object/public/tranportescgdj6/imagenes/");




>>>>>>> 61ee8c3a34bea5e63f190295dbf814a70be65561

    }
}
