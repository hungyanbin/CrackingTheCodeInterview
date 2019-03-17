package com.yanbin.crackingthecodeinterview.chapter1

import org.junit.Test

class ArrayString_7 {

    fun rotate(matrix: MutableList<MutableList<Int>>) {
        val rowCount = matrix.size

        for (i in 0 until rowCount) {
            val row = matrix[i]
            for (j in i + 1 until row.size) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
    }


    @Test
    fun `matrix rotate test`() {
        val input = mutableListOf(
            mutableListOf(1, 2, 3),
            mutableListOf(4, 5, 6),
            mutableListOf(7, 8, 9))

        println("input:")
        printMatrix(input)

        rotate(input)

        println("\noutput:")
        printMatrix(input)
    }

    private fun printMatrix(matrix: List<List<Int>>) {
        for (row in matrix) {
            println(row)
        }
    }
}
