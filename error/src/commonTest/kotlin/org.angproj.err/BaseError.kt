package org.angproj.err

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