package org.zhxf.sale.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.zhxf.sale.dao.BaseDao;
import org.zhxf.sale.domain.StaffInfo;
import org.zhxf.sale.service.StaffInfoService;
import org.zhxf.sale.utils.Page;

public class StaffInfoServiceImpl implements StaffInfoService {

	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<StaffInfo> find(String hql, Class<StaffInfo> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	@Override
	public StaffInfo get(Class<StaffInfo> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public Page<StaffInfo> findPage(String hql, Page<StaffInfo> page, Class<StaffInfo> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	@Override
	public void saveOrUpdate(StaffInfo entity) {
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<StaffInfo> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	@Override
	public void deleteById(Class<StaffInfo> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);// 删除一个对象
	}

	@Override
	public void delete(Class<StaffInfo> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(StaffInfo.class, id);
		}
	}

}
