package com.hzh.web.util;

import com.hzh.web.constant.Client;
import org.junit.Test;

import java.util.Map;

public class CookieUtilsTest {
    @Test
    public void parse() throws Exception {
        Map<String, String> cookieMap = CookieUtils.parse(Client.COOKIE);
        System.out.println(cookieMap);
    }

}