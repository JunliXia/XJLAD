
$(document).ready(function() {
	
	
	changecolors("#userbit");
	tofund();
	


	
}) ;




function loginout() {
	 if (confirm("确定退出吗？")){	window.location.href="jsp/login.jsp"}
	 else{}
}


function changecolors(x) {
	$(".left_list div").attr("class","one");
	  $(x).attr("class","two");
}

function tofund() {
	$(".fund").hide();
	if($(".fund").html()==""){
	$(".fund").load("jsp/child_jsp/fund.jsp");}
	else{
	}
	$(".fund").show();
}

function tobussiness() {
	$(".usermanage").hide();
	$(".mapmanage").hide();
	$(".transactionmanage").hide();
	$(".taskmanage").hide();
	$(".attendance").hide();
	$(".client").hide();
	$(".visitplan").hide();
	$(".bussiness").hide();
	$(".bussiness").html("");
	if($(".bussiness").html()==""){
	$(".bussiness").load("jsp/child_jsp/bussiness.jsp");}
	else{
	}
	$(".bussiness").show();
}

function tovisitplan() {
	$(".usermanage").hide();
	$(".mapmanage").hide();
	$(".transactionmanage").hide();
	$(".taskmanage").hide();
	$(".attendance").hide();
	$(".client").hide();
	$(".bussiness").hide();
	$(".visitplan").hide();
	$(".visitplan").html("");
	if($(".visitplan").html()==""){
	$(".visitplan").load("jsp/child_jsp/visitplan.jsp");}
	else{
	}
	$(".visitplan").show();
}

function toclient(){
	$(".usermanage").hide();
	$(".mapmanage").hide();
	$(".transactionmanage").hide();
	$(".taskmanage").hide();
	$(".attendance").hide();
	$(".client").hide();
	$(".visitplan").hide();
	$(".bussiness").hide();
	$(".client").html("");
	if($(".client").html()==""){
	$(".client").load("jsp/child_jsp/client.jsp");}
	else{
		
	}
	$(".client").show();
}

function toattendance() {
	$(".usermanage").hide();
	$(".mapmanage").hide();
	$(".transactionmanage").hide();
	$(".taskmanage").hide();
	$(".attendance").hide();
	$(".client").hide();
	$(".visitplan").hide();
	$(".bussiness").hide();
	$(".attendance").html("");
	if($(".attendance").html()==""){
	$(".attendance").load("jsp/child_jsp/attendance.jsp");}
	else{
		
	}
	$(".attendance").show();
}

function touser() {
	$(".usermanage").hide();
	$(".mapmanage").hide();
	$(".transactionmanage").hide();
	$(".taskmanage").hide();
	$(".attendance").hide();
	$(".client").hide();
	$(".visitplan").hide();
	$(".bussiness").hide();
	$(".usermanage").html("");
	if($(".usermanage").html()==""){
	$(".usermanage").load("jsp/child_jsp/usermanage.jsp");}
	else{
		
	}
	$(".usermanage").show();
}

function tomap() {
	$(".usermanage").hide();
	$(".mapmanage").hide();
	$(".transactionmanage").hide();
	$(".taskmanage").hide();
	$(".attendance").hide();
	$(".client").hide();
	$(".visitplan").hide();
	$(".bussiness").hide();
	$(".mapmanage").html("");
	if($(".mapmanage").html()==""){
	$(".mapmanage").load("jsp/child_jsp/mapmanage.jsp");}
	else{
		
	}
	$(".mapmanage").show();
}
function totransaction() {
	$(".usermanage").hide();
	$(".mapmanage").hide();
	$(".transactionmanage").hide();
	$(".taskmanage").hide();
	$(".attendance").hide();
	$(".client").hide();
	$(".bussiness").hide();
	$(".visitplan").hide();
	$(".transactionmanage").html("");
	if($(".transactionmanage").html()==""){
	$(".transactionmanage").load("jsp/child_jsp/transactionmanage.jsp");
	}else{
		
	}
	$(".transactionmanage").show();
}
function totask() {
	$(".usermanage").hide();
	$(".mapmanage").hide();
	$(".transactionmanage").hide();
	$(".taskmanage").hide();
	$(".attendance").hide();
	$(".client").hide();
	$(".visitplan").hide();
	$(".bussiness").hide();
	$(".taskmanage").html("");
	if($(".taskmanage").html()==""){
	$(".taskmanage").load("jsp/child_jsp/taskmanage.jsp");
	}
	else{
		
	}
	$(".taskmanage").show();
}



function closepage() {
	$(".shadow").hide();
}