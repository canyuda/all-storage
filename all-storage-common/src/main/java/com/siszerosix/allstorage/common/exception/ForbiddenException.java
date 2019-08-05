package com.siszerosix.allstorage.common.exception;

public class ForbiddenException extends BaseRuntionException {

    private static final long serialVersionUID = -8035027450716458707L;

    public ForbiddenException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ForbiddenException(String msg) {
        super(msg);
    }

    public ForbiddenException(String msg, String reason) {
        super(msg, reason);
    }

    public ForbiddenException(String msg, String reason, Throwable cause) {
        super(msg, reason, cause);
    }
}
