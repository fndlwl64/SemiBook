package com.semi.book.common.jwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {/*templates 폴더에 있는 HTML 파일 매핑 가능하게 설정*/
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/","classpath:/static/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }
}
