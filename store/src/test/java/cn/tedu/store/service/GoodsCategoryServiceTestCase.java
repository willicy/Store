package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.exception.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsCategoryServiceTestCase {

	@Autowired
	private IGoodsCategoryService goodsCategoryService;

	
	@Test
	public void getListParentId() {
		Long parentId = 161l;
		List<GoodsCategory> list
			= goodsCategoryService.getByParent(parentId);
		System.err.println("BEGIN:");
		for (GoodsCategory data : list) {
			System.err.println(data);
		}
		System.err.println("END.");
	}

}
