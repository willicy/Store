package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.District;
import cn.tedu.store.vo.CartVO;
import cn.tedu.store.vo.OrderVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTestCase {

	@Autowired
	private OrderMapper orderMapper;
	

	
	@Test
	public void findById(){
		Integer id = 10;
		OrderVO data = orderMapper.findById(id);
		System.err.println(data);
		String s=null;
		System.out.println(s);
	}
}








