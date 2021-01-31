package com.DWiZero.Controller;

import com.DWiZero.Services.Test.TestIocService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class IocTest {

    @GetMapping(value = "/ioc")
    public void test()
    {
        TestIocService iocService  = new TestIocService();
        iocService.test();
    }
}
