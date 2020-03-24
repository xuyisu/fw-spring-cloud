package com.yisu.jwt.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * @description jwt拦截器异常
 * @author xuyisu
 * @date 2019/2/1
 */
@Getter
public class FwJwtException extends RuntimeException{

    private Integer status = UNAUTHORIZED.value();

    public FwJwtException(String msg){
        super(msg);
    }

    public FwJwtException(HttpStatus status, String msg){
        super(msg);
        this.status = status.value();
    }
}
