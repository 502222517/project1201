package cn.itcast.mybatis.mapper;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class UserMapperTest{

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		 SqlSession sqlSession=sqlSessionFactory.openSession();
		 
		 UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
		 
		 User user= userMapper.findUserById(1);
		 
		 sqlSession.close();
		 
		 System.out.println(user);
	}
	
	
	

}
