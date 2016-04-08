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
	 * 序号：usermodule:1 
	 * 功能：创建用户
	 * 参数：CEntityUser(*)
	 * 返回值:boolean
	 */
	public boolean createUser(CEntityUser cEntityUser){
		boolean bisCreate=iDaoFrame.saveUser(cEntityUser);
		return bisCreate;
	}
	
	/**
	 * 序号：usermodule:2
	 * 功能：用户登录
	 * 参数：CEntityUser(UserAccount,UserPassword)
	 * 返回值:boolean
	 */
	public boolean loginUser(CEntityUser cEntityUser){
		boolean bisLogin=iDaoFrame.queryUserByUserAccountAndUserPassword(cEntityUser);
		return bisLogin;
	}
	
	/**
	 * 序号：usermodule:3
	 * 功能：根据用户账号获取用户详细信息
	 * 参数：CEntityUser(UserAccount)
	 * 返回值:CEntityUser
	 */
	public CEntityUser getUserInfo(CEntityUser cEntityUser){
		CEntityUser findResutl=iDaoFrame.queryUserInfoByUserAccount(cEntityUser);
		return findResutl;
	}
	
	
	
}
