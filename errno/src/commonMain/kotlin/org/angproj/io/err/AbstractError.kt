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
 * Abstract base class for error handling.
 */
abstract class AbstractError {
    companion object {

        /**
         * Error handling after a POSIX function has been called.
         * Prepares a PosixError containing: a message, error description, and error code.
         *
         * @param err Current execution message.
         * @return PosixError exception to be thrown.
         */
        inline fun error(err: String): PosixError {
            Error.load()
            Error.reset()
            val name = ErrName.codeToName(Error.errNum)
            return PosixError("$err: (${Error.errNum}, ${name}) ${Error.errMsg}", name)
        }
    }
}