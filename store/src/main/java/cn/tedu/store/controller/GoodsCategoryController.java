package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.impl.AddressServiceImpl;
import cn.tedu.store.util.ResponseResult;

/**
 * 处理收货地址相关请求的控制器类
 */
@RestController
@RequestMapping("/category")
public class GoodsCategoryController 
	extends BaseController {

	@Autowired
	private IGoodsCategoryService categoryService;
	
	@GetMapping("/list/{parent}")
	public ResponseResult<List<GoodsCategory>> getByParent(
			@PathVariable("parent") Long parent){
		List<GoodsCategory> list = categoryService.getByParent(parent);
		return new ResponseResult<List<GoodsCategory>>(SUCCESS,list);
		
	}                                                          
	
}







