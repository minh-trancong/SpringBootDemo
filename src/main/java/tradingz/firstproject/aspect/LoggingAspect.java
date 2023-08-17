package tradingz.firstproject.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import tradingz.firstproject.models.User;

@Aspect
@Slf4j
@Component
public class LoggingAspect {
    @AfterReturning(pointcut = "execution(* tradingz.firstproject.controllers.UserController.userById(..))", returning = "result")
    public void logUserInfo(JoinPoint joinPoint, User result){
        log.info("Retrieve user: "+ result.getName());
    }
}
