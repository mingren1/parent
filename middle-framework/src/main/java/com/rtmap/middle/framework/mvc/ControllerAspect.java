package com.rtmap.middle.framework.mvc;

import com.rtmap.middle.framework.annotation.AdminAuth;
import com.rtmap.middle.framework.annotation.JWTAuth;
import com.rtmap.middle.framework.base.BaseVO;
import com.rtmap.middle.framework.base.Context;
import com.rtmap.middle.framework.model.Result;
import com.rtmap.middle.framework.annotation.AdminAuth;
import com.rtmap.middle.framework.annotation.JWTAuth;
import com.rtmap.middle.framework.base.BaseVO;
import com.rtmap.middle.framework.base.Context;
import com.rtmap.middle.framework.model.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ControllerAspect {

    @Pointcut("@annotation(com.rtmap.middle.framework.annotation.JWTAuth)")
    public void annotationPointCut() {
    }

    /**
     * 使用注解式的拦截
     *
     * @param joinPoint
     * @After声明一个建言，并使用 @Pointcut定义的切点
     */
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        JWTAuth action = method.getAnnotation(JWTAuth.class);
        System.out.println("注解式拦截：" + action.required());
    }

    @Around("execution(* com.rtmap..*Controller.*(..))")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截: " + method.getName());

        Object[] ps = joinPoint.getArgs();
        if (ps.length > 0 && ps[0] instanceof BaseVO) {
            BaseVO vo = (BaseVO) ps[0];
            vo.setCxt(Context.getLocalContext());
            AdminAuth adminAuth = method.getAnnotation(AdminAuth.class);
            if (adminAuth != null && !"1".equalsIgnoreCase(vo.getCxt().getRole())) {
                return Result.error("无权限，请联系管理员");
            }
        }
        Object obj = joinPoint.proceed();
        return obj;
    }
}
