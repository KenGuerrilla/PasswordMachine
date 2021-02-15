package com.itl.kg.passwordmachine.module

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.lang.StringBuilder

/**
 *
 *  查表法要做更動，透過間隔的方式來取出相對應的字串
 *  groupSize一樣維持在兩位數，對其使用materialList.size()的數值做餘數處理
 *
 */

class LookTableModule(
    private val groupSize: Int = 2,
    private val fillChar: Char = '0'
): BlenderModule {

    private val materialList: List<String> = mutableListOf<String>().also {
        for (s in '0'..'9') {
            it.add(s.toString())
        }
        for (s in 'A'..'Z') {
            it.add(s.toString())
        }
    }

    override fun start(input: String): String = input.run {
        convertLetterToASCii(this)
    }.run {
        groupStringByFillSize(this)
    }.run {
        findLetterByIndex(this)
    }.joinToString("", "", "")


    // 除了數字外所有字元全轉為ASCII碼
    private fun convertLetterToASCii(s: String): String {
        val numberList = mutableListOf<String>()
        for (char in s) {
            if (char in '0'..'9') {
                numberList.add(char.toString())
            } else {
                numberList.add(char.toInt().toString())
            }
        }

        val result = numberList.joinToString("", "", "")

        return fillInZero(result)
    }

    // 檢查數字字串是否需要補零
    private fun fillInZero(s: String): String {
        val needFillSize = groupSize - (s.length % groupSize)
        val charArray = s.toMutableList()

        if (needFillSize > 0) {
            repeat(needFillSize) {
                charArray.add(fillChar)
            }
        }

        return charArray.joinToString("", "", "")
    }

    // 將數字切分為指定大小的字串，依序加入List並回傳
    private fun groupStringByFillSize(s: String): List<String> {
        val numberList = mutableListOf<String>()

        for (index in s.indices step groupSize) {
            val stringBuilder = StringBuilder()
            repeat(groupSize) { count ->
                stringBuilder.append(s[index + count])
            }
            numberList.add(stringBuilder.toString())
        }

        return numberList
    }

    // 檢查數字字串內容，檢查並依序去除位於數字前頭的0，完成後將其轉為Int
    // 如果數字全部為零而產生空字串，轉型為Int時觸發NumberFormatException，則回傳fillChar的ASCII碼
    private fun checkStringToInt(string: String): Int {

        for (s in string) {
            if (s !in '0'..'9')
                throw IllegalArgumentException("the string have a Illegal argument")
        }

        return try {
            string.dropLastWhile { it == '0' }.toInt()
        } catch (e: NumberFormatException) {
            fillChar.toInt()
        }
    }

    // 透過查表法比對table中對應Index的字母
    private fun findLetterByIndex(numberGroup: List<String>) = mutableListOf<String>().apply {
        for (string in numberGroup) {
            val disCode = checkStringToInt(string) % materialList.size
            this.add(materialList[disCode])
        }
    }

}