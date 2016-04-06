package com.ad.dao;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.ad.entity.CEntityUser;
@Component("cDaoUser")
public class CDaoUser extends SuperDAO{
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		CDaoUser tt = (CDaoUser) ctx.getBean("cDaoUser");
		CEntityUser cEntityUser=new CEntityUser();
		cEntityUser.setUserAccount("12311123");
		cEntityUser.setUserPassword("123123");
		System.out.println(tt.queryUserByUserAccountAndUserPassword(cEntityUser));
	}
	
	/**
	 * ��ţ�user:1
	 * ���ܣ�����һ���û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean saveUser(CEntityUser cEntityUser){
		boolean bisSave=false;
		if(queryUserByAccount(cEntityUser)){
			return false;
		}
		try {
			this.getHibernateTemplate().save(cEntityUser);
			bisSave=true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bisSave;
	}
	
	/**
	 * ��ţ�user:2
	 * ���ܣ����û��˺������ѯ�û�
	 * ������CEntityUser(*)
	 * ����ֵ:boolean
	 */
	public boolean queryUserByUserAccountAndUserPassword(CEntityUser cEntityUser){
		boolean bisFind=false;
		String hql="select count(*) from com.ad.entity.CEntityUser as user where user.userAccount=? and userPassword=?";
		List<?> findResult=this.getHibernateTemplate().find(hql,new Object[]{cEntityUser.getUserAccount(),cEntityUser.getUserPassword()});
		long result=(Long)findResult.get(0);
		
		if(result==0){	//û�ҵ�Ϊ��
			bisFind=false;
		}else{			//�ҵ�Ϊ��
			bisFind=true;
		}
		return bisFind;
	}
	
	/**
	 * ��ţ�user:3
	 * ���ܣ����û��˺Ų�ѯ�û�
	 * ������CEntityUser(UserAccount)
	 * ����ֵ:boolean
	 */
	private boolean queryUserByAccount(CEntityUser cEntityUser){
		boolean bisFind=false;
		String hql="select count(*) from com.ad.entity.CEntityUser as user where user.userAccount=?";
		List<?> findResult=this.getHibernateTemplate().find(hql,new Object[]{cEntityUser.getUserAccount()});
		long result=(Long)findResult.get(0);
		
		if(result==0){	//û�ҵ�Ϊ��
			bisFind=false;
		}else{			//�ҵ�Ϊ��
			bisFind=true;
		}
		return bisFind;
	}
	
}
