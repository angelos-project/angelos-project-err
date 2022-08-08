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
 * Error base class for error handling.
 *
 * @constructor Create empty Abstract error
 */
abstract class AbstractError {
    companion object {

        /**
         * Error handling after a POSIX function has been called.
         * prepares a PosixError containing message, error description and error code.
         *
         * @param err Current execution message.
         * @return PosixError exception to be thrown.
         */
        inline fun error(err: String): PosixError {
            Error.load()
            Error.reset()
            return PosixError("$err: (${Error.errNum}) ${Error.errMsg}")
        }
    }
}