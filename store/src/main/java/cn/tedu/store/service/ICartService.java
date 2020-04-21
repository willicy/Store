package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.exception.AccessDeniedException;
import cn.tedu.store.service.exception.CartNotFoundException;
import cn.tedu.store.service.exception.InsertException;
import cn.tedu.store.service.exception.UpdateException;
import cn.tedu.store.vo.CartVO;

/**
 * 购物车的业务层接口
 */
public interface ICartService {

	/**
	 * 将商品添加到购物车
	 * @param cart 购物车数据
	 * @param username 当前操作的执行人
	 * @throws InsertException
	 * @throws UpdateException
	 */
	void addToCart(String username,Cart cart) throws InsertException,UpdateException;

	
	/**
	 * 增加购物车中商品的数量
	 * @param id 购物车数据的id
	 * @param uid 当前用户的id
	 * @throws CartNotFoundException
	 * @throws AccessDeniedException
	 * @throws UpdateException
	 */
	void addCount(Integer id, Integer uid)
		    throws CartNotFoundException, 
		        AccessDeniedException,
		            UpdateException;
	
	/**
	 * 减少购物车中商品的数量
	 * @param id 购物车数据的id
	 * @param uid 当前用户的id
	 * @throws CartNotFoundException
	 * @throws AccessDeniedException
	 * @throws UpdateException
	 */
	void reduceCount(Integer id, Integer uid)
		    throws CartNotFoundException, 
		        AccessDeniedException,
		            UpdateException;
	
	/**
	 * 根据用户id查询该用户的购物车数据列表
	 * @param uid 用户id
	 * @return 该用户的购物车数据列表
	 */
	List<CartVO> getByUid(Integer uid);
	
	/**
	 * 根据若干个id查询匹配的购物车数据的集合
	 * @param ids 若干个id
	 * @return 购物车数据的集合
	 */
	List<CartVO> getByIds(Integer[] ids);
}
