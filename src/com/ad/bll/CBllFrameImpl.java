package com.ad.bll;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import com.ad.entity.CEntityUser;


@Component("cBllFrameImpl")
public class CBllFrameImpl implements IBllFrame{

	/*
	 *------------------------------ 用户模块 usermodule----------------------------
	 */

	private CBllUser cBllUser;
	
	@Resource(name="cBllUser")
	public void setcBllUser(CBllUser cBllUser) {
		this.cBllUser = cBllUser;
	}


	/**
	 * 序号：usermodule:1 
	 * 功能：创建用户
	 * 参数：CEntityUser(*)
	 * 返回值:boolean
	 */
	public boolean createUser(CEntityUser cEntityUser) {
		// TODO Auto-generated method stub
		boolean bisCreate=cBllUser.createUser(cEntityUser);
		return bisCreate;
	}
	

	/**
	 * 序号：usermodule:2
	 * 功能：用户登录
	 * 参数：CEntityUser(UserAccount,UserPassword)
	 * 返回值:boolean
	 */
	public boolean loginUser(CEntityUser cEntityUser){
		boolean bisLogin=cBllUser.loginUser(cEntityUser);
		return bisLogin;
	}
}
