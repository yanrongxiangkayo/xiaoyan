package com.kayo.manager.utils;

import com.kayo.CommData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author yanrx
 * @version 1.0
 * @date 2021/6/27 14:17
 */
@Aspect
@Component
public class RpcLogAspect {

    //切入点为使用了Login注解的任何地方
    @Pointcut("@annotation(com.kayo.manager.utils.RpcLog)")
    public void logPointCut() {

    }

    @Around("logPointCut() && @annotation(rpcLog)")
    public Object around(ProceedingJoinPoint joinPoint, RpcLog rpcLog) {
        System.out.println("开始");
        Object[] objects = joinPoint.getArgs();

        String id = rpcLog.id();
        String name = rpcLog.name();
        Object arg = objects[0];
        String aId = id.substring(id.indexOf(".") + 1);
        String aName = name.substring(name.indexOf(".") + 1);
        Object o = null;
        long uuid = 0;
        String uuName = null;
        try {
            Class<?> aClass = arg.getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                if (aId.equals(field.getName())) {
                    field.setAccessible(true);
                    uuid = (long) field.get(arg);
                }
                if (aName.equals(field.getName())) {
                    field.setAccessible(true);
                    uuName = (String) field.get(arg);
                }
            }

            if (arg instanceof CommData) {
                CommData data = (CommData) arg;
                data.uuid = (long) (Math.random() * 10000L);
            }
            System.out.println("uuid = " + uuid);
            System.out.println("uuName = " + uuName);
            o = joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("1");
        }
        return o;
    }

}
