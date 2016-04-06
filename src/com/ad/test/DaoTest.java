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
		 *------------------------------ ����Ա administrator----------------------------
		 */
		
		// administrator:1����һ������Ա�ʺ�
//		CEntityAdministrator cEntityAdministrator = new CEntityAdministrator(
//				"accountone", "passwordone");
//		System.out.println(tt.saveAdministrator(cEntityAdministrator));
	
	
		// administrator:2���ʺ������ѯ����Ա
//		CEntityAdministrator cEntityAdministrator = new CEntityAdministrator.Builder().AdministratorAccount("accountone").AdministratorPassword("passwordone").build();
//		System.out.println(tt.queryAdministrator(cEntityAdministrator).toString());
		

		/*
		 * -------------------------------Ա��employee----------------------------------
		 */	
		//employee:1����һ��Ա��
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeName("employeethree").EmployeePassword("passwordthree").build();
//		System.out.println(tt.saveEmployee(cEntityEmployee));
		
		//employee:2��ȡ����δɾԱ��
//		CEntityEmployeeArray cEntityEmployeeArray=tt.queryAllEmployee();
//		for(int i=0;i<cEntityEmployeeArray.getSize();i++){
//			System.out.println(cEntityEmployeeArray.getItem(i).toString());
//		}
		
		//employee:3�޸�Ա�����
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).EmployeeType(5).build();
//		System.out.println(tt.updateEmployeeType(cEntityEmployee));

		//employee:4���ʺ��������Ա��
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeAccount("accountone").EmployeePassword("passwordone").build();
//		System.out.println(tt.queryEmployeeByAccountAndPassword(cEntityEmployee).toString());
		
		//employee:5���ʺŲ���Ա��
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeAccount("accountone").build();
//		System.out.println(tt.queryEmployeeByAccount(cEntityEmployee));
		
		//employee:6��Ա�����������Ա��
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeType(1).build();
//		CEntityEmployeeArray cEntityEmployeeArray=tt.queryAllEmployeeByType(cEntityEmployee);
//		System.out.println(cEntityEmployeeArray.toString());

		
		/*
		 * -------------------------------����mission----------------------------------
		 */
		//mission:1 ��������
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionContent("contentOne").MissionPubdate("pubdateone").MissionDeadline("deadlineone").MissionState(0).MissionDelayState(0).build();
//		System.out.println(tt.saveMission(cEntityEmployee, cEntityMission));
		
		//mission:2�޸�����״̬
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(20).MissionState(2).build();
//		System.out.println(tt.updateMissionState(cEntityMission,MyConstant.Mission.MISSION_UNDERWAY));

		//mission:3�޸���������״̬
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).MissionDelayState(2).build();
//		System.out.println(tt.updateMissionDelayState(cEntityMission));

		//mission:4����Ա���Ż�����е�����
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		System.out.println(tt.queryAllMissionByEmployeeId(cEntityEmployee).getSize());
	
		//mission:5������״̬�����������
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionState(1).build();
//		System.out.println(tt.queryAllMissionByMissionType(cEntityMission).getSize());
	
	
		/*
		 * -------------------------------�������� missiondelay----------------------------------
		 */
		
		//missiondealy:1 ����һ����������
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).build();
//		CEntityMissionDelay cEntityMissionDelay=new CEntityMissionDelay.Builder().MissionDelayDeadline("deadlineone").MissionDelayTime("timeone").build();
//		System.out.println(tt.saveMissionDealy(cEntityMission, cEntityMissionDelay));
	
		//missiondealy:2������Ż��������������
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).build();
//		System.out.println(tt.queryAllMissionDelayByMissionId(cEntityMission).getSize());
		
		
		/*
		 * -------------------------------�����ܽ� missionconclusion----------------------------------
		 */	
		
		//missionconclusion:1����һ�������ܽ�
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).build();
//		CEntityMissionConclusion cEntityMissionConclusion=new CEntityMissionConclusion.Builder().MissionAccessoryPath("pathone").MissionCheck(0).MissionSubmitTime("timeone").MissionSummary("summaryOne").build();
//		System.out.println(tt.savaMissionConclusion(cEntityMission, cEntityMissionConclusion));
		
		//missionconclusion:2������Ż�����������ܽ�
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).build();
//		System.out.println(tt.queryAllMissonConclusionByMissionId(cEntityMission).getSize());
		
		
		/*
		 * -------------------------------������missionundo----------------------------------
		 */	
		
		//missionundo:1����һ��������
//		CEntityMission cEntityMission=new CEntityMission.Builder().MissionId(2).build();
//		CEntityMissionUndo cEntityMissionUndo=new CEntityMissionUndo.Builder().MissionUndoReason("reasonone").MissionUndoTime("undotime").MissionUndoType(0).build();
//		System.out.println(tt.saveMissionUndo(cEntityMission, cEntityMissionUndo));
		
		//missionundo:2������е�������
//		CEntityMissionUndoArray cEntityMissionUndoArray=tt.queryAllMissionUndo();
//		System.out.println(cEntityMissionUndoArray.getSize());
		
		//missionundo:3�޸ĳ�������
//		CEntityMissionUndo cEntityMissionUndo=new CEntityMissionUndo.Builder().MissionUndoId(1).MissionUndoType(2).build();
//		System.out.println(tt.updateMissionUndoType(cEntityMissionUndo));
	
		/*
		 * -------------------------------�ͻ�client----------------------------------
		 */
		
		//client:1���ӿͻ�
//		CEntityClient cEntityClient=new CEntityClient.Builder().ClientAddress("addressOne").ClientArea("areaone").ClientCompany("companyone").ClientName("nameone").ClientPhone("phoneone").ClientState(0).build();
//		System.out.println(tt.saveClient(cEntityClient));
	
		//client:2��Ա���Ż�����еĿͻ�
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(2).build();
//		System.out.println(tt.queryAllClientByEmployeeId(cEntityEmployee).getSize());
		
		
		//client:3�޸Ŀͻ�Ա����
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(2).build();
//		CEntityClient cEntityClient=new CEntityClient.Builder().ClientId(1).build();
//		System.out.println(tt.updateClientEmployeeId(cEntityClient, cEntityEmployee));
		
		//client:4���ͻ�״̬������еĿͻ�
//		CEntityClient cEntityClient=new CEntityClient.Builder().ClientState(0).build();
//		System.out.println(tt.queryAllClientByClientState(cEntityClient));
		
		
		/*
		 * -------------------------------�ͻ��ύclientsubmit----------------------------------
		 */	
		//clientsubmit:1����һ���ͻ��ύ��ͬʱ������һ���ͻ���
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(2).build();
//		CEntityClientSubmit cEntityClientSubmit=new CEntityClientSubmit.Builder().ClientSubmitState(0).ClientSubmitTime("timeone").build();
//		CEntityClient cEntityClient=new CEntityClient.Builder().ClientAddress("addressOne").ClientArea("areaone").ClientCompany("companyone").ClientName("nameone").ClientPhone("phoneone").ClientState(0).build();
//		System.out.println(tt.saveClientSubmit(cEntityClient, cEntityEmployee, cEntityClientSubmit));
		
		//clientsubmit:2���ύ״̬������еĿͻ��ύ
//		CEntityClientSubmit cEntityClientSubmit=new CEntityClientSubmit.Builder().ClientSubmitState(0).build();
//		System.out.println(tt.queryAllClientSubmitByClientSubmitState(cEntityClientSubmit));

	
		/*
		 * -------------------------------�ݷüƻ�visitplan----------------------------------
		 */	
		//visitplan:1���Ӱݷüƻ�
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityClient cEntityClient=new CEntityClient.Builder().ClientId(2).build();
//		CEntityVisitPlan cEntityVisitPlan=new CEntityVisitPlan.Builder().VisitPlanCycle(0).VisitPlanCycleNumber(1).build();
//		System.out.println(tt.saveVisitPlan(cEntityClient, cEntityEmployee, cEntityVisitPlan));

		
		//visitplan:2��Ա���Ż�����еİݷüƻ�
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		System.out.println(tt.queryAllVisitPlanByEmployeeId(cEntityEmployee));
		
		/*
		 * ------------------------------�ݷ��ܽ� visitconclusion-------------------------------------
		 */	
		
		//visitconclusion:1���Ӱݷ��ܽ�
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityVisitPlan cEntityVisitPlan=new CEntityVisitPlan.Builder().VisitPlanId(1).build();
//		CEntityVisitConclusion cEntityVisitConclusion=new CEntityVisitConclusion.Builder().VisitAccessoryPath("pathone").VisitCheck(0).VisitCommand("commandone").VisitSubmitTime("subtimewone").VisitSummary("summaryone").build();
//		System.out.println(tt.saveVisitConclusion(cEntityEmployee, cEntityVisitPlan, cEntityVisitConclusion));
		
		//visitconclusion:2��Ա���Ż�����еİݷ��ܽ�
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		System.out.println(tt.queryAllVisitConclusionByEmployeeId(cEntityEmployee));
		
		/*
		 * ------------------------------�ݷó��� visitconclusion-------------------------------------
		 */	
		
		//visitundo:1����һ���ݷó���
//		CEntityVisitPlan cEntityVisitPlan=new CEntityVisitPlan.Builder().VisitPlanId(1).build();
//		CEntityVisitUndo cEntityVisitUndo=new CEntityVisitUndo.Builder().VisitUndoReason("ressonone").VisitUndoTime("timeone").VisitUndoType(0).build();
//		System.out.println(tt.saveVisitUndo(cEntityVisitPlan, cEntityVisitUndo));
	
		//visitundo:2������еİݷó���
//		CEntityVisitUndoArray cEntityVisitUndoArray=tt.queryAllVisitUndo();
//		System.out.println(cEntityVisitUndoArray.getSize());

		/*
		 * -----------------------------�ݷ�����visitdelay-------------------------------------
		 */
		//visitdealy:1����һ���ݷ�����
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityVisitPlan cEntityVisitPlan=new CEntityVisitPlan.Builder().VisitPlanId(1).build();
//		CEntityVisitDelay cEntityVisitDelay=new CEntityVisitDelay.Builder().VisitDelayDeadline("deadlieone").VisitDelayTime("timeone").build();
//		System.out.println(tt.saveVisitDealy(cEntityEmployee, cEntityVisitPlan, cEntityVisitDelay));
		
		//visitdealy:2������аݷ�����
//		CEntityVisitDealyArray cEntityVisitDealyArray=tt.queryAllVisitDelay();
//		System.out.println(cEntityVisitDealyArray.getSize());

		/*
		 * -----------------------------����bussiness------------------------------------
		 */
		//bussiness:1����һ������
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityBussiness cEntityBussiness=new CEntityBussiness.Builder().BussinessContent("contentone").BussinessSideAddress("addressone").BussinessState(0).build();
//		System.out.println(tt.saveBussiness(cEntityEmployee, cEntityBussiness));
		
		//bussiness:2��Ա���Ż�����еĳ���
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntityBussinessArray cEntityBussinessArray=tt.queryAllBussinessByEmployeeId(cEntityEmployee);
//		System.out.println(cEntityBussinessArray.getSize());
	
		/*
		 * -----------------------------����bussinessactivity------------------------------------
		 */
		//bussinessactivity:1����һ������
//		CEntityBussiness cEntityBussiness=new CEntityBussiness.Builder().BussinessId(1).build();
//		CEntityBussinessActivity cEntityBussinessActivity=new CEntityBussinessActivity.Builder().BussinessActivityType(0).BussinessBindType(0).BussinessObjectId(1).build();
//		System.out.println(tt.saveBussinessActivity(cEntityBussinessActivity, cEntityBussiness));
		
		//bussinessactivity:2������Ż�����еĳ���
//		CEntityBussiness cEntityBussiness=new CEntityBussiness.Builder().BussinessId(1).build();
//		System.out.println(tt.queryAllBussinessActivityByBussinessId(cEntityBussiness).getSize());
	
		/*
		 * -----------------------------�������¼bussinessbadrecord------------------------------------
		 */
		//bussinessbadrecord:1����һ���������¼
//		CEntityBussiness cEntityBussiness=new CEntityBussiness.Builder().BussinessId(1).build();
//		CEntityBussinessBadrecord cEntityBussinessBadrecord=new CEntityBussinessBadrecord.Builder().BussinessBadrecordReason("reasonone").BussinessBadrecordTime("timeone").build();
//		System.out.println(tt.saveBussinessBadrecord(cEntityBussiness, cEntityBussinessBadrecord));
		
	
		//bussinessbadrecord:2������еĳ������¼
//		CEntityBussinessBadrecordArray cEntityBussinessBadrecordArra=tt.queryAllBussinessBadrecord();
//		System.out.println(cEntityBussinessBadrecordArra.getSize());
	
		/*
		 * ----------------------------����attendance------------------------------------
		 */
		
		
		//attendance:1����һ������
		
		
		/*
		 * ----------------------------֪ͨ notice------------------------------------
		 */
		//notice:1����һ��֪ͨ
//		for(int i=0;i<100;i++){
//		CEntityNotice cEntityNotice=new CEntityNotice.Builder().NoticeContent("contentone").NoticeTime("timeone").NoticeTitle("titleone").build();
//		System.out.println(tt.saveNotice(cEntityNotice));
//		}
//		//notice:2���ȫ��֪ͨ
//		long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
//
//		CEntityNoticeArray cEntityNoticeArray=tt.queryAllNotice();
//		System.out.println(cEntityNoticeArray.getSize());
//		
//		long endTime=System.currentTimeMillis(); //��ȡ����ʱ��
//
//		System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");
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
//		long start2Time=System.currentTimeMillis();   //��ȡ��ʼʱ��
//		CEntityNoticeArray cEntityNoticeArray2=tt.queryAllNotice();
//		System.out.println(cEntityNoticeArray2.getSize());
//		
//
//		long end2Time=System.currentTimeMillis(); //��ȡ����ʱ��
//
//		System.out.println("��������ʱ�䣺 "+(end2Time-start2Time)+"ms");
//		
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		long start3Time=System.currentTimeMillis();   //��ȡ��ʼʱ��
//		CEntityNoticeArray cEntityNoticeArray3=tt.queryAllNotice();
//		System.out.println(cEntityNoticeArray3.getSize());
//		
//
//		long end3Time=System.currentTimeMillis(); //��ȡ����ʱ��
//
//		System.out.println("��������ʱ�䣺 "+(end3Time-start3Time)+"ms");
//		

		/*
		 * ----------------------------���� suggest----------------------------------
		 */
		//suggest:1����һ������
//		CEntityEmployee cEntityEmployee=new CEntityEmployee.Builder().EmployeeId(1).build();
//		CEntitySuggest cEntitySuggest=new CEntitySuggest.Builder().SuggestContent("contentone").SuggestTime("timeone").build();
//		System.out.println(tt.saveSuggest(cEntityEmployee, cEntitySuggest));

		//uggest:2������еĽ���
//		CEntitySuggestArray cEntitySuggestArray=tt.queryAllSuggest();
//		System.out.println(cEntitySuggestArray.getSize());
		
		
//		System.out.println(tt.sd());
		
	}
	
	

}
