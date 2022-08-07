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

internal actual class Internals {
    actual companion object {
        init {
            System.loadLibrary("jni-error") // Load underlying library via JNI.
        }

        actual fun getError() {
            get_error()
        }

        @JvmStatic
        private external fun get_error()
    }
}