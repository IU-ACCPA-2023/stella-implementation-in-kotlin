package org.stella

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.File
import java.io.FileInputStream
import java.io.IOException

internal class MainTest {
    @ParameterizedTest(name = "{index} Typechecking well-typed program {0}")
    @ValueSource(strings = ["tests/well-typed/factorial.stella", "tests/well-typed/squares.stella", "tests/well-typed/increment_twice.stella", "tests/well-typed/logical-operators.stella"])
    @Throws(
        IOException::class,
        Exception::class
    )
    fun testWellTyped(filepath: String?) {
        val args = arrayOfNulls<String>(0)
        val original = System.`in`
        val fips = FileInputStream(File(filepath))
        System.setIn(fips)
        Main.main(args)
        System.setIn(original)
    }

    @ParameterizedTest(name = "{index} Typechecking ill-typed program {0}")
    @ValueSource(strings = ["tests/ill-typed/bad-squares-1.stella", "tests/ill-typed/bad-squares-2.stella"])
    @Throws(
        IOException::class,
        Exception::class
    )
    fun testIllTyped(filepath: String?) {
        val args = arrayOfNulls<String>(0)
        val original = System.`in`
        val fips = FileInputStream(File(filepath))
        System.setIn(fips)
        try {
            Main.main(args)
            throw Exception("expected the typechecker to fail!")
        } catch (e: Exception) {
            // TODO: check that there is a type error actually, and not a problem with implementation
        }
        System.setIn(original)
    }
}