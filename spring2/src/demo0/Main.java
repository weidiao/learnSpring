package demo0;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"demo0/haha.xml");
	public static void main(String[] args) {
		HahaContrller contrller = context.getBean(HahaContrller.class);
		contrller.handle();
	}
}
