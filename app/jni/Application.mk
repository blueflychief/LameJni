#Application.mk

APP_ABI:=armeabi,armeabi-v7a,arm64-v8a,x86,x86_64,mips,mips64
#APP_ABI:=all
APP_MODULES :=mp3lame

#如果是x86_64的话需要在Application.mk中加上APP_CFLAGS += -DSTDC_HEADERS
APP_CFLAGS += -DSTDC_HEADERS
#APP_ABI:=x86_64
#APP_PLATFORM := android-21