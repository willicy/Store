package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.District;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.GoodsCategory;

/**
 * 商品数据的持久层接口
 */
public interface GoodsMapper {

	/**
	 * 根据商品分类，查询商品列表
	 * @param categoryId 尚品分类的id
	 * @param offset 偏移量
	 * @param count 获取的数据的量大数据
	 * @return 商品列表
	 */
	List<Goods> findByCategory(
			@Param("categoryId") Long categoryId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	
	/**
	 * 根据id查询商品详情
	 * @param id 商品的id
	 * @return 商品详情,没匹配的数据返回null
	 */
	Goods findById(Long id);
	
	/**
	 * 根据优先级获取商品数据的列表
	 * @param count 获取的商品的数量
	 * @return 优先级最高的几个商品数据的列表
	 */
	List<Goods> findByPriority(Integer count);
}
