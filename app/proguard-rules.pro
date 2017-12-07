# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in H:\studio\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#混淆原则：开源库保留 activity好像是可以混淆的

-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}
-keep class android.support.**{*;}

#butterknife
-dontwarn com.jakewharton.**
-keep public class com.jakewharton.**{*;}

#android support
-dontwarn com.android.support.**
-keep public class com.android.support.**{*;}

#retrofit
-dontwarn com.squareup.retrofit2.**
-keep public class com.squareup.retrofit2.**{*;}

#fastjson
-dontwarn com.alibaba.**
-keep public class com.alibaba.**{*;}

#log4j 
-keep public class org.apache.Log4j.**{*;}


