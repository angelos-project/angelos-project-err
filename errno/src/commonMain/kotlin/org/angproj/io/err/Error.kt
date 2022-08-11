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

/**
 * Static error handling class, temporary holding every error and errno, to be passed
 * from the underlying POSIX system.
 *
 * @constructor Create empty Error
 */
@Suppress("VARIABLE_IN_SINGLETON_WITHOUT_THREAD_LOCAL")
expect class Error : AbstractError {
    companion object {
        /**
         * Temporarily holds the errno from POSIX.
         */
        var errNum: Int

        /**
         * Temporarily holds the POSIX error description of the errno.
         */
        var errMsg: String

        /**
         * Loads error values into the execution environment.
         *
         */
        fun load()

        /**
         * Resets the current error code in the POSIX library.
         *
         */
        fun reset()

        /**
         * Number of ERRNO error codes totally supported.
         *
         * @return The total number of possible ERRNOs.
         */
        fun errnoCount(): Int

        /**
         * Get the currently implemented errno code at given index.
         * Returns 0 if there is no code are abbreviation on the current index.
         *
         * @param index Index to receive.
         * @return The current implementation value.
         */
        fun errnoCode(index: Int): Int

        /**
         * Get the currently implemented errno abbreviation at a given index.
         * If 0 is returned for a given index then abbreviation will be NULL.
         *
         * @param index Index to receive.
         * @return The current implementation abbreviation.
         */
        fun errnoAbbr(index: Int): String
    }
}