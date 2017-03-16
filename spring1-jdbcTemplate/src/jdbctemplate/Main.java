package jdbctemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
	static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"jdbctemplate/applicationContext.xml");
	 public static void main(String[] args) {
		 UserDao dao=new UserDao();
		System.out.println(dao.getAllUsers());
	}
}
