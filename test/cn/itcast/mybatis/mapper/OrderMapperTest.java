package cn.itcast.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.OrderCustom;
import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.User;

public class OrderMapperTest {

private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		String resource="SqlMapConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrderList() throws Exception {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		OrderMapper orderMapper= sqlSession.getMapper(OrderMapper.class);
		
		List<OrderCustom>  list= orderMapper.findOrderList();
		sqlSession.close();
		
		System.out.println(list);
	
		 
	}
	
	@Test
	public void testFindOrdersListResultMap() throws Exception {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		OrderMapper orderMapper= sqlSession.getMapper(OrderMapper.class);
		
		List<Orders>  list= orderMapper.findOrdersListResultMap();
		sqlSession.close();
		
		System.out.println(list);
	
		 
	}
	
	@Test
	public void testFindOrdersDetailList() throws Exception {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		OrderMapper orderMapper= sqlSession.getMapper(OrderMapper.class);
		
		List<Orders>  list= orderMapper.findOrdersDetailList();
		sqlSession.close();
		
		System.out.println(list);
	
		 
	}
	
	@Test
	public void testFindUserAndItemsResultMap() throws Exception {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		OrderMapper orderMapper= sqlSession.getMapper(OrderMapper.class);
		
		List<User>  list= orderMapper.findUserAndItemsResultMap();
		
		
		System.out.println(list);
	
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersUserLazyLoading() throws Exception {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		OrderMapper orderMapper= sqlSession.getMapper(OrderMapper.class);
		
		List<Orders>  list= orderMapper.findOrdersUserLazyLoading();
		
		for(Orders orders:list){
			User user=orders.getUser();
			System.out.println(user);
		}
		System.out.println(list);
	
		sqlSession.close();
	} 
	
	
	
}
