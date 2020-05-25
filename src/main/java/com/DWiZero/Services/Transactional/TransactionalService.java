package com.DWiZero.Services.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Transactional 方法使用：
 * 1.其他类调用。内部无事物注解的调用有注解的：无效
 * 2.注解在public方法
 * reason:spring注解的动态代理问题代理方式问题：
 *        使用AspectJ编译时生成代理既可解决
 */
@Service
public class TransactionalService {

    @Transactional
    public void fileUpload()
    {

    }
}
