package com.siszerosix.allstorage.common.response;

public interface ErrorCodeInterface {
    public static final Integer CONSTANT_OK = 0;

    Integer getErrorCode();
    String getMsg();
    String getHintMessage();
}
