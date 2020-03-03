package com.li.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {


    //cron表达式，，表示要执行的时间
    //cron  6位数  秒 分 时 日 月 周几
//    @Scheduled(cron = "0,8,11,17,57 * * * * ?")
    public void hello(){
        System.out.println("你被执行了！");
    }
}
