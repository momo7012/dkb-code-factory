package com.dkbcodefactory.shorturl.controller.impl

import com.dkbcodefactory.shorturl.ShorturlApplication
import com.dkbcodefactory.shorturl.dto.UrlRequest
import com.dkbcodefactory.shorturl.dto.UrlResponse
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(
    classes = arrayOf(ShorturlApplication::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class UrlRestControllerImplTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun test_get_short_url() {
        val result = restTemplate.postForEntity("/url/create",
            UrlRequest("https://www.dkbcodefactory.com/#/"),
            UrlResponse::class.java);

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)
        assertEquals("ODQ2ZjA", result.getBody()?.url)
    }

    @Test
    fun test_get_original_url() {
        restTemplate.postForEntity("/url/create",
            UrlRequest("https://www.dkbcodefactory.com/#/"),
            UrlResponse::class.java);

        val result = restTemplate.getForEntity("/url/ODQ2ZjA", UrlResponse::class.java);

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)
        assertEquals("https://www.dkbcodefactory.com/#/", result.getBody()?.url)
    }


    @Test
    fun test_get_original_url_not_found_exception() {
        val result = restTemplate.getForEntity("/url/1DQ2ZjA", UrlResponse::class.java);

        assertNotNull(result)
        assertEquals(HttpStatus.NOT_FOUND, result?.statusCode)
    }

}