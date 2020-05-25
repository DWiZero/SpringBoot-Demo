package com.DWiZero.Controller;

import com.DWiZero.Services.ScopeTestService.MiddleService;
import com.DWiZero.Services.ScopeTestService.PrototypeService;
import com.DWiZero.Services.ScopeTestService.PrototypeWithProxyService;
import com.DWiZero.Services.ScopeTestService.RequestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController("/Scope")
public class ScopeTest {
    @Autowired
    PrototypeService prototypeService;

    @Autowired
    PrototypeWithProxyService prototypeWithProxyService;

    @Autowired
    RequestService requestService;

    @Autowired
    MiddleService middleService;

    @GetMapping("/log")
    public void logScope(String seq) {
        log.info(seq + "-prototypeService:    " + prototypeService);
        log.info(seq + "-prototypeWithProxyService:    " + prototypeWithProxyService);
        log.info(seq + "-requestService:    " + requestService);
        middleService.logScope(seq);
    }
}
