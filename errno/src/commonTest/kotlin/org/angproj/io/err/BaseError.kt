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

import kotlin.test.assertNotEquals

abstract class BaseError {
    fun prepareEmpty() {
        Error.errNum = 0
        Error.errMsg = ""
    }

    fun assertLoaded() {
        assertNotEquals(Error.errNum, 0)
        assertNotEquals(Error.errMsg, "")
    }
}