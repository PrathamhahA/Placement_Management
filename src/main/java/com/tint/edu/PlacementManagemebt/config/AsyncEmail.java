package com.tint.edu.PlacementManagemebt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
public class AsyncEmail {
    @Bean("emailServiceAsync")
    public Executor emailServiceAsync(){
        ThreadPoolTaskExecutor threadPoolExecutor=new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(2);
        threadPoolExecutor.setMaxPoolSize(10);
        threadPoolExecutor.setQueueCapacity(100);
        threadPoolExecutor.initialize();
        threadPoolExecutor.setThreadNamePrefix("EMAIL THREAD");
        return threadPoolExecutor;
    }
}
