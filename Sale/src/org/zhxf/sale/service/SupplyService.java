package org.zhxf.sale.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.zhxf.sale.domain.Supply;
import org.zhxf.sale.utils.Page;

public interface SupplyService {
	// 查询所有，带条件查询
	public List<Supply> find(String hql, Class<Supply> entityClass, Object[] params);

	// 获取一条记录
	public Supply get(Class<Supply> entityClass, Serializable id);

	// 分页查询，将数据封装到一个page分页工具类对象
	public Page<Supply> findPage(String hql, Page<Supply> page, Class<Supply> entityClass, Object[] params);

	// 新增和修改保存
	public void saveOrUpdate(Supply entity);

	// 批量新增和修改保存
	public void saveOrUpdateAll(Collection<Supply> entitys);

	// 单条删除，按id
	public void deleteById(Class<Supply> entityClass, Serializable id);

	// 批量删除
	public void delete(Class<Supply> entityClass, Serializable[] ids);
}
