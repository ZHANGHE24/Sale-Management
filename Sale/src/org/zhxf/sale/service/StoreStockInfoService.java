package org.zhxf.sale.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.zhxf.sale.domain.StoreStockInfo;
import org.zhxf.sale.utils.Page;

public interface StoreStockInfoService {
	// 查询所有，带条件查询
	public List<StoreStockInfo> find(String hql, Class<StoreStockInfo> entityClass, Object[] params);

	// 获取一条记录
	public StoreStockInfo get(Class<StoreStockInfo> entityClass, Serializable id);

	// 分页查询，将数据封装到一个page分页工具类对象
	public Page<StoreStockInfo> findPage(String hql, Page<StoreStockInfo> page, Class<StoreStockInfo> entityClass, Object[] params);

	// 新增和修改保存
	public void saveOrUpdate(StoreStockInfo entity);

	// 批量新增和修改保存
	public void saveOrUpdateAll(Collection<StoreStockInfo> entitys);

	// 单条删除，按id
	public void deleteById(Class<StoreStockInfo> entityClass, Serializable id);

	// 批量删除
	public void delete(Class<StoreStockInfo> entityClass, Serializable[] ids);
}
