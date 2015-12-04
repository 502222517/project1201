package cn.itcast.mybatis.first;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class MybatisFirst {

	
	// 根据id查询
	@Test
	public void findUserByIdTest() throws IOException{
		
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream= Resources.getResourceAsStream(resource);
		 
		// 创建工厂
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		// 查询
		User user= sqlSession.selectOne("test.findUserById", 1);
		
		
		System.out.println(user);
		
		sqlSession.close();
	}

	@Test
	public void findUserByNameTest() throws IOException {
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream= Resources.getResourceAsStream(resource);
		 
		// 创建工厂
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		// 查询
		List<User> list= sqlSession.selectList("test.findUserByName", "小明");
		 
		System.out.println(list);
		
		sqlSession.close();
		
	}
	
	@Test
	public void insertUserTest() throws IOException {
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream= Resources.getResourceAsStream(resource);
		 
		// 创建工厂
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		User user=new User();
		user.setUsername("张三");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("江西");
		
		// 插入
	 	sqlSession.insert("test.insertUser", user);
	 	sqlSession.commit();
		
	 	System.out.println(user.getId());
	 	
		sqlSession.close();
		
	}
	
	@Test
	public void deleteUserTest() throws IOException {
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream= Resources.getResourceAsStream(resource);
		 
		// 创建工厂
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
	 
		// 插入
	 	sqlSession.delete("test.deleteUser", 28);
	 	sqlSession.commit();
		 
		sqlSession.close();
		
	}
	@Test
	public void updateUserTest() throws IOException {
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream= Resources.getResourceAsStream(resource);
		 
		// 创建工厂
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		User user=new User();
		user.setId(27);
		user.setUsername("张二");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("江西");
		
		// 插入
	 	sqlSession.insert("test.updateUser", user);
	 	sqlSession.commit();
		  
		sqlSession.close();
		
	}
	
	
	
	
}
