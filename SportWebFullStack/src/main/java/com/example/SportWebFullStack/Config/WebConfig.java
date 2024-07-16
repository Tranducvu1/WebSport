package com.example.SportWebFullStack.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.SportWebFullStack.Controller.AuthInterceptor;
@Configuration
public class WebConfig implements WebMvcConfigurer {
private AppConfig appConfig;
	
	@Autowired
	public WebConfig(AppConfig appConfig)
	{
		this.appConfig = appConfig;
	}
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
    	registry.addResourceHandler("/Frontend/img/**").addResourceLocations("/resources/Frontend/images/");
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4444") 
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
    @Override
	public void addInterceptors(InterceptorRegistry registry) {
		// kiểm tra xem có token ko mới đc truy cập vào trang web
		registry.addInterceptor(new AuthInterceptor(appConfig)).addPathPatterns("/admin/**").excludePathPatterns("/admin/login/**");
	}
	
}