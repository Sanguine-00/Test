//
// Created by Administrator on 2016/12/6.
//

#include<stdio.h>
#include<stdlib.h>
#include<jni.h>
#include <com_example_test_JniTest.h>
#include "com_example_test_JniTest.h"

char* _JString2CStr(JNIEnv* env, jstring jstr) {
    char* rtn = NULL;
    jclass clsstring = (*env)->FindClass(env, "java/lang/String");
    jstring strencode = (*env)->NewStringUTF(env,"GB2312");
    jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray)(*env)->CallObjectMethod(env, jstr, mid, strencode); // String .getByte("GB2312");
    jsize alen = (*env)->GetArrayLength(env, barr);
    jbyte* ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
    if(alen > 0) {
        rtn = (char*)malloc(alen+1); //"\0"
        memcpy(rtn, ba, alen);
        rtn[alen]=0;
    }
    (*env)->ReleaseByteArrayElements(env, barr, ba,0);
    return rtn;
}

jstring Java_com_example_test_JniTest_helloworldFromC(JNIEnv* env,jobject thiz){
 char* cstr = "hello from C!12345645645646556465465465";
 return (*env)->NewStringUTF(env,cstr);
}

jint Java_com_example_test_JniTest_add(JNIEnv* env,jobject thiz,jint x,jint y){
  return x+y;

}

jstring Java_com_example_test_JniTest_sayHelloInC(JNIEnv* env,jobject thiz,jstring jstr){
    //调用工具方法把 java中的string 类型 转换成 C 语言中的 char*
    char* cstr = _JString2CStr(env,jstr);
    //调用strlen 获取 cstr 字符串的长度
    int length = strlen(cstr);
    int i;
    for(i = 0;i<length;i++){
        *(cstr+i) += 1;
    }
    return (*env)->NewStringUTF(env,cstr);
}

