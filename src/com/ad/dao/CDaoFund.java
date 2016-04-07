package com.ad.dao;

import java.sql.SQLException;
import java.util.List;


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
	 * 功能：按用户号查询已买/已卖基金
	 * 参数：CEntityUser(UserId),page
	 * 返回值:List<CEntityFund>
	 */
	@SuppressWarnings("unchecked")
	public List<CEntityFund> queryFundByUserId(final CEntityUser cEntityUser, final int page,final int FundState){
		List<CEntityFund> findResult=this.getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				String hql="from com.ad.entity.CEntityFund as fund where fund.userId=? and fund.fundState=?";
				Query query = arg0.createQuery(hql).setInteger(0, cEntityUser.getUserId()).setInteger(1, FundState);  
				query.setFirstResult(page*MyConstant.Paging.PageLength);     
			    query.setMaxResults(MyConstant.Paging.PageLength); 
			    List<CEntityFund> findResult=query.list();
				return findResult;
			}
		});
		return findResult;
	}
	
	/**
	 * 序号：fund:3
	 * 功能：按用户号查询已买/已卖的基金总数
	 * 参数：CEntityUser(UserId),FundState
	 * 返回值:int
	 */
	public int queryFundNumberByUserId(CEntityUser cEntityUser,int FundState){
		String hql="select count(*) from com.ad.entity.CEntityFund as fund where userId=? and fundState=?";
		List<?> findResult=this.getHibernateTemplate().find(hql,new Object[]{cEntityUser.getUserId(),FundState});
		Long result=(Long)findResult.get(0);
		int count=result.intValue();
		return count;
	
	}
	
	
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		CDaoFund tt = (CDaoFund) ctx.getBean("cDaoFund");
		
		CEntityUser cEntityUser=new CEntityUser();
		cEntityUser.setUserId(1);
		
		int findResult=tt.queryFundNumberByUserId(cEntityUser,MyConstant.Fund.FundSell);
		
//		JSONArray outjson=JSONArray.fromObject(findResult);
		System.out.println(findResult);
//		Iterator<CEntityFund> it=findResult.iterator();
//		int count=0;
//		while(it.hasNext()){
//			CEntityFund cf=it.next();
//			count++;
//			System.out.println(count+"--"+cf.toString());
//		}
		
		
		
	}
	
	
}
