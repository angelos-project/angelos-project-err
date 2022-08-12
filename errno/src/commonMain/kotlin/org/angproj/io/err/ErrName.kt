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
 * Enumeration of all POSIX error names.
 *
 * @property errName
 * @constructor Create empty Err name
 */
enum class ErrName(val errName: String) {
    E2BIG("E2BIG"),
    EACCES("EACCES"),
    EADDRINUSE("EADDRINUSE"),
    EADDRNOTAVAIL("EADDRNOTAVAIL"),
    EAFNOSUPPORT("EAFNOSUPPORT"),
    EAGAIN("EAGAIN"),
    EALREADY("EALREADY"),
    EBADF("EBADF"),
    EBADMSG("EBADMSG"),
    EBUSY("EBUSY"),
    ECANCELED("ECANCELED"),
    ECHILD("ECHILD"),
    ECONNABORTED("ECONNABORTED"),
    ECONNREFUSED("ECONNREFUSED"),
    ECONNRESET("ECONNRESET"),
    EDEADLK("EDEADLK"),
    EDESTADDRREQ("EDESTADDRREQ"),
    EDOM("EDOM"),
    EDQUOT("EDQUOT"),
    EEXIST("EEXIST"),
    EFAULT("EFAULT"),
    EFBIG("EFBIG"),
    EHOSTUNREACH("EHOSTUNREACH"),
    EIDRM("EIDRM"),
    EILSEQ("EILSEQ"),
    EINPROGRESS("EINPROGRESS"),
    EINTR("EINTR"),
    EINVAL("EINVAL"),
    EIO("EIO"),
    EISCONN("EISCONN"),
    EISDIR("EISDIR"),
    ELOOP("ELOOP"),
    EMFILE("EMFILE"),
    EMLINK("EMLINK"),
    EMSGSIZE("EMSGSIZE"),
    EMULTIHOP("EMULTIHOP"),
    ENAMETOOLONG("ENAMETOOLONG"),
    ENETDOWN("ENETDOWN"),
    ENETRESET("ENETRESET"),
    ENETUNREACH("ENETUNREACH"),
    ENFILE("ENFILE"),
    ENOBUFS("ENOBUFS"),
    ENODATA("ENODATA"),
    ENODEV("ENODEV"),
    ENOENT("ENOENT"),
    ENOEXEC("ENOEXEC"),
    ENOLCK("ENOLCK"),
    ENOLINK("ENOLINK"),
    ENOMEM("ENOMEM"),
    ENOMSG("ENOMSG"),
    ENOPROTOOPT("ENOPROTOOPT"),
    ENOSPC("ENOSPC"),
    ENOSR("ENOSR"),
    ENOSTR("ENOSTR"),
    ENOSYS("ENOSYS"),
    ENOTCONN("ENOTCONN"),
    ENOTDIR("ENOTDIR"),
    ENOTEMPTY("ENOTEMPTY"),
    ENOTRECOVERABLE("ENOTRECOVERABLE"),
    ENOTSOCK("ENOTSOCK"),
    ENOTSUP("ENOTSUP"),
    ENOTTY("ENOTTY"),
    ENXIO("ENXIO"),
    EOPNOTSUPP("EOPNOTSUPP"),
    EOVERFLOW("EOVERFLOW"),
    EOWNERDEAD("EOWNERDEAD"),
    EPERM("EPERM"),
    EPIPE("EPIPE"),
    EPROTO("EPROTO"),
    EPROTONOSUPPORT("EPROTONOSUPPORT"),
    EPROTOTYPE("EPROTOTYPE"),
    ERANGE("ERANGE"),
    EROFS("EROFS"),
    ESPIPE("ESPIPE"),
    ESRCH("ESRCH"),
    ESTALE("ESTALE"),
    ETIME("ETIME"),
    ETIMEDOUT("ETIMEDOUT"),
    ETXTBSY("ETXTBSY"),
    EWOULDBLOCK("EWOULDBLOCK"),
    EXDEV("EXDEV"),


    UNKNOWN("UNKNOWN");

    companion object {
        private val numCache = mutableMapOf<Int, ErrName>()
        private val nameCache = mutableMapOf<ErrName, Int>()

        init {
            for(num in 0..Error.errnoCount()) {
                val code = Error.errnoCode(num)
                if(code != 0 && !numCache.containsKey(code)) {
                    try {
                        val abbr = valueOf(Error.errnoAbbr(num))
                        numCache[code] = abbr
                        nameCache[abbr] = code
                    } catch (_: Exception) {}
                }
            }
        }

        /**
         * Convert an ERRNO number to its equivalent ERRNO name, throws UnsupportedErrnoException if not supported.
         *
         * @param errNum ERRNO number.
         * @return ERRNO name.
         */
        fun codeToName(errNum: Int): ErrName = numCache[errNum] ?: throw UnsupportedErrnoException("Unsupported ERRNO number: $errNum")

        /**
         * Convert ERRNO name to its equivalent ERRNO number, throws UnsupportedErrnoException if not supported.
         *
         * @param errName ERRNO name.
         * @return ERRNO number.
         */
        fun nameToCode(errName: ErrName): Int = nameCache[errName] ?: throw UnsupportedErrnoException("Unsupported ERRNO name: $errName")

        /**
         * Check if an ERRNO number is implemented.
         *
         * @param errNum Implemented or not.
         */
        fun isImplemented(errNum: Int) = numCache.containsKey(errNum)

        /**
         * Check if an ERRNO name is implemented.
         *
         * @param errName Implemented or not.
         */
        fun isImplemented(errName: ErrName) = nameCache.containsKey(errName)
    }
}