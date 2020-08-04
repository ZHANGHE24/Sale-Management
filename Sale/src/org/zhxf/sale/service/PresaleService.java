package org.zhxf.sale.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.zhxf.sale.domain.Presale;
import org.zhxf.sale.utils.Page;

public interface PresaleService {
	// 查询所有，带条件查询
	public List<Presale> find(String hql, Class<Presale> entityClass, Object[] params);

	// 获取一条记录
	public Presale get(Class<Presale> entityClass, Serializable id);

	// 分页查询，将数据封装到一个page分页工具类对象
	public Page<Presale> findPage(String hql, Page<Presale> page, Class<Presale> entityClass, Object[] params);

	// 新增和修改保存
	public void saveOrUpdate(Presale entity);

	// 批量新增和修改保存
	public void saveOrUpdateAll(Collection<Presale> entitys);

	// 单条删除，按id
	public void deleteById(Class<Presale> entityClass, Serializable id);

	// 批量删除
	public void delete(Class<Presale> entityClass, Serializable[] ids);
}
