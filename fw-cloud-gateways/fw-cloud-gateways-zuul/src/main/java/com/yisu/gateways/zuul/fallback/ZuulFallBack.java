package com.yisu.gateways.zuul.fallback;

import cn.hutool.json.JSONUtil;
import com.netflix.zuul.context.RequestContext;
import com.yisu.common.result.FwResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author xuyisu
 * @description fallback
 * @date 2020/1/4
 */
@Slf4j
@Component
public class ZuulFallBack implements FallbackProvider {
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                RequestContext ctx=RequestContext.getCurrentContext();
                Throwable throwable = ctx.getThrowable();
                if(null!=throwable){
                    log.error("Zuul发生错误,{}",throwable.getCause().getMessage());
                    FwResult<String> byteMsg = FwResult.failed(throwable.getCause().getMessage(), "网络或服务异常");
                    return new ByteArrayInputStream(JSONUtil.toJsonStr(byteMsg).getBytes());
                }
                FwResult<String> byteMsg = FwResult.failedMsg("网络或服务异常");
                return new ByteArrayInputStream(JSONUtil.toJsonStr(byteMsg).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers=new HttpHeaders();
                MediaType mediaType=new MediaType("application", "json", StandardCharsets.UTF_8);
                headers.setContentType(mediaType);
                return headers;
            }
        };
    }
}
