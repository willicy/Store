package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

/**
 * 购物车的持久层接口
 */
public interface CartMapper {
	
	
	
	/**
	 * 新增购物车数据
	 * @param cart 购物车数据
	 * @return 受影响的行数
	 */
	Integer addnew(Cart cart);

	/**
	 * 更改商品数量
	 * @param id 购物车id
	 * @param count 商品数量
	 * @return 受影响行数
	 */
	Integer updateCount(
		    @Param("id") Integer id, 
		    @Param("count") Integer count);
	/**
	 * 根据用户id,和商品id查出购物车数据
	 * @param uid 用户id
	 * @param goodsId 商品id
	 * @return 购物车id和商品数量
	 */
	Cart findByUidAndGid(
		    @Param("uid") Integer uid, 
		    @Param("goodsId") Long goodsId);
	
	/**
	 * 根据id获取购物车数据
	 * @param id 数据id
	 * @return 购物车数据
	 */
	Cart findById(Integer id);
	
	
	/**
	 * 根据若干个id查询匹配的购物车数据的集合
	 * @param ids 若干个id
	 * @return 购物车数据的集合
	 */
	List<CartVO> findByIds(Integer[] ids);
	
	
	
	/**
	 * 根据用户id查询该用户的购物车数据列表
	 * @param uid 用户id
 	 * @return 该用户的购物车数据列表
	 */
	List<CartVO> findByUid(Integer uid);
	

}
