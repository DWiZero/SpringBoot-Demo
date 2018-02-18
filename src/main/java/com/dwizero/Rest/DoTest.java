package com.dwizero.Rest;

import com.dwizero.GlobleBean.ServiceException;
import com.dwizero.Services.rabbitMQ.RabbitMQClient;
import com.dwizero.Util.DynamicScheduledTask;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DoTest
{
    @Autowired
    private DynamicScheduledTask dynamicScheduledTask;
    @Autowired
    RabbitMQClient rabbitMQClient;

    @RequestMapping(value = "/scheduled", method = RequestMethod.GET)
    public void testScheduled()
    {
        dynamicScheduledTask.setCron("0/5 8 1 * * ?");
    }

    @ApiOperation("/exception")
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public void testException()
    {
        throw new ServiceException("test GlobleException", 5300);
    }

    @ApiOperation("/rabbitmq")
    @RequestMapping(value = "/rabbitmq", method = RequestMethod.GET)
    public void testRabbitMQ()
    {
        rabbitMQClient.send("test");
    }
}
