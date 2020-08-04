package org.zhxf.sale.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.zhxf.sale.dao.BaseDao;
import org.zhxf.sale.domain.SupplyInfo;
import org.zhxf.sale.service.SupplyInfoService;
import org.zhxf.sale.utils.Page;

public class SupplyInfoServiceImpl implements SupplyInfoService {

	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<SupplyInfo> find(String hql, Class<SupplyInfo> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public SupplyInfo get(Class<SupplyInfo> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<SupplyInfo> findPage(String hql, Page<SupplyInfo> page, Class<SupplyInfo> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(SupplyInfo entity) {
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<SupplyInfo> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<SupplyInfo> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);// 删除一个对象
	}

	@Override
	public void delete(Class<SupplyInfo> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(SupplyInfo.class, id);
		}
	}

}
