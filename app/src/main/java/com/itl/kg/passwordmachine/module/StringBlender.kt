package com.itl.kg.passwordmachine.module

import java.math.BigInteger
import java.security.MessageDigest


class StringBlender(
    private val outputMaxSize: Int = 8,
    private val module: BlenderModule = LookTableModule()
) {

    fun process(input: String): String {

        var output = hashBySHA256(input)

        do {
            output = module.start(output)
        } while (output.length > outputMaxSize)

        return output
    }

    // Hash處理
    private fun hashBySHA256(origin: String): String {
        val md = MessageDigest.getInstance("SHA-256")
            .also { it.update(origin.toByteArray()) }
        val digest = md.digest()
        // %x為16進制整數, 064則代表輸出長度為64byte，不足的長度則在前頭補上0
        return String.format("%064x", BigInteger(1, digest))
    }

}
