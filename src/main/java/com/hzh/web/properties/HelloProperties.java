package com.hzh.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    public List<String> getFoo() {
        return foo;
    }

    public void setFoo(List<String> foo) {
        this.foo = foo;
    }

    private List<String> foo = Arrays.asList("a", "b");
}
