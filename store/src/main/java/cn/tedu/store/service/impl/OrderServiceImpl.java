package cn.tedu.store.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.mapper.DistrictMapper;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.service.exception.AddressNotFoundException;
import cn.tedu.store.service.exception.InsertException;
import cn.tedu.store.vo.CartVO;
import cn.tedu.store.vo.OrderVO;
import sun.management.Sensor;
/**
 * 订单与订单商品的业务层实现类
 */
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private IAddressService addressService;
	@Autowired
	private ICartService cartService;
	
	
	
	@Override
	@Transactional
	public Order createOrder(Integer uid, String username, Integer addressId, Integer[] cartIds)
			throws InsertException {
		 // 创建Date对象
		Date now = new Date();
	    // 声明pay变量
		Long pay=0L;
	    // List<CartVO> cartService.getByIds(ids)
		List<CartVO> carts = cartService.getByIds(cartIds);

	    // 创建List<OrderItem> orderItems
		List<OrderItem> orderItems=new ArrayList();
	    // 遍历集合，过程中，计算总价pay
		for (CartVO cartVO:carts){
			pay += cartVO.getNewPrice()*cartVO.getCount();
	    // -- 创建OrderItem
			OrderItem item = new OrderItem();
	    // -- item属性：goods_5，OK f
			item.setGoodsId(cartVO.getGid());
			item.setGoodsTitle(cartVO.getTitle());
			item.setGoodsImage(cartVO.getImage());
			item.setGoodsPrice(cartVO.getNewPrice());
			item.setGoodsCount(cartVO.getCount());
	    // -- item属性：4个日志，OK
			item.setCreatedUser(username);
			item.setCreatedTime(now);
			item.setModifiedUser(username);
			item.setModifiedTime(now);
			
			orderItems.add(item);
		}
	    // 创建Order对象
		Order order = new Order();
	    // order属性：uid，OK
		order.setUid(uid);
	    // order属性：pay，OK
		order.setPay(pay);
	    // 通过addressService.getById()得到收货地址数据
		Address address = addressService.getById(addressId);
		
		if(address==null){
			throw new AddressNotFoundException(
					"创建订单失败！收货地址数据有误，请刷新");
		}
		
	    // order属性：recv_4，OK
		order.setRecvName(address.getName());
		order.setRecvPhone(address.getPhone());
		order.setRecvDistrict(address.getDistrict());
		order.setRecvAddress(address.getAddress());
	    // order属性：order_time，OK
		order.setOrderTime(now);
	    // order属性：status，OK，值为0
		order.setStatus(0);
	    // 插入订单数据并获取oid：insertOrder(order)
		System.err.println("为什么没输出");
		insertOrder(order);
	    // 遍历orderItems
		for (OrderItem orderItem : orderItems) {
	        // item属性：oid
			orderItem.setOid(order.getId());
	        // 插入订单商品数据
			insertOrderItem(orderItem);
		}
		return order;
	}

	@Override
	public OrderVO getById(Integer id) {
		
		return findById(id);
	}
	
	/**
	 * 插入订单数据
	 * @param order 订单数据
	 * @return 受影响的行数
	 */
	private void insertOrder(Order order) {
		System.out.println("?");
		System.err.println("好奇怪");
		Integer rows = orderMapper.insertOrder(order);
		if (rows != 1){
			throw new InsertException("插入订单时发现未知错误");
		}
	}
	
	/**
	 * 插入订单商品数据
	 * @param orderItem 订单商品数据
	 * @return 受影响的行数
	 */
	private void insertOrderItem(OrderItem orderItem) {
		Integer rows = orderMapper.insertOrderItem(orderItem);
		if (rows != 1){
			throw new InsertException("插入订单商品时发现未知错误");
		}
	}
	/**
	 * 根据id查询订单详情
	 * @param id 订单id
	 * @return 匹配的订单详情，如果没有匹配的数据，则返回null
	 */
	private OrderVO findById(Integer id) {
		return orderMapper.findById(id);
	}

	
}
