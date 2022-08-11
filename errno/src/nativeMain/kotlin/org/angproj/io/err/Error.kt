/**
 * Copyright (c) 2021-2022 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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

import cerrno.clear_error
import cerrno.errno_abbr
import cerrno.errno_code
import cerrno.errno_count
import kotlinx.cinterop.toKString
import platform.posix.errno
import platform.posix.strerror

/**
 * The Kotlin/Native receive errors and perform resets by using c-interop.
 *
 * @constructor Create empty Error
 */
@Suppress("VARIABLE_IN_SINGLETON_WITHOUT_THREAD_LOCAL")
actual class Error : AbstractError() {
    actual companion object {
        actual var errNum: Int = 0
        actual var errMsg: String = ""

        /**
         * Load
         *
         */
        actual inline fun load() {
            errNum = errno
            errMsg = strerror(errno)?.toKString().toString()
        }

        /**
         * Reset
         *
         */
        actual inline fun reset() {
            clear_error()
        }

        /**
         * Number of ERRNO error codes totally supported.
         *
         * @return The total number of possible ERRNOs.
         */
        actual inline fun errnoCount(): Int = errno_count().toInt()

        /**
         * Get the currently implemented errno code at given index.
         * Returns 0 if there is no code are abbreviation on the current index.
         *
         * @param index Index to receive.
         * @return The current implementation value.
         */
        actual inline fun errnoCode(index: Int): Int = errno_code(index.toUInt()).toInt()

        /**
         * Get the currently implemented errno abbreviation at a given index.
         * If 0 is returned for a given index then abbreviation will be NULL.
         *
         * @param index Index to receive.
         * @return The current implementation abbreviation.
         */
        actual inline fun errnoAbbr(index: Int): String = errno_abbr(index.toUInt())?.toKString() ?: ""
    }
}