package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;

public interface UserMapper {
	
	public User findUserById(int id) throws	Exception;
	
	public List<User> findUserByName(String username) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void deleteUser(int id) throws Exception;
	
}
