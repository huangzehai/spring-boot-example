package com.hzh.web;

import com.hzh.web.properties.HelloProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloPropertiesTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void listShouldContainsPropertiesFromYaml() {
        HelloProperties properties = applicationContext.getBean(HelloProperties.class);
        List<String> foo = properties.getFoo();
        assertThat(foo).containsExactly("c");
    }

}