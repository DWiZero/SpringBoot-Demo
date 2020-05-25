package com.DWiZero.Services.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Async 方法使用：
 * 1.其他类调用。内部无事物注解的调用有注解的：无效
 * 2.注解在public方法
 * reason:spring注解的动态代理问题代理方式问题：
 * 使用AspectJ编译时生成代理既可解决
 */

@Service
public class AsyncService {


    @Async
    public void submitTaskWithoutResult() {

    }

    /**
     * Integer可以替换为返回对象
     * @return 线程执行结果
     */
    @Async
    public  Future<Integer> submitTaskWithResult() {
        return new AsyncResult<Integer>(5);
    }
}
