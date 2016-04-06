package com.ad.dao;

import com.ad.entity.CEntityUser;


public interface IDaoFrame {
	/*
	 *------------------------------ 用户 user *user----------------------------
	 */
	
	/**
	 * 序号：user:1
	 * 功能：增加一个用户
	 * 参数：CEntityUser(*)
	 * 返回值:boolean
	 */
	public boolean saveUser(CEntityUser cEntityUser);
	
	/**
	 * 序号：user:2
	 * 功能：按用户账号密码查询用户
	 * 参数：CEntityUser(*)
	 * 返回值:boolean
	 */
	public boolean queryUserByUserAccountAndUserPassword(CEntityUser cEntityUser);
}

