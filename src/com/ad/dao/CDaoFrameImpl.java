package com.ad.dao;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ad.entity.CEntityUser;

@Component("cDaoFrameImpl")
public class CDaoFrameImpl implements IDaoFrame {

	/*
	 *------------------------------ �û� user----------------------------
	 */
	
	private CDaoUser cDaoUser;
	
	@Resource(name="cDaoUser")
	public void setcDaoUser(CDaoUser cDaoUser) {
		this.cDaoUser = cDaoUser;
	}

	/**
	 * ��ţ�user:1
	 * ���ܣ�����һ���û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean saveUser(CEntityUser cEntityUser) {
		// TODO Auto-generated method stub
		boolean bisSave=cDaoUser.saveUser(cEntityUser);
		
		return bisSave;
	}
	
	/**
	 * ��ţ�user:2
	 * ���ܣ����û��˺������ѯ�û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean queryUserByUserAccountAndUserPassword(CEntityUser cEntityUser){
		boolean bisQuery=cDaoUser.queryUserByUserAccountAndUserPassword(cEntityUser);
		return bisQuery;
	}

}
