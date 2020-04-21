package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.GoodsCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsMapperTestCase {

	@Autowired
	private GoodsMapper mapper;
	
	@Test
	public void findByUid() {
		Long categoryId = 163l;
		Integer offset=0;
		Integer count=10;
		List<Goods> list
			= mapper.findByCategory(categoryId, offset, count);
		
		System.err.println();
		System.err.println("BEGIN:");
		for (Goods data: list) {
			System.err.println(data);
		}
		System.err.println("END.");
	}
	
	@Test
	public void findById(){
		Long id=100000401L;
		Goods goods = mapper.findById(id);
		System.out.println(goods);
	}
	@Test
	public void findByPriority() {
		Integer count =10;
		List<Goods> list
			= mapper.findByPriority(count);
		
		System.err.println("BEGIN:");
		for (Goods data: list) {
			System.err.println(data);
		}
		System.err.println("END.");
	}
}








