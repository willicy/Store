package cn.tedu.store.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.exception.AccessDeniedException;
import cn.tedu.store.service.exception.AddressNotFoundException;
import cn.tedu.store.service.exception.DeleteException;
import cn.tedu.store.service.exception.InsertException;
import cn.tedu.store.service.exception.UpdateException;

@Service
public class GoodsCategoryServiceImpl 
	implements IGoodsCategoryService {
	
	@Autowired
	private GoodsCategoryMapper goodsCategoryMapper;
	@Override
	public List<GoodsCategory> getByParent(Long parentId) {
		return findByParent(parentId);
	}

	/**
	 * 根据父级id获取子级的商品分类的数据的列表
	 * @param parentId 父级商品分类的id
	 * @return 子级的商品分类的数据的列表
	 */
	private List<GoodsCategory> findByParent(Long parentId) {
		return goodsCategoryMapper.findByParent(parentId);
	}

}




