package com.mokcoding.ex03.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component // Proxy 객체에 주입(injection)하기 위해 선언
@Aspect
@Log4j
public class HomeAspect {
	// * Aspect
	// - 일반적으로 메소드에 특정 기능을 적용시킬 때 사용
	
	// * PointCut 지정 방법 1
	// - @Pointcut
	//    ㄴ 동일한 Pointcut이 반복되는 것을 피할 수 있음
	//	  ㄴ 한번 지정한 Pointcut을 여러 advice 메소드에서 참조
	
	@Pointcut("execution(* com.mokcoding.ex03.HomeController.home(..))")
	// HomeController의 home() 메소드에 포인트컷 지정
	public void pcHome() {} // 포인트컷 위치 지정
	
	@Around("pcHome()") // 포인트컷 메서드를 적용
	public Object homeAdvice(ProceedingJoinPoint jp) {
		// ProceedingJoinPoint :
		// Advice가 적용된 메소드를 호출, 호출된 메소드의 실행을 계속 진행
		Object result = null;
		
		log.info("==== homeAdvice");
		try {
			log.info("==== home() 호출 전"); // @before
			result = jp.proceed(); // HomeController.home() 실행
			log.info("==== home() 리턴 후"); // @afterReturning
		} catch (Throwable e) {
			// @afterThrowing
			log.info("==== 예외 발생 : " + e.getMessage());
			e.printStackTrace();
		}finally {
			// @after
			log.info("==== finally");
		}
		
		return result;
	} // end homeAdvice
	
}
