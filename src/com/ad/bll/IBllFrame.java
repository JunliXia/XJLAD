package com.ad.bll;

import java.util.List;

import com.ad.entity.CEntityFund;
import com.ad.entity.CEntityUser;



public interface IBllFrame {
	/*
	 *------------------------------ �û�ģ�� usermodule *usermodule----------------------------
	 */
	
	/**
	 * ��ţ�usermodule:1 
	 * ���ܣ������û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean createUser(CEntityUser cEntityUser);

	
	/**
	 * ��ţ�usermodule:2
	 * ���ܣ��û���¼
	 * ������CEntityUser(UserAccount,UserPassword)
	 * ����ֵ:boolean
	 */
	public boolean loginUser(CEntityUser cEntityUser);
	
	/**
	 * ��ţ�usermodule:3
	 * ���ܣ������û��˺Ż�ȡ�û���ϸ��Ϣ
	 * ������CEntityUser(UserAccount)
	 * ����ֵ:CEntityUser
	 */
	public CEntityUser getUserInfo(CEntityUser cEntityUser);
	
	/*
	 *------------------------------ ����ģ�� fundmodule *fundmodule----------------------------
	 */
	/**
	 * ��ţ�fundmodule:1 
	 * ���ܣ���������
	 * ������CEntityFund(*)
	 * ����ֵ:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund);
	

	/**
	 * ��ţ�fundmodule:2 
	 * ���ܣ�����û�����
	 * ������CEntityUser(UserId),page,FundState
	 * ����ֵ:List<CEntityFund>
	 */
	public List<CEntityFund> getUserFund(CEntityUser cEntityUser,int page,int FundState);
	
	
	/**
	 * ��ţ�fundmodule:3 
	 * ���ܣ�����û�/����/����������
	 * ������CEntityUser(UserId),FundState
	 * ����ֵ:int
	 */
	public int getUserFundNumer(CEntityUser cEntityUser,int FundState);
	
	/**
	 * ��ţ�fundmodule:4 
	 * ���ܣ�����û�/����/�����������ƺͻ������
	 * ������CEntityUser(UserId)
	 * ����ֵ:List
	 */
	@SuppressWarnings("unchecked")
	public List getFundNameAndCode(CEntityUser cEntityUser);
	
	/**
	 * ��ţ�fundmodule:5 
	 * ���ܣ���������
	 * ������CEntityFund
	 * ����ֵ:boolean
	 */
	public boolean sellFund(CEntityFund cEntityFund);
	
	
	
	
	
}