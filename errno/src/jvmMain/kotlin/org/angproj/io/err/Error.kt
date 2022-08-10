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
 * The Kotlin/JVM receive errors and preform resets by using the JNI interface.
 *
 * @constructor Create empty Error
 */
actual class Error : AbstractError() {
    actual companion object {
        init { System.loadLibrary("jni-errno") }

        @JvmStatic
        private external fun get_error()

        @JvmStatic
        private external fun clear_error()

        actual var errNum: Int = 0
        actual var errMsg: String = ""

        /**
         * Load
         *
         */
        actual fun load() { get_error() }

        /**
         * Reset
         *
         */
        actual fun reset() { clear_error() }
    }
}