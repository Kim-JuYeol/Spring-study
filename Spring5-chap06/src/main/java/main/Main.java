package main;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.Appctx;
import spring.Client;
import spring.Client2;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Appctx.class);
	}
}
