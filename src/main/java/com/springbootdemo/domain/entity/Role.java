package com.springbootdemo.domain.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Role {
    private Integer rid;
    private String rname;
    private Set<User> users = new HashSet<>();
    private Set<Module> modules = new HashSet<>();
}
