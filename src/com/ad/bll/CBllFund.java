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
	 * ��ţ�fundmodule:1 
	 * ���ܣ���������
	 * ������CEntityFund(*)
	 * ����ֵ:boolean
	 */
	public boolean saveFund(CEntityFund cEntityFund){
		boolean bisSave=iDaoFrame.saveFund(cEntityFund);
		return bisSave;
	}
	
	/**
	 * ��ţ�fundmodule:2 
	 * ���ܣ�����û�����
	 * ������CEntityUser(UserId),page,FundState
	 * ����ֵ:List<CEntityFund>
	 */
	public List<CEntityFund> getUserFund(CEntityUser cEntityUser,int page,int FundState){
		page=page-1;
		List<CEntityFund> findReuslt=iDaoFrame.queryFundByUserId(cEntityUser, page,FundState);
		return findReuslt;
	}
	
	/**
	 * ��ţ�fundmodule:3 
	 * ���ܣ�����û�/����/����������
	 * ������CEntityUser(UserId),FundState
	 * ����ֵ:int
	 */
	public int getUserFundNumer(CEntityUser cEntityUser,int FundState){
		int count=iDaoFrame.queryFundNumberByUserId(cEntityUser, FundState);
		return count;
	}
	
	/**
	 * ��ţ�fundmodule:4 
	 * ���ܣ�����û�/����/�����������ƺͻ������
	 * ������CEntityUser(UserId)
	 * ����ֵ:List
	 */
	@SuppressWarnings("unchecked")
	public List getFundNameAndCode(CEntityUser cEntityUser){
		List findResult=iDaoFrame.queryFundNameAndFundCode(cEntityUser);
		return findResult;
	}
	
	/**
	 * ��ţ�fundmodule:5 
	 * ���ܣ���������
	 * ������CEntityFund
	 * ����ֵ:boolean
	 */
	public boolean sellFund(CEntityFund cEntityFund){
		CEntityFund aimFund=iDaoFrame.queryFundByFundId(cEntityFund);
		
		
		aimFund.setFundSellDate(cEntityFund.getFundSellDate());
		aimFund.setFundSellFee(cEntityFund.getFundSellFee());
		aimFund.setFundState(MyConstant.Fund.FundSell);
		aimFund.setFundSellNetValue(cEntityFund.getFundSellNetValue());
		
		//�����������=(����ݶ�*����������ֵ)
		double resultSellAmount=aimFund.getFundShares()*cEntityFund.getFundSellNetValue();
		aimFund.setFundSellAmount(resultSellAmount);
		
		//����������=(�����������-������-��������������-��������������)
		double resultProfitAmount=resultSellAmount-aimFund.getFundAmount()-aimFund.getFundBuyFee()-cEntityFund.getFundSellFee();
		aimFund.setFundProfitAmount(resultProfitAmount);
		
		//���������ʣ�%��=����������/(������+��������������+��������������)
		double resultProfitRate=resultProfitAmount/(aimFund.getFundAmount()+aimFund.getFundBuyFee()+cEntityFund.getFundSellFee());
		DecimalFormat df = new DecimalFormat("0.0000");
		aimFund.setFundProfitRate(Double.parseDouble(df.format(resultProfitRate))*100);
		
		boolean bisSell=iDaoFrame.updateFund(aimFund);
		return bisSell;
	}
	
	
}
