package guice.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.time.Duration;
import java.time.LocalDateTime;

public class ConsumeTimeLogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object proceed = null;
        LocalDateTime start = LocalDateTime.now();
        String methodName = null;
        try{
            proceed = methodInvocation.proceed();
            methodName = methodInvocation.getMethod().getDeclaringClass().getName()
                        + "."+ methodInvocation.getMethod().getName();
            int a = 1;
        }finally {
            LocalDateTime end = LocalDateTime.now();
            Duration duration = Duration.between(start, end);
            System.out.println("method : " + methodName +" consume time : "+duration.toMillis());
            return proceed;
        }
    }
}
