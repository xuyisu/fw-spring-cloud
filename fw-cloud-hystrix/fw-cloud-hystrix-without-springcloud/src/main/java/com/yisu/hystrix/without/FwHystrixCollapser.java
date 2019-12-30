package com.yisu.hystrix.without;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuyisu
 * @description 合并请求
 * @date 2019/12/30
 */
@Slf4j
public class FwHystrixCollapser extends HystrixCollapser<List<String>, String, String> {

    private final String name;

    public FwHystrixCollapser(String name) {
        this.name = name;
    }

    @Override
    public String getRequestArgument() {
        return this.name;
    }

    @Override
    protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String, String>> requests) {
        return new FwBatchCommand(requests);
    }

    @Override
    protected void mapResponseToRequests(List<String> strings, Collection<CollapsedRequest<String, String>> requests) {
        AtomicInteger count = new AtomicInteger();
        requests.stream().forEach(request -> request.setResponse(strings.get(count.getAndIncrement())));
    }

    private static final class FwBatchCommand extends HystrixCommand<List<String>> {

        private Collection<CollapsedRequest<String, String>> requests;

        protected FwBatchCommand(Collection<CollapsedRequest<String, String>> requests) {
            super(Setter.withGroupKey(
                    HystrixCommandGroupKey.Factory.asKey("testGroup")
                    ).andCommandKey(
                    HystrixCommandKey.Factory.asKey("testKey")
                    )
            );
            this.requests=requests;
        }

        @Override
        protected List<String> run() throws Exception {
            log.info("real request");
            List<String> response=new ArrayList<>();
            for (CollapsedRequest<String, String> request : requests) {
                response.add("result:"+request.getArgument());
            }
            return response;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        Future<String> tesFuture1 = new FwHystrixCollapser("test1").queue();
        Future<String> tesFuture2 = new FwHystrixCollapser("test2").queue();
        log.info(tesFuture1.get());
        log.info(tesFuture2.get());
        context.shutdown();
    }
}
