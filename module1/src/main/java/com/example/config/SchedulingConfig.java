package com.example.config;

import com.example.service.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SchedulingConfig {

    private final SendMessage sendMessage;

    @Scheduled(fixedDelay = 30000)
    public void sendMessageScheduleTask(){
        sendMessage.sendMessage();

    }
}
