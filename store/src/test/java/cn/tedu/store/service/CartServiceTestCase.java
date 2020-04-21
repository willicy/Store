package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.District;
import cn.tedu.store.vo.CartVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTestCase {

	@Autowired
	private ICartService service;
	
	@Test
	public void add() {
		String username = "qq";
		Cart cart = new Cart();
		cart.setUid(4);
		cart.setGid(9627L);
		cart.setCount(2);
		cart.setPrice(1000L);
		service.addToCart(username, cart);
	}

	@Test
	public void addCount() {
		Integer id = 80;
		Integer uid = 17;
		service.addCount(id, uid);
	}
	@Test
	public void findByUid(){
		List<CartVO> list = service.getByUid(17);
		System.err.println("Begin");
		for (CartVO cartVO : list) {
			System.err.println(cartVO);
		}
	}
	@Test
	public void findByIds(){
		Integer[] ids={6,7,8,9};
		List<CartVO>list=service.getByIds(ids);
		System.out.println("begin");
		for (CartVO cartVO : list) {
			System.err.println(cartVO);
		}
	}
}
