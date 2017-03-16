package demo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"demo2/applicationContext.xml");
		Performer performer = context.getBean(Performer.class);
		performer.perform();
		context.close();
	}
}