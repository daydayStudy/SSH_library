package com.library.dao;

import com.library.bean.Admin;
import com.library.bean.Reader;

/**
 * @author Administrator
 * ����Աͨ�ýӿ�
 */
public interface AdminDao {

	/**
	 * ���¹���Ա��Ϣ
	 * @param admin
	 * @return
	 */
	public boolean update(Admin admin);
	public Admin getadmin(int admindid);
}
