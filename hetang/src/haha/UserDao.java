package haha;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
@Component
public class UserDao {
	@Resource
	JdbcTemplate template;

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		System.out
				.println(JSON.toJSONString(dao.getUserListByUserType(0), true));
	}
	public String insert(User user) {
		String sql = "insert into user set id=?,num=?,name=?,remark=?,state=?,createdTime=?,lastAccessTime=?,userType=?";
		user.setId(UUID.randomUUID().toString());
		user.setCreatedTime(System.currentTimeMillis());
		user.setLastAccessTime(System.currentTimeMillis());
		int rows = template.update(sql, user.id, user.num, user.name,
				user.remark, user.state, user.createdTime, user.lastAccessTime,
				user.userType);
		return rows == 1 ? user.getId() : null;
	}
	public boolean delete(String id) {
		String sql = "delete from user where id=?";
		int rows = template.update(sql, id);
		return rows == 1;
	}
	public boolean update(User user) {
		User o = getUserById(user.getId());
		System.out.println(o);
		if (Util.nullOrEmpty(user.getNum())) {
			user.setNum(o.getNum());
		}
		if (Util.nullOrEmpty(user.getName())) {
			user.setName(o.getName());
		}
		if (Util.nullOrEmpty(user.getRemark())) {
			user.setRemark(o.getRemark());
		}
		if (user.getState() == null) {
			user.setState(o.getState());
		}
		if (user.getCreatedTime() == null) {
			user.setCreatedTime(o.getCreatedTime());
		}
		if (user.getUserType() == null) {
			user.setUserType(o.getUserType());
		}
		String sql = "update user set num=?,name=?,remark=?,state=?,createdTime=?,userType=? where id =?";
		int rows = template.update(sql, user.getNum(), user.getName(),
				user.getRemark(), user.getState(), user.getCreatedTime(),
				user.getUserType(), user.getId());
		return rows == 1;
	}
	public User getUserById(String id) {
		List<User> list = template.query("select * from user where id=?",
				new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
		if (list.size() == 0)
			return null;
		return list.get(0);
	}
	public List<User> getAllUsers() {
		return template.query("select * from user",
				new BeanPropertyRowMapper<>(User.class));
	}
	public List<User> getUserListByNum(String num) {
		String key = "%" + num + "%";
		String sql = "select * from user where num like ?";
		Object[] args = {key};
		return template.query(sql, args,
				new BeanPropertyRowMapper<>(User.class));
	}
	public List<User> getUserListByName(String name) {
		String key = "%" + name + "%";
		String sql = "select * from user where name like ?";
		Object[] args = {key};
		return template.query(sql, args,
				new BeanPropertyRowMapper<User>(User.class));
	}
	public List<User> getUserListByCreatedTime(long beg, long end) {
		String sql = "select * from user where createdTime between ? and ?";
		Object[] args = {beg, end};
		return template.query(sql, args,
				new BeanPropertyRowMapper<User>(User.class));
	}
	public List<User> getUserListByUserType(int userType) {
		String sql = "select * from user where userType=?";
		Object[] args = {userType};
		return template.query(sql, args,
				new BeanPropertyRowMapper<User>(User.class));
	}
	public boolean lockUser(String id) {
		String sql = "update user set state=1 where id=?";
		int rows = template.update(sql, id);
		return rows == 1;
	}
	public boolean unlockUser(String id) {
		String sql = "update user set state=0 where id=?";
		int rows = template.update(sql, id);
		return rows == 1;
	}
}
