package haha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import po.UserPo;
import service.UserService;
@ContextConfiguration(locations = {"classpath:spring.xml",
		"classpath:spring-mybatis.xml"})
public class Main {
	@Autowired
	static UserService service;
	public static void main(String[] args) {
		UserPo user = service.getUserById(3);
		System.out.println(user.getName());
	}
}
