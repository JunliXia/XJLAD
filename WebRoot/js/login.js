function Login(){
	var UserAccount=$(".account input").val();
	var UserPassword=$(".pass input").val();
	
	
	$.getJSON("./WLogin",{
		UserAccount:UserAccount,
		UserPassword:UserPassword,
	},function(outjson){
		if(outjson.check==true){
			window.location.href="jsp/main.jsp"

		}else if(outjson.check==false){
		    alert("账号密码不正确");
		}
	})
}

function registered(){
	window.location.href="jsp/registered.jsp"
}

function registeredok() {
	var UserAccount=$(".account input").val();
	var UserPassword=$(".pass input").val();
	var UserName=$(".name input").val();
	$.getJSON("./WCreateUser",{
		UserAccount:UserAccount,
		UserPassword:UserPassword,
		UserName:UserName
	},function(outjson){
		if(outjson.check==true){
		    alert("注册成功");
			window.location.href="jsp/login.jsp"

		}else if(outjson.check==false){
		    alert("账号以被注册什么的，还有自己注意下啊");
		}
	})
}