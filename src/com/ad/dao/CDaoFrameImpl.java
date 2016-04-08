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
	 * ������CEntityUser(UserId),page,FundState
	 * ����ֵ:List<CEntityFund>
	 */
	public List<CEntityFund> queryFundByUserId(CEntityUser cEntityUser, int page,int FundState){
		List<CEntityFund> findReuslt=cDaoFund.queryFundByUserId(cEntityUser, page,FundState);
		return findReuslt;
	}
	
	
	/**
	 * ��ţ�fund:3
	 * ���ܣ����û��Ų�ѯ����/�����Ļ�������
	 * ������CEntityUser(UserId),FundState
	 * ����ֵ:int
	 */
	public int queryFundNumberByUserId(CEntityUser cEntityUser,int FundState){
		int count = cDaoFund.queryFundNumberByUserId(cEntityUser, FundState);
		return count;
	}
	
	
	/**
	 * ��ţ�fund:4
	 * ���ܣ����û��Ų�ѯ����/�����Ļ���������������
	 * ������CEntityUser(UserId)
	 * ����ֵ:List
	 */
	@SuppressWarnings("unchecked")
	public List queryFundNameAndFundCode(CEntityUser cEntityUser){
		List findResult=cDaoFund.queryFundNameAndFundCode(cEntityUser);
		return findResult;
	}
	
	/**
	 * ��ţ�fund:5
	 * ���ܣ������޸�
	 * ������CEntityFund
	 * ����ֵ:bolean
	 */
	public boolean updateFund(CEntityFund cEntityFund){
		boolean bisUpdate=cDaoFund.updateFund(cEntityFund);
		return bisUpdate;
	}
	/**
	 * ��ţ�fund:6
	 * ���ܣ�ͨ������ŵõ���������
	 * ������CEntityFund
	 * ����ֵ:CEntityFund
	 */
	public CEntityFund queryFundByFundId(CEntityFund cEntityFund){
		CEntityFund findResult=cDaoFund.queryFundByFundId(cEntityFund);
		return findResult;
	}
	
	/**
	 * ��ţ�fund:7
	 * ���ܣ�ͨ�����������������õ��û��Լ����ض�������
	 * ������CEntityFund(FundName,FundCode,FundState,UserId)
	 * ����ֵ:int
	 */
	public int queryUserFundNumberByFundNameCodeUserId(CEntityFund cEntityFund){
		int count=cDaoFund.queryUserFundNumberByFundNameCodeUserId(cEntityFund);
		return count;
	}
	
	/**
	 * ��ţ�fund:8
	 * ���ܣ����û��Ų�ѯ����/�����ض��Ļ���
	 * ������CEntityFund(FundName,FundCode,FundState,UserId)
	 * ����ֵ:List<CEntityFund>
	 */
	public List<CEntityFund> queryUserFundByFundNameCodeUserId(final CEntityFund cEntityFund, final int page){
		List<CEntityFund> findResult=cDaoFund.queryUserFundByFundNameCodeUserId(cEntityFund, page);
		return findResult;
	}
	
	
	/**
	 * ��ţ�fund:9
	 * ���ܣ����û��Ų�ѯ����Ļ��������������룬���ֻ�����
	 * ������CEntityFund
	 * ����ֵ:List
	 */
	@SuppressWarnings("unchecked")
	public List queryUserFundNameAndFundCodeNumber(CEntityFund cEntityFund){
		List findResult=cDaoFund.queryUserFundNameAndFundCodeNumber(cEntityFund);
		return findResult;
	}
}
