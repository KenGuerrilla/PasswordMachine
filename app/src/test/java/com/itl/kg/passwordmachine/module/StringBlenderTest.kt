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
        val result = blenderDefaultModule.lookTableWithHash(testMessage)
        assertTrue(result == testMessageFinal)
    }
}