package com.ad.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fund")
public class CEntityFund {
	private int FundId;					//基金号，自增
	private String FundName;			//基金名
	private String FundCode;			//基金代码
	private double FundAmount;			//基金金额（=基金份额*基金净值）
	private double FundShares;			//基金份额
	private double FundNetValue;		//基金净值
	private String FundBuyDate;			//基金买入日期（yyyy-MM-dd）
	private double FundBuyFee;			//基金买入手续费
	private String FundSellDate;		//基金卖出日期（yyyy-MM-dd）
	private double FundSellFee;			//基金卖出手续费
	private double FundProfitRate;		//基金利润率（%）
	private double FundProfitAmount;	//基金利润金额
	private int FundState;				//基金状态
	private double FundProfitLimit;		//基金赢利点
	private double FundLossLimit;		//基金止损点
	private int UserId;					//用户号，自增
	
	
	public CEntityFund() {
	}
	
	
	
	
public CEntityFund(int fundId, String fundName, String fundCode,
			double fundAmount, double fundShares, double fundNetValue,
			String fundBuyDate, double fundBuyFee, String fundSellDate,
			double fundSellFee, double fundProfitRate, double fundProfitAmount,
			int fundState, double fundProfitLimit, double fundLossLimit,
			int userId) {
		FundId = fundId;
		FundName = fundName;
		FundCode = fundCode;
		FundAmount = fundAmount;
		FundShares = fundShares;
		FundNetValue = fundNetValue;
		FundBuyDate = fundBuyDate;
		FundBuyFee = fundBuyFee;
		FundSellDate = fundSellDate;
		FundSellFee = fundSellFee;
		FundProfitRate = fundProfitRate;
		FundProfitAmount = fundProfitAmount;
		FundState = fundState;
		FundProfitLimit = fundProfitLimit;
		FundLossLimit = fundLossLimit;
		UserId = userId;
	}




//	public CEntityFund(int fundId, String fundName, String fundCode,
//			double fundAmount, double fundShares, double fundNetValue,
//			String fundBuyDate, double fundBuyFee, String fundSellDate,
//			double fundSellFee, double fundProfitRate, double fundProfitAmount,
//			int fundState, int userId) {
//		FundId = fundId;
//		FundName = fundName;
//		FundCode = fundCode;
//		FundAmount = fundAmount;
//		FundShares = fundShares;
//		FundNetValue = fundNetValue;
//		FundBuyDate = fundBuyDate;
//		FundBuyFee = fundBuyFee;
//		FundSellDate = fundSellDate;
//		FundSellFee = fundSellFee;
//		FundProfitRate = fundProfitRate;
//		FundProfitAmount = fundProfitAmount;
//		FundState = fundState;
//		UserId = userId;
//	}
	@Id
	@GeneratedValue
	public int getFundId() {
		return FundId;
	}
	public void setFundId(int fundId) {
		FundId = fundId;
	}
	public String getFundName() {
		return FundName;
	}
	public void setFundName(String fundName) {
		FundName = fundName;
	}
	public String getFundCode() {
		return FundCode;
	}
	public void setFundCode(String fundCode) {
		FundCode = fundCode;
	}
	public double getFundAmount() {
		return FundAmount;
	}
	public void setFundAmount(double fundAmount) {
		FundAmount = fundAmount;
	}
	public double getFundShares() {
		return FundShares;
	}
	public void setFundShares(double fundShares) {
		FundShares = fundShares;
	}
	public double getFundNetValue() {
		return FundNetValue;
	}
	public void setFundNetValue(double fundNetValue) {
		FundNetValue = fundNetValue;
	}
	public String getFundBuyDate() {
		return FundBuyDate;
	}
	public void setFundBuyDate(String fundBuyDate) {
		FundBuyDate = fundBuyDate;
	}
	public double getFundBuyFee() {
		return FundBuyFee;
	}
	public void setFundBuyFee(double fundBuyFee) {
		FundBuyFee = fundBuyFee;
	}
	public String getFundSellDate() {
		return FundSellDate;
	}
	public void setFundSellDate(String fundSellDate) {
		FundSellDate = fundSellDate;
	}
	public double getFundSellFee() {
		return FundSellFee;
	}
	public void setFundSellFee(double fundSellFee) {
		FundSellFee = fundSellFee;
	}
	public double getFundProfitRate() {
		return FundProfitRate;
	}
	public void setFundProfitRate(double fundProfitRate) {
		FundProfitRate = fundProfitRate;
	}
	public double getFundProfitAmount() {
		return FundProfitAmount;
	}
	public void setFundProfitAmount(double fundProfitAmount) {
		FundProfitAmount = fundProfitAmount;
	}
	public int getFundState() {
		return FundState;
	}
	public void setFundState(int fundState) {
		FundState = fundState;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public double getFundProfitLimit() {
		return FundProfitLimit;
	}
	public void setFundProfitLimit(double fundProfitLimit) {
		FundProfitLimit = fundProfitLimit;
	}
	public double getFundLossLimit() {
		return FundLossLimit;
	}
	public void setFundLossLimit(double fundLossLimit) {
		FundLossLimit = fundLossLimit;
	}
	@Override
	public String toString() {
		return "CEntityFund [FundAmount=" + FundAmount + ", FundBuyDate="
				+ FundBuyDate + ", FundBuyFee=" + FundBuyFee + ", FundCode="
				+ FundCode + ", FundId=" + FundId + ", FundLossLimit="
				+ FundLossLimit + ", FundName=" + FundName + ", FundNetValue="
				+ FundNetValue + ", FundProfitAmount=" + FundProfitAmount
				+ ", FundProfitLimit=" + FundProfitLimit + ", FundProfitRate="
				+ FundProfitRate + ", FundSellDate=" + FundSellDate
				+ ", FundSellFee=" + FundSellFee + ", FundShares=" + FundShares
				+ ", FundState=" + FundState + ", UserId=" + UserId + "]";
	}

	
	
	
	
	
}
