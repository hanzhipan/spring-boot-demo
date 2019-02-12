package com.springbootdemo.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hanzhipan
 */
@Component
public class ShowRemoteHystrix implements ShowRemote {

    @Override
    public String show(@RequestParam(value = "name") String name) {
        return "hello" + name + ", this messge send failed ";
    }
}