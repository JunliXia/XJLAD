package com.ad.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.ad.bll.IBllFrame;
import com.ad.entity.CEntityFund;
import com.ad.tool.MyOpcode;
import com.ad.tool.MySpring;

@SuppressWarnings("serial")
public class WSellFund extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");

		int FundId=Integer.parseInt(request.getParameter(MyOpcode.Fund.FundId));
		double FundShares=Double.parseDouble(request.getParameter(MyOpcode.Fund.FundShares));
		String FundSellDate=new String(request.getParameter(MyOpcode.Fund.FundSellDate).getBytes("ISO-8859-1"),"utf-8");
		double FundSellNetValue=Double.parseDouble(request.getParameter(MyOpcode.Fund.FundSellNetValue));
		double FundSellFee=Double.parseDouble(request.getParameter(MyOpcode.Fund.FundSellFee));
		
		PrintWriter out = response.getWriter();
		MySpring context=MySpring.getInstance();
		IBllFrame iBllFrame=(IBllFrame)context.getContext().getBean("cBllFrameImpl");
	
		CEntityFund cEntityFund=new CEntityFund();
		cEntityFund.setFundId(FundId);
		cEntityFund.setFundShares(FundShares);
		cEntityFund.setFundSellDate(FundSellDate);
		cEntityFund.setFundSellNetValue(FundSellNetValue);
		cEntityFund.setFundSellFee(FundSellFee);
		
		boolean bisSell=iBllFrame.sellFund(cEntityFund);
		
		JSONObject outjson=new JSONObject();
		outjson.put(MyOpcode.Operation.CHECK, bisSell);
		System.out.println(outjson);
		out.println(outjson);
		out.flush();
		out.close();
		
	}

}
