package com.da.provideserver.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
public class ExceptionCatch {
    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public Map<String,Object> catchException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("info", "系统繁忙,请稍后再试!");
        map.put("desc", e.getMessage());
        return map;
    }

}
