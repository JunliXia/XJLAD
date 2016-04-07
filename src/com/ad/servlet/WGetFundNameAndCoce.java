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
import com.ad.entity.CEntityUser;
import com.ad.tool.MyOpcode;
import com.ad.tool.MySpring;

@SuppressWarnings("serial")
public class WGetFundNameAndCoce extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");

		
		int UserId=Integer.parseInt(request.getParameter(MyOpcode.User.UserId));
	
		PrintWriter out = response.getWriter();
		MySpring context=MySpring.getInstance();
		IBllFrame iBllFrame=(IBllFrame)context.getContext().getBean("cBllFrameImpl");
		CEntityUser cEntityUser=new CEntityUser();
		cEntityUser.setUserId(UserId);
	
		List findResult=iBllFrame.getFundNameAndCode(cEntityUser);
		JSONArray outjson=JSONArray.fromObject(findResult);
		System.out.println(outjson);
		
		out.println(outjson);
		out.flush();
		out.close();
		
	}

}
