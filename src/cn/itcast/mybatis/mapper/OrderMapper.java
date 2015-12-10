package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.OrderCustom;
import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.User;

public interface OrderMapper {

	public List<OrderCustom> findOrderList() throws Exception;
	
	public List<Orders> findOrdersListResultMap() throws Exception;
	
	public List<Orders> findOrdersDetailList() throws Exception;
	
	public List<User> findUserAndItemsResultMap() throws Exception;
	


}
