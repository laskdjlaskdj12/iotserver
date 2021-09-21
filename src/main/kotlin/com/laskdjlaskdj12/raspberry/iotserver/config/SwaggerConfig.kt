package com.laskdjlaskdj12.raspberry.iotserver.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("Horyu Desktop Auto Start SErver")
            .description("API")
            .build()
    }

    @Bean
    fun commonApi(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .groupName("Computer AutoStart")
            .apiInfo(apiInfo())
            .select()
            .apis(
                RequestHandlerSelectors
                    .basePackage("com.laskdjlaskdj12.raspberry.iotserver.controller")
            )
            .build()
    }
}