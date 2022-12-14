package com.CGDJ6.transportes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class MvcConfig  implements WebMvcConfigurer {

    private  final Logger log = LoggerFactory.getLogger(getClass());
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry  registry) {


        WebMvcConfigurer.super.addResourceHandlers(registry);
        String resourcePath = Paths.get("images").toAbsolutePath().toUri().toString();
        log.info(resourcePath);

        registry.addResourceHandler("/images/**")
                .addResourceLocations(resourcePath);







    }
}
