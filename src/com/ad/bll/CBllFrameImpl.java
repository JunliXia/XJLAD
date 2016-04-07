package com.ad.bll;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import com.ad.entity.CEntityFund;
import com.ad.entity.CEntityUser;


@Component("cBllFrameImpl")
public class CBllFrameImpl implements IBllFrame{

	/*
	 *------------------------------ �û�ģ�� usermodule----------------------------
	 */

	private CBllUser cBllUser;
	
	@Resource(name="cBllUser")
	public void setcBllUser(CBllUser cBllUser) {
		this.cBllUser = cBllUser;
	}


	/**
	 * ��ţ�usermodule:1 
	 * ���ܣ������û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean createUser(CEntityUser cEntityUser) {
		// TODO Auto-generated method stub
		boolean bisCreate=cBllUser.createUser(cEntityUser);
		return bisCreate;
	}
	

	/**
	 * ��ţ�usermodule:2
	 * ���ܣ��û���¼
	 * ������CEntityUser(UserAccount,UserPassword)
	 * ����ֵ:boolean
	 */
	public boolean loginUser(CEntityUser cEntityUser){
		boolean bisLogin=cBllUser.loginUser(cEntityUser);
		return bisLogin;
	}
	
	/**
	 * ��ţ�usermodule:3
	 * ���ܣ������û��˺Ż�ȡ�û���ϸ��Ϣ
	 * ������CEntityUser(UserAccount)
	 * ����ֵ:CEntityUser
	 */
	public CEntityUser getUserInfo(CEntityUser cEntityUser){
		CEntityUser findResult=cBllUser.getUserInfo(cEntityUser);
		return findResult;
	}
	
	
	

	/*
	 *------------------------------ ����ģ�� fundmodule----------------------------
	 */
	private CBllFund cBllFund;
	
	@Resource(name="cBllFund")
	public void setcBllFund(CBllFund cBllFund) {
		this.cBllFund = cBllFund;
	}


	/**
	 * ��ţ�fundmodule:1 
	 * ���ܣ���������
	 * ������CEntityFund(*)
	 * ����ֵ:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund){
		boolean bisSave=cBllFund.saveFund(cEntityFund);
		return bisSave;
	}
	
	/**
	 * ��ţ�fundmodule:2 
	 * ���ܣ�����û�����
	 * ������CEntityUser(UserId),page
	 * ����ֵ:List<CEntityFund>
	 */
	public List<CEntityFund> getUserFund(CEntityUser cEntityUser,int page,int FundState){
		List<CEntityFund> findReuslt=cBllFund.getUserFund(cEntityUser, page,FundState);
		return findReuslt;
	}

	
	/**
	 * ��ţ�fundmodule:3 
	 * ���ܣ�����û�/����/����������
	 * ������CEntityUser(UserId),FundState
	 * ����ֵ:int
	 */
	public int getUserFundNumer(CEntityUser cEntityUser,int FundState){
		int count =cBllFund.getUserFundNumer(cEntityUser, FundState);
		return count;
	}
	
	/**
	 * ��ţ�fundmodule:4 
	 * ���ܣ�����û�/����/�����������ƺͻ������
	 * ������CEntityUser(UserId)
	 * ����ֵ:List
	 */
	@SuppressWarnings("unchecked")
	public List getFundNameAndCode(CEntityUser cEntityUser){
		List findResutl=cBllFund.getFundNameAndCode(cEntityUser);
		return findResutl;
	}
	
	/**
	 * ��ţ�fundmodule:5 
	 * ���ܣ���������
	 * ������CEntityFund
	 * ����ֵ:boolean
	 */
	public boolean sellFund(CEntityFund cEntityFund) {
		
		boolean bisSell=cBllFund.sellFund(cEntityFund);
		return bisSell;
	}
}
