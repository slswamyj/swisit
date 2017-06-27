package com.stackroute.swisit.intentparser;
/*-----------Importing Liberaries-----------*/
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
/*-------------Spring Boot Application Main Class--------------*/
@SpringBootApplication
public class IntentParserApplication {

    public static void main(String[] args) throws Exception {

       SpringApplication.run(IntentParserApplication.class, args);   
    }
    /*-----------------Resolving Locale-----------------*/
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
    /*------------------Loading Message Bundles--------------------*/
    @Bean
    public MessageSource messageSource() {
         ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
         messageSource.setBasename("classpath:/messages/messages");
         return messageSource;
    }
    /*-------------Changing Language with User Preference------------*/
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
