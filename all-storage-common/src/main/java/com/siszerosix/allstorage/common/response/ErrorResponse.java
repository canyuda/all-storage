package com.siszerosix.allstorage.common.response;

public class ErrorResponse {
    private BaseResponse baseResponse;

    public BaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    public ErrorResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }
}
