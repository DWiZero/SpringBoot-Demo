package com.dwizero.Filter;

import com.dwizero.GlobleBean.ResponseEntry;
import com.dwizero.GlobleBean.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理使用@ControllerAdvice
 * 针对相应的异常使用@ExceptionHandler(value = Exception.class)
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntry<String> defaultErrorHandler(ServiceException e) throws Exception {
        ResponseEntry<String> r = new ResponseEntry<>();
        r.setMessage(e.getMessage());
        r.setCode(e.getCode());
        r.setData("Sorry ServiceException");
        return r;
    }
}
