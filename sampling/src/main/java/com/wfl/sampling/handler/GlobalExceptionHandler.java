package com.wfl.sampling.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 11:17 2018/12/19
 * @ Description：
 * @ Modified By：
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest req, Exception e){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("succesee",false);
        modelMap.put("errMsg",e.getMessage());
        return modelMap;
    }
}