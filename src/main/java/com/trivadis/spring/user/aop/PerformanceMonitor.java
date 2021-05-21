package com.trivadis.spring.user.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitor {

//	@Around("execution(* com.trivadis.spring.user.service..*.*(..))")
	@Around("@annotation(com.trivadis.spring.user.aop.Monitor)")
	public Object monitor(ProceedingJoinPoint jp) throws Throwable {
		long before = System.currentTimeMillis();
		
		try {			
			return jp.proceed();
		} finally {			
			long after= System.currentTimeMillis();
			long duration = after - before;
			System.out.println(duration + " ms " + jp.getSignature().getName());
		}
		
	}
}
