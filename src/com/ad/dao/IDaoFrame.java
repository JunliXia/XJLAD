package com.ad.dao;

import java.util.List;

import com.ad.entity.CEntityFund;
import com.ad.entity.CEntityUser;


public interface IDaoFrame {
	/*
	 *------------------------------ �û� user *user----------------------------
	 */
	
	/**
	 * ��ţ�user:1
	 * ���ܣ�����һ���û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean saveUser(CEntityUser cEntityUser);
	
	/**
	 * ��ţ�user:2
	 * ���ܣ����û��˺������ѯ�û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean queryUserByUserAccountAndUserPassword(CEntityUser cEntityUser);
	

	/**
	 * ��ţ�user:4
	 * ���ܣ����û��˺Ų�ѯ�û���ϸ��Ϣ
	 * ������CEntityUser(UserAccount)
	 * ����ֵ:CEntityUser
	 */
	public CEntityUser queryUserInfoByUserAccount(CEntityUser cEntityUser);
	
	
	/*
	 *------------------------------ ���� fund *fund----------------------------
	 */
	/**
	 * ��ţ�fund:1
	 * ���ܣ�����һ������
	 * ������CEntityFund(*)
	 * ����ֵ:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund);
	
	/**
	 * ��ţ�fund:2
	 * ���ܣ����û��Ų�ѯ����
	 * ������CEntityUser(UserId),page,FundState
	 * ����ֵ:List<CEntityFund>
	 */
	public List<CEntityFund> queryFundByUserId(CEntityUser cEntityUser, int page,int FundState);
	
	/**
	 * ��ţ�fund:3
	 * ���ܣ����û��Ų�ѯ����/�����Ļ�������
	 * ������CEntityUser(UserId),FundState
	 * ����ֵ:int
	 */
	public int queryFundNumberByUserId(CEntityUser cEntityUser,int FundState);
	
	
	/**
	 * ��ţ�fund:4
	 * ���ܣ����û��Ų�ѯ����/�����Ļ���������������
	 * ������CEntityUser(UserId)
	 * ����ֵ:List
	 */
	@SuppressWarnings("unchecked")
	public List queryFundNameAndFundCode(CEntityUser cEntityUser);
	
	/**
	 * ��ţ�fund:5
	 * ���ܣ������޸�
	 * ������CEntityFund
	 * ����ֵ:bolean
	 */
	public boolean updateFund(CEntityFund cEntityFund);
	
	/**
	 * ��ţ�fund:6
	 * ���ܣ�ͨ������ŵõ���������
	 * ������CEntityFund
	 * ����ֵ:CEntityFund
	 */
	public CEntityFund queryFundByFundId(CEntityFund cEntityFund);
	
	/**
	 * ��ţ�fund:7
	 * ���ܣ�ͨ�����������������õ��û��Լ����ض�������
	 * ������CEntityFund(FundName,FundCode,FundState,UserId)
	 * ����ֵ:int
	 */
	public int queryUserFundNumberByFundNameCodeUserId(CEntityFund cEntityFund);
	
	/**
	 * ��ţ�fund:8
	 * ���ܣ����û��Ų�ѯ����/�����ض��Ļ���
	 * ������CEntityFund(FundName,FundCode,FundState,UserId)
	 * ����ֵ:List<CEntityFund>
	 */
	public List<CEntityFund> queryUserFundByFundNameCodeUserId(final CEntityFund cEntityFund, final int page);
	/**
	 * ��ţ�fund:9
	 * ���ܣ����û��Ų�ѯ����Ļ��������������룬���ֻ�����
	 * ������CEntityFund
	 * ����ֵ:List
	 */
	@SuppressWarnings("unchecked")
	public List queryUserFundNameAndFundCodeNumber(CEntityFund cEntityFund);
}

