package com.todo.myrestapi.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	/*@Before(value = "execution(* com.todo.myrestapi.controller.*.*(..)")
	public void beforeAdvice(Joinpoint joinpoint) {
		logger.info("Inside Before Advice");
	}*/
	/*@Before(value = "execution(* com.todo.myrestapi.controller.*.*(..) and args(object)")
	public void beforeAdvice(Joinpoint joinpoint, Object object) {
		logger.info("Request"+object);
}*/
	/*@After(value = "execution(* com.todo.myrestapi.controller.*.*(..) and args(object)")
	public void beforeAdvice(Joinpoint joinpoint, Object object) {
		logger.info("Request"+object);}*/
	/*@AfterReturning(value = "execution(* com.todo.myrestapi.controller.*.*(..) and args(object)",returning = "returningObject")
	public void afterAdvice(Joinpoint joinpoint,Object object, Object returningObject) {
		logger.info("Response= " + object);}
	*/
	@Around(value = "execution(* com.todo.myrestapi.controller.*.*(..) and args(object)")
	public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint , Object object) {
		logger.info("Request"+object);
		Object returningObject=null;
		try {
			returningObject= proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Response"+returningObject);
		}}
