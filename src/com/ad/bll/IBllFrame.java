package com.ad.bll;

import com.ad.entity.CEntityUser;



public interface IBllFrame {
	/*
	 *------------------------------ �û�ģ�� usermodule *usermodule----------------------------
	 */
	
	/**
	 * ��ţ�usermodule:1 
	 * ���ܣ������û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean createUser(CEntityUser cEntityUser);

	
	/**
	 * ��ţ�usermodule:2
	 * ���ܣ��û���¼
	 * ������CEntityUser(UserAccount,UserPassword)
	 * ����ֵ:boolean
	 */
	public boolean loginUser(CEntityUser cEntityUser);
	
	
	
	
}