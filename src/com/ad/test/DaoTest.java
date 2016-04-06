package com.ad.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ad.dao.IDaoFrame;


@Component("daoTest")
public class DaoTest {

	private IDaoFrame iDaoFrame;

	@Resource(name = "cDaoFrameImpl")
	public void setiDaoFrame(IDaoFrame iDaoFrame) {
		this.iDaoFrame = iDaoFrame;
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		DaoTest tt = (DaoTest) ctx.getBean("daoTest");
		
		
		/*
		 *------------------------------ 管理员 administrator----------------------------
		 */
		
		// administrator:1增加一个管理员帐号
//		CEntityAdministrator cEntityAdministrator = new CEntityAdministrator(
//				"accountone", "passwordone");
//		System.out.println(tt.saveAdministrator(cEntityAdministrator));
	
	
		// administrator:2按帐号密码查询管理员
//		CEntityAdministrator cEntityAdministrator = new CEntityAdministrator.Builder().AdministratorAccount("accountone").AdministratorPassword("passwordone").build();
//		System.out.println(tt.queryAdministrator(cEntityAdministrator).toString());
		

		/*
		 * -------------------------------员工employee----------------------------------
		 */	
		//employee:1增加一个员工
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeName("employeethree").EmployeePassword("passwordthree").build();
//		System.out.println(tt.saveEmployee(cEntityEmployee));
		
		//employee:2获取所有未删员工
//		CEntityEmployeeArray cEntityEmployeeArray=tt.queryAllEmployee();
//		for(int i=0;i<cEntityEmployeeArray.getSize();i++){
//			System.out.println(cEntityEmployeeArray.getItem(i).toString());
//		}
		
		//employee:3修改员工类别
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).EmployeeType(5).build();
//		System.out.println(tt.updateEmployeeType(cEntityEmployee));

		//employee:4按帐号密码查找员工
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeAccount("accountone").EmployeePassword("passwordone").build();
//		System.out.println(tt.queryEmployeeByAccountAndPassword(cEntityEmployee).toString());
		
		//employee:5按帐号查找员工
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeAccount("accountone").build();
//		System.out.println(tt.queryEmployeeByAccount(cEntityEmployee));
		
		//employee:6按员工类别获得所有员工
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeType(1).build();
//		CEntityEmployeeArray cEntityEmployeeArray=tt.queryAllEmployeeByType(cEntityEmployee);
//		System.out.println(cEntityEmployeeArray.toString());

		
		/*
		 * -------------------------------任务mission----------------------------------
		 */
		//mission:1 增加任务
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionContent("contentOne").MissionPubdate("pubdateone").MissionDeadline("deadlineone").MissionState(0).MissionDelayState(0).build();
//		System.out.println(tt.saveMission(cEntityEmployee, cEntityMission));
		
		//mission:2修改任务状态
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(20).MissionState(2).build();
//		System.out.println(tt.updateMissionState(cEntityMission,MyConstant.Mission.MISSION_UNDERWAY));

		//mission:3修改任务延期状态
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).MissionDelayState(2).build();
//		System.out.println(tt.updateMissionDelayState(cEntityMission));

		//mission:4根据员工号获得所有的任务
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		System.out.println(tt.queryAllMissionByEmployeeId(cEntityEmployee).getSize());
	
		//mission:5按任务状态获得所有任务
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionState(1).build();
//		System.out.println(tt.queryAllMissionByMissionType(cEntityMission).getSize());
	
	
		/*
		 * -------------------------------任务延期 missiondelay----------------------------------
		 */
		
		//missiondealy:1 增加一条任务延期
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).build();
//		CEntityMissionDelay cEntityMissionDelay=new CEntityMissionDelay.Builder().MissionDelayDeadline("deadlineone").MissionDelayTime("timeone").build();
//		System.out.println(tt.saveMissionDealy(cEntityMission, cEntityMissionDelay));
	
		//missiondealy:2按任务号获得所有任务延期
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).build();
//		System.out.println(tt.queryAllMissionDelayByMissionId(cEntityMission).getSize());
		
		
		/*
		 * -------------------------------任务总结 missionconclusion----------------------------------
		 */	
		
		//missionconclusion:1增加一条任务总结
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).build();
//		CEntityMissionConclusion cEntityMissionConclusion=new CEntityMissionConclusion.Builder().MissionAccessoryPath("pathone").MissionCheck(0).MissionSubmitTime("timeone").MissionSummary("summaryOne").build();
//		System.out.println(tt.savaMissionConclusion(cEntityMission, cEntityMissionConclusion));
		
		//missionconclusion:2按任务号获得所有任务总结
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).build();
//		System.out.println(tt.queryAllMissonConclusionByMissionId(cEntityMission).getSize());
		
		
		/*
		 * -------------------------------任务撤销missionundo----------------------------------
		 */	
		
		//missionundo:1增加一条任务撤销
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).build();
//		CEntityMissionUndo cEntityMissionUndo=new CEntityMissionUndo.Builder().MissionUndoReason("reasonone").MissionUndoTime("undotime").MissionUndoType(0).build();
//		System.out.println(tt.saveMissionUndo(cEntityMission, cEntityMissionUndo));
		
		//missionundo:2获得所有的任务撤销
//		CEntityMissionUndoArray cEntityMissionUndoArray=tt.queryAllMissionUndo();
//		System.out.println(cEntityMissionUndoArray.getSize());
		
		//missionundo:3修改撤销类型
//		CEntityMissionUndo cEntityMissionUndo=new CEntityMissionUndo.Builder().MissionUndoId(1).MissionUndoType(2).build();
//		System.out.println(tt.updateMissionUndoType(cEntityMissionUndo));
	
		/*
		 * -------------------------------客户client----------------------------------
		 */
		
		//client:1增加客户
//		CEntityClient cEntityClient=new CEntityClient.Builder().ClientAddress("addressOne").ClientArea("areaone").ClientCompany("companyone").ClientName("nameone").ClientPhone("phoneone").ClientState(0).build();
//		System.out.println(tt.saveClient(cEntityClient));
	
		//client:2按员工号获得所有的客户
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(2).build();
//		System.out.println(tt.queryAllClientByEmployeeId(cEntityEmployee).getSize());
		
		
		//client:3修改客户员工号
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(2).build();
//		CEntityClient cEntityClient=new CEntityClient.Builder().ClientId(1).build();
//		System.out.println(tt.updateClientEmployeeId(cEntityClient, cEntityEmployee));
		
		//client:4按客户状态获得所有的客户
//		CEntityClient cEntityClient=new CEntityClient.Builder().ClientState(0).build();
//		System.out.println(tt.queryAllClientByClientState(cEntityClient));
		
		
		/*
		 * -------------------------------客户提交clientsubmit----------------------------------
		 */	
		//clientsubmit:1增加一条客户提交（同时增加了一条客户）
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(2).build();
//		CEntityClientSubmit cEntityClientSubmit=new CEntityClientSubmit.Builder().ClientSubmitState(0).ClientSubmitTime("timeone").build();
//		CEntityClient cEntityClient=new CEntityClient.Builder().ClientAddress("addressOne").ClientArea("areaone").ClientCompany("companyone").ClientName("nameone").ClientPhone("phoneone").ClientState(0).build();
//		System.out.println(tt.saveClientSubmit(cEntityClient, cEntityEmployee, cEntityClientSubmit));
		
		//clientsubmit:2按提交状态获得所有的客户提交
//		CEntityClientSubmit cEntityClientSubmit=new CEntityClientSubmit.Builder().ClientSubmitState(0).build();
//		System.out.println(tt.queryAllClientSubmitByClientSubmitState(cEntityClientSubmit));

	
		/*
		 * -------------------------------拜访计划visitplan----------------------------------
		 */	
		//visitplan:1增加拜访计划
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityClient cEntityClient=new CEntityClient.Builder().ClientId(2).build();
//		CEntityVisitPlan cEntityVisitPlan=new CEntityVisitPlan.Builder().VisitPlanCycle(0).VisitPlanCycleNumber(1).build();
//		System.out.println(tt.saveVisitPlan(cEntityClient, cEntityEmployee, cEntityVisitPlan));

		
		//visitplan:2按员工号获得所有的拜访计划
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		System.out.println(tt.queryAllVisitPlanByEmployeeId(cEntityEmployee));
		
		/*
		 * ------------------------------拜访总结 visitconclusion-------------------------------------
		 */	
		
		//visitconclusion:1增加拜访总结
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityVisitPlan cEntityVisitPlan=new CEntityVisitPlan.Builder().VisitPlanId(1).build();
//		CEntityVisitConclusion cEntityVisitConclusion=new CEntityVisitConclusion.Builder().VisitAccessoryPath("pathone").VisitCheck(0).VisitCommand("commandone").VisitSubmitTime("subtimewone").VisitSummary("summaryone").build();
//		System.out.println(tt.saveVisitConclusion(cEntityEmployee, cEntityVisitPlan, cEntityVisitConclusion));
		
		//visitconclusion:2按员工号获得所有的拜访总结
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		System.out.println(tt.queryAllVisitConclusionByEmployeeId(cEntityEmployee));
		
		/*
		 * ------------------------------拜访撤销 visitconclusion-------------------------------------
		 */	
		
		//visitundo:1增加一条拜访撤销
//		CEntityVisitPlan cEntityVisitPlan=new CEntityVisitPlan.Builder().VisitPlanId(1).build();
//		CEntityVisitUndo cEntityVisitUndo=new CEntityVisitUndo.Builder().VisitUndoReason("ressonone").VisitUndoTime("timeone").VisitUndoType(0).build();
//		System.out.println(tt.saveVisitUndo(cEntityVisitPlan, cEntityVisitUndo));
	
		//visitundo:2获得所有的拜访撤销
//		CEntityVisitUndoArray cEntityVisitUndoArray=tt.queryAllVisitUndo();
//		System.out.println(cEntityVisitUndoArray.getSize());

		/*
		 * -----------------------------拜访延期visitdelay-------------------------------------
		 */
		//visitdealy:1增加一条拜访延期
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityVisitPlan cEntityVisitPlan=new CEntityVisitPlan.Builder().VisitPlanId(1).build();
//		CEntityVisitDelay cEntityVisitDelay=new CEntityVisitDelay.Builder().VisitDelayDeadline("deadlieone").VisitDelayTime("timeone").build();
//		System.out.println(tt.saveVisitDealy(cEntityEmployee, cEntityVisitPlan, cEntityVisitDelay));
		
		//visitdealy:2获得所有拜访延期
//		CEntityVisitDealyArray cEntityVisitDealyArray=tt.queryAllVisitDelay();
//		System.out.println(cEntityVisitDealyArray.getSize());

		/*
		 * -----------------------------出差bussiness------------------------------------
		 */
		//bussiness:1增加一条出差
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityBussiness cEntityBussiness=new CEntityBussiness.Builder().BussinessContent("contentone").BussinessSideAddress("addressone").BussinessState(0).build();
//		System.out.println(tt.saveBussiness(cEntityEmployee, cEntityBussiness));
		
		//bussiness:2按员工号获得所有的出差
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityBussinessArray cEntityBussinessArray=tt.queryAllBussinessByEmployeeId(cEntityEmployee);
//		System.out.println(cEntityBussinessArray.getSize());
	
		/*
		 * -----------------------------出差活动bussinessactivity------------------------------------
		 */
		//bussinessactivity:1增加一条出差活动
//		CEntityBussiness cEntityBussiness=new CEntityBussiness.Builder().BussinessId(1).build();
//		CEntityBussinessActivity cEntityBussinessActivity=new CEntityBussinessActivity.Builder().BussinessActivityType(0).BussinessBindType(0).BussinessObjectId(1).build();
//		System.out.println(tt.saveBussinessActivity(cEntityBussinessActivity, cEntityBussiness));
		
		//bussinessactivity:2按出差号获得所有的出差活动
//		CEntityBussiness cEntityBussiness=new CEntityBussiness.Builder().BussinessId(1).build();
//		System.out.println(tt.queryAllBussinessActivityByBussinessId(cEntityBussiness).getSize());
	
		/*
		 * -----------------------------出差不良记录bussinessbadrecord------------------------------------
		 */
		//bussinessbadrecord:1增加一条出差不良记录
//		CEntityBussiness cEntityBussiness=new CEntityBussiness.Builder().BussinessId(1).build();
//		CEntityBussinessBadrecord cEntityBussinessBadrecord=new CEntityBussinessBadrecord.Builder().BussinessBadrecordReason("reasonone").BussinessBadrecordTime("timeone").build();
//		System.out.println(tt.saveBussinessBadrecord(cEntityBussiness, cEntityBussinessBadrecord));
		
	
		//bussinessbadrecord:2获得所有的出差不良记录
//		CEntityBussinessBadrecordArray cEntityBussinessBadrecordArra=tt.queryAllBussinessBadrecord();
//		System.out.println(cEntityBussinessBadrecordArra.getSize());
	
		/*
		 * ----------------------------考勤attendance------------------------------------
		 */
		
		
		//attendance:1增加一条考勤
		
		
		/*
		 * ----------------------------通知 notice------------------------------------
		 */
		//notice:1增加一条通知
//		for(int i=0;i<100;i++){
//		CEntityNotice cEntityNotice=new CEntityNotice.Builder().NoticeContent("contentone").NoticeTime("timeone").NoticeTitle("titleone").build();
//		System.out.println(tt.saveNotice(cEntityNotice));
//		}
//		//notice:2获得全部通知
//		long startTime=System.currentTimeMillis();   //获取开始时间
//
//		CEntityNoticeArray cEntityNoticeArray=tt.queryAllNotice();
//		System.out.println(cEntityNoticeArray.getSize());
//		
//		long endTime=System.currentTimeMillis(); //获取结束时间
//
//		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//
//		
//		
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		long start2Time=System.currentTimeMillis();   //获取开始时间
//		CEntityNoticeArray cEntityNoticeArray2=tt.queryAllNotice();
//		System.out.println(cEntityNoticeArray2.getSize());
//		
//
//		long end2Time=System.currentTimeMillis(); //获取结束时间
//
//		System.out.println("程序运行时间： "+(end2Time-start2Time)+"ms");
//		
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		long start3Time=System.currentTimeMillis();   //获取开始时间
//		CEntityNoticeArray cEntityNoticeArray3=tt.queryAllNotice();
//		System.out.println(cEntityNoticeArray3.getSize());
//		
//
//		long end3Time=System.currentTimeMillis(); //获取结束时间
//
//		System.out.println("程序运行时间： "+(end3Time-start3Time)+"ms");
//		

		/*
		 * ----------------------------建议 suggest----------------------------------
		 */
		//suggest:1增加一条建议
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntitySuggest cEntitySuggest=new CEntitySuggest.Builder().SuggestContent("contentone").SuggestTime("timeone").build();
//		System.out.println(tt.saveSuggest(cEntityEmployee, cEntitySuggest));

		//uggest:2获得所有的建议
//		CEntitySuggestArray cEntitySuggestArray=tt.queryAllSuggest();
//		System.out.println(cEntitySuggestArray.getSize());
		
		
//		System.out.println(tt.sd());
		
	}
	
	

}
