package demo3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"demo3/applicationContext.xml");
		IStudent student = (IStudent) context.getBean("student");
		student.haha();
		System.out.println("===================");
		IStudent second = (IStudent) context.getBean("studenttarget");
		second.haha();
		context.close();
	}
}
