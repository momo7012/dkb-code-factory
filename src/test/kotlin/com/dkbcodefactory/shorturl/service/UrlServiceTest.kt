package com.dkbcodefactory.shorturl.service

import com.dkbcodefactory.shorturl.ShorturlApplication
import com.dkbcodefactory.shorturl.dto.UrlRequest
import com.dkbcodefactory.shorturl.entity.UrlEntity
import com.dkbcodefactory.shorturl.exception.NotFoundException
import com.dkbcodefactory.shorturl.repository.UrlRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@SpringBootTest(classes = [ShorturlApplication::class])
@ExtendWith(SpringExtension::class)
internal class UrlServiceTest {
    @Autowired
    lateinit var urlRepository: UrlRepository

    @Autowired
    lateinit var urlService: UrlService

    fun insert() {
        val urlEntity = UrlEntity("ODQ2ZjA", "https://www.dkbcodefactory.com/#/", Date().toInstant())
        urlService.insert(urlEntity)
    }

    @Test
    @Order(1)
    fun test_insert() {
        val urlEntity = UrlEntity("ODQ2ZjA", "https://www.dkbcodefactory.com", Date().toInstant())
        urlService.insert(urlEntity)
        val findAll = urlRepository.findAll()
        assertTrue(findAll.size > 0)
    }

    @Test
    @Order(2)
    fun test_checking_url() {
        val urlRequest = UrlRequest("https://www.dkbcodefactory.com/#/")
        val response = urlService.checkingUrl(urlRequest)
        assertEquals(response.url, "ODQ2ZjA")
    }

    @Test
    @Order(3)
    fun test_find_original_url() {
        insert()
        val response = urlService.findOriginalUrl("ODQ2ZjA")
        assertEquals(response.url, "https://www.dkbcodefactory.com/#/")
    }

    @Test
    fun test_find_original_url_not_found() {

        Assertions.assertThrows(NotFoundException::class.java) {
            urlService.findOriginalUrl("1DQ2ZjA")
        }
    }
}