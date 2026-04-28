package tn.esprit.arctic.championnat.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ServiceLoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(ServiceLoggingAspect.class);

    @Pointcut("execution(* tn.esprit.arctic.championnat.Service..*(..))")
    public void serviceLayer() {
        // Pointcut for all service methods.
    }

    @Before("serviceLayer()")
    public void logBefore(org.aspectj.lang.JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info("[BEFORE] {}.{} args={}",
                signature.getDeclaringTypeName(),
                signature.getName(),
                Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "serviceLayer()", returning = "result")
    public void logAfterReturning(org.aspectj.lang.JoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info("[AFTER_RETURNING] {}.{} result={}",
                signature.getDeclaringTypeName(),
                signature.getName(),
                result);
    }

    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
    public void logAfterThrowing(org.aspectj.lang.JoinPoint joinPoint, Throwable ex) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.error("[AFTER_THROWING] {}.{} error={}",
                signature.getDeclaringTypeName(),
                signature.getName(),
                ex.toString());
    }

    @After("serviceLayer()")
    public void logAfter(org.aspectj.lang.JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info("[AFTER] {}.{}", signature.getDeclaringTypeName(), signature.getName());
    }

    @Around("serviceLayer()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long durationMs = System.currentTimeMillis() - start;
            log.info("[AROUND] {}.{} took {} ms", signature.getDeclaringTypeName(), signature.getName(), durationMs);
            return result;
        } catch (Throwable ex) {
            long durationMs = System.currentTimeMillis() - start;
            log.error("[AROUND] {}.{} failed after {} ms", signature.getDeclaringTypeName(), signature.getName(), durationMs);
            throw ex;
        }
    }
}

