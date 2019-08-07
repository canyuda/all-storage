package com.siszerosix.allstorage.common.exception;

import com.siszerosix.allstorage.common.exception.base.BaseRuntimeException;

public class ResourceNotFoundException extends BaseRuntimeException {

    private static final long serialVersionUID = -8035027450716458707L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

    public ResourceNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ResourceNotFoundException(String msg, String reason) {
        super(msg, reason);
    }

    public ResourceNotFoundException(String msg, String reason, Throwable cause) {
        super(msg, reason, cause);
    }
}
