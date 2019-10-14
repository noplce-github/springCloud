package com.mengxuegu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: 梦学谷
 */
@Configuration //标识配置类
public class ConfigBean {
    //@LoadBalanced 实现负载均衡，调用地址IP可以变成服务名称，
    // 服务名称就是被调用的那个yml配置中的服务名称spring.application.name
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
