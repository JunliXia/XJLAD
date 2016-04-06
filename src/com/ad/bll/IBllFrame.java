package com.ad.bll;

import com.ad.entity.CEntityUser;



public interface IBllFrame {
	/*
	 *------------------------------ 用户模块 usermodule *usermodule----------------------------
	 */
	
	/**
	 * 序号：usermodule:1 
	 * 功能：创建用户
	 * 参数：CEntityUser(*)
	 * 返回值:boolean
	 */
	public boolean createUser(CEntityUser cEntityUser);

	
	/**
	 * 序号：usermodule:2
	 * 功能：用户登录
	 * 参数：CEntityUser(UserAccount,UserPassword)
	 * 返回值:boolean
	 */
	public boolean loginUser(CEntityUser cEntityUser);
	
	
	
	
}