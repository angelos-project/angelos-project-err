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

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse

class ErrNameTest {

    @Test
    fun codeToName() {
        assertFailsWith<UnsupportedErrnoException> {
            ErrName.codeToName(0)
        }
    }

    @Test
    fun nameToCode() {
        assertFailsWith<UnsupportedErrnoException> {
            ErrName.nameToCode(ErrName.UNKNOWN)
        }
    }

    @Test
    fun isImplementedInt() {
        assertFalse(ErrName.isImplemented(0))
    }

    @Test
    fun isImplementedEnum() {
        assertFalse(ErrName.isImplemented(ErrName.UNKNOWN))
    }

    @Test
    fun values() {
        for (value in ErrName.values()) {
            if(ErrName.isImplemented(value)) {
                println("✅ - ${ErrName.nameToCode(value)}: $value")
            } else {
                println("❌ - n/a: $value")
            }
        }
    }
}