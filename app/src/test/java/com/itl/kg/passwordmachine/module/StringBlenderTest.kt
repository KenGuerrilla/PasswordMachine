package com.itl.kg.passwordmachine.module

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by kenguerrilla on 2020/7/14.
 */
class StringBlenderTest {

    private val testMessage = "testMessage"
    private val testMessageFinal = "Y1KBLFA7"
    private val blenderDefaultModule = StringBlender()

    @Test
    fun processTest() {
        val result = blenderDefaultModule.process(testMessage)
        assertTrue(result == testMessageFinal)
    }
}