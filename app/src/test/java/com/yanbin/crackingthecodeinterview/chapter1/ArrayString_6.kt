package com.yanbin.crackingthecodeinterview.chapter1

import org.junit.Assert
import org.junit.Test
import java.lang.StringBuilder

class ArrayString_6 {

    fun compress(input: String): String {
        var charCount = 1
        var currentChar = input[0]
        var output = StringBuilder()

        for (i in 1 until input.length) {
            if (input[i] == currentChar) {
                charCount ++
            } else {
                output.append("$currentChar$charCount")
                charCount = 1
                currentChar = input[i]
            }
        }
        output.append("$currentChar$charCount")

        return if(output.length > input.length) input else output.toString()
    }

    @Test
    fun `'aaaaa' should return 'a5'`() {
        val input = "aaaaa"
        val result = compress(input)
        val expect = "a5"

        Assert.assertEquals(expect, result)
    }

    @Test
    fun `'aabcccccaaa' should return 'a2b1c5a3'`() {
        val input = "aabcccccaaa"
        val result = compress(input)
        val expect = "a2b1c5a3"

        Assert.assertEquals(expect, result)
    }

    @Test
    fun `'abcd' should return 'abck'`() {
        val input = "abcd"
        val result = compress(input)
        val expect = "abcd"

        Assert.assertEquals(expect, result)
    }
}