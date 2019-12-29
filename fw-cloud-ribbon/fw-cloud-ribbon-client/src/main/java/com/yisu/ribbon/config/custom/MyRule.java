package com.yisu.ribbon.config.custom;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author xuyisu
 * @description 自定义负载规则
 * @date 2019/12/22
 */
@Slf4j
public class MyRule implements IRule {

    private ILoadBalancer loadBalancer;

    @Override
    public Server choose(Object o) {
        List<Server> allServers = loadBalancer.getAllServers();
        //输出一遍提供者实例
        allServers.stream().forEach(server -> System.out.println(server.getHostPort()));
        if(CollectionUtils.isEmpty(allServers)){
            log.info("当前不存在负载调用的提供者实例");
            return null;
        }
        return allServers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.loadBalancer=iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.loadBalancer;
    }
}
