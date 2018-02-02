package com.dwizero.rest;

import com.dwizero.Util.DynamicScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class scheduTest {
    @Autowired
    private DynamicScheduledTask dynamicScheduledTask;

    @RequestMapping("")
    public void testScheduled() {
        dynamicScheduledTask.setCron("0/5 8 1 * * ?");
    }

}
