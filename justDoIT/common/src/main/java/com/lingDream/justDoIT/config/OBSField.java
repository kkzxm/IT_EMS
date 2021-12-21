package com.lingDream.justDoIT.config;

import com.lingDream.interceptors.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 酷酷宅小明
 * @CreateDate: 2021/12/20 0020 21:31
 */
@Configuration
public class OBSField implements WebMvcConfigurer {

    /**
     * 登录验证拦截
     *
     * @param registry 参数
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/admin/*");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    /**
     * 解决跨域问题
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(false)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
