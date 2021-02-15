package com.itl.kg.passwordmachine.module

import java.util.*


class StringBlender(
    private val outputMaxSize: Int = 8,
    private val module: BlenderModule = LookTableModule()
) {

    private val hashHelper = HashProcessTool()

    @Deprecated("查表法還需要研究")
    fun lookTableWithHash(input: String): String {

        var output = hashHelper.saltString(input)

        do {
            output = module.start(output)
        } while (output.length > outputMaxSize)

        return output
    }

    fun hashString(input: String): String {
        val result = hashHelper.saltString(input).toUpperCase(Locale.getDefault())
        return result.slice(0 until outputMaxSize)
    }

}
