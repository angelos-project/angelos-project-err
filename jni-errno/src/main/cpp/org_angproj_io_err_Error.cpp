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
#include <string.h>
#include <errno.h>

#include "c_error.h"

#ifndef _Included_org_angproj_io_err_Error
#define _Included_org_angproj_io_err_Error
#ifdef __cplusplus
extern "C" {
#endif

static const char *JNIT_CLASS = "org/angproj/io/err/Error";

static jclass error_class = NULL;
static jfieldID err_num = NULL;
static jfieldID err_msg = NULL;

/*
 * Class:     _Included_org_angproj_err_Error
 * Method:    get_error
 * Signature: ()V
 */
static void get_error(JNIEnv * env, jclass thisClass){
    (*env)->SetStaticIntField(env, error_class, err_num, errno);
    (*env)->SetStaticObjectField(env, error_class, err_msg, (*env)->NewStringUTF(env, strerror(errno)));
}

/*
 * Class:     _Included_org_angproj_err_Error
 * Method:    clear_error
 * Signature: ()V
 */
static void get_clear_error(JNIEnv * env, jclass thisClass){
    errno = 0;
}

/*
 * Class:     _Included_org_angproj_err_Error
 * Method:    errno_count
 * Signature: ()I
 */
static jint get_errno_count(JNIEnv * env, jclass thisClass) {
    return (jint) errno_count();
}

/*
 * Class:     _Included_org_angproj_err_Error
 * Method:    errno_code
 * Signature: (I)I
 */
static jint get_errno_code(JNIEnv * env, jclass thisClass, jint index) {
    return (jint) errno_code((unsigned int) index);
}

/*
 * Class:     _Included_org_angproj_err_Error
 * Method:    errno_abbr
 * Signature: (I)Ljava/lang/String;
 */
static jstring get_errno_abbr(JNIEnv * env, jclass thisClass, jint index){
    const char * abbr = errno_abbr((unsigned int) index);
    return (*env)->NewStringUTF(env, abbr);
}

static JNINativeMethod funcs[] = {
	{"get_error", "()V", (void *) &get_error},
	{"clear_error", "()V", (void *) &clear_error},

	{"errno_count", "()I", (void *) &get_errno_count},
	{"errno_code", "(I)I", (void *) &get_errno_code},
	{"errno_abbr", "(I)Ljava/lang/String;", (void *) &get_errno_abbr},
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

	// PREPARE STATIC START
    error_class = (*env)->FindClass(env, "org/angproj/io/err/Error");
    err_num = (*env)->GetStaticFieldID(env, error_class, "errNum", "I");
    err_msg = (*env)->GetStaticFieldID(env, error_class, "errMsg", "Ljava/lang/String;");
	// PREPARE STATIC OVER

	return CURRENT_JNI;
}

JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved)
{
    // PREPARE STATIC END
    error_class = NULL;
    err_num = NULL;
    err_msg = NULL;
    // PREPARE STATIC OVER

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
#endif // _Included_org_angproj_io_err_Error