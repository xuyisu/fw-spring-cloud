package com.yisu.gateways.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xuyisu
 * @description Token Filter
 * @date 2019/12/12
 */
@Slf4j
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; // 在请求被路由之前调用
    }

    @Override
    public int filterOrder() {
        return 0; // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true; // 是否执行该过滤器，此处为true，说明需要过滤
    }

    @Override
    public Object run() {

//        int i=10/0;

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("我是TokenFilter");
        String token = request.getHeader("token");// 获取请求的参数

        // 如果有token参数并且token值为123456，才进行路由
        if (StringUtils.isNotBlank(token) && token.equals("123456")) {
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("code", 1);
        } else {
            //失败之后通知后续不应该执行了
            ctx.set("isShould",false);

            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(401);
            HttpServletResponse response = ctx.getResponse();
            response.setHeader("content-type", "text/html;charset=utf8");
            ctx.setResponseBody("认证失败");
            ctx.set("code", 0);
        }
        return null;
    }
}
