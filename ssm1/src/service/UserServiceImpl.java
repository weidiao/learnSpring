package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserDao;
import po.UserPo;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	UserDao dao;
	@Override
	public UserPo getUserById(int userId) {
		return dao.getUserById(userId);
	}
}
