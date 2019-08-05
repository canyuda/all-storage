package com.siszerosix.allstorage.common.exception;

import com.siszerosix.allstorage.common.util.NestedExceptionUtils;

public class BaseRuntionException extends RuntimeException {
    private static final long serialVersionUID = -6748535679132417636L;
    private String reason;


    public BaseRuntionException(String msg) {
        this(msg, "");
    }

    public BaseRuntionException(String msg, Throwable cause) {
        this(msg, "", cause);
    }

    public BaseRuntionException(String msg, String reason) {
        super(msg);
        this.reason = reason;
    }

    public BaseRuntionException(String msg, String reason, Throwable cause) {
        super(msg, cause);
        this.reason = reason;
    }

    public String getReason() {
        return reason == null ? "" : reason;
    }

    public String getMessage() {
        return NestedExceptionUtils.buildMessage(super.getMessage(), getCause());
    }

}
