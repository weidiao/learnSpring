package haha;

import entity.User;

public class LoginService {
	public boolean login(User user) {
		System.out.println(user.getUsername() + ":" + user.getPassword());
		return user.getUsername().equals("admin")
				&& user.getPassword().equals("admin");
	}
}
