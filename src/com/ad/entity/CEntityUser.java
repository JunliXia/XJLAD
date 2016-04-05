package com.ad.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//用户
@Entity
@Table(name="User")
public class CEntityUser {
	private int UserId; 		//用户号
	private String UserAccount;	//用户账号
	private String UserPassword;	//用户密码
	private String UserName; //用户名
	
	public CEntityUser() {
	}

	@Id
	@GeneratedValue
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserAccount() {
		return UserAccount;
	}

	public void setUserAccount(String userAccount) {
		UserAccount = userAccount;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	@Override
	public String toString() {
		return "CEntityUser [UserAccount=" + UserAccount + ", UserId=" + UserId
				+ ", UserName=" + UserName + ", UserPassword=" + UserPassword
				+ "]";
	}
	

	
}
