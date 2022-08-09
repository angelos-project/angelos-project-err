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

/**
 * Test class to access some POSIX functionality for testing only.
 * Never use outside JVM testing of angelos-project-err.
 *
 * @constructor Create empty Test
 */
class TestPosix {
    companion object {
        init { System.loadLibrary("jni-error-test") }

        @JvmStatic
        external fun test_malloc(size: Long): Long

        @JvmStatic
        external fun test_close(fd: Int): Int
    }
}