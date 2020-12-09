package com.itl.kg.passwordmachine.module


class StringBlender(
    private val outputMaxSize: Int = 8,
    private val module: BlenderModule = LookTableModule()
) {

    private val hashHelper = HashHelper()

    fun process(input: String): String {

        var output = hashHelper.saltString(input)

        do {
            output = module.start(output)
        } while (output.length > outputMaxSize)

        return output
    }
}
