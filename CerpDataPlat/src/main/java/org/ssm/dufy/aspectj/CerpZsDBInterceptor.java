package org.ssm.dufy.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.ssm.dufy.service.DBHolder;

public class CerpZsDBInterceptor {
    public Object setCerpZsDB(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("set master db");
        try {
            DBHolder.setCerpZsDB();
            return pjp.proceed();
        } finally {
            DBHolder.clearDB();
        }
    }
}
