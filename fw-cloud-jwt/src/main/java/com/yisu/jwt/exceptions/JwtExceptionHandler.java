package com.yisu.jwt.exceptions;

import com.yisu.common.result.FwResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Slf4j
@ControllerAdvice
public class JwtExceptionHandler {

    @ExceptionHandler(FwJwtException.class)
    @ResponseBody
    public FwResult handleException(Exception e) {
        log.error("[FwJwtException]=>",e);
        return FwResult.failedCodeData(UNAUTHORIZED.value(),e.getMessage());
    }
}
