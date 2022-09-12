package com.CGDJ6.transportes.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.Locale;

@Configuration
public class WebConfig  implements WebMvcConfigurer {


    @Override
    public  void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index"); // ojo que el progrma inicia aca con las vistas
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");

    }

}
