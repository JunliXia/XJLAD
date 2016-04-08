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
import com.ad.tool.MyOpcode;

@Component("cDaoFund")
public class CDaoFund extends SuperDAO{

	

	/**
	 * ��ţ�fund:1
	 * ���ܣ�����һ������
	 * ������CEntityFund(*)
	 * ����ֵ:boolean
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
	 * ��ţ�fund:2
	 * ���ܣ����û��Ų�ѯ����/��������
	 * ������CEntityUser(UserId),page
	 * ����ֵ:List<CEntityFund>
	 */
	@SuppressWarnings("unchecked")
	public List<CEntityFund> queryFundByUserId(final CEntityUser cEntityUser, final int page,final int FundState){
		List<CEntityFund> findResult=this.getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				String addHql="";
				if(FundState==MyConstant.Fund.FundBuy){
					addHql="order by fund.fundBuyDate desc";
				}else if(FundState==MyConstant.Fund.FundSell){
					addHql="order by fund.fundSellDate desc";
				}
				
				String hql="from com.ad.entity.CEntityFund as fund where fund.userId=? and fund.fundState=?"+addHql;
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
	 * ��ţ�fund:3
	 * ���ܣ����û��Ų�ѯ����/�����Ļ�������
	 * ������CEntityUser(UserId),FundState
	 * ����ֵ:int
	 */
	public int queryFundNumberByUserId(CEntityUser cEntityUser,int FundState){
		String hql="select count(*) from com.ad.entity.CEntityFund as fund where userId=? and fundState=?";
		List<?> findResult=this.getHibernateTemplate().find(hql,new Object[]{cEntityUser.getUserId(),FundState});
		Long result=(Long)findResult.get(0);
		int count=result.intValue();
		return count;
	
	}
	
	/**
	 * ��ţ�fund:4
	 * ���ܣ����û��Ų�ѯ����/�����Ļ���������������
	 * ������CEntityUser(UserId)
	 * ����ֵ:List
	 */
	@SuppressWarnings("unchecked")
	public List queryFundNameAndFundCode(CEntityUser cEntityUser){
		String hql="select fund.fundName,fund.fundCode from com.ad.entity.CEntityFund as fund where fund.userId=? group by fund.fundName ";
		List findRList=this.getHibernateTemplate().find(hql,cEntityUser.getUserId());
		return findRList;
	}
	
	
	/**
	 * ��ţ�fund:5
	 * ���ܣ��޸Ļ���
	 * ������CEntityFund
	 * ����ֵ:bolean
	 */
	public boolean updateFund(CEntityFund cEntityFund){
//		CEntityFund aimFund=(CEntityFund) this.getHibernateTemplate().get(CEntityFund.class, cEntityFund.getFundId());
//		aimFund.setFundSellDate(cEntityFund.getFundSellDate());
//		aimFund.setFundSellFee(cEntityFund.getFundSellFee());
//		aimFund.setFundProfitRate(cEntityFund.getFundProfitRate());
//		aimFund.setFundProfitAmount(cEntityFund.getFundProfitAmount());
//		aimFund.setFundSellAmount(cEntityFund.getFundSellAmount());
//		aimFund.setFundSellNetValue(cEntityFund.getFundSellNetValue());
//		aimFund.setFundState(cEntityFund.getFundState());
		
		boolean bisUpdate=false;
		try {
			this.getHibernateTemplate().update(cEntityFund);
			bisUpdate=true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bisUpdate;
	}
	
	
	/**
	 * ��ţ�fund:6
	 * ���ܣ�ͨ������ŵõ���������
	 * ������CEntityFund
	 * ����ֵ:CEntityFund
	 */
	public CEntityFund queryFundByFundId(CEntityFund cEntityFund){
		CEntityFund findResult=(CEntityFund)this.getHibernateTemplate().get(CEntityFund.class, cEntityFund.getFundId());
		return findResult;
	}
	
	
	/**
	 * ��ţ�fund:7
	 * ���ܣ�ͨ�����������������õ��û��Լ����ض�������
	 * ������CEntityFund(FundName,FundCode,FundState,UserId)
	 * ����ֵ:int
	 */
	public int queryUserFundNumberByFundNameCodeUserId(CEntityFund cEntityFund){
		String hql="select count(*) from com.ad.entity.CEntityFund as fund where userId=? and fundState=? and fundName=? and fundCode=?";
		List<?> findResult=this.getHibernateTemplate().find(hql,new Object[]{cEntityFund.getUserId(),cEntityFund.getFundState(),cEntityFund.getFundName(),cEntityFund.getFundCode()});
		Long result=(Long)findResult.get(0);
		int count=result.intValue();
		return count;
	}
	
	
	/**
	 * ��ţ�fund:8
	 * ���ܣ����û��Ų�ѯ����/�����ض��Ļ���
	 * ������CEntityFund(FundName,FundCode,FundState,UserId)
	 * ����ֵ:List<CEntityFund>
	 */
	@SuppressWarnings("unchecked")
	public List<CEntityFund> queryUserFundByFundNameCodeUserId(final CEntityFund cEntityFund, final int page){
		List<CEntityFund> findResult=this.getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				String addHql="";
				if(cEntityFund.getFundState()==MyConstant.Fund.FundBuy){
					addHql="order by fund.fundBuyDate desc";
				}else if(cEntityFund.getFundState()==MyConstant.Fund.FundSell){
					addHql="order by fund.fundSellDate desc";
				}
				
				String hql="from com.ad.entity.CEntityFund as fund where fund.userId=? and fund.fundName=? and fund.fundCode=? and fund.fundState=?"+addHql;
				Query query = arg0.createQuery(hql)
				.setInteger(0, cEntityFund.getUserId())
				.setString(1, cEntityFund.getFundName())
				.setString(2, cEntityFund.getFundCode())
				.setInteger(3, cEntityFund.getFundState());  
				query.setFirstResult(page*MyConstant.Paging.PageLength);     
			    query.setMaxResults(MyConstant.Paging.PageLength); 
			    List<CEntityFund> findResult=query.list();
				return findResult;
			}
		});
		return findResult;
	}
	
	
	
	
	
	/**
	 * ��ţ�fund:9
	 * ���ܣ����û��Ų�ѯ����Ļ��������������룬���ֻ�����
	 * ������CEntityFund
	 * ����ֵ:List
	 */
	@SuppressWarnings("unchecked")
	public List queryUserFundNameAndFundCodeNumber(CEntityFund cEntityFund){
		String hql="select fund.fundName,fund.fundCode," +
				" sum(case when fund.userId=? and fund.fundState=? then 1 else 0 end)  " +
				" from com.ad.entity.CEntityFund as fund where fund.userId=? and fund.fundState=? group by fund.fundName order by sum(case when fund.userId=? and fund.fundState=? then 1 else 0 end) desc ";
		List findRList=this.getHibernateTemplate().find(hql,new Object[]{cEntityFund.getUserId(),MyConstant.Fund.FundBuy,cEntityFund.getUserId(),MyConstant.Fund.FundBuy,cEntityFund.getUserId(),MyConstant.Fund.FundBuy});
		return findRList;
	}
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		CDaoFund tt = (CDaoFund) ctx.getBean("cDaoFund");
		
		
		CEntityFund cEntityFund=new CEntityFund();
		cEntityFund.setUserId(1);
//		cEntityFund.setFundState(MyConstant.Fund.FundBuy);
//		cEntityFund.setFundName("��1��");
//		cEntityFund.setFundCode("541541");
//		System.out.println(tt.queryUserFundNumberByFundNameCodeUserId(cEntityFund));
		List findResult=tt.queryUserFundNameAndFundCodeNumber(cEntityFund);
		JSONArray outjson=JSONArray.fromObject(findResult);
		System.out.println(outjson);
		
		
		
		
//		CEntityUser cEntityUser=new CEntityUser();
//		cEntityUser.setUserId(1);
		
//		List findResult=tt.queryFundNameAndFundCode(cEntityUser);
//		JSONArray outjson=JSONArray.fromObject(findResult);
//		System.out.println(outjson);
//		Iterator it=findResult.iterator();
//		while (it.hasNext()) {       
//			Object[] tuple = (Object[]) it.next();
//			System.out.println((String)tuple[0]+"---"+(String)tuple[1]);
//		 }   
//		
		
//		int findResult=tt.queryFundNumberByUserId(cEntityUser,MyConstant.Fund.FundSell);
		
//		JSONArray outjson=JSONArray.fromObject(findResult);
//		System.out.println(findResult);
//		Iterator<CEntityFund> it=findResult.iterator();
//		int count=0;
//		while(it.hasNext()){
//			CEntityFund cf=it.next();
//			count++;
//			System.out.println(count+"--"+cf.toString());
//		}
		
		
		
	}
	
	
}
