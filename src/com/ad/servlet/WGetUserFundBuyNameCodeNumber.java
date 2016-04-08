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
public class WGetUserFundBuyNameCodeNumber extends HttpServlet {

	
	@SuppressWarnings("unchecked")
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");

		
		int UserId=Integer.parseInt(request.getParameter(MyOpcode.User.UserId));
		PrintWriter out = response.getWriter();
		MySpring context=MySpring.getInstance();
		IBllFrame iBllFrame=(IBllFrame)context.getContext().getBean("cBllFrameImpl");
		CEntityFund cEntityFund=new CEntityFund();
		cEntityFund.setUserId(UserId);
		
		List findResult=iBllFrame.getUserFundNameCodeNumber(cEntityFund);
		
		JSONArray outjson=JSONArray.fromObject(findResult);
		out.println(outjson);
		System.out.println(outjson);
		out.flush();
		out.close();
		
	}

}
