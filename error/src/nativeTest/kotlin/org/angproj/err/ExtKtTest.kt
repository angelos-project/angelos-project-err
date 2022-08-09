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

import kotlinx.cinterop.toLong
import platform.posix.*
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
        assertFailsWith<PosixError> {
            errorByNullPredicate("Eat RAM") {
                malloc(ULong.MAX_VALUE).toLong()
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
                close(Int.MAX_VALUE)
            }
        }
    }
}