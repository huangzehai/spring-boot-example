package com.hzh.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class BackgroundTaskController {

    @RequestMapping("merge")
    public String mergeProduct() {
        CompletableFuture.runAsync(()->{
            System.out.println("start to do something for a long time");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done something for a long time");
        });
        return "success";
    }
}
