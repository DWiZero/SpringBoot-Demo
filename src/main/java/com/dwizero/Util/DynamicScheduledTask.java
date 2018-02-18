package com.dwizero.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

/**
 * 动态设置定时任务的时间
 */
@Service
public class DynamicScheduledTask
{
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler()
    {
        return new ThreadPoolTaskScheduler();
    }

    private static final Logger logger = LoggerFactory.getLogger(DynamicScheduledTask.class);
    private String cron = "0/1 * * * * ?";

    public String getCron()
    {
        return cron;
    }

    public void setCron(String cron)
    {
        this.cron = cron;
        threadPoolTaskScheduler.schedule(() -> {
            logger.info(cron);
            //业务逻辑（What do you want to do）

        }, new CronTrigger(cron));
    }

}
