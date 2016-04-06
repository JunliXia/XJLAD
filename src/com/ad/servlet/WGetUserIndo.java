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

@SuppressWarnings("serial")
public class WGetUserIndo extends HttpServlet {


	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");

		String UserAccount=new String(request.getParameter(MyOpcode.User.UserAccount).getBytes("ISO-8859-1"),"utf-8");
	
		PrintWriter out = response.getWriter();
		MySpring context=MySpring.getInstance();
		IBllFrame iBllFrame=(IBllFrame)context.getContext().getBean("cBllFrameImpl");
		CEntityUser cEntityUser=new CEntityUser();
		cEntityUser.setUserAccount(UserAccount);
		CEntityUser findResult=iBllFrame.getUserInfo(cEntityUser);
		JSONObject outjson=new JSONObject();
		outjson.put(MyOpcode.Operation.CHECK, true);
		outjson.put(MyOpcode.User.UserId, findResult.getUserId());
		outjson.put(MyOpcode.User.UserName, findResult.getUserName());
		outjson.put(MyOpcode.User.UserAccount, findResult.getUserAccount());
		outjson.put(MyOpcode.User.UserPassword, findResult.getUserPassword());
		
		System.out.println(outjson);
		out.println(outjson);
		out.flush();
		out.close();
	}

}
