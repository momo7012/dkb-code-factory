package com.dkbcodefactory.shorturl.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HashUtilTest {

    @Test
    fun test_md5_method() {
        val md5 = HashUtil.md5("https://www.dkbcodefactory.com/#/")
        assertEquals(md5, "846f06d356b188e4f05094671a2aa3cb")
    }

    @Test
    fun test_bas264_method() {
        val base64 = HashUtil.base64("https://www.dkbcodefactory.com/#/")
        assertEquals(base64, "aHR0cHM6Ly93d3cuZGtiY29kZWZhY3RvcnkuY29tLyMv")
    }

    @Test
    fun test_md5_fail_method() {
        val md5 = HashUtil.md5("https://www.dkbcodefactory.com/#/")
        assertNotEquals(md5, "671a2aa3cb846f06d356b188e4f0")
    }

    @Test
    fun test_bas264_fail_method() {
        val base64 = HashUtil.base64("https://www.dkbcodefactory.com/#/")
        assertNotEquals(base64, "RvcnkuY29tLyMvaHR0cHM6Ly93d3cuZGtiY29kZWZhY3")
    }
}