package com.ad.bll;

import java.util.List;

import com.ad.entity.CEntityFund;
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
	
	/**
	 * 序号：usermodule:3
	 * 功能：根据用户账号获取用户详细信息
	 * 参数：CEntityUser(UserAccount)
	 * 返回值:CEntityUser
	 */
	public CEntityUser getUserInfo(CEntityUser cEntityUser);
	
	/*
	 *------------------------------ 基金模块 fundmodule *fundmodule----------------------------
	 */
	/**
	 * 序号：fundmodule:1 
	 * 功能：创建基金
	 * 参数：CEntityFund(*)
	 * 返回值:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund);
	

	/**
	 * 序号：fundmodule:2 
	 * 功能：获得用户基金
	 * 参数：CEntityUser(UserId),page,FundState
	 * 返回值:List<CEntityFund>
	 */
	public List<CEntityFund> getUserFund(CEntityUser cEntityUser,int page,int FundState);
	
	
	/**
	 * 序号：fundmodule:3 
	 * 功能：获得用户/已买/已卖基金数
	 * 参数：CEntityUser(UserId),FundState
	 * 返回值:int
	 */
	public int getUserFundNumer(CEntityUser cEntityUser,int FundState);
	
	/**
	 * 序号：fundmodule:4 
	 * 功能：获得用户/已买/已卖基金名称和基金代码
	 * 参数：CEntityUser(UserId)
	 * 返回值:List
	 */
	@SuppressWarnings("unchecked")
	public List getFundNameAndCode(CEntityUser cEntityUser);
	
	/**
	 * 序号：fundmodule:5 
	 * 功能：卖出基金
	 * 参数：CEntityFund
	 * 返回值:boolean
	 */
	public boolean sellFund(CEntityFund cEntityFund);
	
	
	
	
	
}