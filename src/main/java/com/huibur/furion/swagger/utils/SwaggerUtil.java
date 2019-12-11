package com.huibur.furion.swagger.utils;

import com.huibur.furion.common.io.PropertiesUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


public class SwaggerUtil {
    public SwaggerUtil() {
    }

    private static ApiInfo apiInfo() {
        String applicationContext = PropertiesUtils.getInstance().getProperty("server.servlet.context-path", "/Furion");
        return new ApiInfoBuilder()
                .title(applicationContext.substring(1) +" RESTful APIs")
                .version("1.0")
                .description("API 描述")
                .contact(new Contact("HuiBur", "", ""))
                .build();
    }

    public static Docket initDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()   // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.huibur"))
                .paths(PathSelectors.any())
                .build();
    }
}
