package bean2;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import demo.Aser;
import demo.Ser;
import demo.User;





public class Text {
/*	ApplicationContext context;
	@Test
	public  void text() {
		context=new ClassPathXmlApplicationContext("bean1.xml");
		 Object bean=context.getBean("helloService");
		 System.out.println("123:");
		 System.out.println(bean.getClass());
	}*/
/*	@Test
	public void text1() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context1=new AnnotationConfigApplicationContext();
		 context1.scan("cn.com.taiji.controller");
		 context1.refresh();
		 context1.registerShutdownHook();
		 int cunt= context1.getBeanDefinitionCount();
		 System.out.println("321:"+cunt);
		 String[] names=context1.getBeanDefinitionNames();
		 for(String name:names) {
			 System.out.println(name+"-->");
			 Object aaa=context1.getBean(name);
			 System.out.println(aaa.getClass());
		 }
		 
		
	}*/

	@Test
	public void text2() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context1=new AnnotationConfigApplicationContext();
		 context1.scan("demo");
		 context1.refresh();
		 Ser d=(Ser)context1.getBean("ser");
		 d.dou();
		
	
		 
		
	}
	@Test
	public void text3() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Aser.class); 
		
		context.registerShutdownHook();
		 System.out.println("123");
		 System.out.println("123"+context.getBean("abc"));
		 
	}
}
