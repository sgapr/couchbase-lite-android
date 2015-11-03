LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    := libicuuc
LOCAL_CFLAGS 	:= -DUCONFIG_ONLY_COLLATION
LOCAL_SRC_FILES := libs/$(TARGET_ARCH_ABI)/libicuuc_static.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := libicui18n
LOCAL_CFLAGS 	:= -DUCONFIG_ONLY_COLLATION
LOCAL_SRC_FILES := libs/$(TARGET_ARCH_ABI)/libicui18n_static.a
include $(PREBUILT_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := com_couchbase_touchdb_TDCollateJSON
LOCAL_SRC_FILES := JsonCollator/com_couchbase_touchdb_TDCollateJSON.cpp
#					libs/$(TARGET_ARCH_ABI)/libicui18n_static.a \
#					libs/$(TARGET_ARCH_ABI)/libicuuc_static.a.a
LOCAL_C_INCLUDES := include/icu4c/common \
					include/icu4c/i18n
LOCAL_CFLAGS 	:= -DUCONFIG_ONLY_COLLATION
LOCAL_LDLIBS    := -llog -ldl -L$(LOCAL_PATH/JsonCollator)
LOCAL_STATIC_LIBRARIES := libicui18n libicuuc
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := com_couchbase_touchdb_RevCollator
LOCAL_SRC_FILES := RevCollator/com_couchbase_touchdb_RevCollator.cpp
LOCAL_LDLIBS    := -llog -ldl -L$(LOCAL_PATH/RevCollator)
include $(BUILD_SHARED_LIBRARY)