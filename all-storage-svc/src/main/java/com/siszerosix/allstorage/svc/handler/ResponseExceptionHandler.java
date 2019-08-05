package com.siszerosix.allstorage.svc.handler;

import com.siszerosix.allstorage.common.exception.ForbiddenException;
import com.siszerosix.allstorage.common.exception.HttpClientException;
import com.siszerosix.allstorage.common.exception.ResourceNotFoundException;
import com.siszerosix.allstorage.common.response.BaseResponse;
import com.siszerosix.allstorage.common.response.ErrorCodeException;
import com.siszerosix.allstorage.common.response.ErrorCodeInterface;
import com.siszerosix.allstorage.common.response.ErrorResponse;
import org.apache.commons.httpclient.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ResponseExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ResponseExceptionHandler.class);


    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Object handException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        BaseResponse baseResponse = new BaseResponse();
        if (ex instanceof ServletException) {
            response.setStatus(HttpStatus.SC_UNPROCESSABLE_ENTITY);
            logger.warn(ex.getMessage(), ex);
        } else if (ex instanceof ResourceNotFoundException) {
            String reason = ((ResourceNotFoundException) ex).getReason();
            baseResponse.setErrorCode(HttpStatus.SC_NOT_FOUND);
            baseResponse.setErrorMessage(reason);
            baseResponse.setHintMessage("");
            response.setStatus(HttpStatus.SC_OK);
            logger.warn(ex.getMessage(), ex);
        } else if (ex instanceof ForbiddenException) {
            String reason = ((ForbiddenException) ex).getReason();
            baseResponse.setErrorCode(HttpStatus.SC_FORBIDDEN);
            baseResponse.setErrorMessage(reason);
            baseResponse.setHintMessage("");
            response.setStatus(HttpStatus.SC_OK);
            logger.warn(ex.getMessage(), ex);
        } else if (ex instanceof HttpClientException) {
            String reason = ((HttpClientException) ex).getReason();
            baseResponse.setErrorCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            baseResponse.setErrorMessage(reason);
            baseResponse.setHintMessage("");
            response.setStatus(HttpStatus.SC_OK);
            logger.warn(ex.getMessage(), ex);
        } else if (ex instanceof ErrorCodeException) {
            ErrorCodeInterface errorCodeInterface = ((ErrorCodeException) ex).getErrorCodeInterface();
            baseResponse.setErrorCode(errorCodeInterface.getErrorCode());
            baseResponse.setErrorMessage(errorCodeInterface.getMsg());
            baseResponse.setHintMessage(errorCodeInterface.getHintMessage());
            response.setStatus(HttpStatus.SC_OK);
            logger.info(ex.getMessage(), ex);
        }
        return new ErrorResponse(baseResponse);
    }

}
