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
 * The Kotlin/JS implementation of the Error class never returns any errors.
 * Only simulates to do that.
 *
 * @constructor Create empty Error
 */
actual class Error : AbstractError() {
    actual companion object {
        actual var errNum: Int = 0
        actual var errMsg: String = ""

        /**
         * Load
         *
         */
        actual fun load() {}

        /**
         * Reset
         *
         */
        actual fun reset() {}

        /**
         * Number of ERRNO error codes totally supported.
         *
         * @return The total number of possible ERRNOs.
         */
        actual fun errnoCount(): Int = 0

        /**
         * Get the currently implemented errno code at given index.
         * Returns 0 if there is no code are abbreviation on the current index.
         *
         * @param index Index to receive.
         * @return The current implementation value.
         */
        actual fun errnoCode(index: Int): Int = 0

        /**
         * Get the currently implemented errno abbreviation at a given index.
         * If 0 is returned for a given index then abbreviation will be NULL.
         *
         * @param index Index to receive.
         * @return The current implementation abbreviation.
         */
        actual fun errnoAbbr(index: Int): String = ""
    }
}