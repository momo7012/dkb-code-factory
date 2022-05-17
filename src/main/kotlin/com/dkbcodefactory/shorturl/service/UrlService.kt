package com.dkbcodefactory.shorturl.service

import com.dkbcodefactory.shorturl.dto.UrlRequest
import com.dkbcodefactory.shorturl.dto.UrlResponse
import com.dkbcodefactory.shorturl.entity.UrlEntity
import com.dkbcodefactory.shorturl.exception.NotFoundException
import com.dkbcodefactory.shorturl.repository.UrlRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UrlService(private val urlRepository: UrlRepository) {


    fun insert(urlEntity: UrlEntity) {
        urlRepository.save(urlEntity)
    }

    fun checkingUrl(request: UrlRequest): UrlResponse {
        val hashUrl = request.hashCodeOriginalUrl();
        val urlEntityOptional = findByShortUrl(hashUrl)
        if (urlEntityOptional.isEmpty) {
            insert(UrlEntity(hashUrl, request.originalUrl, Date().toInstant()))
        }
        return UrlResponse(hashUrl);
    }

    fun findOriginalUrl(shortUrl: String): UrlResponse {
        val urlEntityOptional = findByShortUrl(shortUrl)
        if (urlEntityOptional.isEmpty) {
            throw NotFoundException("There is no original url with this short url")
        }
        return UrlResponse(urlEntityOptional.get().originalUrl)
    }

    private fun findByShortUrl(shortUrl: String): Optional<UrlEntity> {
        return urlRepository.findByHashUrl(shortUrl)
    }
}