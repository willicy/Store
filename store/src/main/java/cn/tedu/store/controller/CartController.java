package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;
import cn.tedu.store.service.impl.AddressServiceImpl;
import cn.tedu.store.util.ResponseResult;
import cn.tedu.store.vo.CartVO;

/**
 *购物车数据的控制器类
 */
@RestController
@RequestMapping("/cart")
public class CartController 
	extends BaseController {

	@Autowired
	private ICartService cartService;
	
	@PostMapping("/add_to_cart")
	public ResponseResult<Void> addToCart(
				HttpSession session,Cart cart){
	    // 从session中获取username
		String username = session.getAttribute("username").toString();
	    // 从session中获取uid
		Integer uid = getUidFromSession(session);
	    // 将uid封装到cart中
		cart.setUid(uid);

	
	    // 执行业务方法
		cartService.addToCart(username, cart);
	    // 返回
		return new ResponseResult<>(SUCCESS);
	}                                                       
	
	@GetMapping("/list")
	public ResponseResult<List<CartVO>> getByUid(
				HttpSession session){
	    // 从session中获取uid
		Integer uid = getUidFromSession(session);
	    // 将uid封装到cart中
		List<CartVO> list= cartService.getByUid(uid);

	    // 返回
		return new ResponseResult<List<CartVO>>(SUCCESS,list);
	}  
	
	@GetMapping("/add_count")
	public ResponseResult<Void> addCount(
			@RequestParam("id") Integer id,
				HttpSession session){
	    // 从session中获取uid
		Integer uid = getUidFromSession(session);
	   cartService.addCount(id, uid);

	    // 返回
		return new ResponseResult<>(SUCCESS);
	}  
	
	@GetMapping("/reduce_count")
	public ResponseResult<Void> reduceCount(
			@RequestParam("id") Integer id,
				HttpSession session){
	    // 从session中获取uid
		Integer uid = getUidFromSession(session);
	   cartService.reduceCount(id, uid);
	   
	    // 返回
		return new ResponseResult<>(SUCCESS);
	}
	
	@GetMapping("/get_by_ids")
	public ResponseResult<List<CartVO>>
	    getByIds(@RequestParam("cart_id")Integer[] ids) {
	    // 将uid封装到cart中
		List<CartVO> list= cartService.getByIds(ids);

	    // 返回
		return new ResponseResult<List<CartVO>>(SUCCESS,list);
	}
}







