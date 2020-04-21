package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.exception.DeleteException;
import cn.tedu.store.service.exception.InsertException;

/**
 * 商品数据的业务层接口
 */
public interface IGoodsService {
	/**
	 * 根据商品分类，查询商品列表
	 * @param categoryId 尚品分类的id
	 * @param offset 偏移量
	 * @param count 获取的数据的量大数据
	 * @return 商品列表
	 */
	List<Goods> getByCategory(
			Long categoryId,Integer offset, Integer count);
	
	/**
	 * 根据id查询商品详情
	 * @param id 商品的id
	 * @return 商品详情,没匹配的数据返回null
	 */
	Goods getById(Long id);
	
	/**
	 * 根据优先级获取商品数据的列表
	 * @param count 获取的商品的数量
	 * @return 优先级最高的几个商品数据的列表
	 */
	List<Goods> getByPriority(Integer count);
}
