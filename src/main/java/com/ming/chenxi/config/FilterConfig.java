package com.ming.chenxi.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;

/**
 * Created by Ming on 2016/4/6.
 */
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*"); //设置拦截器链

        return registrationBean;
    }

    @Bean
	public HttpMessageConverter<String> responseBodyConverter() {
    	StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
     	return converter;
	}
}

