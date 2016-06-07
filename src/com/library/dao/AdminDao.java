package com.library.dao;

import com.library.bean.Admin;

/**
 * @author Administrator
 * 管理员通用接口
 */
public interface AdminDao {

	/**
	 * 更新管理员信息
	 * @param admin
	 * @return
	 */
	public boolean update(Admin admin);
}
