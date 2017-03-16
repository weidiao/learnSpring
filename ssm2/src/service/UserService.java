package service;

import java.util.List;

import po.UserPo;

public interface UserService {
	UserPo getUserById(int userId); 
	List<UserPo>getAllUsers();
}
