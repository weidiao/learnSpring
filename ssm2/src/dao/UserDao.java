package dao;

import java.util.List;

import po.UserPo;
public interface UserDao {
	UserPo getUserById(Integer id);
	List<UserPo> getAllUsers();
}
