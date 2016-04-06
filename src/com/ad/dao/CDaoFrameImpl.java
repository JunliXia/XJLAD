package com.ad.dao;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ad.entity.CEntityFund;
import com.ad.entity.CEntityUser;

@Component("cDaoFrameImpl")
public class CDaoFrameImpl implements IDaoFrame {

	/*
	 *------------------------------ 用户 user *user----------------------------
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
	

	/**
	 * 序号：user:4
	 * 功能：按用户账号查询用户详细信息
	 * 参数：CEntityUser(UserAccount)
	 * 返回值:CEntityUser
	 */
	public CEntityUser queryUserInfoByUserAccount(CEntityUser cEntityUser){
		CEntityUser findReuslt=cDaoUser.queryUserInfoByUserAccount(cEntityUser);
		return findReuslt;
	}

	/*
	 *------------------------------ 基金 fund *fund----------------------------
	 */
	private CDaoFund cDaoFund;
	
	@Resource(name="cDaoFund")
	public void setcDaoFund(CDaoFund cDaoFund) {
		this.cDaoFund = cDaoFund;
	}

	/**
	 * 序号：fund:1
	 * 功能：增加一个基金
	 * 参数：CEntityFund(*)
	 * 返回值:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund){
		boolean bisSave=cDaoFund.saveFund(cEntityFund);
		return bisSave;
	}
	
	/**
	 * 序号：fund:2
	 * 功能：按用户号查询基金
	 * 参数：CEntityUser(UserId),page
	 * 返回值:List<CEntityFund>
	 */
	public List<CEntityFund> queryFundByUserAccount(final CEntityUser cEntityUser, final int page){
		List<CEntityFund> findReuslt=cDaoFund.queryFundByUserAccount(cEntityUser, page);
		return findReuslt;
	}
}
