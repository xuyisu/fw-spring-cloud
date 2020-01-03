package com.yisu.gateways.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xuyisu
 * @description Zuul Filter
 * @date 2019/12/28
 */
@Slf4j
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; // 在请求被路由之前调用
    }

    @Override
    public int filterOrder() {
        return 5; // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true; // 是否执行该过滤器，此处为true，说明需要过滤
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("我是ZuulFilter");
        String token = request.getHeader("name");// 获取请求的参数

        // 如果有name参数并且token值为zuul，才进行路由
        if (StringUtils.isNotBlank(token) && token.equals("zuul")) {
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("code", 1);
        } else {
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(401);
            HttpServletResponse response = ctx.getResponse();
            response.setHeader("content-type", "text/html;charset=utf8");
            ctx.setResponseBody("请携带网关必须参数");
            ctx.set("code", 0);
        }
        return null;
    }
}
