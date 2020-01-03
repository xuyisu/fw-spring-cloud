package com.yisu.gateways.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

/**
 * @author xuyisu
 * @description 异常处理过滤器
 * @date 2020/1/3
 */
@Slf4j
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        ctx.setSendZuulResponse(false); //不对其进行路由
        ctx.setResponseStatusCode(401);
        HttpServletResponse response = ctx.getResponse();
        response.setHeader("content-type", "text/html;charset=utf8");
        ctx.setResponseBody("认证失败"+throwable.getCause().getMessage());
        ctx.set("code", 500);
        log.error("异常信息,{}",throwable.getCause().getMessage());
        return null;
    }
}
