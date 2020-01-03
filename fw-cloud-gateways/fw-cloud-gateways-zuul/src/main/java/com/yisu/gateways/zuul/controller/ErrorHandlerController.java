package com.yisu.gateways.zuul.controller;

import cn.hutool.core.util.StrUtil;
import com.yisu.gateways.zuul.result.FwResult;
import org.apache.http.protocol.ResponseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author xuyisu
 * @description  异常处理类
 * @date 2020/1/3
 */
@RestController
public class ErrorHandlerController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public FwResult error(HttpServletRequest request){
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(new ServletWebRequest(request), true);
        String message = (String) errorAttributes.get("message");
        String trace = (String) errorAttributes.get("trace");
        if(StrUtil.isNotBlank(trace)){
            message=message+",trace is "+trace;
        }
        return FwResult.failed(message);
    }
}
