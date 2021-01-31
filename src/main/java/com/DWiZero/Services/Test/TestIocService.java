package com.DWiZero.Services.Test;

import com.DWiZero.Services.Transactional.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TestIocService {
    @Autowired
    TransactionalService transactionalService;

    public void test(){
        transactionalService.fileUpload();
    }
}
