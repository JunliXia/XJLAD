package com.ad.dao;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONArray;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.ad.entity.CEntityFund;
import com.ad.entity.CEntityUser;
import com.ad.tool.MyConstant;

@Component("cDaoFund")
public class CDaoFund extends SuperDAO{

	

	/**
	 * 序号：fund:1
	 * 功能：增加一个基金
	 * 参数：CEntityFund(*)
	 * 返回值:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund){
		boolean bisSave=false;
		try {
			this.getHibernateTemplate().save(cEntityFund);
			bisSave=true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bisSave;
	}
	
	
	/**
	 * 序号：fund:2
	 * 功能：按用户号查询基金
	 * 参数：CEntityUser(UserId),page
	 * 返回值:List<CEntityFund>
	 */
	@SuppressWarnings("unchecked")
	public List<CEntityFund> queryFundByUserAccount(final CEntityUser cEntityUser, final int page){
		List<CEntityFund> findResult=this.getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				String hql="from com.ad.entity.CEntityFund as fund where fund.userId=?";
				Query query = arg0.createQuery(hql).setInteger(0, cEntityUser.getUserId());  
				query.setFirstResult(page*MyConstant.Paging.PageLength);     
			    query.setMaxResults(MyConstant.Paging.PageLength); 
			    List<CEntityFund> findResult=query.list();
				return findResult;
			}
		});
		return findResult;
	}
	
	
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		CDaoFund tt = (CDaoFund) ctx.getBean("cDaoFund");
		
		CEntityUser cEntityUser=new CEntityUser();
		cEntityUser.setUserId(1);
		
		List<CEntityFund> findResult=tt.queryFundByUserAccount(cEntityUser, 2);
		
		JSONArray outjson=JSONArray.fromObject(findResult);
		System.out.println(outjson);
		
//		Iterator<CEntityFund> it=findResult.iterator();
//		int count=0;
//		while(it.hasNext()){
//			CEntityFund cf=it.next();
//			count++;
//			System.out.println(count+"--"+cf.toString());
//		}
		
		
		
	}
	
	
}
