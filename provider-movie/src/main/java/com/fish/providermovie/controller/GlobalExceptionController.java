package com.fish.providermovie.controller;

import com.fish.providermovie.ret.RetCode;
import com.fish.providermovie.ret.RetResponse;
import com.fish.providermovie.ret.RetResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerError;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局处理错误 luo
 */
@ControllerAdvice
public class GlobalExceptionController {

    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Value("${debug}")
    private boolean debug;

    @ExceptionHandler(Exception.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RetResult ajaxException(HttpServletRequest req, Exception exception) throws Exception {
        if(exception instanceof ServerError) {
            return RetResponse.makeErrRsp(exception.getMessage());
        }

        if(exception instanceof NoHandlerFoundException) {
            return RetResponse.makeErrRsp(RetCode.NOT_FOUND, exception.getMessage());
        }

        if(debug) {
            throw exception;
        }

        Map<String, Object> errorMap = new HashMap(2);
        errorMap.put("url", req.getRequestURI());

        errorMap.put("stackTrace", exception.getStackTrace());
        logger.error(exception.getStackTrace());

        return RetResponse.makeRsp(400, exception.getMessage(), errorMap);

    }






}
