function register() {
	if(!checkname()){
		return false;
	}else if (!checkpass()) {
		return false;
	} 

	return true;
}

function checkname()    
{

	var name = document.getElementById("uName").value;  
	var ts = document.getElementById("namets");
	if(name.length == 0)    
	{   
		ts.innerHTML ="用户名不能为空";
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

//	if(userPass.length<6 || userPass.length >15)  
//	{   
//		pts.innerHTML ="";
//		pts.style.color="red";
//		return false;
//	}
	pts.innerHTML = '';
	return true;
}