package com.ad.bll;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ad.dao.IDaoFrame;
import com.ad.entity.CEntityFund;
import com.ad.entity.CEntityUser;

@Component("cBllFund")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class CBllFund {
	
	private IDaoFrame iDaoFrame;

	@Resource(name = "cDaoFrameImpl")
	public void setiDaoFrame(IDaoFrame iDaoFrame) {
		this.iDaoFrame = iDaoFrame;
	}
	
	/**
	 * 序号：fundmodule:1 
	 * 功能：创建基金
	 * 参数：CEntityFund(*)
	 * 返回值:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund){
		boolean bisSave=iDaoFrame.saveFund(cEntityFund);
		return bisSave;
	}
	
	/**
	 * 序号：fundmodule:2 
	 * 功能：获得用户基金
	 * 参数：CEntityUser(UserId),page
	 * 返回值:List<CEntityFund>
	 */
	public List<CEntityFund> getUserFund(CEntityUser cEntityUser,int page){
		List<CEntityFund> findReuslt=iDaoFrame.queryFundByUserAccount(cEntityUser, page);
		return findReuslt;
	}
	
	
}
