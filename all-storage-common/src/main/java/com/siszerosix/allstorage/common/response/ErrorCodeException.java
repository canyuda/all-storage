package com.siszerosix.allstorage.common.response;

import com.siszerosix.allstorage.common.exception.base.BaseRuntimeException;

public class ErrorCodeException extends BaseRuntimeException {

    private static final long serialVersionUID = 9084367480345181688L;
    private ErrorCodeInterface errorCodeInterface;

    public ErrorCodeException(ErrorCodeInterface errorCodeInterface, String msg, Throwable cause) {
        super(msg, errorCodeInterface.getMsg(), cause);
        this.errorCodeInterface = errorCodeInterface;
    }

    public ErrorCodeException(ErrorCodeInterface errorCodeInterface, String msg) {
        super(msg, "", null);
        this.errorCodeInterface = errorCodeInterface;
    }

    public ErrorCodeInterface getErrorCodeInterface() {
        return errorCodeInterface;
    }
}
