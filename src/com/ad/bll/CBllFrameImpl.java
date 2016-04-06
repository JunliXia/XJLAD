package com.ad.bll;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import com.ad.entity.CEntityUser;


@Component("cBllFrameImpl")
public class CBllFrameImpl implements IBllFrame{

	/*
	 *------------------------------ �û�ģ�� usermodule----------------------------
	 */

	private CBllUser cBllUser;
	
	@Resource(name="cBllUser")
	public void setcBllUser(CBllUser cBllUser) {
		this.cBllUser = cBllUser;
	}


	/**
	 * ��ţ�usermodule:1 
	 * ���ܣ������û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean createUser(CEntityUser cEntityUser) {
		// TODO Auto-generated method stub
		boolean bisCreate=cBllUser.createUser(cEntityUser);
		return bisCreate;
	}
	

	/**
	 * ��ţ�usermodule:2
	 * ���ܣ��û���¼
	 * ������CEntityUser(UserAccount,UserPassword)
	 * ����ֵ:boolean
	 */
	public boolean loginUser(CEntityUser cEntityUser){
		boolean bisLogin=cBllUser.loginUser(cEntityUser);
		return bisLogin;
	}
}
