function register1() {
	if(!checkname()){
		return false;
	}else if (!checkpass()) {
		return false;
	} else if (!checkage()){
		return false;
	}
	else if (!checktel()){
		return false;
	}
	else if (!checkemail()){
		return false;
	}

	return true;
}

function falseemail(str3){
    var fb= /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return fb.test(str3);
}

function falsename(str){
	var fna=/^[\u4E00-\u9FA5A-Za-z0-9]+$/;
	return fna.test(str);
}

function falsepassword(str1){
	var fpw=/^[A-Za-z0-9]+$/;
	return fpw.test(str1);
}

function falseage(str2){
	var fage=/^([0-9.]+)$/;
	return fage.test(str2);
}

function falsetel(str4){
	var ftel=/(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}/;
	return ftel.test(str4);
}


function checkname()    
{
	
	var name = document.getElementById("uName").value;
	var ts = document.getElementById("namets");
	 
	if(name.length==0)    
	{   
		ts.innerHTML ="用户名不能为空";
		ts.style.color="red";
		return false;
		
	}
	else if(name.length<1||name.length>20){
		ts.innerHTML ="用户名长度为20以内";
		ts.style.color="red";
		return false;
	}
	

	  else if(!falsename(name)){ 
		  ts.innerHTML="用户名不能数字开头，并且只能为数字字母汉字组合"; 
		  ts.style.color="red"; 
		  return false; 
		  }

	ts.innerHTML = '';
	return true;
}

function checkpass(){
	var userPass = document.getElementById("uPass").value;

	var pts = document.getElementById("namets");
	
	if(userPass.length == 0) {
		pts.innerHTML ="密码不能为空";
		pts.style.color="red";
		return false;
	}
	else if(userPass.length<6||userPass.length>20){
		pts.innerHTML ="密码长度为6-20";
		pts.style.color="red";
		return false;
	}
	
	
	pts.innerHTML = '';
	return true;
}

function checkage(){
	var usage = document.getElementById("uAge").value;
	var ats = document.getElementById("namets");
	
	if(usage.length == 0) {
		ats.innerHTML ="年龄不能为空";
		ats.style.color="red";
		return false;
	}
	else if(usage.length<1||usage.length>3){
		ats.innerHTML ="年龄长度为3位数以内";
		ats.style.color="red";
		return false;
	}
	  else if(!falseage(usage)){ 
		  ats.innerHTML="年龄只能输入数字"; 
		  ats.style.color="red"; 
		  return false; 
		  }
		
	ats.innerHTML = '';
	return true;
}

function checktel(){
	var utel = document.getElementById("uTel").value;
	var tts = document.getElementById("namets");	
	if(utel.length == 0) {
		tts.innerHTML ="联系方式不能为空";
		tts.style.color="red";
		return false;
	}
	else if(!falsetel(utel)){ 
		  ats.innerHTML="手机号不合法"; 
		  ats.style.color="red"; 
		  return false; 
		  }
		
	tts.innerHTML = '';
	return true;
}

function checkemail(){
	var uem = document.getElementById("uEmail").value;
	var mts = document.getElementById("namets");	
	if(uem.length == 0) {
		mts.innerHTML ="邮箱不能为空";
		mts.style.color="red";
		return false;
	}
	
	else if(!falseemail(uem)){ 
		  mts.innerHTML="邮箱格式错误"; 
		  mts.style.color="red"; 
		  return false; 
		  }
		
	mts.innerHTML = '';
	return true;
}