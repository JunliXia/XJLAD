package com.ad.dao;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ad.entity.CEntityUser;

@Component("cDaoFrameImpl")
public class CDaoFrameImpl implements IDaoFrame {

	/*
	 *------------------------------ 用户 user----------------------------
	 */
	
	private CDaoUser cDaoUser;
	
	@Resource(name="cDaoUser")
	public void setcDaoUser(CDaoUser cDaoUser) {
		this.cDaoUser = cDaoUser;
	}

	/**
	 * 序号：user:1
	 * 功能：增加一个用户
	 * 参数：CEntityUser(*)
	 * 返回值:boolean
	 */
	public boolean saveUser(CEntityUser cEntityUser) {
		// TODO Auto-generated method stub
		boolean bisSave=cDaoUser.saveUser(cEntityUser);
		
		return bisSave;
	}
	
	/**
	 * 序号：user:2
	 * 功能：按用户账号密码查询用户
	 * 参数：CEntityUser(*)
	 * 返回值:boolean
	 */
	public boolean queryUserByUserAccountAndUserPassword(CEntityUser cEntityUser){
		boolean bisQuery=cDaoUser.queryUserByUserAccountAndUserPassword(cEntityUser);
		return bisQuery;
	}

}
