package com.dkbcodefactory.shorturl.util

import java.math.BigInteger
import java.security.MessageDigest
import java.util.Base64

class HashUtil {

    companion object {
        fun md5(input: String): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }

        fun base64(input: String): String {
            return Base64.getEncoder().encodeToString(input.toByteArray())
        }
    }
}