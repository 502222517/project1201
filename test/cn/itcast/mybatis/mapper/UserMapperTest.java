package cn.itcast.mybatis.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

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
	
	
	@Test
	public void testFindUserList() throws Exception {
		 SqlSession sqlSession=sqlSessionFactory.openSession();
		 
		 UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
		 
		 UserQueryVo userQueryVo=new UserQueryVo();
		 UserCustom userCustom=new UserCustom();
		 userCustom.setUsername("ÕÅÈý");
//		 userCustom.setSex("1");
		 userQueryVo.setUserCustom(userCustom);
		 
		 List<Integer> ids=new  ArrayList<Integer>();
		
		 ids.add(1);
		 ids.add(10);
		 ids.add(16);
		 userQueryVo.setIds(ids);
		 
		 List<UserCustom>  list= userMapper.findUserList(userQueryVo);
		 
		 sqlSession.close();
		 
		 System.out.println(list);
	}
	

}
