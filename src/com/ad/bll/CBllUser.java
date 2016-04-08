package com.ad.bll;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ad.dao.IDaoFrame;
import com.ad.entity.CEntityUser;

@Component("cBllUser")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class CBllUser {
	private IDaoFrame iDaoFrame;

	@Resource(name = "cDaoFrameImpl")
	public void setiDaoFrame(IDaoFrame iDaoFrame) {
		this.iDaoFrame = iDaoFrame;
	}
	
	/**
	 * ��ţ�usermodule:1 
	 * ���ܣ������û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean createUser(CEntityUser cEntityUser){
		boolean bisCreate=iDaoFrame.saveUser(cEntityUser);
		return bisCreate;
	}
	
	/**
	 * ��ţ�usermodule:2
	 * ���ܣ��û���¼
	 * ������CEntityUser(UserAccount,UserPassword)
	 * ����ֵ:boolean
	 */
	public boolean loginUser(CEntityUser cEntityUser){
		boolean bisLogin=iDaoFrame.queryUserByUserAccountAndUserPassword(cEntityUser);
		return bisLogin;
	}
	
	/**
	 * ��ţ�usermodule:3
	 * ���ܣ������û��˺Ż�ȡ�û���ϸ��Ϣ
	 * ������CEntityUser(UserAccount)
	 * ����ֵ:CEntityUser
	 */
	public CEntityUser getUserInfo(CEntityUser cEntityUser){
		CEntityUser findResutl=iDaoFrame.queryUserInfoByUserAccount(cEntityUser);
		return findResutl;
	}
	
	
	
}
