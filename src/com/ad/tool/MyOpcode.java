package com.ad.tool;



public class MyOpcode {
	public static final class Operation {
		public static final String OPERATION = "operation";		//操作码
		public static final String SIGN = "sign";				//标志
		public static final String TRUE = "true";				//真,正确
		public static final String FALSE = "false";				//假,错误
		public static final String LIST = "list";				//表示列表
		public static final String TYPE = "type";				//类型
		public static final String CHECK="check";				//结果
		public static final String PAGE="page";					//页数
		
		
//		// 登录
//		public static final int LOGIN = 1;
//
//		// 考勤管理
//		public static final int ENTER_ATTENDANCE = 2; // 进入考勤管理
//		public static final int SEND_ATTENDANCE = 3; // 签到/签退
//
//		// 任务
//		public static final int ENTER__MISSION = 4; // 进入任务
////		public static final int ENTER_WAITTAKE_MISSION = 4; // 进入待接受任务
//		public static final int GET_WAITTAKE_MISSION = 5; // 接受任务
////		public static final int ENTER_UNDERWAY_MISSION = 6; // 进入待处理任务
//		public static final int SENT_MISSION = 7; // 提交任务
////		public static final int ENTER_COMPLETE_MISSION = 8; // 进入已完成任务
//
//		// 出差
//		public static final int ENTER_BUSSINESS = 9; // 进入出差
//		public static final int SEND_BUSSINESS=10;	//提交出差
////		public static final int SEND_BUSSINESS_REGISTER = 10; // 提交出差登记
////		public static final int SEND_BUSSINESS_IN = 11; // 提交出差抵达
////		public static final int SEND_BUSSINESS_OUT = 12; // 提交出差离开
////		public static final int SEND_BUSSINESS_RETURN = 13; // 提交出差归来
//
//		// 客户管理
//		public static final int ENTER_CLIENT_MANAGER = 14; // 进入客户管理
//		public static final int ENTER_CLIENT_VISIT = 15; // 提交客户拜访
//		public static final int ADD_CLIENT = 16; // 增加客户
//		public static final int UPDATA_CLIENT = 17; // 修改客户
//		public static final int ENTER_VISIT = 18; // 进入拜访记录
//
//		// 通信录
//		public static final int ENTER_COMMINITION = 19; // 进入通讯录
//
//		// 通知公告
//		public static final int ENTER_NOTICE = 20;// 进入通知通告
//		
//		
//		
//		public static final int SEND_SUGGEST=21;//提交投诉建议
//		
//		public static final int UPLOADIMG=22;//图片上传
//		
//		public static final int SENDADDRESS=23;//传输地理位置信息
	}
	/**
	 *
	 * 功能：用户
	 *
	 */
	public static final class User{
		public static final String User="User";
		public static final String UserId="UserId";
		public static final String UserAccount="UserAccount";
		public static final String UserPassword="UserPassword";
		public static final String UserName="UserName";
	}
	
	/**
	 * 
	 * 功能:基金
	 *
	 */
	public static final class Fund{
		public static final String Fund="Fund";
		public static final String FundName="FundName";
		public static final String FundCode="FundCode";
		public static final String FundAmount="FundAmount";
		public static final String FundShares="FundShares";
		public static final String FundNetValue="FundNetValue";
		public static final String FundBuyDate="FundBuyDate";
		public static final String FundBuyFee="FundBuyFee";
		public static final String FundSellDate="FundSellDate";
		public static final String FundSellFee="FundSellFee";
		public static final String FundProfitRate="FundProfitRate";
		public static final String FundProfitAmount="FundProfitAmount";
		public static final String FundState="FundState";
		
	}
	
	
}
