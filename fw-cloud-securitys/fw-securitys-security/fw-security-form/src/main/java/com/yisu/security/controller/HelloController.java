package com.yisu.security.controller;

import com.yisu.common.result.FwResult;
import com.yisu.security.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@RestController
@Slf4j
public class HelloController {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当需要身份认证时，跳转到这里
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/authentication/require")
    public FwResult requireAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是:" + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }

        return FwResult.failed("访问的服务需要身份认证，请重新登录");
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @RequestMapping("/user")
    public FwResult getUser() {
        List<Map<String, String>> maps = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("username", "李四");
        map.put("sex", "男");
        maps.add(map);
        return FwResult.ok(maps);
    }


}
