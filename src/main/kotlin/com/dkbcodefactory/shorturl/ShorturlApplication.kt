package com.dkbcodefactory.shorturl

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
@OpenAPIDefinition(
    info = Info(
        title = "URL shortener",
        version = "1.0",
        description = "URL shortener project for DKB code factory"
    )
)
class ShorturlApplication

fun main(args: Array<String>) {
    runApplication<ShorturlApplication>(*args)
}
