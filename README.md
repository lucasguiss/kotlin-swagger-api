# Kotlin Swagger SpringBoot API Example

Example of an API documented with Swagger in Kotlin and SpringBoot.

## To install the application dependencies:
```shell
$ mvn clean install -DskipTests
```

## POM dependencies needed:

```xml
    <repositories>
        <repository>
            <id>jcenter-snapshots</id>
            <name>jcenter</name>
            <url>https://jcenter.bintray.com/</url>
        </repository>
    </repositories>
    <dependencies>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
            <version>3.0.0</version>
        </dependency>
```

## Necessary configuration to Swagger map the application:

```kotlin
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
```

### To see the generated documentation go to `http://localhost:8080/swagger-ui/index.html#/`