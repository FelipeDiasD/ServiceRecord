package br.com.felipedias.ServiceRecord.docs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class SwaggerConfig {


    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Public apis")
                .pathsToMatch("/**").build();
    }
    @Bean
    OpenAPI minhaApi(){
        return new OpenAPI().info(new Info()
                .title("Service Record API")
                .description("Uma API para registros de uma equipe de TI")
                .version("1.0"));
    }
}