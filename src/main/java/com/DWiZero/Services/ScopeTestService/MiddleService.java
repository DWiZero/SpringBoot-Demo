package com.DWiZero.Services.ScopeTestService;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MiddleService {
    @Autowired
    RequestService requestService;

    @Autowired
    PrototypeWithProxyService prototypeWithProxyService;

    public void logScope(String seq) {
        log.info(seq + "-MiddleService:request   " + requestService);
        log.info(seq + "-MiddleService:prototype    " + prototypeWithProxyService);
    }
}
