package com.ad.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.ad.bll.IBllFrame;
import com.ad.entity.CEntityFund;
import com.ad.tool.MyOpcode;
import com.ad.tool.MySpring;

@SuppressWarnings("serial")
public class WGetUserSpecificFundInfo extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");

		int UserId=Integer.parseInt(request.getParameter(MyOpcode.User.UserId));
		String FundName=new String(request.getParameter(MyOpcode.Fund.FundName).getBytes("ISO-8859-1"),"utf-8");
		String FundCode=new String(request.getParameter(MyOpcode.Fund.FundCode).getBytes("ISO-8859-1"),"utf-8");
		int FundState=Integer.parseInt(request.getParameter(MyOpcode.Fund.FundState));
		int Page=Integer.parseInt(request.getParameter(MyOpcode.Operation.PAGE));

		PrintWriter out = response.getWriter();
		MySpring context=MySpring.getInstance();
		IBllFrame iBllFrame=(IBllFrame)context.getContext().getBean("cBllFrameImpl");
		
		CEntityFund cEntityFund=new CEntityFund();
		cEntityFund.setUserId(UserId);
		cEntityFund.setFundName(FundName);
		cEntityFund.setFundCode(FundCode);
		cEntityFund.setFundState(FundState);
		
		List<CEntityFund> findReuslt=iBllFrame.getUserSpecificFundInfo(cEntityFund, Page);
		JSONArray outjson=JSONArray.fromObject(findReuslt);
		
		out.println(outjson);
		System.out.println(outjson);
		out.flush();
		out.close();
		
	}

}
