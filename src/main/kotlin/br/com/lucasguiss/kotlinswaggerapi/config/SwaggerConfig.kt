package br.com.lucasguiss.kotlinswaggerapi.config

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

    companion object {
        private const val PACKAGE = "br.com.lucasguiss.kotlinswaggerapi"
        private const val TITLE = "Kotlin API"
        private const val DESCRIPTION = "Example of a Kotlin API documented with Swagger"
        private const val VERSION = "1.0"
    }

    @Bean
    fun initApiDoc(): Docket {
        return Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage(PACKAGE))
            .build()
            .apiInfo(metaInfo())
    }

    private fun metaInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title(TITLE)
            .description(DESCRIPTION)
            .version(VERSION)
            .build()
    }
}