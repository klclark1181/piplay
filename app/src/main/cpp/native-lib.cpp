#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_example_kevin_drone_Connect_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Welcome to the Drone!";
    return env->NewStringUTF(hello.c_str());
}
