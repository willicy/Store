package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.exception.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceTestCase {

	@Autowired
	private IGoodsService goodsService;

	
	@Test
	public void getListParentId() {
		Long categoryId = 163l;
		Integer offset=0;
		Integer count=5;
		List<Goods> list
			= goodsService.getByCategory(categoryId, offset, count);
		
		System.err.println();
		System.err.println("BEGIN:");
		for (Goods data: list) {
			System.err.println(data);
		}
		System.err.println("END.");
	}
	@Test
	public void getById(){
		Long id =100000401L;
		Goods goods = goodsService.getById(id);
		System.err.println(goods);
	}
	
	@Test
	public void getByPriority() {
		Integer count=5;
		List<Goods> list
			= goodsService.getByPriority(count);
		
		System.err.println("BEGIN:");
		for (Goods data: list) {
			System.err.println(data);
		}
		System.err.println("END.");
	}
}
