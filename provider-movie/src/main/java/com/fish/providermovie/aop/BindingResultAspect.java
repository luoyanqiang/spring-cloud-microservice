package com.fish.providermovie.aop;

import com.fish.providermovie.ret.RetResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * 验证错误统一处理
 * public RetResult post(@Validated @RequestBody ShareSpaceResult spaceCustom, BindingResult bindingResult)
 */
@Aspect
@Component
@Order(2)
public class BindingResultAspect {
    @Pointcut("execution(public * com.fish.providermovie.controller.*.*(..))")
    public void bindingResult() {
    }

    @Around("bindingResult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    return RetResponse.makeErrRsp(result.getFieldError().getDefaultMessage());
                }
            }
        }
        return joinPoint.proceed();
    }
}