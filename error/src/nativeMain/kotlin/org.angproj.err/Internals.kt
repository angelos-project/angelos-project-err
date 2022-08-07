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

import kotlinx.cinterop.toKString
import kotlinx.cinterop.usePinned
import platform.posix.errno
import platform.posix.strerror
import cerror.clear_error

internal actual class Internals {
    actual companion object {
        actual fun getError() {
            Error.errNum.usePinned { errno }
            Error.errMsg.usePinned { strerror(errno)?.toKString().toString() }
            clear_error()
        }
    }
}