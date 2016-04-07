package com.ad.bll;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import com.ad.entity.CEntityFund;
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
	
	/**
	 * 序号：usermodule:3
	 * 功能：根据用户账号获取用户详细信息
	 * 参数：CEntityUser(UserAccount)
	 * 返回值:CEntityUser
	 */
	public CEntityUser getUserInfo(CEntityUser cEntityUser){
		CEntityUser findResult=cBllUser.getUserInfo(cEntityUser);
		return findResult;
	}
	
	
	

	/*
	 *------------------------------ 基金模块 fundmodule----------------------------
	 */
	private CBllFund cBllFund;
	
	@Resource(name="cBllFund")
	public void setcBllFund(CBllFund cBllFund) {
		this.cBllFund = cBllFund;
	}


	/**
	 * 序号：fundmodule:1 
	 * 功能：创建基金
	 * 参数：CEntityFund(*)
	 * 返回值:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund){
		boolean bisSave=cBllFund.saveFund(cEntityFund);
		return bisSave;
	}
	
	/**
	 * 序号：fundmodule:2 
	 * 功能：获得用户基金
	 * 参数：CEntityUser(UserId),page
	 * 返回值:List<CEntityFund>
	 */
	public List<CEntityFund> getUserFund(CEntityUser cEntityUser,int page,int FundState){
		List<CEntityFund> findReuslt=cBllFund.getUserFund(cEntityUser, page,FundState);
		return findReuslt;
	}

	
	/**
	 * 序号：fundmodule:3 
	 * 功能：获得用户/已买/已卖基金数
	 * 参数：CEntityUser(UserId),FundState
	 * 返回值:int
	 */
	public int getUserFundNumer(CEntityUser cEntityUser,int FundState){
		int count =cBllFund.getUserFundNumer(cEntityUser, FundState);
		return count;
	}
	
	/**
	 * 序号：fundmodule:4 
	 * 功能：获得用户/已买/已卖基金名称和基金代码
	 * 参数：CEntityUser(UserId)
	 * 返回值:List
	 */
	@SuppressWarnings("unchecked")
	public List getFundNameAndCode(CEntityUser cEntityUser){
		List findResutl=cBllFund.getFundNameAndCode(cEntityUser);
		return findResutl;
	}
	
	/**
	 * 序号：fundmodule:5 
	 * 功能：卖出基金
	 * 参数：CEntityFund
	 * 返回值:boolean
	 */
	public boolean sellFund(CEntityFund cEntityFund) {
		
		boolean bisSell=cBllFund.sellFund(cEntityFund);
		return bisSell;
	}
}
