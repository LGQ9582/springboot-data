package com.li.config;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;
//bzvuvqqkxgudbabd
@Configuration
@EnableSwagger2  //开启swagger2
public class SwaggerConfig {

    //配置swagger 的Docket的bean实例
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //RequestHandlerSelectors  配置要扫描的方式
                //basePackage   配置要扫描的包
                //any()  扫描全部
                //none()  不扫描
                .apis(RequestHandlerSelectors.basePackage("com.li.controller"))//配置指定要扫描的接口的包
                //paths()过滤
//                .paths(PathSelectors.any())
                .build();
    }

    //配置swagger页面的基本信息的apiinfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("", "", "");
        return new ApiInfo(
                "Li 的SwaggerAPI文档",
                "Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
