package com.springbootdemo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "eureka-demo", fallback = ShowRemoteHystrix.class)
public interface ShowRemote {

    @RequestMapping(value = "/show")
    public String show(@RequestParam(value = "name") String name);
}
