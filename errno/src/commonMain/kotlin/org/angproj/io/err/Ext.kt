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

/**
 * Posix errno receiver function.
 *
 * @return PosixError exception that may be thrown.
 */
inline fun Error.Companion.posix(): PosixError {
    load()
    reset()
    val name = ErrName.codeToName(errNum)
    return PosixError("POSIX errno: ($errNum, ${name}) $errMsg", name)
}

/**
 * Predicate an error if NULL, based on the return value of the POSIX function.
 * Usually those functions are supposed to return a valid pointer.
 *
 * @param msg Describing the action that may go wrong.
 * @param predicate Lambda carrying out the POSIX operation.
 * @receiver
 * @return On success returns presumably a pointer as a Long.
 */
@Deprecated("Use generic predicate function instead.")
inline fun errorByNullPredicate(msg: String, predicate: () -> Long): Long = when (val outcome = predicate()) {
    0L -> throw AbstractError.error(msg)
    else -> outcome
}

/**
 * Predicate an error if NULL, based on the return value of the POSIX function.
 * Usually those functions are supposed to return a valid pointer.
 *
 * @param E Generic exception to be turned to the error method.
 * @param predicate Predicate to be examined.
 * @param handler Lambda that build eventual exeption to be thrown.
 * @receiver
 * @return The predicate.
 */
@Throws(RuntimeException::class)
inline fun <E: RuntimeException>errorByNullPredicate(predicate: Long, handler: (it: PosixError) -> E): Long = when (predicate) {
    0L -> throw handler(Error.posix())
    else -> predicate
}

/**
 * Predicate an error if NULL, based on the return value of the POSIX function.
 * Usually those functions are supposed to return a valid pointer.
 *
 * @param E Generic exception to be turned to the error method.
 * @param predicate Predicate to be examined.
 * @param handler Lambda that build eventual exeption to be thrown.
 * @receiver
 * @return The predicate.
 */
@Throws(RuntimeException::class)
inline fun <E: RuntimeException>errorByNullPredicate(predicate: Int, handler: (it: PosixError) -> E): Int = when (predicate) {
    0 -> throw handler(Error.posix())
    else -> predicate
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
@Deprecated("Use generic predicate function instead.")
inline fun errorByNonZeroPredicate(msg: String, predicate: () -> Long): Long = when(val outcome = predicate()) {
    in 1..Long.MAX_VALUE -> throw AbstractError.error(msg)
    else -> outcome
}

/**
 * Predicate an error if more than 0, based on the return value of the POSIX function.
 * Usually those functions are supposed to return zero or an error.
 *
 * @param E Generic exception to be turned to the error method.
 * @param predicate Predicate to be examined.
 * @param handler Lambda that build eventual exeption to be thrown.
 * @receiver
 * @return The predicate.
 */
@Throws(RuntimeException::class)
inline fun <E: RuntimeException>errorByNonZeroPredicate(predicate: Long, handler: (it: PosixError) -> E): Long = when (predicate) {
    in 1L..Long.MAX_VALUE -> throw handler(Error.posix())
    else -> predicate
}

/**
 * Predicate an error if more than 0, based on the return value of the POSIX function.
 * Usually those functions are supposed to return zero or an error.
 *
 * @param E Generic exception to be turned to the error method.
 * @param predicate Predicate to be examined.
 * @param handler Lambda that build eventual exeption to be thrown.
 * @receiver
 * @return The predicate.
 */
@Throws(RuntimeException::class)
inline fun <E: RuntimeException>errorByNonZeroPredicate(predicate: Int, handler: (it: PosixError) -> E): Int = when (predicate) {
    in 1..Int.MAX_VALUE -> throw handler(Error.posix())
    else -> predicate
}

/**
 * Predicate an error if -1, based on the return value of the POSIX function.
 * Usually those functions are supposed to return zero or positive value but -1 indicate error.
 *
 * @param msg Describing the action that may go wrong.
 * @param predicate Lambda carrying out the POSIX operation.
 * @receiver
 * @return On success returns the result as an Int.
 */
@Deprecated("Use generic predicate function instead.")
inline fun errorByMinusOnePredicate(msg: String, predicate: () -> Int): Int = when (val outcome = predicate()) {
    -1 -> throw AbstractError.error(msg)
    else -> outcome
}

/**
 * Predicate an error if -1, based on the return value of the POSIX function.
 * Usually those functions are supposed to return zero or positive value but -1 indicate error.
 *
 * @param E Generic exception to be turned to the error method.
 * @param predicate Predicate to be examined.
 * @param handler Lambda that build eventual exeption to be thrown.
 * @receiver
 * @return The predicate.
 */
@Throws(RuntimeException::class)
inline fun <E: RuntimeException>errorByMinusOnePredicate(predicate: Long, handler: (it: PosixError) -> E): Long = when (predicate) {
    -1L -> throw handler(Error.posix())
    else -> predicate
}

/**
 * Predicate an error if -1, based on the return value of the POSIX function.
 * Usually those functions are supposed to return zero or positive value but -1 indicate error.
 *
 * @param E Generic exception to be turned to the error method.
 * @param predicate Predicate to be examined.
 * @param handler Lambda that build eventual exeption to be thrown.
 * @receiver
 * @return The predicate.
 */
@Throws(RuntimeException::class)
inline fun <E: RuntimeException>errorByMinusOnePredicate(predicate: Int, handler: (it: PosixError) -> E): Int = when (predicate) {
    -1 -> throw handler(Error.posix())
    else -> predicate
}