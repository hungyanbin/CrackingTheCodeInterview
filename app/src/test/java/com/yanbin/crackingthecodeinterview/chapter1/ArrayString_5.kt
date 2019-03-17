package com.yanbin.crackingthecodeinterview.chapter1

import org.junit.Assert
import org.junit.Test

class ArrayString_5 {

    fun isAtLeastOneEdit(origin: String, comp: String): Boolean {
        val originLength = origin.length
        val compLength = comp.length
        var originIndex = 0
        var compIndex = 0


        //replace
        var editFound = false
        while (originIndex < originLength && compIndex < compLength) {
            if (origin[originIndex] == comp[compIndex]) {
                originIndex++
                compIndex++
            } else {
                if (editFound) {
                    return false
                }
                editFound = true
                when {
                    originLength < compLength -> compIndex++
                    compLength < originLength -> originIndex++
                    else -> {
                        originIndex++
                        compIndex++
                    }
                }
            }
        }

        return true


    }

    @Test
    fun `pale and paaale should return false`() {
        val origin = "pale"
        val comp = "paaale"

        val result = isAtLeastOneEdit(origin, comp)

        Assert.assertFalse(result)
    }

    @Test
    fun `pale and ple should return true`() {
        val origin = "pale"
        val comp = "ple"

        val result = isAtLeastOneEdit(origin, comp)

        Assert.assertTrue(result)
    }

    @Test
    fun `pales and pals should return true`() {
        val origin = "pales"
        val comp = "pals"

        val result = isAtLeastOneEdit(origin, comp)

        Assert.assertTrue(result)
    }


    @Test
    fun `pales and pale should return true`() {
        val origin = "pales"
        val comp = "pale"

        val result = isAtLeastOneEdit(origin, comp)

        Assert.assertTrue(result)
    }


    @Test
    fun `pale and bale should return true`() {
        val origin = "pale"
        val comp = "bale"

        val result = isAtLeastOneEdit(origin, comp)

        Assert.assertTrue(result)
    }


    @Test
    fun `pale and bake should return false`() {
        val origin = "pale"
        val comp = "bake"

        val result = isAtLeastOneEdit(origin, comp)

        Assert.assertFalse(result)
    }

    @Test
    fun `'' and b should return true`() {
        val origin = ""
        val comp = "b"

        val result = isAtLeastOneEdit(origin, comp)

        Assert.assertTrue(result)
    }

    @Test
    fun `pale and palle should return true`() {
        val origin = "pale"
        val comp = "palle"

        val result = isAtLeastOneEdit(origin, comp)

        Assert.assertTrue(result)
    }

    @Test
    fun `'a' and 'b' should return true`() {
        val origin = "a"
        val comp = "b"

        val result = isAtLeastOneEdit(origin, comp)

        Assert.assertTrue(result)
    }
}