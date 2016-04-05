package com.ad.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//�û�
@Entity
@Table(name="User")
public class CEntityUser {
	private int UserId; 		//�û���
	private String UserAccount;	//�û��˺�
	private String UserPassword;	//�û�����
	private String UserName; //�û���
	
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
