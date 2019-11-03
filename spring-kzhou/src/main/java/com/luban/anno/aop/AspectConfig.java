package com.luban.anno.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *      <bean id="aspectPrograme" class="com.luban.kzhou.aspect.AspectPrograme"></bean>
 *     <bean id="pointCut" class="com.luban.kzhou.aspect.PointCut"></bean>
 *     <aop:config>
 *         <aop:pointcut id="targertPointCut" expression="execution(* com.luban.kzhou.aspect.PointCut.save(*))"></aop:pointcut>
 *         <aop:aspect ref="aspectPrograme">
 *             <aop:before method="doBefore" pointcut-ref="targertPointCut"/>
 *         </aop:aspect>
 *     </aop:config>
 */
@Component
@Aspect
public class AspectConfig {

	@Pointcut("execution(* com.luban.anno.aop.TargetProgrome.*(..))")
	public void PointCut(){
	}

	/*@Around("PointCut()")
	public void around(ProceedingJoinPoint joinPoint){
		System.out.println("---------环绕：目标组件前：程序--------------");
		try {
			joinPoint.proceed();
			System.out.println("targer hascode: "+joinPoint.getTarget().hashCode());
			System.out.println("proxy hascode "+joinPoint.getThis().hashCode());
			System.out.println("aspect class hascode "+this.hashCode());
			System.out.println("---------环绕：目标组件后：程序--------------");
		} catch (Throwable throwable) {
			System.out.println("---------环绕：目标组件异常：程序--------------");
			throwable.printStackTrace();
		}
		System.out.println("---------环绕：目标组件最终：程序--------------");
	}*/

	@Before("PointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
        System.out.println("打印日志，权限验证，异常处理，事务处理");
    }
}
