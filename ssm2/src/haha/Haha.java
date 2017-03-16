package haha;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.UserPo;
import service.UserService;

public class Haha {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"spring.xml", "spring-mybatis.xml"); 
	public static void main(String[] args) {
		UserService service=context.getBean(UserService.class);
		UserPo userPo = service.getUserById(2);
		System.out.println(userPo.getName());
	}
}
