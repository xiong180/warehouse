package com.serversys.web.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author 熊志伟
 * 创建时间  2021-01-02 11:19
 * 描述
 */
@Component
@Slf4j
public class SmsAsyncComponent {
    @Async("taskExecutor")
    public void smsAsync() throws InterruptedException {
        log.info(">02<");
        log.info(">正在发送短信..<");
        Thread.sleep(3000);
        log.info(">03<");
        log.info("短信线程:{}",Thread.currentThread().getName());
    }
}
