package com.dan.danbusiness.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author lijun
 * @Description 访问接口进出详情记录
 * @Date 2020-05-28 10:20 上午
 **/

@Slf4j
@Aspect
@Component
public class InOutAopLog {

    @Pointcut("@annotation(com.dan.danbusiness.aop.EagleEye)")
    public void eagleEye() {

    }

    @Around("eagleEye()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 访问开始时间
        long begin = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        EagleEye eagleEye = method.getAnnotation(EagleEye.class);

        // 接口信息
        String desc = eagleEye.desc();

        log.info("======================请求开始========================");

        log.info("请求连接：{}", request.getRequestURL().toString());

        log.info("接口描述：{}", desc);

        log.info("请求类型：{}", request.getMethod());

        log.info("请求方法：{}{}", signature.getDeclaringTypeName(), signature.getName());

        log.info("请求IP：{}", request.getRemoteAddr());

        log.info("请求参数：{}", pjp.getArgs());

        Object result = pjp.proceed();
        // 访问结束时间
        long end = System.currentTimeMillis();
        log.info("请求耗时：{}ms", end - begin);

        log.info("请求返回：{}", JSON.toJSONString(result));

        log.info("======================请求结束========================");
        return result;
    }
}
