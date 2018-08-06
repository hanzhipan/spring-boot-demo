package com.springbootdemo.domain.entity;

import lombok.Data;

import java.util.Set;
@Data
public class Module {
    private Integer mid;
    private String mname;
    private Set<Role> roles;
}
