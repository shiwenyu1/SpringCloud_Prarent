package com.springcloud.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomRule {
    /**
     * 将顺序显示访问数据修改改为随机显示数据
     * @return
     */
    @Bean
    public IRule suijiRule(){
        //将负载均衡的显示顺序，改成随机
        com.netflix.loadbalancer.RandomRule randomRule = new com.netflix.loadbalancer.RandomRule();
        return randomRule;
//       return new RoundRobinRule();   //轮询算法(默认轮询)

    }
}
