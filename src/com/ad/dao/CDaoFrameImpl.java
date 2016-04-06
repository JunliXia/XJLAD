package com.ad.dao;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ad.entity.CEntityFund;
import com.ad.entity.CEntityUser;

@Component("cDaoFrameImpl")
public class CDaoFrameImpl implements IDaoFrame {

	/*
	 *------------------------------ �û� user *user----------------------------
	 */
	
	private CDaoUser cDaoUser;
	
	@Resource(name="cDaoUser")
	public void setcDaoUser(CDaoUser cDaoUser) {
		this.cDaoUser = cDaoUser;
	}

	/**
	 * ��ţ�user:1
	 * ���ܣ�����һ���û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean saveUser(CEntityUser cEntityUser) {
		// TODO Auto-generated method stub
		boolean bisSave=cDaoUser.saveUser(cEntityUser);
		
		return bisSave;
	}
	
	/**
	 * ��ţ�user:2
	 * ���ܣ����û��˺������ѯ�û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean queryUserByUserAccountAndUserPassword(CEntityUser cEntityUser){
		boolean bisQuery=cDaoUser.queryUserByUserAccountAndUserPassword(cEntityUser);
		return bisQuery;
	}
	

	/**
	 * ��ţ�user:4
	 * ���ܣ����û��˺Ų�ѯ�û���ϸ��Ϣ
	 * ������CEntityUser(UserAccount)
	 * ����ֵ:CEntityUser
	 */
	public CEntityUser queryUserInfoByUserAccount(CEntityUser cEntityUser){
		CEntityUser findReuslt=cDaoUser.queryUserInfoByUserAccount(cEntityUser);
		return findReuslt;
	}

	/*
	 *------------------------------ ���� fund *fund----------------------------
	 */
	private CDaoFund cDaoFund;
	
	@Resource(name="cDaoFund")
	public void setcDaoFund(CDaoFund cDaoFund) {
		this.cDaoFund = cDaoFund;
	}

	/**
	 * ��ţ�fund:1
	 * ���ܣ�����һ������
	 * ������CEntityFund(*)
	 * ����ֵ:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund){
		boolean bisSave=cDaoFund.saveFund(cEntityFund);
		return bisSave;
	}
	
	/**
	 * ��ţ�fund:2
	 * ���ܣ����û��Ų�ѯ����
	 * ������CEntityUser(UserId),page
	 * ����ֵ:List<CEntityFund>
	 */
	public List<CEntityFund> queryFundByUserAccount(final CEntityUser cEntityUser, final int page){
		List<CEntityFund> findReuslt=cDaoFund.queryFundByUserAccount(cEntityUser, page);
		return findReuslt;
	}
}
