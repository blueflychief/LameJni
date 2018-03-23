#Android.mk

LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
# 此处对于jni下面的lame目录
LAME_LIBMP3_DIR:=libmp3lame3995

// 此处表示的是java代码引入.so的名称与Application文件的APP_MODULES := mp3lame 保持一致
LOCAL_MODULE:=mp3lame

LOCAL_SRC_FILES:=\
$(LAME_LIBMP3_DIR)/bitstream.c \
$(LAME_LIBMP3_DIR)/fft.c \
$(LAME_LIBMP3_DIR)/id3tag.c \
$(LAME_LIBMP3_DIR)/mpglib_interface.c \
$(LAME_LIBMP3_DIR)/presets.c \
$(LAME_LIBMP3_DIR)/quantize.c \
$(LAME_LIBMP3_DIR)/reservoir.c \
$(LAME_LIBMP3_DIR)/tables.c  \
$(LAME_LIBMP3_DIR)/util.c \
$(LAME_LIBMP3_DIR)/VbrTag.c \
$(LAME_LIBMP3_DIR)/encoder.c \
$(LAME_LIBMP3_DIR)/gain_analysis.c \
$(LAME_LIBMP3_DIR)/lame.c \
$(LAME_LIBMP3_DIR)/newmdct.c \
$(LAME_LIBMP3_DIR)/psymodel.c \
$(LAME_LIBMP3_DIR)/quantize_pvt.c \
$(LAME_LIBMP3_DIR)/set_get.c \
$(LAME_LIBMP3_DIR)/takehiro.c \
$(LAME_LIBMP3_DIR)/vbrquantize.c \
$(LAME_LIBMP3_DIR)/version.c \
MP3Recorder.c

include $(BUILD_SHARED_LIBRARY)