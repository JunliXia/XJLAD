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
	 * 参数：CEntityUser(UserId),page,FundState
	 * 返回值:List<CEntityFund>
	 */
	public List<CEntityFund> queryFundByUserId(CEntityUser cEntityUser, int page,int FundState){
		List<CEntityFund> findReuslt=cDaoFund.queryFundByUserId(cEntityUser, page,FundState);
		return findReuslt;
	}
	
	
	/**
	 * 序号：fund:3
	 * 功能：按用户号查询已买/已卖的基金总数
	 * 参数：CEntityUser(UserId),FundState
	 * 返回值:int
	 */
	public int queryFundNumberByUserId(CEntityUser cEntityUser,int FundState){
		int count = cDaoFund.queryFundNumberByUserId(cEntityUser, FundState);
		return count;
	}
	
	
	/**
	 * 序号：fund:4
	 * 功能：按用户号查询已买/已卖的基金名称与基金代码
	 * 参数：CEntityUser(UserId)
	 * 返回值:List
	 */
	@SuppressWarnings("unchecked")
	public List queryFundNameAndFundCode(CEntityUser cEntityUser){
		List findResult=cDaoFund.queryFundNameAndFundCode(cEntityUser);
		return findResult;
	}
	
	/**
	 * 序号：fund:5
	 * 功能：基金修改
	 * 参数：CEntityFund
	 * 返回值:bolean
	 */
	public boolean updateFund(CEntityFund cEntityFund){
		boolean bisUpdate=cDaoFund.updateFund(cEntityFund);
		return bisUpdate;
	}
	/**
	 * 序号：fund:6
	 * 功能：通过基金号得到基金详情
	 * 参数：CEntityFund
	 * 返回值:CEntityFund
	 */
	public CEntityFund queryFundByFundId(CEntityFund cEntityFund){
		CEntityFund findResult=cDaoFund.queryFundByFundId(cEntityFund);
		return findResult;
	}
	
	/**
	 * 序号：fund:7
	 * 功能：通过基金名跟基金代码得到用户自己的特定基金数
	 * 参数：CEntityFund(FundName,FundCode,FundState,UserId)
	 * 返回值:int
	 */
	public int queryUserFundNumberByFundNameCodeUserId(CEntityFund cEntityFund){
		int count=cDaoFund.queryUserFundNumberByFundNameCodeUserId(cEntityFund);
		return count;
	}
	
	/**
	 * 序号：fund:8
	 * 功能：按用户号查询已买/已卖特定的基金
	 * 参数：CEntityFund(FundName,FundCode,FundState,UserId)
	 * 返回值:List<CEntityFund>
	 */
	public List<CEntityFund> queryUserFundByFundNameCodeUserId(final CEntityFund cEntityFund, final int page){
		List<CEntityFund> findResult=cDaoFund.queryUserFundByFundNameCodeUserId(cEntityFund, page);
		return findResult;
	}
	
	
	/**
	 * 序号：fund:9
	 * 功能：按用户号查询已买的基金名称与基金代码，所持基金数
	 * 参数：CEntityFund
	 * 返回值:List
	 */
	@SuppressWarnings("unchecked")
	public List queryUserFundNameAndFundCodeNumber(CEntityFund cEntityFund){
		List findResult=cDaoFund.queryUserFundNameAndFundCodeNumber(cEntityFund);
		return findResult;
	}
}
