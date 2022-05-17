package com.dkbcodefactory.shorturl.dto

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class UrlRequestTest {

    @Test
    fun test_hash_code_original_url() {
        val request =UrlRequest("https://www.dkbcodefactory.com/#/")

        assertEquals(request.hashCodeOriginalUrl(), "ODQ2ZjA")
    }

    @Test
    fun test_hash_code_original_url_fail() {
        val request =UrlRequest("https://www.dkbcodefactory.com/#/")

        assertNotEquals(request.hashCodeOriginalUrl(), "ODQ2ZjB")
    }
}