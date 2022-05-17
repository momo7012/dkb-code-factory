package com.dkbcodefactory.shorturl.controller

import com.dkbcodefactory.shorturl.dto.UrlRequest
import com.dkbcodefactory.shorturl.dto.UrlResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.RequestBody
import javax.websocket.server.PathParam

interface UrlRestController {

    @Operation(summary = "Shorting original url")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Created",
            content = [Content(
                mediaType = "application/json",
                schema = Schema(implementation = UrlRequest::class)
            )]
        )]
    )
    fun getShortUrl(@RequestBody request: UrlRequest): UrlResponse

    @Operation(summary = "Getting original url")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "OK",
            content = [Content(
                mediaType = "application/json",
                schema = Schema(implementation = String::class)
            )]
        ),
            ApiResponse(
                responseCode = "404",
                description = "Not found",
                content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = String::class)
                )]
            )
        ]
    )
    fun getOriginalUrl(@PathParam("shortUrl") shortUrl: String) : UrlResponse
}