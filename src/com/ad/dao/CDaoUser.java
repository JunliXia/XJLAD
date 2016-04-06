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
	 * 序号：user:1
	 * 功能：增加一个用户
	 * 参数：CEntityUser(*)
	 * 返回值:boolean
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
	 * 序号：user:2
	 * 功能：按用户账号密码查询用户
	 * 参数：CEntityUser(*)
	 * 返回值:boolean
	 */
	public boolean queryUserByUserAccountAndUserPassword(CEntityUser cEntityUser){
		boolean bisFind=false;
		String hql="select count(*) from com.ad.entity.CEntityUser as user where user.userAccount=? and userPassword=?";
		List<?> findResult=this.getHibernateTemplate().find(hql,new Object[]{cEntityUser.getUserAccount(),cEntityUser.getUserPassword()});
		long result=(Long)findResult.get(0);
		
		if(result==0){	//没找到为假
			bisFind=false;
		}else{			//找到为真
			bisFind=true;
		}
		return bisFind;
	}
	
	/**
	 * 序号：user:3
	 * 功能：按用户账号查询用户
	 * 参数：CEntityUser(UserAccount)
	 * 返回值:boolean
	 */
	private boolean queryUserByAccount(CEntityUser cEntityUser){
		boolean bisFind=false;
		String hql="select count(*) from com.ad.entity.CEntityUser as user where user.userAccount=?";
		List<?> findResult=this.getHibernateTemplate().find(hql,new Object[]{cEntityUser.getUserAccount()});
		long result=(Long)findResult.get(0);
		
		if(result==0){	//没找到为假
			bisFind=false;
		}else{			//找到为真
			bisFind=true;
		}
		return bisFind;
	}
	
}
