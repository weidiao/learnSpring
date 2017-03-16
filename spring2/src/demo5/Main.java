package demo5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"demo5/haha.xml");
		HahaContrller contrller = context.getBean(HahaContrller.class);
		contrller.handle();
		HahaService service = context.getBean(HahaService.class);
		service.go();
		context.close();
	}
}
