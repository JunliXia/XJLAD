package com.ad.dao;

import com.ad.entity.CEntityUser;


public interface IDaoFrame {
	/*
	 *------------------------------ �û� user *user----------------------------
	 */
	
	/**
	 * ��ţ�user:1
	 * ���ܣ�����һ���û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean saveUser(CEntityUser cEntityUser);
	
	/**
	 * ��ţ�user:2
	 * ���ܣ����û��˺������ѯ�û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean queryUserByUserAccountAndUserPassword(CEntityUser cEntityUser);
}

