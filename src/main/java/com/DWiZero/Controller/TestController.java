package com.DWiZero.Controller;

import com.DWiZero.Bean.GlobleBean.ResponseEntry;
import com.DWiZero.Bean.GlobleBean.ServiceException;
import com.DWiZero.Services.RabbitMQ.RabbitMQProductor;
import com.DWiZero.Services.Cache.UserService;
import com.DWiZero.Util.DynamicScheduledTask;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController
{
    @Autowired
    private DynamicScheduledTask dynamicScheduledTask;
//    @Autowired
    RabbitMQProductor rabbitMQProductor;
    @Autowired
    UserService userService;

    @GetMapping(value = "/scheduled")
    public void testScheduled()
    {
        dynamicScheduledTask.setCron("0/5 8 1 * * ?");
    }

    @ApiOperation("/exception")
    @GetMapping(value = "/exception")
    public void testException()
    {
        throw new ServiceException("test GlobleException", 5300);
    }

    @ApiOperation("/rabbitMQ")
    @GetMapping(value = "/rabbitMQ")
    public void testRabbitMQ()
    {
        rabbitMQProductor.send();
    }

    @ApiOperation("/rabbitMQTopic")
    @GetMapping(value = "/rabbitMQTopic")
    public void testRabbitMQTopic()
    {
        rabbitMQProductor.sendTopicMessage();
    }

    @ApiOperation("/rabbitMQFanout")
    @GetMapping(value = "/rabbitMQFanout")
    public void testRabbitMQFanout()
    {
        rabbitMQProductor.sendFanoutMessage();
    }

    @ApiOperation("/getUserCacheTest")
    @GetMapping(value = "/getUserCacheTest")
    public ResponseEntry testGetUserCache(@RequestParam() Integer uid)
    {
        ResponseEntry responseEntry = new ResponseEntry();
        responseEntry.setData(userService.findUser(uid));
        return responseEntry;
    }

    @ApiOperation("/delUserCacheTest")
    @RequestMapping(value = "/delUserCacheTest", method = RequestMethod.DELETE)
    public ResponseEntry testDelUserCache(@RequestParam() Integer uid)
    {
        ResponseEntry responseEntry = new ResponseEntry();
        responseEntry.setData(userService.delUser(uid));
        return responseEntry;
    }

    @ApiOperation("/GetFilterParam")
    @RequestMapping(value = "/GetFilterParam")
    public ResponseEntry testGetFilterParam(@RequestParam() String cn)
    {
        ResponseEntry responseEntry = new ResponseEntry();
        responseEntry.setData(cn);
        return responseEntry;
    }
}
