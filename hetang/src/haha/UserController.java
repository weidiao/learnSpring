package haha;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@Resource
	UserDao dao;
	@Resource
	HttpServletRequest req;
	@Resource
	HttpServletResponse resp;

	@RequestMapping("CreateUser")
	@ResponseBody
	void insertUser(User user) throws ServletException, IOException {
		System.out.println(user.getName());
		dao.insert(user);
		resp.sendRedirect("allUsers.jsp");
	}
	@ResponseBody
	@RequestMapping("DeleteUser")
	void deleteUser(String id) {
		dao.delete(id);
	}
	@RequestMapping("UpdateUser")
	@ResponseBody
	void updateUser(User user) throws IOException {
		dao.update(user);
		resp.sendRedirect("allUsers.jsp");
	}
	@RequestMapping("AllUsers")
	@ResponseBody
	List<User> allUsers() {
		return dao.getAllUsers();
	}
	@RequestMapping("UserById")
	@ResponseBody
	User userById(String id) {
		return dao.getUserById(id);
	}

	@RequestMapping("UserListByName")
	@ResponseBody
	List<User> userListByName(String key) {
		return dao.getUserListByName(key);
	}
	@RequestMapping("UserListByNum")
	@ResponseBody
	List<User> userListByNum(String key) {
		return dao.getUserListByNum(key);
	}
	@RequestMapping("UserListByCreatedTime")
	@ResponseBody
	List<User> userListByCreatedTime(long beg, long end) {
		return dao.getUserListByCreatedTime(beg, end);
	}
	@RequestMapping("UserListByUserType")
	@ResponseBody
	List<User> userListByUserType(int userType) {
		return dao.getUserListByUserType(userType);
	}
	@RequestMapping("LockUser")
	@ResponseBody
	void lockUser(String id) {
		dao.lockUser(id);
	}
	@RequestMapping("UnlockUser")
	@ResponseBody
	void unlockUser(String id) {
		dao.unlockUser(id);
	}
}
