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

	
	// ����id��ѯ
	@Test
	public void findUserByIdTest() throws IOException{
		
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream= Resources.getResourceAsStream(resource);
		 
		// ��������
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		// ��ѯ
		User user= sqlSession.selectOne("test.findUserById", 1);
		
		
		System.out.println(user);
		
		sqlSession.close();
	}

	@Test
	public void findUserByNameTest() throws IOException {
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream= Resources.getResourceAsStream(resource);
		 
		// ��������
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		// ��ѯ
		List<User> list= sqlSession.selectList("test.findUserByName", "С��");
		 
		System.out.println(list);
		
		sqlSession.close();
		
	}
	
	@Test
	public void insertUserTest() throws IOException {
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream= Resources.getResourceAsStream(resource);
		 
		// ��������
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		User user=new User();
		user.setUsername("����");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("����");
		
		// ����
	 	sqlSession.insert("test.insertUser", user);
	 	sqlSession.commit();
		
	 	System.out.println(user.getId());
	 	
		sqlSession.close();
		
	}
	
	@Test
	public void deleteUserTest() throws IOException {
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream= Resources.getResourceAsStream(resource);
		 
		// ��������
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
	 
		// ����
	 	sqlSession.delete("test.deleteUser", 28);
	 	sqlSession.commit();
		 
		sqlSession.close();
		
	}
	@Test
	public void updateUserTest() throws IOException {
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream= Resources.getResourceAsStream(resource);
		 
		// ��������
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		User user=new User();
		user.setId(27);
		user.setUsername("�Ŷ�");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("����");
		
		// ����
	 	sqlSession.insert("test.updateUser", user);
	 	sqlSession.commit();
		  
		sqlSession.close();
		
	}
	
	
	
	
}
