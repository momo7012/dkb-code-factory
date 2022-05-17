package com.dkbcodefactory.shorturl.dto

import com.dkbcodefactory.shorturl.util.HashUtil
import java.util.*

data class UrlRequest(val originalUrl: String){
    fun hashCodeOriginalUrl(): String {
        return HashUtil.base64(HashUtil.md5(originalUrl)).substring(0, 7)
    }
}
