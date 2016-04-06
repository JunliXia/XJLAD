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
import com.ad.tool.MyOpcode;
import com.ad.tool.MySpring;
//ÓÃ»§µÇÂ¼
@SuppressWarnings("serial")
public class WLogin extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");

		String UserAccount=new String(request.getParameter(MyOpcode.User.UserAccount).getBytes("ISO-8859-1"),"utf-8");
		String UserPassword=new String(request.getParameter(MyOpcode.User.UserPassword).getBytes("ISO-8859-1"),"utf-8");
		
		PrintWriter out = response.getWriter();
		MySpring context=MySpring.getInstance();
		IBllFrame iBllFrame=(IBllFrame)context.getContext().getBean("cBllFrameImpl");
		CEntityUser cEntityUser=new CEntityUser();
		cEntityUser.setUserAccount(UserAccount);
		cEntityUser.setUserPassword(UserPassword);
		boolean bisLogin=iBllFrame.loginUser(cEntityUser);
		JSONObject outjson=new JSONObject();
		outjson.put("check", bisLogin);
		System.out.println(outjson);
		out.println(outjson);
		out.flush();
		out.close();
	}

}
