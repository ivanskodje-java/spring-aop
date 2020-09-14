package com.ivanskodje.springaop.aop;

import com.ivanskodje.springaop.problem.InternalServerProblem;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class StopwatchAspect {

    @Around(value = "@annotation(stopwatchAnnotation)")
    public Object stopwatch(final ProceedingJoinPoint joinPoint, final Stopwatch stopwatchAnnotation) {
        long timerStart = System.nanoTime();
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        try {
            log.info("{} started", stopwatchAnnotation.name());
            return joinPoint.proceed();
        } catch (Throwable ex) {
            throw new InternalServerProblem("Unhandled error occurred: " + ex.getMessage());
        } finally {
            long timerEnd = System.nanoTime();
            double timerDifference = (timerEnd - timerStart) / 1000000.0;
            log.info("{} ended in {}", stopwatchAnnotation.name(), timerDifference);
        }
    }
}
