package com.jyanedu.app.handle;

import com.jyanedu.app.exception.DefException;
import com.jyanedu.app.module.BaseResp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liu_kai on 2018/2/2.
 */
@ControllerAdvice
public class ErrorHandle {

    @ExceptionHandler(DefException.class)
    @ResponseBody
    public Object handleBizExp(DefException e){
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(1);
        baseResp.setMsg(e.getMessage());
        return baseResp;
    }
}
