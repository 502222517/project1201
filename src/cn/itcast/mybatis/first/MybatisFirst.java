package cn.itcast.mybatis.first;


import java.io.IOException;
import java.io.InputStream;
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
	
}
