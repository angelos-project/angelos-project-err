/**
 * Copyright (c) 2022 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
 *
 * This software is available under the terms of the MIT license. Parts are licensed
 * under different terms if stated. The legal terms are attached to the LICENSE file
 * and are made available on:
 *
 *      https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 *
 * Contributors:
 *      Kristoffer Paulsson - initial implementation
 */
package org.angproj.io.err

import kotlinx.cinterop.toLong
import platform.posix.NULL
import platform.posix.close
import platform.posix.malloc
import kotlin.test.*

actual class ExtKtTest : BaseError(){

    @BeforeTest
    fun setUp (){
        prepareEmpty()
    }

    @AfterTest
    fun tearDown() {
        assertLoaded()
    }

    @Test
    actual fun errorByNullPredicate() {
        assertEquals(1, errorByNullPredicate("Return NULL by zero") { 1 })
        assertFailsWith<PosixError> {
            errorByNullPredicate("Eat RAM") {
                malloc(ULong.MAX_VALUE).toLong()
            }
        }
    }

    @Test
    actual fun errorByNonZeroPredicate() {
        assertEquals(0, errorByNonZeroPredicate("Return nonzero") { 0 })
        assertFailsWith<PosixError> {
            errorByNonZeroPredicate("Close nothing") {
                malloc(ULong.MAX_VALUE)
                1
            }
        }
    }

    @Test
    actual fun errorByMinusOnePredicate() {
        assertEquals(0, errorByMinusOnePredicate("Return minus one") { 0 })
        assertFailsWith<PosixError> {
            errorByMinusOnePredicate("Infinite descriptor") {
                close(Int.MAX_VALUE)
            }
        }
    }

    @Test
    actual fun testErrorByNullPredicateLong() {
        assertEquals(1L, errorByNullPredicate(1L) { it })
        assertFailsWith<PosixError> {
            errorByNullPredicate(malloc(ULong.MAX_VALUE).toLong()) { it }
        }
    }

    @Test
    actual fun testErrorByNullPredicateInt() {
        assertEquals(1, errorByNullPredicate(1) { it })
        assertFailsWith<PosixError> {
            errorByNullPredicate(malloc(ULong.MAX_VALUE).toLong().toInt()) { it }
        }
    }

    @Test
    actual fun testErrorByMinusOnePredicateLong() {
        assertEquals(1L, errorByMinusOnePredicate(1L) { it })
        assertFailsWith<PosixError> {
            errorByMinusOnePredicate(close(Int.MAX_VALUE).toLong()) { it }
        }
    }

    @Test
    actual fun testErrorByMinusOnePredicateInt() {
        assertEquals(0, errorByMinusOnePredicate(0) { it })
        assertFailsWith<PosixError> {
            errorByMinusOnePredicate(close(Int.MAX_VALUE)) { it }
        }
    }

    @Test
    actual fun testErrorByNonZeroPredicateLong() {
        assertEquals(0L, errorByNonZeroPredicate(0L) { it })
        assertFailsWith<PosixError> {
            malloc(ULong.MAX_VALUE)
            errorByNonZeroPredicate(1L) { it }
        }
    }

    @Test
    actual fun testErrorByNonZeroPredicateInt() {
        assertEquals(0, errorByNonZeroPredicate(0) { it })
        assertFailsWith<PosixError> {
            malloc(ULong.MAX_VALUE)
            errorByNonZeroPredicate(1.toInt()) { it }
        }
    }
}