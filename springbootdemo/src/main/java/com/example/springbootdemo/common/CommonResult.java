package com.example.springbootdemo.common;

import lombok.Data;

@Data
public class CommonResult {

    private int code;
    private String message;
    private Object result;

    public static CommonResult success(Object result){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(1);
        commonResult.setMessage("SUCCESS");
        commonResult.setResult(result);
        return commonResult;
    }

}
