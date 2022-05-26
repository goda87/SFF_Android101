package com.example.kotlin101

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KotlinExampleTest {

    private lateinit var sut: KotlinExample

    private val sortExpectedResult = listOf("sand", "surf", "sun", "water", "waves")

    @BeforeEach
    fun before() {
        sut = KotlinExample()
    }

    @DisplayName(
        """
            Given a list of strings
            When sort reading from right to left
            Then should return a list with the strings in the input string ordered alphabetically
             with the letters at the end of the string taking priority over letters at the start
             of the string.
        """
    )
    @Test
    fun testSort() {
        // given
        val input = listOf("sand", "water", "sun", "waves", "surf")
        // when
        val output = sut.sortReadingFromRightToLeft(input)
        // then
        assertEquals(sortExpectedResult, output)
    }


    @DisplayName(
        """
            Given a number
            When fizzbuzz
            Then should return
             a String representation of the number if not multiple of 3 or 5
             fizz if multiple of 3
             buzz if multiple of 5
             fizzbuzz if multiple of 3 and 5
        """
    )
    @ParameterizedTest
    @ArgumentsSource(FizzBuzzArgumentsProvider::class)
    fun testRequiredParams(expected: String, given: Int) {
        // when
        val result = sut.fizzbuzz(given)
        // then
        assertEquals(expected, result)
    }

    @DisplayName(
        """
            Given a number
            When fizzbuzzUntil
            Then should return string with the result of the fizzbuzz game until that number
        """
    )
    @Test
    fun testFizzBuzzUntil() {
        // given
        val input = 200
        // when
        val output = sut.fizzbuzzUntil(input)
        // then
        assertEquals(fizzbuzz200, output)
    }
}

internal class FizzBuzzArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext): Stream<out Arguments> {
        return Stream.of(
            arguments("1", 1),
            arguments("2", 2),
            arguments("fizz", 3),
            arguments("4", 4),
            arguments("buzz", 5),
            arguments("fizz", 9),
            arguments("fizzbuzz", 15),
            arguments("fizzbuzz", 30),
            arguments("32", 32),
            arguments("fizz", 33),
            arguments("fizzbuzz", 45),
            arguments("buzz", 50),
            arguments("fizz", 51),
            arguments("53", 53),
            arguments("fizzbuzz", 60),
            arguments("fizz", 63),
            arguments("fizzbuzz", 75),
            arguments("fizzbuzz", 90),
            arguments("fizzbuzz", 105),
            arguments("fizz", 108),
        )
    }
}

private const val fizzbuzz200 = "fizzbuzz; 1; 2; fizz; 4; buzz; fizz; 7; 8; fizz; buzz; 11; fizz; 13; 14; fizzbuzz; 16; 17; fizz; 19; buzz; fizz; 22; 23; fizz; buzz; 26; fizz; 28; 29; fizzbuzz; 31; 32; fizz; 34; buzz; fizz; 37; 38; fizz; buzz; 41; fizz; 43; 44; fizzbuzz; 46; 47; fizz; 49; buzz; fizz; 52; 53; fizz; buzz; 56; fizz; 58; 59; fizzbuzz; 61; 62; fizz; 64; buzz; fizz; 67; 68; fizz; buzz; 71; fizz; 73; 74; fizzbuzz; 76; 77; fizz; 79; buzz; fizz; 82; 83; fizz; buzz; 86; fizz; 88; 89; fizzbuzz; 91; 92; fizz; 94; buzz; fizz; 97; 98; fizz; buzz; 101; fizz; 103; 104; fizzbuzz; 106; 107; fizz; 109; buzz; fizz; 112; 113; fizz; buzz; 116; fizz; 118; 119; fizzbuzz; 121; 122; fizz; 124; buzz; fizz; 127; 128; fizz; buzz; 131; fizz; 133; 134; fizzbuzz; 136; 137; fizz; 139; buzz; fizz; 142; 143; fizz; buzz; 146; fizz; 148; 149; fizzbuzz; 151; 152; fizz; 154; buzz; fizz; 157; 158; fizz; buzz; 161; fizz; 163; 164; fizzbuzz; 166; 167; fizz; 169; buzz; fizz; 172; 173; fizz; buzz; 176; fizz; 178; 179; fizzbuzz; 181; 182; fizz; 184; buzz; fizz; 187; 188; fizz; buzz; 191; fizz; 193; 194; fizzbuzz; 196; 197; fizz; 199; buzz"