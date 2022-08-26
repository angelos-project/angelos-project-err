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

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFailsWith

actual class ExtKtTest : BaseError() {
// JS currently don't support underlying POSIX errors.
// May come in the future, hold out, or contribute please.

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
        assertFailsWith<UnsupportedErrnoException> {
            errorByNullPredicate("Return NULL by zero") {
                0
            }
        }

        // Cheating because of JS simulation
        Error.errNum = 1
        Error.errMsg = "Error"
    }

    fun oneLong(): Long = 1L

    @Test
    actual fun errorByNonZeroPredicate() {
        assertFailsWith<UnsupportedErrnoException> {
            errorByNonZeroPredicate("Return nonzero") {
                1
            }
        }

        // Cheating because of JS simulation
        Error.errNum = 1
        Error.errMsg = "Error"
    }

    @Test
    actual fun errorByMinusOnePredicate() {
        assertFailsWith<UnsupportedErrnoException> {
            errorByMinusOnePredicate("Return minus one") {
                -1
            }
        }

        // Cheating because of JS simulation
        Error.errNum = 1
        Error.errMsg = "Error"
    }

    @Test
    actual fun testErrorByNullPredicateLong() {
        assertFailsWith<UnsupportedErrnoException> {
            errorByNullPredicate(0L) { it }
        }

        // Cheating because of JS simulation
        Error.errNum = 1
        Error.errMsg = "Error"
    }

    @Test
    actual fun testErrorByNullPredicateInt() {
        assertFailsWith<UnsupportedErrnoException> {
            errorByNullPredicate(0) { it }
        }

        // Cheating because of JS simulation
        Error.errNum = 1
        Error.errMsg = "Error"
    }

    @Test
    actual fun testErrorByMinusOnePredicateLong() {
        assertFailsWith<UnsupportedErrnoException> {
            errorByMinusOnePredicate(-1L) { it }
        }

        // Cheating because of JS simulation
        Error.errNum = 1
        Error.errMsg = "Error"
    }

    @Test
    actual fun testErrorByMinusOnePredicateInt() {
        assertFailsWith<UnsupportedErrnoException> {
            errorByMinusOnePredicate(-1) { it }
        }

        // Cheating because of JS simulation
        Error.errNum = 1
        Error.errMsg = "Error"
    }

    @Test
    actual fun testErrorByNonZeroPredicateLong() {
        assertFailsWith<UnsupportedErrnoException> {
            errorByNonZeroPredicate(1L) { it }
        }

        // Cheating because of JS simulation
        Error.errNum = 1
        Error.errMsg = "Error"
    }

    @Test
    actual fun testErrorByNonZeroPredicateInt() {
        assertFailsWith<UnsupportedErrnoException> {
            errorByNonZeroPredicate(1) { it }
        }

        // Cheating because of JS simulation
        Error.errNum = 1
        Error.errMsg = "Error"
    }
}