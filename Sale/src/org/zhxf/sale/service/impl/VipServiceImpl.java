package org.zhxf.sale.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.zhxf.sale.dao.BaseDao;
import org.zhxf.sale.domain.Vip;
import org.zhxf.sale.service.VipService;
import org.zhxf.sale.utils.Page;

public class VipServiceImpl implements VipService {

	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Vip> find(String hql, Class<Vip> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public Vip get(Class<Vip> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<Vip> findPage(String hql, Page<Vip> page, Class<Vip> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(Vip entity) {
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<Vip> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<Vip> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);// 删除一个对象
	}

	@Override
	public void delete(Class<Vip> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(Vip.class, id);
		}
	}

}
