package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;
import cn.tedu.store.entity.Order;
import cn.tedu.store.vo.OrderVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTestCase {

	@Autowired
	private IOrderService service;

	@Test
	public void getListByParent() {
		Integer[] a={6,8,9};
	Order order = service.createOrder(17, "笑话", 20, a);
			System.err.println(order);
	}
	
	@Test
	public void a(){
		Integer id=10;
		OrderVO data = service.getById(id);
		System.out.println(data);
		
		
		
	}
}
