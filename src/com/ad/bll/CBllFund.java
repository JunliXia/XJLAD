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
	 * ��ţ�fundmodule:1 
	 * ���ܣ���������
	 * ������CEntityFund(*)
	 * ����ֵ:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund){
		boolean bisSave=iDaoFrame.saveFund(cEntityFund);
		return bisSave;
	}
	
	/**
	 * ��ţ�fundmodule:2 
	 * ���ܣ�����û�����
	 * ������CEntityUser(UserId),page,FundState
	 * ����ֵ:List<CEntityFund>
	 */
	public List<CEntityFund> getUserFund(CEntityUser cEntityUser,int page,int FundState){
		page=page-1;
		List<CEntityFund> findReuslt=iDaoFrame.queryFundByUserId(cEntityUser, page,FundState);
		return findReuslt;
	}
	
	/**
	 * ��ţ�fundmodule:3 
	 * ���ܣ�����û�/����/����������
	 * ������CEntityUser(UserId),FundState
	 * ����ֵ:int
	 */
	public int getUserFundNumer(CEntityUser cEntityUser,int FundState){
		int count=iDaoFrame.queryFundNumberByUserId(cEntityUser, FundState);
		return count;
	}
	
}
