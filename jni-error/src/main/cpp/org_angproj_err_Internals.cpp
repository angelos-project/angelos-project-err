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

#include "c_error.h"

#ifndef _Included_org_angproj_err_Internals
#define _Included_org_angproj_err_Internals
#ifdef __cplusplus
extern "C" {
#endif

static const char *JNIT_CLASS = "org/angproj/err/Error";

/*
 * Class:     _Included_org_angproj_err_Internals
 * Method:    get_error
 * Signature: ()V
 */
static void get_error(JNIEnv * env, jclass thisClass){
    if (errno == 0)
        return;

    jclass proc = (*env)->FindClass(env, "org/angproj/err/Error");
    jfieldID err_num = (*env)->GetStaticFieldID(env, proc, "errNum", "I");
    jfieldID err_msg = (*env)->GetStaticFieldID(env, proc, "errMsg", "Ljava/lang/String;");
    (*env)->SetStaticIntField(env, proc, err_num, errno);
    (*env)->SetStaticObjectField(env, proc, err_msg, (*env)->NewStringUTF(env, strerror(errno)));
}

/*
 * Class:     _Included_org_angproj_err_Internals
 * Method:    clear_error
 * Signature: ()V
 */
static void clear_error(JNIEnv * env, jclass thisClass){
    errno = 0;
}

static JNINativeMethod funcs[] = {
	{"get_error", "()V", (void *) &get_error},
	{"clear_error", "()V", (void *) &clear_error},
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
#endif // _Included_org_angproj_err_Internals