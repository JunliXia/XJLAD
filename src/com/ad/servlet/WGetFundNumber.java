package com.ad.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.ad.bll.IBllFrame;
import com.ad.entity.CEntityUser;
import com.ad.tool.MyConstant;
import com.ad.tool.MyOpcode;
import com.ad.tool.MySpring;
//获得基金数
@SuppressWarnings("serial")
public class WGetFundNumber extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");

		
		int UserId=Integer.parseInt(request.getParameter(MyOpcode.User.UserId));
		int FundState=Integer.parseInt(request.getParameter(MyOpcode.Fund.FundState));
		PrintWriter out = response.getWriter();
		MySpring context=MySpring.getInstance();
		IBllFrame iBllFrame=(IBllFrame)context.getContext().getBean("cBllFrameImpl");
		CEntityUser cEntityUser=new CEntityUser();
		cEntityUser.setUserId(UserId);
	
		int count=iBllFrame.getUserFundNumer(cEntityUser, FundState);
		int page=count/MyConstant.Paging.PageLength+1;
		JSONObject outjson=new JSONObject();
		outjson.put("FundNumber", page);
		
		System.out.println("FundNumber------------"+page);
		System.out.println(outjson);
		
		out.println(outjson);
		out.flush();
		out.close();
	}

}
