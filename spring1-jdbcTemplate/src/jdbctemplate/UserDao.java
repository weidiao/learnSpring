package jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
public class UserDao {
	JdbcTemplate template = Main.context.getBean(JdbcTemplate.class);

	public List<Map<String, Object>> findALL() {
		String sql = "select * from user";
		return template.queryForList(sql);
	}
	public List<String> getAllUserNames() {
		String sql = "select name from user";
		System.out.println(template);
		return template.queryForList(sql, String.class);
	}
	public List<User> getAllUsers() {
		String sql = "select * from user";
		return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}

	public List<User> findALLBooks() {
		String sql = "select * from user";
		List<Map<String, Object>> list = template.queryForList(sql);
		List<User> users = new ArrayList<User>();
		list.forEach(x -> {
			User user = new User();
			user.setName(x.get("name").toString());
			user.setAge((int) x.get("age"));
			users.add(user);
		});
		return users;
	}
	public String getUserNameById(long id) {
		return template.queryForObject("select name from user where id=?",
				new Object[]{id}, String.class);
	}
	RowMapper<User> userRowMapper = new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setAge(rs.getInt("age"));
			user.setName(rs.getString("name"));
			return user;
		}

	};
	public User getUserById(long id) {
		return template.queryForObject("select * from user where id=?",
				new Object[]{id}, userRowMapper);

	}
	public User getUserById2(long id) {
		return template.queryForObject("select * from user where id=?",
				new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
	}

	public int delete(int bid) {
		String sql = "delete from user where bid =?";
		return template.update(sql, new Object[]{bid});
	}
}