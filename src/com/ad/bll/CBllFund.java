package com.ad.bll;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ad.dao.IDaoFrame;
import com.ad.entity.CEntityFund;
import com.ad.entity.CEntityUser;
import com.ad.tool.MyConstant;

@Component("cBllFund")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class CBllFund {
	
	private IDaoFrame iDaoFrame;

	@Resource(name = "cDaoFrameImpl")
	public void setiDaoFrame(IDaoFrame iDaoFrame) {
		this.iDaoFrame = iDaoFrame;
	}
	
	/**
	 * 序号：fundmodule:1 
	 * 功能：创建基金
	 * 参数：CEntityFund(*)
	 * 返回值:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund){
		boolean bisSave=iDaoFrame.saveFund(cEntityFund);
		return bisSave;
	}
	
	/**
	 * 序号：fundmodule:2 
	 * 功能：获得用户基金
	 * 参数：CEntityUser(UserId),page,FundState
	 * 返回值:List<CEntityFund>
	 */
	public List<CEntityFund> getUserFund(CEntityUser cEntityUser,int page,int FundState){
		page=page-1;
		List<CEntityFund> findReuslt=iDaoFrame.queryFundByUserId(cEntityUser, page,FundState);
		return findReuslt;
	}
	
	/**
	 * 序号：fundmodule:3 
	 * 功能：获得用户/已买/已卖基金数
	 * 参数：CEntityUser(UserId),FundState
	 * 返回值:int
	 */
	public int getUserFundNumer(CEntityUser cEntityUser,int FundState){
		int count=iDaoFrame.queryFundNumberByUserId(cEntityUser, FundState);
		return count;
	}
	
	/**
	 * 序号：fundmodule:4 
	 * 功能：获得用户/已买/已卖基金名称和基金代码
	 * 参数：CEntityUser(UserId)
	 * 返回值:List
	 */
	@SuppressWarnings("unchecked")
	public List getFundNameAndCode(CEntityUser cEntityUser){
		List findResult=iDaoFrame.queryFundNameAndFundCode(cEntityUser);
		return findResult;
	}
	
	/**
	 * 序号：fundmodule:5 
	 * 功能：卖出基金
	 * 参数：CEntityFund
	 * 返回值:boolean
	 */
	public boolean sellFund(CEntityFund cEntityFund){
		CEntityFund aimFund=iDaoFrame.queryFundByFundId(cEntityFund);
		
		
		aimFund.setFundSellDate(cEntityFund.getFundSellDate());
		aimFund.setFundSellFee(cEntityFund.getFundSellFee());
		aimFund.setFundState(MyConstant.Fund.FundSell);
		aimFund.setFundSellNetValue(cEntityFund.getFundSellNetValue());
		
		//基金卖出金额=(基金份额*基金卖出净值)
		double resultSellAmount=aimFund.getFundShares()*cEntityFund.getFundSellNetValue();
		aimFund.setFundSellAmount(resultSellAmount);
		
		//基金利润金额=(基金卖出金额-基金金额-基金买入手续费-基金卖出手续费)
		double resultProfitAmount=resultSellAmount-aimFund.getFundAmount()-aimFund.getFundBuyFee()-cEntityFund.getFundSellFee();
		aimFund.setFundProfitAmount(resultProfitAmount);
		
		//基金利润率（%）=基金利润金额/(基金金额+基金买入手续费+基金卖出手续费)
		double resultProfitRate=resultProfitAmount/(aimFund.getFundAmount()+aimFund.getFundBuyFee()+cEntityFund.getFundSellFee());
		DecimalFormat df = new DecimalFormat("0.0000");
		aimFund.setFundProfitRate(Double.parseDouble(df.format(resultProfitRate))*100);
		
		boolean bisSell=iDaoFrame.updateFund(aimFund);
		return bisSell;
	}
	
	
}
