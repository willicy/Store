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
import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;
import cn.tedu.store.service.impl.AddressServiceImpl;
import cn.tedu.store.util.ResponseResult;

/**
 * 处理收货地址相关请求的控制器类
 */
@RestController
@RequestMapping("/goods")
public class GoodsController 
	extends BaseController {

	@Autowired
	private IGoodsService goodsService;
	
	@GetMapping("/list/{categoryId}")
	public ResponseResult<List<Goods>> getByCategory(
				@PathVariable("categoryId")Long categoryId){
		List<Goods> list = goodsService.getByCategory(categoryId, 0, 20);
					return new ResponseResult<List<Goods>>(SUCCESS,list);
		
	}                                                       
	@GetMapping("/details/{id}")
	public ResponseResult<Goods> getById(
				@PathVariable("id")Long id){
		Goods goods = goodsService.getById(id);
					return new ResponseResult<Goods>(SUCCESS,goods);
		
	}   
	@GetMapping("/hot")
	public ResponseResult<List<Goods>> getHotGoods() {
	    List<Goods> list
	        = goodsService.getByPriority(4);
	    return new ResponseResult<List<Goods>>(SUCCESS, list);
	}
}







