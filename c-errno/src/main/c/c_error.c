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
#include <errno.h>
#include <stddef.h>
#include "c_error.h"

void clear_error() {
    errno = 0;
}


static unsigned int const count = 81;
static char const * const names[] =
{

    #ifdef E2BIG
    "E2BIG",
    #else
    NULL,
    #endif

    #ifdef EACCES
    "EACCES",
    #else
    NULL,
    #endif

    #ifdef EADDRINUSE
    "EADDRINUSE",
    #else
    NULL,
    #endif

    #ifdef EADDRNOTAVAIL
    "EADDRNOTAVAIL",
    #else
    NULL,
    #endif

    #ifdef EAFNOSUPPORT
    "EAFNOSUPPORT",
    #else
    NULL,
    #endif

    #ifdef EAGAIN
    "EAGAIN",
    #else
    NULL,
    #endif

    #ifdef EALREADY
    "EALREADY",
    #else
    NULL,
    #endif

    #ifdef EBADF
    "EBADF",
    #else
    NULL,
    #endif

    #ifdef EBADMSG
    "EBADMSG",
    #else
    NULL,
    #endif

    #ifdef EBUSY
    "EBUSY",
    #else
    NULL,
    #endif

    #ifdef ECANCELED
    "ECANCELED",
    #else
    NULL,
    #endif

    #ifdef ECHILD
    "ECHILD",
    #else
    NULL,
    #endif

    #ifdef ECONNABORTED
    "ECONNABORTED",
    #else
    NULL,
    #endif

    #ifdef ECONNREFUSED
    "ECONNREFUSED",
    #else
    NULL,
    #endif

    #ifdef ECONNRESET
    "ECONNRESET",
    #else
    NULL,
    #endif

    #ifdef EDEADLK
    "EDEADLK",
    #else
    NULL,
    #endif

    #ifdef EDESTADDRREQ
    "EDESTADDRREQ",
    #else
    NULL,
    #endif

    #ifdef EDOM
    "EDOM",
    #else
    NULL,
    #endif

    #ifdef EDQUOT
    "EDQUOT",
    #else
    NULL,
    #endif

    #ifdef EEXIST
    "EEXIST",
    #else
    NULL,
    #endif

    #ifdef EFAULT
    "EFAULT",
    #else
    NULL,
    #endif

    #ifdef EFBIG
    "EFBIG",
    #else
    NULL,
    #endif

    #ifdef EHOSTUNREACH
    "EHOSTUNREACH",
    #else
    NULL,
    #endif

    #ifdef EIDRM
    "EIDRM",
    #else
    NULL,
    #endif

    #ifdef EILSEQ
    "EILSEQ",
    #else
    NULL,
    #endif

    #ifdef EINPROGRESS
    "EINPROGRESS",
    #else
    NULL,
    #endif

    #ifdef EINTR
    "EINTR",
    #else
    NULL,
    #endif

    #ifdef EINVAL
    "EINVAL",
    #else
    NULL,
    #endif

    #ifdef EIO
    "EIO",
    #else
    NULL,
    #endif

    #ifdef EISCONN
    "EISCONN",
    #else
    NULL,
    #endif

    #ifdef EISDIR
    "EISDIR",
    #else
    NULL,
    #endif

    #ifdef ELOOP
    "ELOOP",
    #else
    NULL,
    #endif

    #ifdef EMFILE
    "EMFILE",
    #else
    NULL,
    #endif

    #ifdef EMLINK
    "EMLINK",
    #else
    NULL,
    #endif

    #ifdef EMSGSIZE
    "EMSGSIZE",
    #else
    NULL,
    #endif

    #ifdef EMULTIHOP
    "EMULTIHOP",
    #else
    NULL,
    #endif

    #ifdef ENAMETOOLONG
    "ENAMETOOLONG",
    #else
    NULL,
    #endif

    #ifdef ENETDOWN
    "ENETDOWN",
    #else
    NULL,
    #endif

    #ifdef ENETRESET
    "ENETRESET",
    #else
    NULL,
    #endif

    #ifdef ENETUNREACH
    "ENETUNREACH",
    #else
    NULL,
    #endif

    #ifdef ENFILE
    "ENFILE",
    #else
    NULL,
    #endif

    #ifdef ENOBUFS
    "ENOBUFS",
    #else
    NULL,
    #endif

    #ifdef ENODATA
    "ENODATA",
    #else
    NULL,
    #endif

    #ifdef ENODEV
    "ENODEV",
    #else
    NULL,
    #endif

    #ifdef ENOENT
    "ENOENT",
    #else
    NULL,
    #endif

    #ifdef ENOEXEC
    "ENOEXEC",
    #else
    NULL,
    #endif

    #ifdef ENOLCK
    "ENOLCK",
    #else
    NULL,
    #endif

    #ifdef ENOLINK
    "ENOLINK",
    #else
    NULL,
    #endif

    #ifdef ENOMEM
    "ENOMEM",
    #else
    NULL,
    #endif

    #ifdef ENOMSG
    "ENOMSG",
    #else
    NULL,
    #endif

    #ifdef ENOPROTOOPT
    "ENOPROTOOPT",
    #else
    NULL,
    #endif

    #ifdef ENOSPC
    "ENOSPC",
    #else
    NULL,
    #endif

    #ifdef ENOSR
    "ENOSR",
    #else
    NULL,
    #endif

    #ifdef ENOSTR
    "ENOSTR",
    #else
    NULL,
    #endif

    #ifdef ENOSYS
    "ENOSYS",
    #else
    NULL,
    #endif

    #ifdef ENOTCONN
    "ENOTCONN",
    #else
    NULL,
    #endif

    #ifdef ENOTDIR
    "ENOTDIR",
    #else
    NULL,
    #endif

    #ifdef ENOTEMPTY
    "ENOTEMPTY",
    #else
    NULL,
    #endif

    #ifdef ENOTRECOVERABLE
    "ENOTRECOVERABLE",
    #else
    NULL,
    #endif

    #ifdef ENOTSOCK
    "ENOTSOCK",
    #else
    NULL,
    #endif

    #ifdef ENOTSUP
    "ENOTSUP",
    #else
    NULL,
    #endif

    #ifdef ENOTTY
    "ENOTTY",
    #else
    NULL,
    #endif

    #ifdef ENXIO
    "ENXIO",
    #else
    NULL,
    #endif

    #ifdef EOPNOTSUPP
    "EOPNOTSUPP",
    #else
    NULL,
    #endif

    #ifdef EOVERFLOW
    "EOVERFLOW",
    #else
    NULL,
    #endif

    #ifdef EOWNERDEAD
    "EOWNERDEAD",
    #else
    NULL,
    #endif

    #ifdef EPERM
    "EPERM",
    #else
    NULL,
    #endif

    #ifdef EPIPE
    "EPIPE",
    #else
    NULL,
    #endif

    #ifdef EPROTO
    "EPROTO",
    #else
    NULL,
    #endif

    #ifdef EPROTONOSUPPORT
    "EPROTONOSUPPORT",
    #else
    NULL,
    #endif

    #ifdef EPROTOTYPE
    "EPROTOTYPE",
    #else
    NULL,
    #endif

    #ifdef ERANGE
    "ERANGE",
    #else
    NULL,
    #endif

    #ifdef EROFS
    "EROFS",
    #else
    NULL,
    #endif

    #ifdef ESPIPE
    "ESPIPE",
    #else
    NULL,
    #endif

    #ifdef ESRCH
    "ESRCH",
    #else
    NULL,
    #endif

    #ifdef ESTALE
    "ESTALE",
    #else
    NULL,
    #endif

    #ifdef ETIME
    "ETIME",
    #else
    NULL,
    #endif

    #ifdef ETIMEDOUT
    "ETIMEDOUT",
    #else
    NULL,
    #endif

    #ifdef ETXTBSY
    "ETXTBSY",
    #else
    NULL,
    #endif

    #ifdef EWOULDBLOCK
    "EWOULDBLOCK",
    #else
    NULL,
    #endif

    #ifdef EXDEV
    "EXDEV",
    #else
    NULL,
    #endif
};


static int const codes[] =
{
    #ifdef E2BIG
    E2BIG,
    #else
    0,
    #endif

    #ifdef EACCES
    EACCES,
    #else
    0,
    #endif

    #ifdef EADDRINUSE
    EADDRINUSE,
    #else
    0,
    #endif

    #ifdef EADDRNOTAVAIL
    EADDRNOTAVAIL,
    #else
    0,
    #endif

    #ifdef EAFNOSUPPORT
    EAFNOSUPPORT,
    #else
    0,
    #endif

    #ifdef EAGAIN
    EAGAIN,
    #else
    0,
    #endif

    #ifdef EALREADY
    EALREADY,
    #else
    0,
    #endif

    #ifdef EBADF
    EBADF,
    #else
    0,
    #endif

    #ifdef EBADMSG
    EBADMSG,
    #else
    0,
    #endif

    #ifdef EBUSY
    EBUSY,
    #else
    0,
    #endif

    #ifdef ECANCELED
    ECANCELED,
    #else
    0,
    #endif

    #ifdef ECHILD
    ECHILD,
    #else
    0,
    #endif

    #ifdef ECONNABORTED
    ECONNABORTED,
    #else
    0,
    #endif

    #ifdef ECONNREFUSED
    ECONNREFUSED,
    #else
    0,
    #endif

    #ifdef ECONNRESET
    ECONNRESET,
    #else
    0,
    #endif

    #ifdef EDEADLK
    EDEADLK,
    #else
    0,
    #endif

    #ifdef EDESTADDRREQ
    EDESTADDRREQ,
    #else
    0,
    #endif

    #ifdef EDOM
    EDOM,
    #else
    0,
    #endif

    #ifdef EDQUOT
    EDQUOT,
    #else
    0,
    #endif

    #ifdef EEXIST
    EEXIST,
    #else
    0,
    #endif

    #ifdef EFAULT
    EFAULT,
    #else
    0,
    #endif

    #ifdef EFBIG
    EFBIG,
    #else
    0,
    #endif

    #ifdef EHOSTUNREACH
    EHOSTUNREACH,
    #else
    0,
    #endif

    #ifdef EIDRM
    EIDRM,
    #else
    0,
    #endif

    #ifdef EILSEQ
    EILSEQ,
    #else
    0,
    #endif

    #ifdef EINPROGRESS
    EINPROGRESS,
    #else
    0,
    #endif

    #ifdef EINTR
    EINTR,
    #else
    0,
    #endif

    #ifdef EINVAL
    EINVAL,
    #else
    0,
    #endif

    #ifdef EIO
    EIO,
    #else
    0,
    #endif

    #ifdef EISCONN
    EISCONN,
    #else
    0,
    #endif

    #ifdef EISDIR
    EISDIR,
    #else
    0,
    #endif

    #ifdef ELOOP
    ELOOP,
    #else
    0,
    #endif

    #ifdef EMFILE
    EMFILE,
    #else
    0,
    #endif

    #ifdef EMLINK
    EMLINK,
    #else
    0,
    #endif

    #ifdef EMSGSIZE
    EMSGSIZE,
    #else
    0,
    #endif

    #ifdef EMULTIHOP
    EMULTIHOP,
    #else
    0,
    #endif

    #ifdef ENAMETOOLONG
    ENAMETOOLONG,
    #else
    0,
    #endif

    #ifdef ENETDOWN
    ENETDOWN,
    #else
    0,
    #endif

    #ifdef ENETRESET
    ENETRESET,
    #else
    0,
    #endif

    #ifdef ENETUNREACH
    ENETUNREACH,
    #else
    0,
    #endif

    #ifdef ENFILE
    ENFILE,
    #else
    0,
    #endif

    #ifdef ENOBUFS
    ENOBUFS,
    #else
    0,
    #endif

    #ifdef ENODATA
    ENODATA,
    #else
    0,
    #endif

    #ifdef ENODEV
    ENODEV,
    #else
    0,
    #endif

    #ifdef ENOENT
    ENOENT,
    #else
    0,
    #endif

    #ifdef ENOEXEC
    ENOEXEC,
    #else
    0,
    #endif

    #ifdef ENOLCK
    ENOLCK,
    #else
    0,
    #endif

    #ifdef ENOLINK
    ENOLINK,
    #else
    0,
    #endif

    #ifdef ENOMEM
    ENOMEM,
    #else
    0,
    #endif

    #ifdef ENOMSG
    ENOMSG,
    #else
    0,
    #endif

    #ifdef ENOPROTOOPT
    ENOPROTOOPT,
    #else
    0,
    #endif

    #ifdef ENOSPC
    ENOSPC,
    #else
    0,
    #endif

    #ifdef ENOSR
    ENOSR,
    #else
    0,
    #endif

    #ifdef ENOSTR
    ENOSTR,
    #else
    0,
    #endif

    #ifdef ENOSYS
    ENOSYS,
    #else
    0,
    #endif

    #ifdef ENOTCONN
    ENOTCONN,
    #else
    0,
    #endif

    #ifdef ENOTDIR
    ENOTDIR,
    #else
    0,
    #endif

    #ifdef ENOTEMPTY
    ENOTEMPTY,
    #else
    0,
    #endif

    #ifdef ENOTRECOVERABLE
    ENOTRECOVERABLE,
    #else
    0,
    #endif

    #ifdef ENOTSOCK
    ENOTSOCK,
    #else
    0,
    #endif

    #ifdef ENOTSUP
    ENOTSUP,
    #else
    0,
    #endif

    #ifdef ENOTTY
    ENOTTY,
    #else
    0,
    #endif

    #ifdef ENXIO
    ENXIO,
    #else
    0,
    #endif

    #ifdef EOPNOTSUPP
    EOPNOTSUPP,
    #else
    0,
    #endif

    #ifdef EOVERFLOW
    EOVERFLOW,
    #else
    0,
    #endif

    #ifdef EOWNERDEAD
    EOWNERDEAD,
    #else
    0,
    #endif

    #ifdef EPERM
    EPERM,
    #else
    0,
    #endif

    #ifdef EPIPE
    EPIPE,
    #else
    0,
    #endif

    #ifdef EPROTO
    EPROTO,
    #else
    0,
    #endif

    #ifdef EPROTONOSUPPORT
    EPROTONOSUPPORT,
    #else
    0,
    #endif

    #ifdef EPROTOTYPE
    EPROTOTYPE,
    #else
    0,
    #endif

    #ifdef ERANGE
    ERANGE,
    #else
    0,
    #endif

    #ifdef EROFS
    EROFS,
    #else
    0,
    #endif

    #ifdef ESPIPE
    ESPIPE,
    #else
    0,
    #endif

    #ifdef ESRCH
    ESRCH,
    #else
    0,
    #endif

    #ifdef ESTALE
    ESTALE,
    #else
    0,
    #endif

    #ifdef ETIME
    ETIME,
    #else
    0,
    #endif

    #ifdef ETIMEDOUT
    ETIMEDOUT,
    #else
    0,
    #endif

    #ifdef ETXTBSY
    ETXTBSY,
    #else
    0,
    #endif

    #ifdef EWOULDBLOCK
    EWOULDBLOCK,
    #else
    0,
    #endif

    #ifdef EXDEV
    EXDEV,
    #else
    0,
    #endif
};


unsigned int errno_count() {
    return count;
}

unsigned int errno_code(unsigned int index) {
    if (index >= count) {
        return 0;
    } else {
        return codes[index];
    }
}

const char * errno_abbr(unsigned int index) {
    if (index >= count) {
        return (void *) 0;
    } else {
        return names[index];
    }
}