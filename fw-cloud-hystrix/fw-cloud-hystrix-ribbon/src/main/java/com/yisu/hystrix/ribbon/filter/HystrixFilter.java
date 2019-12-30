package com.yisu.hystrix.ribbon.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author xuyisu
 * @description hystrix 缓存过滤器
 * @date 2019/12/30
 */
@WebFilter(urlPatterns = "/*",filterName = "hystrixFilter")
@Component
public class HystrixFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            filterChain.doFilter(servletRequest,servletResponse);
        }finally {
            context.shutdown();
        }
    }
}
