package com.huibur.furion.swagger.config;

import com.huibur.furion.swagger.utils.SwaggerUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile({"dev", "test"})
public class SwaggerConfig {
    public SwaggerConfig() {
    }

    @Bean
    public Docket docket() {
        return SwaggerUtil.initDocket();
    }
}
