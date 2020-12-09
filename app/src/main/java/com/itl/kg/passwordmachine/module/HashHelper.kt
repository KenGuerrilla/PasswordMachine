package com.itl.kg.passwordmachine.module

import java.math.BigInteger
import java.security.MessageDigest

class HashHelper {

    private val md = MessageDigest.getInstance("SHA-512")

    fun saltString(source: String): String {
        md.update(source.toByteArray())
        val digest = md.digest()

        // %x為16進制整數, 064則代表輸出長度為64byte，不足的長度則在前頭補上0
        return String.format("%064x", BigInteger(1, digest))
    }
}