package com.example.springbrrowbook.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Aspect
public class BookAspect {
//    @Before(value = "within(  com.example.springbrrowbook.service.BookService)&& execution(public * com.example.springbrrowbook.service.BookService.getAllBooks())")
//    public void Logging(){
//        System.out.println("Sow list");
//    }
//    @After(value = "execution(* com.example.springbrrowbook.controller.BookController.borrowBook(..))")
//    public void Logging1(JoinPoint joinPoint){
//        System.out.println("Muon sach thanh cong !!!");
//        String className=joinPoint.getTarget().getClass().getSimpleName();
//        String methodName=joinPoint.getSignature().getName();
//        String args= Arrays.toString(joinPoint.getArgs());
//        System.out.print("Ten cua class la :");
//        System.out.print( className);
//        System.out.print( ":");
//        System.out.print( methodName);
//        System.out.print( ".");;
//        System.out.print( args);;
//
//
//    }
//    @AfterReturning(value = "execution(public * com.example.springbrrowbook.controller.BookController.getAllBooks(..))",returning = "result")
//    public void Logging2(JoinPoint joinPoint,Object result){
//        String className=joinPoint.getTarget().getClass().getSimpleName();
//        String methodName=joinPoint.getSignature().getName();
//        System.out.println(className);
//        System.out.println("--------------");
//        System.out.println(methodName);
//        System.out.println("--------------");
//
//        System.out.println(result);
//
//@AfterThrowing(value = "execution(public * com.example.springbrrowbook.controller.BookController.getBook(..))",throwing = "ex")
//    public void Logging3(JoinPoint joinPoint,Exception ex){
//    String className=joinPoint.getTarget().getClass().getSimpleName();
//    String methodName=joinPoint.getSignature().getName();
//    String args=Arrays.toString(joinPoint.getArgs());
//    System.out.println(className);
//    System.out.println("----------------");
//    System.out.println(methodName);
//    System.out.println("----------------");
//    System.out.println(args);
//    System.out.println("----------------");
//    System.out.println(ex.getMessage());
//
//
//
//    }

}
