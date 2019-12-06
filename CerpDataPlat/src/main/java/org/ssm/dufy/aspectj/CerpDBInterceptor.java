package org.ssm.dufy.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.ssm.dufy.service.DBHolder;

public class CerpDBInterceptor {
    public Object setCerpDB(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("set master db");
        try {
            DBHolder.setCerpDB();
            return pjp.proceed();
        } finally {
            DBHolder.clearDB();
        }
    }
}
