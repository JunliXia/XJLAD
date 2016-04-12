
$(document).ready(function() {
//	alert("我也出发")
//	$.getJSON("./WGetUserIndo",{
//		UserAccount:UserAccount,
//	},function(outjson){
//		if(outjson.check==true){
//			UserName=outjson.UserName;
//		}else if(outjson.check==false){
//		}
//	})
	
	
	
	

})



function fundSpecificPageNumber(FundState,FundName,FundCode){
	 $.getJSON("./WGetUserSpecificFundNumber",{UserId:UserId,FundState:FundState,FundName:FundName,FundCode:FundCode},function(outjson){
		 pageCountRealForVoluation=outjson.FundNumber;
	});	
}

function valuationfundsimple() {
	var x=curtab;
	if(x==null){
		alert("请选择需要估值的基金")
	}else{
		$(".shadow").show();
		$(".pagehead font").html("基金估值")
		$(".showpage").css("width","280px");
		$(".showpage").css("height","270px");
		$(".showpage").css("margin-left","600px");
		$(".pagemain").html("<div class=userset>"+
//	  				"<div><a>基金号:</a><input id=fundId disabled='disabled' type='text' style='margin-left: 29px;'value='"+$(x).find("th").eq(0).html()+"' /></div>"+
	  				"<div><a>基金名:</a><input id='fundseachnameId'  disabled='disabled' type='text' style='margin-left: 29px;' value='"+$(x).find("th").eq(0).html()+"'/></div>"+
	  				"<div><a>基金代码：</a><input  type='text'  disabled='disabled' id='fundcodeId'  value='"+$(x).find("th").eq(1).html()+"'/></div>"+
	  				"<div><a>昨日净值：</a><input  type='text' id='fundyesterdayvalue'/></div>"+
//	  				"<div><a>今日涨幅：</a><input  type='text' id='fundtodaygains'/></div>"+
	  				"<div><a>手续费率：</a><input  type='text' id='fundfeerate'/></div>"+
	  	  			
	  				"<div style='margin-left: 30px;margin-top: 10px;'><button onclick='valuationfundsimpleOK()' class=but1>确定</button><button class=but1 onclick='closepage()'>取消</button></div>"+
	  				"</div>");
		
		var FundName= $(x).find("th").eq(0).html();
		var FundCode= $(x).find("th").eq(1).html()
		//得到页数
		fundSpecificPageNumber(0, FundName, FundCode)
//		//得到第一页数据

	}
}




function valuationfund() {
	var x=curtab;
	if(x==null){
		alert("请选择需要估值的基金")
	}else{
		$(".shadow").show();
		$(".pagehead font").html("基金估值")
		$(".showpage").css("width","280px");
		$(".showpage").css("height","270px");
		$(".showpage").css("margin-left","600px");
		$(".pagemain").html("<div class=userset>"+
//	  				"<div><a>基金号:</a><input id=fundId disabled='disabled' type='text' style='margin-left: 29px;'value='"+$(x).find("th").eq(0).html()+"' /></div>"+
	  				"<div><a>基金名:</a><input id='fundseachnameId'  disabled='disabled' type='text' style='margin-left: 29px;' value='"+$(x).find("th").eq(0).html()+"'/></div>"+
	  				"<div><a>基金代码：</a><input  type='text'  disabled='disabled' id='fundcodeId'  value='"+$(x).find("th").eq(1).html()+"'/></div>"+
	  				"<div><a>昨日净值：</a><input  type='text' id='fundyesterdayvalue'/></div>"+
	  				"<div><a>今日涨幅：</a><input  type='text' id='fundtodaygains'/></div>"+
	  				"<div><a>手续费率：</a><input  type='text' id='fundfeerate'/></div>"+
	  	  			
	  				"<div style='margin-left: 30px;margin-top: 10px;'><button onclick='valuationfundOk()' class=but1>确定</button><button class=but1 onclick='closepage()'>取消</button></div>"+
	  				"</div>");
		
		var FundName= $(x).find("th").eq(0).html();
		var FundCode= $(x).find("th").eq(1).html()
		//得到页数
		fundSpecificPageNumber(0, FundName, FundCode)
//		//得到第一页数据

	}
}

function valuationfundsimpleOK() {
	closepage();
	
	var FundName=$("#fundseachnameId").val();
	var FundCode=$("#fundcodeId").val();
	var FundYesterdayNetValue=$("#fundyesterdayvalue").val();	//昨日净值
//	var FundTodayGains=$("#fundtodaygains").val();				//今日涨幅
	var FundFeeRate=$("#fundfeerate").val();					//手续费率
	 $(".group-listfund").html("");
		$(".group-listfund").append('<div class="group-one" style="height:100%;background-color: rgb(248,254,254);"> '+
			'<img src="./pic/back.png" style="height:30px;width:20px;cursor: pointer;margin-left:20px;margin-bottom:-40px;" onclick="showfundvaluation()"></img>'+
			'<div class="group-title"><font>'+FundName+'基金估算表</font>'+ 
			"<div id=butclient style='height:25px;width:350px;float:right;margin-top:-20px; margin-left:900px;'>" +
		"</div>"+
			'</div>'+
			'<table id="tabclient" style="font-size:13px;" width="100%">'+
	        '<tbody>'+
	         '<tr style="height:20x;background-color:rgb(178,243,238);font-size:13px;color:rgb(60,60,60;">'+
	           	 '<th>基金号</th>'+
	         	 '<th>基金名</th>'+
	         	 '<th>基金代码</th>'+
	             '<th>基金金额</th>'+
	             '<th>基金份额</th>'+
	             '<th>基金净值</th>'+
	             '<th>基金买入日期</th>'+
	             '<th>基金买入手续费</th>'+
	             '<th>待需净值</th>'+
	             '<th>待需盈利率</th>'+
//	             '<th>估值盈利金额</th>'+
//	             '<th>估值金额</th>'+
	         '</tr>'+
	         '</tbody>'+
	         
	          
	         '<tbody  class="thisgroup">'+
	         	
	         '</tbody>'+
	         '</table>'+
	      
	        ' <div style="margin-bottom:-10px;margin-left:300px" class="tcdPageCode"></div>'+
	         
		'</div>');
		
		 $.getJSON("./WGetUserSpecificFundInfo",{UserId:UserId,page:1,FundState:0,FundName:FundName,FundCode:FundCode},function(outjson){
     	for ( var i = 0; i < outjson.length; i++) {
     		var one=1;
     		//待需净值净值=买入净值*（1+基金盈利点+手续费率）
     		var waitneednetvlaue=(parseFloat(outjson[i].fundNetValue)*(parseFloat(one)+parseFloat(outjson[i].fundProfitLimit)/100+parseFloat(FundFeeRate))).toFixed(4);
     		//待需盈利率=((待需净值净值/昨日净值)-1)*100
     		var waitneedrate=(waitneednetvlaue/FundYesterdayNetValue-1)*100
     		$(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;" style="height:20x;font-size:12px;font-weight: normal;background-color: rgb(232,251,250);-moz-user-select:none;" FundId='+outjson[i].fundId+'>'+
     				'<th style="font-weight: normal">'+outjson[i].fundId+'</th>'+
     				'<th style="font-weight: normal">'+outjson[i].fundName+'</th>'+
     				'<th style="font-weight: normal">'+outjson[i].fundCode+'</th>'+
     			    '<th style="font-weight: normal">'+outjson[i].fundAmount+'</th>'+
     			    '<th style="font-weight: normal">'+outjson[i].fundShares+'</th>'+
     			    '<th style="font-weight: normal">'+outjson[i].fundNetValue+'</th>'+
     			    '<th style="font-weight: normal">'+outjson[i].fundBuyDate+'</th>'+
     			    '<th style="font-weight: normal">'+outjson[i].fundBuyFee+'</th>'+
     			    '<th style="font-weight: normal">'+waitneednetvlaue+'</th>'+
     			    '<th style="font-weight: normal">'+waitneedrate+'</th>'+
     				'</tr>')
     	}
	});	
		
		  $(".tcdPageCode").createPage({
		        pageCount:pageCountRealForVoluation,
		        current:1,
		        backFn:function(p){
		            console.log(p);
		            $(".thisgroup").html("")
		            
		            $.getJSON("./WGetUserSpecificFundInfo",{UserId:UserId,page:p,FundState:0,FundName:FundName,FundCode:FundCode},function(outjson){
		            	for ( var i = 0; i < outjson.length; i++) {
		            		var one=1;
		            		//待需净值净值=买入净值*（1+基金盈利点+手续费率）
		             		var waitneednetvlaue=(parseFloat(outjson[i].fundNetValue)*(parseFloat(one)+parseFloat(outjson[i].fundProfitLimit)/100+parseFloat(FundFeeRate))).toFixed(4);
		             		//待需盈利率=((待需净值净值/昨日净值)-1)*100
		             		var waitneedrate=(waitneednetvlaue/FundYesterdayNetValue-1)*100
		             		$(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;" style="height:20x;font-size:12px;font-weight: normal;background-color: rgb(232,251,250);-moz-user-select:none;" FundId='+outjson[i].fundId+'>'+
		             				'<th style="font-weight: normal">'+outjson[i].fundId+'</th>'+
		             				'<th style="font-weight: normal">'+outjson[i].fundName+'</th>'+
		             				'<th style="font-weight: normal">'+outjson[i].fundCode+'</th>'+
		             			    '<th style="font-weight: normal">'+outjson[i].fundAmount+'</th>'+
		             			    '<th style="font-weight: normal">'+outjson[i].fundShares+'</th>'+
		             			    '<th style="font-weight: normal">'+outjson[i].fundNetValue+'</th>'+
		             			    '<th style="font-weight: normal">'+outjson[i].fundBuyDate+'</th>'+
		             			    '<th style="font-weight: normal">'+outjson[i].fundBuyFee+'</th>'+
		             			    '<th style="font-weight: normal">'+waitneednetvlaue+'</th>'+
		             			    '<th style="font-weight: normal">'+waitneedrate+'</th>'+
		             				'</tr>')
		             	}
		    	});	
		        }
		    });

	
}


function valuationfundOk() {
	closepage();
	
	var FundName=$("#fundseachnameId").val();
	var FundCode=$("#fundcodeId").val();
	var FundYesterdayNetValue=$("#fundyesterdayvalue").val();	//昨日净值
	var FundTodayGains=$("#fundtodaygains").val();				//今日涨幅
	var FundFeeRate=$("#fundfeerate").val();					//手续费率
	 $(".group-listfund").html("");
		$(".group-listfund").append('<div class="group-one" style="height:100%;background-color: rgb(248,254,254);"> '+
			'<img src="./pic/back.png" style="height:30px;width:20px;cursor: pointer;margin-left:20px;margin-bottom:-40px;" onclick="showfundvaluation()"></img>'+
			'<div class="group-title"><font>'+FundName+'基金估算表</font>'+ 
			"<div id=butclient style='height:25px;width:350px;float:right;margin-top:-20px; margin-left:900px;'>" +
//			"<div class=usebut  style=' cursor:pointer; position: relative;' onclick='sellfund()'>卖出</div>"+
//			"<div class=usebut  style=' cursor:pointer; position: relative;' onclick='valuationfund()'>估值</div>"+
//			"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='updateclient()'>修改</div>"+
//			"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='seeclient()'>查看</div>"+
//			"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='delclient()'>删除</div>"+
		"</div>"+
			'</div>'+
			'<table id="tabclient" style="font-size:13px;" width="100%">'+
	        '<tbody>'+
	         '<tr style="height:20x;background-color:rgb(178,243,238);font-size:13px;color:rgb(60,60,60;">'+
	           	 '<th>基金号</th>'+
	         	 '<th>基金名</th>'+
	         	 '<th>基金代码</th>'+
	             '<th>基金金额</th>'+
	             '<th>基金份额</th>'+
	             '<th>基金净值</th>'+
	             '<th>基金买入日期</th>'+
	             '<th>基金买入手续费</th>'+
	             '<th>估值净值</th>'+
	             '<th>估值盈利率</th>'+
	             '<th>估值盈利金额</th>'+
	             '<th>估值金额</th>'+
//	             '<th>基金盈利点</th>'+
//	             '<th>基金止损点</th>'+
//	             '<th>基金卖出日期</th>'+
//	             '<th>基金卖出手续费</th>'+
	         '</tr>'+
	         '</tbody>'+
	         
	          
	         '<tbody  class="thisgroup">'+
	         	
	         '</tbody>'+
	         '</table>'+
	      
	        ' <div style="margin-bottom:-10px;margin-left:300px" class="tcdPageCode"></div>'+
	         
		'</div>');
		
		 $.getJSON("./WGetUserSpecificFundInfo",{UserId:UserId,page:1,FundState:0,FundName:FundName,FundCode:FundCode},function(outjson){
     	for ( var i = 0; i < outjson.length; i++) {
     		var one=1;
//     		alert("昨日净值--"+FundYesterdayNetValue+"--今日涨幅---"+FundTodayGains)
     		
     		//估值金额=（昨日净值*（1+今日涨幅））*基金份额
     		var valuationamount=(FundYesterdayNetValue*(parseFloat(one)+parseFloat(FundTodayGains)))*outjson[i].fundShares;
//     		alert("1+FundTodayGains=="+(parseFloat+parseFloat(FundTodayGains))+"昨日净值=="+FundYesterdayNetValue+"--1+今日涨幅=="+FundTodayGains+"---基金份额=="+outjson[i].fundShares)
     		
     		//估值盈利金额=估值金额*（1-手续费率）-基金金额-基金买入手续费
     		var valuationprofitamount=valuationamount*(one-FundFeeRate)-outjson[i].fundAmount-outjson[i].fundBuyFee;
     		
     		//估值盈利率=估值盈利金额/(基金金额+基金买入手续费)*100
     		var valuationgainsrate=valuationprofitamount/(parseFloat(outjson[i].fundAmount)+parseFloat(outjson[i].fundBuyFee));
     		
     		$(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;" style="height:20x;font-size:12px;font-weight: normal;background-color: rgb(232,251,250);-moz-user-select:none;" FundId='+outjson[i].fundId+'>'+
     				'<th style="font-weight: normal">'+outjson[i].fundId+'</th>'+
     				'<th style="font-weight: normal">'+outjson[i].fundName+'</th>'+
     				'<th style="font-weight: normal">'+outjson[i].fundCode+'</th>'+
     			    '<th style="font-weight: normal">'+outjson[i].fundAmount+'</th>'+
     			    '<th style="font-weight: normal">'+outjson[i].fundShares+'</th>'+
     			    '<th style="font-weight: normal">'+outjson[i].fundNetValue+'</th>'+
     			    '<th style="font-weight: normal">'+outjson[i].fundBuyDate+'</th>'+
     			    '<th style="font-weight: normal">'+outjson[i].fundBuyFee+'</th>'+
     			    '<th style="font-weight: normal">'+(FundYesterdayNetValue*(parseFloat(one)+parseFloat(FundTodayGains))).toFixed(4)+'</th>'+
     			    '<th style="font-weight: normal">'+valuationgainsrate.toFixed(4)+'</th>'+
     			    '<th style="font-weight: normal">'+valuationprofitamount.toFixed(4)+'</th>'+
     			    '<th style="font-weight: normal">'+valuationamount.toFixed(4)+'</th>'+
//     			    '<th style="font-weight: normal">'+outjson[i].fundProfitLimit+'</th>'+
//     			    '<th style="font-weight: normal">'+outjson[i].fundLossLimit+'</th>'+
//     			    '<th style="font-weight: normal">'+outjson[i].fundSellDate+'</th>'+
//     			    '<th style="font-weight: normal">'+outjson[i].fundSellFee+'</th>'+
//     				'<th style="font-weight: normal; display:none;">'+outjson[i].ClientId+'</th>'+
     				'</tr>')
     	}
	});	
		
		  $(".tcdPageCode").createPage({
		        pageCount:pageCountRealForVoluation,
		        current:1,
		        backFn:function(p){
		            console.log(p);
		            $(".thisgroup").html("")
		            
		            $.getJSON("./WGetUserSpecificFundInfo",{UserId:UserId,page:p,FundState:0,FundName:FundName,FundCode:FundCode},function(outjson){
		            	for ( var i = 0; i < outjson.length; i++) {
		            		var one=1;
		            		//估值金额=（昨日净值*（1+今日涨幅））*基金份额
		            		var valuationamount=(FundYesterdayNetValue*(parseFloat(one)+parseFloat(FundTodayGains)))*outjson[i].fundShares;
		             		//估值盈利金额=估值金额*（1-手续费率）-基金金额-基金买入手续费
		             		var valuationprofitamount=valuationamount*(1-FundFeeRate)-outjson[i].fundAmount-outjson[i].fundBuyFee;
		             		//估值盈利率=估值盈利金额/(基金金额+基金买入手续费)
		             		var valuationgainsrate=valuationprofitamount/(outjson[i].fundAmount+outjson[i].fundBuyFee);
		             		$(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;" style="height:20x;font-size:12px;font-weight: normal;background-color: rgb(232,251,250);-moz-user-select:none;" FundId='+outjson[i].fundId+'>'+
		             				'<th style="font-weight: normal">'+outjson[i].fundId+'</th>'+
		             				'<th style="font-weight: normal">'+outjson[i].fundName+'</th>'+
		             				'<th style="font-weight: normal">'+outjson[i].fundCode+'</th>'+
		             			    '<th style="font-weight: normal">'+outjson[i].fundAmount+'</th>'+
		             			    '<th style="font-weight: normal">'+outjson[i].fundShares+'</th>'+
		             			    '<th style="font-weight: normal">'+outjson[i].fundNetValue+'</th>'+
		             			    '<th style="font-weight: normal">'+outjson[i].fundBuyDate+'</th>'+
		             			    '<th style="font-weight: normal">'+outjson[i].fundBuyFee+'</th>'+
		             			   '<th style="font-weight: normal">'+(FundYesterdayNetValue*(parseFloat(one)+parseFloat(FundTodayGains))).toFixed(4)+'</th>'+
		             			    '<th style="font-weight: normal">'+valuationamount+'</th>'+
		             			    '<th style="font-weight: normal">'+valuationprofitamount+'</th>'+
		             			    '<th style="font-weight: normal">'+valuationgainsrate+'</th>'+
//		             			    '<th style="font-weight: normal">'+outjson[i].fundProfitLimit+'</th>'+
//		             			    '<th style="font-weight: normal">'+outjson[i].fundLossLimit+'</th>'+
//		             			    '<th style="font-weight: normal">'+outjson[i].fundSellDate+'</th>'+
//		             			    '<th style="font-weight: normal">'+outjson[i].fundSellFee+'</th>'+
//		             				'<th style="font-weight: normal; display:none;">'+outjson[i].ClientId+'</th>'+
		             				'</tr>')
		             	}
		    	});	
		        }
		    });

	
}



function showfundvaluation() {
	 $(".group-listfund").html("");
		$(".group-listfund").append('<div class="group-one" style="height:100%;background-color: rgb(248,254,254);"> '+
			'<img src="./pic/back.png" style="height:30px;width:20px;cursor: pointer;margin-left:20px;margin-bottom:-40px;" onclick="showback()"></img>'+
			'<div class="group-title"><font>所持基金估值表</font>'+ 
			"<div id=butclient style='height:25px;width:350px;float:right;margin-top:-20px; margin-left:900px;'>" +
//			"<div class=usebut  style=' cursor:pointer; position: relative;' onclick='sellfund()'>卖出</div>"+
			"<div class=usebut  style=' cursor:pointer; position: relative;' onclick='valuationfund()'>估值</div>"+
			"<div class=usebut  style=' cursor:pointer; position: relative;' onclick='valuationfundsimple()'>简易估值</div>"+
//			"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='updateclient()'>修改</div>"+
//			"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='seeclient()'>查看</div>"+
//			"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='delclient()'>删除</div>"+
		"</div>"+
			'</div>'+
			'<table id="tabclient" style="font-size:13px;" width="100%">'+
	        '<tbody>'+
	         '<tr style="height:20x;background-color:rgb(178,243,238);font-size:13px;color:rgb(60,60,60;">'+
//	           	 '<th>基金号</th>'+
	         	 '<th>基金名</th>'+
	         	 '<th>基金代码</th>'+
//	             '<th>基金金额</th>'+
//	             '<th>基金份额</th>'+
//	             '<th>基金净值</th>'+
//	             '<th>基金买入日期</th>'+
//	             '<th>基金买入手续费</th>'+
//	             '<th>基金盈利点</th>'+
//	             '<th>基金止损点</th>'+
//	             '<th>基金卖出日期</th>'+
//	             '<th>基金卖出手续费</th>'+
	             '<th>持有基金数</th>'+
	         '</tr>'+
	         '</tbody>'+
	         
	          
	         '<tbody  class="thisgroup">'+
	         	
	         '</tbody>'+
	         '</table>'+
	      
	        ' <div style="margin-bottom:-10px;margin-left:300px" class="tcdPageCode"></div>'+
	         
		'</div>');
//		  var currentPage=1;
//		  $(".tcdPageCode").createPage({
//		        pageCount:pageCountReal,
//		        current:1,
//		        backFn:function(p){
//		            console.log(p);
//		            $(".thisgroup").html("")
//		            
		            $.getJSON("./WGetUserFundBuyNameCodeNumber",{UserId:UserId},function(outjson){
		            	for ( var i = 0; i < outjson.length; i++) {
		            		
		            		$(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;" style="height:20x;font-size:12px;font-weight: normal;background-color: rgb(232,251,250);-moz-user-select:none;" FundId='+outjson[i].fundId+'>'+
//		            				'<th style="font-weight: normal">'+outjson[i].fundId+'</th>'+
		            				'<th style="font-weight: normal">'+outjson[i][0]+'</th>'+
		            				'<th style="font-weight: normal">'+outjson[i][1]+'</th>'+
		            				'<th style="font-weight: normal">'+outjson[i][2]+'</th>'+
//		            			    '<th style="font-weight: normal">'+outjson[i].fundAmount+'</th>'+
//		            			    '<th style="font-weight: normal">'+outjson[i].fundShares+'</th>'+
//		            			    '<th style="font-weight: normal">'+outjson[i].fundNetValue+'</th>'+
//		            			    '<th style="font-weight: normal">'+outjson[i].fundBuyDate+'</th>'+
//		            			    '<th style="font-weight: normal">'+outjson[i].fundBuyFee+'</th>'+
//		            			    '<th style="font-weight: normal">'+outjson[i].fundProfitLimit+'</th>'+
//		            			    '<th style="font-weight: normal">'+outjson[i].fundLossLimit+'</th>'+
//		            			    '<th style="font-weight: normal">'+outjson[i].fundSellDate+'</th>'+
//		            			    '<th style="font-weight: normal">'+outjson[i].fundSellFee+'</th>'+
//		            				'<th style="font-weight: normal; display:none;">'+outjson[i].ClientId+'</th>'+
		            				'</tr>')
		            	}
		    	});	
//		        }
//		    });


}




