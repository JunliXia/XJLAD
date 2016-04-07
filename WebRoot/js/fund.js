var str;
var arrFundName=new Array();
var arrFundCode=new Array();
var UserName=""
	
var pageCountReal;
var FundStateBuy=0;
var FundStateSell=1;



//var FundState=0;
$(document).ready(function() {
	$.getJSON("./WGetUserIndo",{
		UserAccount:UserAccount,
	},function(outjson){
		if(outjson.check==true){
			UserName=outjson.UserName;
		}else if(outjson.check==false){
		}
	})
	
	
	
	
	
	//获得基金数
	getFundNumber(FundStateBuy);

	setTimeout(showmainfundtitle,500);
	setTimeout(showfundouttime(FundStateBuy),500);
	setTimeout(showfundPageOneouttime(FundStateBuy),500);
	
	
	$.getJSON("./WGetFundNameAndCoce",{
		UserId:UserId,
	},function(outjson){
		for(var i=0;i<outjson.length;i++){
			arrFundName.push(outjson[i][0]);
			arrFundCode.push(outjson[i][1]);
		}
	})
	


})

//带参数延迟写法
function showfundouttime(FundState) {
	  return function()  
	  
      {  
		  showfund(FundState);  
	
      }  
}


function showfundPageOneouttime(FundState) {
	return function() {
		 fundPageOne(FundState);
	}
}

//触发第一页数据
function fundPageOne(FundState) {
	if(FundState==FundStateBuy){
		 $(".thisgroup").html("");
		  $.getJSON("./WGetUserFund",{UserId:UserId,page:1,FundState:FundState},function(outjson){
				for ( var i = 0; i < outjson.length; i++) {
				$(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;" style="height:20x;font-size:12px;font-weight: normal;background-color: rgb(232,251,250);-moz-user-select:none;" FundId='+outjson[i].fundId+'>'+
						'<th style="font-weight: normal">'+outjson[i].fundId+'</th>'+
						'<th style="font-weight: normal">'+outjson[i].fundName+'</th>'+
						'<th style="font-weight: normal">'+outjson[i].fundCode+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundAmount+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundShares+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundNetValue+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundBuyDate+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundBuyFee+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundProfitLimit+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundLossLimit+'</th>'+
//					    '<th style="font-weight: normal">'+outjson[i].fundSellDate+'</th>'+
//					    '<th style="font-weight: normal">'+outjson[i].fundSellFee+'</th>'+
//						'<th style="font-weight: normal; display:none;">'+outjson[i].ClientId+'</th>'+
						'</tr>')
			}
		});	
	}else if(FundState==FundStateSell){
		 $(".thisgroup").html("");
		  $.getJSON("./WGetUserFund",{UserId:UserId,page:1,FundState:FundState},function(outjson){
				for ( var i = 0; i < outjson.length; i++) {
				$(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;" style="height:20x;font-size:12px;font-weight: normal;background-color: rgb(232,251,250);-moz-user-select:none;" FundId='+outjson[i].fundId+'>'+
						'<th style="font-weight: normal">'+outjson[i].fundId+'</th>'+
						'<th style="font-weight: normal">'+outjson[i].fundName+'</th>'+
						'<th style="font-weight: normal">'+outjson[i].fundCode+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundAmount+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundShares+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundNetValue+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundSellAmount+'</th>'+
        			    '<th style="font-weight: normal">'+outjson[i].fundSellNetValue+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundProfitRate+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundProfitAmount+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundSellDate+'</th>'+
					    '<th style="font-weight: normal">'+outjson[i].fundSellFee+'</th>'+
						'<th style="font-weight: normal; display:none;">'+outjson[i].ClientId+'</th>'+
						'</tr>')
			}
		});	
	
	}
}


function getFundNumber(FundState) {
	 $.getJSON("./WGetFundNumber",{UserId:UserId,FundState:FundState},function(outjson){
		 pageCountReal=outjson.FundNumber;
	});	
	
}



function showmainfundtitle() {

	$(".right-title").html("");
	$(".right-title").append(
			"<img onclick='	showmainfundtitle(),showfund()' src='./pic/daohang.png'  title='客户管理导航' style=' width:30px;height:30px; cursor:pointer; margin-left:100px;margin-bottom:-64px; margin-top:7px;' />"+
 			"</div>"+
 			"<div  style=' margin-left:450px;margin-top:5px;'><font>欢迎"+UserName+"</font></div>"+
 			"<div id=attenss style='height:25px;width:400px;float:right;margin-top:-10px; margin-left:700px;'>" +
 			
 				"<div class=usebut  style=' cursor:pointer; position: relative;' onclick='updateclient()'>修改</div>"+
				"<div class=usebut  style=' cursor:pointer; position: relative;' onclick='seeclient()'>查看</div>"+
				"<div class=usebut  style=' cursor:pointer; position: relative;' onclick='delclient()'>删除</div>"+
				"<div class=usebut  style=' cursor:pointer; position: relative;' onclick='addfund()'>增加</div>"+
				"<div class=usebut  style=' cursor:pointer; position: relative; margin-left:50px;'> <select id=selectID onchange='showSelectFund()' class=useselect style='height:25px;'><option value='1'>已买入</option><option value='2'>已卖出</option><option value='3'>总基金</option><option value='4'>待定</option></select></div> "+
 			
 			"</div>"
 		
 			
	);
	
}




function addfund() {
	$(".shadow").show();
	$(".pagehead font").html("添加基金")
	$(".showpage").css("width","350px");
	$(".showpage").css("height","280px");
	$(".showpage").css("margin-left","400px");
	$(".pagemain").html(
//			'<div style="margin-top: 10px;">选择员工：<select id="movemember"></select></div>'+
			'<div>基金名称：<input style="width:244px" class="inadress" id="fundseachnameId" type="text"/></div>'+
			'<div>基金代码：<input style="width:244px" class="inadress" id="fundcodeId" type="text"/></div>'+
			'<div>基金份额：<input style="width:244px" class="inadress" id="fundsharesId" type="text"/></div>'+
			'<div>基金净值：<input style="width:244px" class="inadress" id="fundnetvalueId" type="text"/></div>'+
			'<div>买入日期：<input style="width:244px" class="inadress" id="fundbuydateId" onclick=SelectDate(this,\'yyyy-MM-dd\') type="text"/></div>'+
			'<div>手续费用：<input style="width:244px" class="inadress" id="fundbuyfee" type="text"/></div>'+
			'<div>盈利点&nbsp&nbsp&nbsp：<select style="width:244px" class="inadress" id="fundprofitlimitId" ></select></div>'+
			'<div>止损点&nbsp&nbsp&nbsp：<select style="width:244px" class="inadress" id="fundlosslimitId" ></select></div>'+
			'<div style="margin-left: 70px;margin-top: 10px;"><button class=but1 onclick="addfundOk()">确定</button><button class=but1 onclick="closepage()">取消</button></div>'
	);
	
	var profitStr="<option value ='0'>0%</option>";
	for(var i=1;i<101;i++){
		profitStr=profitStr+"<option value ="+i+">"+i+"%</option>";
	
	}
	
	$("#fundprofitlimitId").append(profitStr);
	$("#fundlosslimitId").append(profitStr);
}

function addfundOk() {
	var FundName=$("#fundseachnameId").val();
	var FundCode=$("#fundcodeId").val();
	var FundShares=$("#fundsharesId").val();
	var FundNetValue=$("#fundnetvalueId").val();
	var FundBuyDate=$("#fundbuydateId").val();
	var FundBuyFee=$("#fundbuyfee").val();
	var FundProfitLimit=$("#fundprofitlimitId").val();
	var FundLossLimit=$("#fundlosslimitId").val();
	

	$.getJSON("./WCreateFund",{
		UserId:UserId,
		FundName:FundName,
		FundCode:FundCode,
		FundShares:FundShares,
		FundNetValue:FundNetValue,
		FundBuyDate:FundBuyDate,
		FundBuyFee:FundBuyFee,
		FundProfitLimit:FundProfitLimit,
		FundLossLimit:FundLossLimit
	},function(outjson){
		if(outjson.check){
			alert("成功")
			$.getJSON("./WGetFundNameAndCoce",{
				UserId:UserId,
				},function(outjson){
					arrFundName=new Array();
					arrFundCode=new Array();
					for(var i=0;i<outjson.length;i++){
						arrFundName.push(outjson[i][0]);
						arrFundCode.push(outjson[i][1]);
					}
			})
			
		}else{
			alert("失败")
		}
		closepage();
		showback();
	
	})
}

function sellfundOk() {
	var FundId=$("#fundId").val();
	var FundShares=$("#fundsharesId").val();
	var FundSellDate=$("#fundselldateId").val();
	var FundSellNetValue=$("#fundsellnetvalueId").val();
	var FundSellFee=$("#fundsellfeeId").val();
	
	$.getJSON("./WSellFund",{
		FundId:FundId,
		FundShares:FundShares,
		FundSellDate:FundSellDate,
		FundSellNetValue:FundSellNetValue,
		FundSellFee:FundSellFee,
	},function(outjson){
		if(outjson.check){
			alert("成功")
		}else{
			alert("失败")
		}
		closepage();
		showback();
	
	})
}

function sellfund() {
	var x=curtab;
	if(x==null){
		alert("请选择要卖出的基金")
	}else{
		
	$(".shadow").show();
	$(".pagehead font").html("分配客户")
	$(".showpage").css("width","280px");
	$(".showpage").css("height","270px");
	$(".showpage").css("margin-left","600px");
	$(".pagemain").html("<div class=userset>"+
  				"<div><a>基金号:</a><input id=fundId disabled='disabled' type='text' style='margin-left: 29px;'value='"+$(x).find("th").eq(0).html()+"' /></div>"+
  				"<div><a>基金名:</a><input id=wtf disabled='disabled' type='text' style='margin-left: 29px;' value='"+$(x).find("th").eq(1).html()+"'/></div>"+
  				"<div><a>基金代码：</a><input disabled='disabled' type='text' value='"+$(x).find("th").eq(2).html()+"'/></div>"+
  				"<div><a>基金份额：</a><input id=fundsharesId disabled='disabled' type='text' value='"+$(x).find("th").eq(4).html()+"'/></div>"+
  				"<div><a>卖出时间：</a><input class='inadress' id='fundselldateId' onclick=SelectDate(this,\'yyyy-MM-dd\') type='text'/></div>"+
  				"<div><a>卖出净值：</a><input  type='text' id='fundsellnetvalueId'/></div>"+
  				"<div><a>手续费用：</a><input  type='text' id='fundsellfeeId'/></div>"+
  	  			
  				"<div style='margin-left: 30px;margin-top: 10px;'><button onclick='sellfundOk()' class=but1>确定</button><button class=but1 onclick='closepage()'>取消</button></div>"+
  				"</div>");
	
	}
}



$(function searchfundname () {
	setTimeout(searchfundname, 1000);
   var resarray=new Array();
   resarray=arrFundName;
  
$("#fundseachnameId").autocomplete(resarray,{
        minChars: 0, // 双击空白文本框时显示全部提示数据
        max:100,
        formatItem: function (data, i, total) {
            return  data[0] ; // 改变匹配数据显示的格式
        },
        formatMatch: function (data, i, total) {
            return data[0];
        },
        formatResult: function (data) {
            return data[0];
        }
    }).result(SearchCallback); 
    function SearchCallback(event, data, formatted) {
//$(".tip").show().html("您的选择是：" + (!data ? "空" : formatted));
//    	$("#fundcodeId").val(arrFundCode[i]);
    	
    	for(var i=0;i<arrFundName.length;i++){
    		if(arrFundName[i]==data){
    			$("#fundcodeId").val(arrFundCode[i]);
    			break;
    		}
    		
    	}
    	
    }
});



function showSelectFund() {
	var selectId=$("#selectID").val();
	if(selectId==1){
		getFundNumber(FundStateBuy);
		setTimeout(showfundouttime(FundStateBuy),500);
		setTimeout(showfundPageOneouttime(FundStateBuy),500);

	}else if(selectId==2){
		getFundNumber(FundStateSell);
		setTimeout(showfundouttime(FundStateSell),500);
		setTimeout(showfundPageOneouttime(FundStateSell),500);
	}else if(selectId==3){
		shownocheck();
	}else if(selectId==4){
		showdelclient();
	}
	
	$("#clientsearchameid").val("");
	
	
}


function showback() {
	var seleed=$("#selectID").val();
		if(seleed==1){
			getFundNumber(FundStateBuy);
			setTimeout(showfundouttime(FundStateBuy),500);
			setTimeout(showfundPageOneouttime(FundStateBuy),500);

		}else if(seleed==2){
			getFundNumber(FundStateSell);
			setTimeout(showfundouttime(FundStateSell),500);
			setTimeout(showfundPageOneouttime(FundStateSell),500);
		}else if(seleed==3){
			shownocheck();
		}else if(seleed==4){
 			showdelclient();
 		}
		showmainfundtitle();
		var op=parseInt(seleed);
		$("#selectID").find("option").eq(op-1).attr("selected","selected");
}


function showfund(FundState) {

	if(FundState==FundStateBuy){
		 $(".group-listfund").html("");
			$(".group-listfund").append('<div class="group-one" style="height:100%;background-color: rgb(248,254,254);"> '+
				'<div class="group-title"><font>已买入基金表</font>'+ 
				"<div id=butclient style='height:25px;width:350px;float:right;margin-top:-20px; margin-left:900px;'>" +
				"<div class=usebut  style=' cursor:pointer; position: relative;' onclick='sellfund()'>卖出</div>"+
//				"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='disbutclient()' >分配客户</div>"+
//				"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='updateclient()'>修改</div>"+
//				"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='seeclient()'>查看</div>"+
//				"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='delclient()'>删除</div>"+
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
		             '<th>基金盈利点</th>'+
		             '<th>基金止损点</th>'+
//		             '<th>基金卖出日期</th>'+
//		             '<th>基金卖出手续费</th>'+
		         '</tr>'+
		         '</tbody>'+
		         
		          
		         '<tbody  class="thisgroup">'+
		         	
		         '</tbody>'+
		         '</table>'+
		      
		        ' <div style="margin-bottom:-10px;margin-left:300px" class="tcdPageCode"></div>'+
		         
			'</div>');
			  var currentPage=1;
			  $(".tcdPageCode").createPage({
			        pageCount:pageCountReal,
			        current:1,
			        backFn:function(p){
			            console.log(p);
			            $(".thisgroup").html("")
			            
			            $.getJSON("./WGetUserFund",{UserId:UserId,page:p,FundState:FundState},function(outjson){
			            	for ( var i = 0; i < outjson.length; i++) {
			            		
			            		$(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;" style="height:20x;font-size:12px;font-weight: normal;background-color: rgb(232,251,250);-moz-user-select:none;" FundId='+outjson[i].fundId+'>'+
			            				'<th style="font-weight: normal">'+outjson[i].fundId+'</th>'+
			            				'<th style="font-weight: normal">'+outjson[i].fundName+'</th>'+
			            				'<th style="font-weight: normal">'+outjson[i].fundCode+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundAmount+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundShares+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundNetValue+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundBuyDate+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundBuyFee+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundProfitLimit+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundLossLimit+'</th>'+
//			            			    '<th style="font-weight: normal">'+outjson[i].fundSellDate+'</th>'+
//			            			    '<th style="font-weight: normal">'+outjson[i].fundSellFee+'</th>'+
//			            				'<th style="font-weight: normal; display:none;">'+outjson[i].ClientId+'</th>'+
			            				'</tr>')
			            	}
			    	});	
			        }
			    });

	
	}else if(FundState==FundStateSell){
		 $(".group-listfund").html("");
			$(".group-listfund").append('<div class="group-one" style="height:100%;background-color: rgb(248,254,254);"> '+
				'<div class="group-title"><font>已卖出基金表</font>'+ 
				"<div id=butclient style='height:25px;width:350px;float:right;margin-top:-20px; margin-left:900px;'>" +
//				"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='disbutclient()' >分配客户</div>"+
//				"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='updateclient()'>修改</div>"+
//				"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='seeclient()'>查看</div>"+
//				"<div class=clientbut  style=' cursor:pointer; position: relative;' onclick='delclient()'>删除</div>"+
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
		             '<th>基金卖出金额</th>'+
		             '<th>基金卖出净值</th>'+
		             '<th>基金利润率</th>'+
		             '<th>基金利润金额</th>'+
		             '<th>基金卖出日期</th>'+
		             '<th>基金卖出手续费</th>'+
		         '</tr>'+
		         '</tbody>'+
		         
		          
		         '<tbody  class="thisgroup">'+
		         	
		         '</tbody>'+
		         '</table>'+
		      
		        ' <div style="margin-bottom:-10px;margin-left:300px" class="tcdPageCode"></div>'+
		         
			'</div>');
			  var currentPage=1;
			  $(".tcdPageCode").createPage({
			        pageCount:pageCountReal,
			        current:1,
			        backFn:function(p){
			            console.log(p);
			            $(".thisgroup").html("")
			            
			            $.getJSON("./WGetUserFund",{UserId:UserId,page:p,FundState:FundState},function(outjson){
			            	for ( var i = 0; i < outjson.length; i++) {
			            		
			            		$(".thisgroup").append('<tr onclick=do_onclick(this) ondblclick=do_blcclick(this) onmousemove="changeTrColorone(this)" onmouseout="changeTrColortwo(this)"   onselectstart="return false;" style="height:20x;font-size:12px;font-weight: normal;background-color: rgb(232,251,250);-moz-user-select:none;" FundId='+outjson[i].fundId+'>'+
			            				'<th style="font-weight: normal">'+outjson[i].fundId+'</th>'+
			            				'<th style="font-weight: normal">'+outjson[i].fundName+'</th>'+
			            				'<th style="font-weight: normal">'+outjson[i].fundCode+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundAmount+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundShares+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundNetValue+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundSellAmount+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundSellNetValue+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundProfitRate+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundProfitAmount+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundSellDate+'</th>'+
			            			    '<th style="font-weight: normal">'+outjson[i].fundSellFee+'</th>'+
			            				'<th style="font-weight: normal; display:none;">'+outjson[i].ClientId+'</th>'+
			            				'</tr>')
			            	}
			    	});	
			        }
			    });
	}

		
		curtab=null;
}





function changeTrColorone(obj){    

	    var _table=obj.parentNode;

	    for (var i=0;i<_table.rows.length;i++){


	    }    
	    var x=69;
	    var y=205;
	    var z=195;
	    obj.style.backgroundColor=setColor(x, y, z);

	}


var curtab = null;
function do_onclick(tab){
	 if(curtab==tab){
		tab.style.backgroundColor =setColor(232,251,250);
		curtab = null;
	 }else{
		 var x=69;
		 var y=205;
  	     var z=195;
    	 tab.style.backgroundColor = setColor(x, y, z);
    	 
         if(curtab != null) curtab.style.backgroundColor = setColor(232,251,250);
         curtab = tab;
	 }
	
}

function do_blcclick(tab) {
	 tab.style.backgroundColor = setColor(255, 255, 255);
	 curtab=null;
}

function setColor(x,y,z){
		return "#"  + x.toString(16) + y.toString(16) + z.toString(16);
		}
function changeTrColortwo(obj) {
	  var _table=obj.parentNode;

    for (var i=0;i<_table.rows.length;i++){

        _table.rows[i].style.backgroundColor=setColor(232,251,250);

    }    
	var x=69;
    var y=205;
    var z=195;
    obj.style.backgroundColor=setColor(232,251,250);
  if(curtab != null) curtab.style.backgroundColor = setColor(x, y, z);
}

 

 Date.prototype.format = function (format) {
            var args = {
                "M+": this.getMonth() + 1,
                "d+": this.getDate(),
                "h+": this.getHours(),
                "m+": this.getMinutes(),
                "s+": this.getSeconds(),
                "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
                "S": this.getMilliseconds()
            };
            if (/(y+)/.test(format))
                format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var i in args) {
                var n = args[i];
                if (new RegExp("(" + i + ")").test(format))
                    format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? n : ("00" + n).substr(("" + n).length));
            }
            return format;
        };

