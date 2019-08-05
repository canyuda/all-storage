package com.siszerosix.allstorage.common.exception;

public class ResourceNotFoundException extends BaseRuntionException {

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
