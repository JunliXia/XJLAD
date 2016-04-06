package com.ad.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ad.bll.IBllFrame;
import com.ad.entity.CEntityUser;
import com.ad.tool.MyOpcode;
import com.ad.tool.MySpring;

import net.sf.json.JSONObject;

//×¢²áÓÃ»§
@SuppressWarnings("serial")
public class WCreateUser extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");

		String UserAccount=new String(request.getParameter(MyOpcode.User.UserAccount).getBytes("ISO-8859-1"),"utf-8");
		String UserName=new String(request.getParameter(MyOpcode.User.UserName).getBytes("ISO-8859-1"),"utf-8");
		String UserPassword=new String(request.getParameter(MyOpcode.User.UserPassword).getBytes("ISO-8859-1"),"utf-8");
		
		PrintWriter out = response.getWriter();
		MySpring context=MySpring.getInstance();
		IBllFrame iBllFrame=(IBllFrame)context.getContext().getBean("cBllFrameImpl");
		CEntityUser cEntityUser=new CEntityUser();
		cEntityUser.setUserAccount(UserAccount);
		cEntityUser.setUserName(UserName);
		cEntityUser.setUserPassword(UserPassword);
		boolean bisCreate=iBllFrame.createUser(cEntityUser);
		JSONObject outjson=new JSONObject();
		outjson.put("check", bisCreate);
		System.out.println(outjson);
		out.println(outjson);
		out.flush();
		out.close();
	}

}
