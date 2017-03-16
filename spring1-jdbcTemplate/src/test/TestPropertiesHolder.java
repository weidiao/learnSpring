package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPropertiesHolder {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"test/applicationContext.xml");
	static ApplicationContext context2 = new ClassPathXmlApplicationContext(
			"test/applicationContext2.xml");
	public static void main(String[] args) {
		MyBean one = context.getBean(MyBean.class),
				two = context2.getBean(MyBean.class);
		System.out.println(one.getName());
		System.out.println(two.getName());
	}
}
