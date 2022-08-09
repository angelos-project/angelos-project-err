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

/**
 * Predicate an error if NULL, based on the return value of the POSIX function.
 * Usually those functions are supposed to return a valid pointer.
 *
 * @param msg Describing the action that may go wrong.
 * @param predicate Lambda carrying out the POSIX operation.
 * @receiver
 * @return On success returns presumably a pointer as a Long.
 */
inline fun errorByNullPredicate(msg: String, predicate: () -> Long): Long = when (val outcome = predicate()) {
    0L -> throw AbstractError.error(msg)
    else -> outcome
}

/**
 * Predicate an error if more than 0, based on the return value of the POSIX function.
 * Usually those functions are supposed to return zero or an error.
 *
 * @param msg Describing the action that may go wrong.
 * @param predicate Lambda carrying out the POSIX operation.
 * @receiver
 * @return On success returns the result as an Int.
 */
/*inline fun errorByNonZeroPredicate(msg: String, predicate: () -> Int): Int = when(val outcome = predicate()) {
    in 1..Int.MAX_VALUE -> throw AbstractError.error(msg)
    else -> outcome
}*/

/**
 * Predicate an error if -1, based on the return value of the POSIX function.
 * Usually those functions are supposed to return zero or positive value but -1 indicate error.
 *
 * @param msg Describing the action that may go wrong.
 * @param predicate Lambda carrying out the POSIX operation.
 * @receiver
 * @return On success returns the result as an Int.
 */
inline fun errorByMinusOnePredicate(msg: String, predicate: () -> Int): Int = when (val outcome = predicate()) {
    -1 -> throw AbstractError.error(msg)
    else -> outcome
}