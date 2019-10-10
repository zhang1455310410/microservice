package com.ccit.cfgbeans;

import com.ccit.component.AdminLoginHandlerInterceptor;
import com.ccit.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
	@Bean 
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
		 @Override
         public void addInterceptors(InterceptorRegistry registry) {
             //super.addInterceptors(registry);
           
             registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/cart");
             registry.addInterceptor(new AdminLoginHandlerInterceptor()).addPathPatterns("/manageAdd").addPathPatterns("/manageProducts").addPathPatterns("/manageAbout");
         }
     };
     return adapter;
 }
    @Bean
    public HttpPutFormContentFilter httpPutFormContentFilter() {
        return new HttpPutFormContentFilter();
    }
}
