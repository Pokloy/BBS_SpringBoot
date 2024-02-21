package jp.co.cyzennt.bbs.BBS_Spring_Alier.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * Spring AOP aspect logging database access before repository methods execution.
 * @author Alier Torrenueva
 * 01/17/2024
 */

@Aspect
@Component
public class AspectExample {
	
	// Define a Before advice that will be executed before the specified pointcut
	@Before(value = "execution(* com.example.repository.*.*(..))")
	void before() {
		// Action taken by the advice: print a message to the console
		System.out.println("DB Access Occurs");
	}
}
