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

inline fun errorByNullPredicate(msg: String, predicate: () -> Long): Long = when (val outcome = predicate()) {
    0L -> throw AbstractError.error(msg)
    else -> outcome
}

inline fun errorByPositivePredicate(msg: String, predicate: () -> Int): Int = when(val outcome = predicate()) {
    in 1..Int.MAX_VALUE -> throw AbstractError.error(msg)
    else -> outcome
}

inline fun errorByMinusOnePredicate(msg: String, predicate: () -> Int): Int = when (val outcome = predicate()) {
    -1 -> throw AbstractError.error(msg)
    else -> outcome
}