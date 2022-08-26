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

expect class ExtKtTest : BaseError {
    @Test
    fun errorByNullPredicate()

    @Test
    fun testErrorByNullPredicateLong()

    @Test
    fun testErrorByNullPredicateInt()

    @Test
    fun errorByMinusOnePredicate()

    @Test
    fun testErrorByMinusOnePredicateLong()

    @Test
    fun testErrorByMinusOnePredicateInt()

    @Test
    fun errorByNonZeroPredicate()

    @Test
    fun testErrorByNonZeroPredicateLong()

    @Test
    fun testErrorByNonZeroPredicateInt()
}