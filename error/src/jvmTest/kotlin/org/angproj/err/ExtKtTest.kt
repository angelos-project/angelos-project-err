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
package org.angproj.err

import kotlin.test.Test
import kotlin.test.BeforeTest
import kotlin.test.AfterTest
import kotlin.test.assertFailsWith

actual class ExtKtTest : BaseError() {

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
        assertFailsWith<PosixError> {
            errorByNullPredicate("Eat RAM") {
                TestPosix.test_malloc(Long.MAX_VALUE)
            }
        }
    }

    /*@Test
    actual fun errorByNonZeroPredicate() {
        assertFailsWith<PosixError> {
            errorByNonZeroPredicate("Close nothing") {
                fclose(Long.MAX_VALUE.toCPointer())
            }
        }
    }*/

    @Test
    actual fun errorByMinusOnePredicate() {
        assertFailsWith<PosixError> {
            errorByMinusOnePredicate("Infinite descriptor") {
                TestPosix.test_close(Int.MAX_VALUE)
            }
        }
    }

}

