package haha;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import po.UserPo;
public class Main {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	public static void main(String[] args) {
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		UserPo user = userDao.getUserById(3);
		System.out.println(user.getName());
	}
}
