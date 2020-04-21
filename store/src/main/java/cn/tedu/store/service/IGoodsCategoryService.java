package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.exception.DeleteException;
import cn.tedu.store.service.exception.InsertException;

/**
 * 商品分类数据的业务层接口
 */
public interface IGoodsCategoryService {

	/**
	 * 用父级id取出子级
	 * @param parentId 父级id
	 * @return 子级列表
	 */
	public List<GoodsCategory> getByParent(Long parentId);
}
