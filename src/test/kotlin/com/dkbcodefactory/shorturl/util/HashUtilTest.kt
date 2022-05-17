package com.dkbcodefactory.shorturl.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HashUtilTest {

    @Test
    fun test_md5_method() {
        val md5 = HashUtil.md5("https://www.dkbcodefactory.com/#/")
        assertEquals(md5, "846f06d356b188e4f05094671a2aa3cb")
    }
}