package com.ad.dao;

import java.util.List;

import com.ad.entity.CEntityFund;
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
	

	/**
	 * 序号：user:4
	 * 功能：按用户账号查询用户详细信息
	 * 参数：CEntityUser(UserAccount)
	 * 返回值:CEntityUser
	 */
	public CEntityUser queryUserInfoByUserAccount(CEntityUser cEntityUser);
	
	
	/*
	 *------------------------------ 基金 fund *fund----------------------------
	 */
	/**
	 * 序号：fund:1
	 * 功能：增加一个基金
	 * 参数：CEntityFund(*)
	 * 返回值:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund);
	
	/**
	 * 序号：fund:2
	 * 功能：按用户号查询基金
	 * 参数：CEntityUser(UserId),page
	 * 返回值:List<CEntityFund>
	 */
	public List<CEntityFund> queryFundByUserAccount(final CEntityUser cEntityUser, final int page);
	
	
	
	
}

