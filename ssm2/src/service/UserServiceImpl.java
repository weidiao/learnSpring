package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDao;
import po.UserPo;
import service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource // @Autowired
	UserDao dao;
	@Override
	public UserPo getUserById(int userId) {
		return dao.getUserById(userId);
	}
	@Override
	public List<UserPo> getAllUsers() {
		return dao.getAllUsers();
	}
}
