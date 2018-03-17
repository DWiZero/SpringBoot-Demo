package com.dwizero.Filter.AOP;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Aspect 将一个类定义为一个切面类
 @order(i) 标记切面类的处理优先级,i值越小,优先级别越高.PS:可以注解类,也能注解到方法上
 方法注解:ProceedingJoinPoint与@Around 一起使用

 @Pointcut 定义一个方法为切点里面的内容为一个表达式,下面详细介绍
 @Before 在切点前执行方法,内容为指定的切点
 @After 在切点后,return前执行,
 @AfterReturning 在切入点,return后执行,如果想对某些方法的返回参数进行处理,可以在这操作
 @Around 环绕切点,在进入切点前,跟切点后执行
 @AfterThrowing 在切点后抛出异常进行处理
 @order(i) 标记切点的优先级,i越小,优先级越高
 */
@Aspect
//@Component
public class serviceLog
{
    private Logger logger = Logger.getLogger(getClass());
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.dwizero.Services..*.*(..))")
    public void Log()
    {
    }

    @Before("Log()")
    public void doBefore(JoinPoint pjp) throws Throwable
    {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名
        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning(returning = "ret", pointcut = "Log()")
    public void doAfterReturning() throws Throwable
    {
        long serviceTime = System.currentTimeMillis() - startTime.get();
        logger.info(serviceTime);
    }
}
