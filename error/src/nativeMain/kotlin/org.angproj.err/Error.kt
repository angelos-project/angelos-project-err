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
package org.angproj.err

import cerror.clear_error
import kotlinx.cinterop.toKString
import kotlinx.cinterop.usePinned
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
    }
}