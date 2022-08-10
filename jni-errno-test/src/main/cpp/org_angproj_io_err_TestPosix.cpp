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
#include <jni.h>

#include <unistd.h>
#include <stdlib.h>

#ifndef _Included_org_angproj_io_err_TestPosix
#define _Included_org_angproj_io_err_TestPosix
#ifdef __cplusplus
extern "C" {
#endif

static const char *JNIT_CLASS = "org/angproj/io/err/TestPosix";

/*
 * Class:     _Included_org_angproj_err_TestPosix
 * Method:    test_close
 * Signature: (I)I
 */
static jint test_close(JNIEnv * env, jclass thisClass, jint fd) {
    return close(fd);
}

/*
 * Class:     _Included_org_angproj_err_TestPosix
 * Method:    test_malloc
 * Signature: (J)J
 */
static jlong test_malloc(JNIEnv * env, jclass thisClass, jlong size){
    return (jlong) malloc((void*) size);
}

static JNINativeMethod funcs[] = {
	{"test_close", "(I)I", (void *) &test_close},
	{"test_malloc", "(J)J", (void *) &test_malloc},
};

#define CURRENT_JNI JNI_VERSION_1_6

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved)
{
	JNIEnv *env;
	jclass  cls;
	jint    res;

	(void)reserved;

	if ((*vm)->GetEnv(vm, (void **)&env, CURRENT_JNI) != JNI_OK)
		return -1;

	cls = (*env)->FindClass(env, JNIT_CLASS);
	if (cls == NULL)
		return -1;

	res = (*env)->RegisterNatives(env, cls, funcs, sizeof(funcs)/sizeof(*funcs));
	if (res != 0)
		return -1;

	return CURRENT_JNI;
}

JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved)
{
	JNIEnv *env;
	jclass  cls;

	(void)reserved;

	if ((*vm)->GetEnv(vm, (void **)&env, CURRENT_JNI) != JNI_OK)
		return;

	cls = (*env)->FindClass(env, JNIT_CLASS);
	if (cls == NULL)
		return;

	(*env)->UnregisterNatives(env, cls);
}


#ifdef __cplusplus
}
#endif
#endif // _Included_org_angproj_io_err_TestPosix