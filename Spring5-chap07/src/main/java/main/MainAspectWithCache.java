package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtxWithCache;
import chap07.Calculator;

public class MainAspectWithCache
{
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithCache.class);
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		cal.factorial(7);
		cal.factorial(7);
		cal.factorial(5);
		cal.factorial(5);
		ctx.close();
	}
}
