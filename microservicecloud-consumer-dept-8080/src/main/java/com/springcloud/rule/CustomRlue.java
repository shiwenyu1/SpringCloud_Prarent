package com.springcloud.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.validation.AbstractBindingResult;

import java.util.List;


public class CustomRlue extends AbstractLoadBalancerRule {

    //总调用的次数
    private int total = 0;
    //当前提供服务的机器号
    private int currentIndex=0;


    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null){
            return null;
        }
        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCont = allList.size();
            if (serverCont == 0) {
                return null;
            }
            if (total < 2) {
                server = upList.get(currentIndex);
                total++;
            }else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }
            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }
        return server;
    }


    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }
}
