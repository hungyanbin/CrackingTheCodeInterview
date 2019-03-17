package com.yanbin.crackingthecodeinterview.chapter1

import org.junit.Assert
import org.junit.Test

class ArrayString_8 {

    fun isRotation(str1: String, str2: String): Boolean {
        if(str1.length != str2.length) {
            return false
        }

        for (i in 1 until str2.length) {
            if (str2.substring(0, i).isSubstringOf(str1)) {
                if (str2.substring(i, str2.length) + str2.substring(0, i) == str1) {
                    return true
                }
            }
        }

        return false
    }

    private fun String.isSubstringOf(comp: String): Boolean {
        return comp.contains(this)
    }

    @Test
    fun `"abc" is rotation of "bca"`() {
        val result = isRotation("abc", "bca")

        Assert.assertTrue(result)
    }

    @Test
    fun `"waterbottle" is rotation of "erbottlewat"`() {
        val result = isRotation("waterbottle", "erbottlewat")

        Assert.assertTrue(result)
    }


    @Test
    fun `"waterbottle" is not rotation of "rbottlewat"`() {
        val result = isRotation("waterbottle", "rbottlewat")

        Assert.assertFalse(result)
    }

    @Test
    fun `"ababbaba" is not rotation of "babababa"`() {
        val result = isRotation("ababbaba", "babababa")

        Assert.assertFalse(result)
    }
}