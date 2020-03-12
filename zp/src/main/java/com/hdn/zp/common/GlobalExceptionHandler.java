package com.hdn.zp.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器，统一将异常转换为 {@link Result}.
 * @author Jack
 * @since 2020/3/8
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /*@ExceptionHandler(Exception.class)
    public void exception(Exception e) {
        logger.info("wechat has exception", e);
    }*/

    @ExceptionHandler({ BusinessException.class, Exception.class })
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        logger.error("handle exception:", ex);
        return new ResponseEntity<>(DefaultResult.newFailResult(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
