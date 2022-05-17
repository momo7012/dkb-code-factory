package com.dkbcodefactory.shorturl.controller.impl

import com.dkbcodefactory.shorturl.controller.UrlRestController
import com.dkbcodefactory.shorturl.dto.UrlRequest
import com.dkbcodefactory.shorturl.dto.UrlResponse
import com.dkbcodefactory.shorturl.service.UrlService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/url")
class UrlRestControllerImpl(private val urlService: UrlService ) : UrlRestController {

    @PostMapping("/create")
    override fun getShortUrl(@RequestBody request : UrlRequest) : UrlResponse {
        return urlService.checkingUrl(request)
    }

    @GetMapping("/{shortUrl}")
    override fun getOriginalUrl(@PathParam("shortUrl") shortUrl: String): UrlResponse {
        return urlService.findOriginalUrl(shortUrl);
    }
}