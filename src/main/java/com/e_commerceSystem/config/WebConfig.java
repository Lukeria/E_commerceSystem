package com.e_commerceSystem.config;

import com.e_commerceSystem.additional.converters.ComponentTypeStringToEnumConverter;
import com.e_commerceSystem.additional.converters.ProductTypeStringToEnumConverter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.e_commerceSystem.controllers")
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/accessDenied").setViewName("accessDenied");
        registry.addViewController("/contacts").setViewName("user/contacts");
        registry.addViewController("/main").setViewName("user/main");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public ResourceBundleMessageSource validationMessageSource() {

        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
        rb.setBasenames("classpath:messages/messages");
        rb.setDefaultEncoding("UTF-8");
        return rb;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(new ComponentTypeStringToEnumConverter());
        registry.addConverter(new ProductTypeStringToEnumConverter());
    }

    @Bean
    public MultipartResolver multipartResolver() {

        return new StandardServletMultipartResolver();
    }

    @Bean("messageSource")
    public MessageSource messageSource(){

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages/messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver(){

        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        return localeResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }
}
