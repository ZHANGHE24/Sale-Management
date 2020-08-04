package org.zhxf.sale.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.zhxf.sale.domain.StaffInfo;
import org.zhxf.sale.utils.Page;

public interface StaffInfoService {
	// 查询所有，带条件查询
	public List<StaffInfo> find(String hql, Class<StaffInfo> entityClass, Object[] params);

	// 获取一条记录
	public StaffInfo get(Class<StaffInfo> entityClass, Serializable id);

	// 分页查询，将数据封装到一个page分页工具类对象
	public Page<StaffInfo> findPage(String hql, Page<StaffInfo> page, Class<StaffInfo> entityClass, Object[] params);

	// 新增和修改保存
	public void saveOrUpdate(StaffInfo entity);

	// 批量新增和修改保存
	public void saveOrUpdateAll(Collection<StaffInfo> entitys);

	// 单条删除，按id
	public void deleteById(Class<StaffInfo> entityClass, Serializable id);

	// 批量删除
	public void delete(Class<StaffInfo> entityClass, Serializable[] ids);
}
