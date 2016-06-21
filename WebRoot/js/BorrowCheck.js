function confirms() {
	if(!checkReaderid()){
		return false;
	}else if (!checkBorrowID()) {
		return false;
	} else if(!checkBackDate()) {
		return false;
	}

	document.borrowinfo.action = "/library/borrowBook!addRecord.action";
	document.borrowinfo.submit();
	return true;
}

function checkReaderid()    
{

	var name = document.getElementById("ip_readerid").value;  
	var ts = document.getElementById("borrowTips");
	if(name.length == 0)    
	{   
		ts.innerHTML ="用户ID不能为空";
		ts.style.color="red";
		return false;
	}else if(name.length != 7) {
		ts.innerHTML ="用户ID不正确";
		ts.style.color="red";
		return false;
	}

	ts.innerHTML = '';
	return true;
}

function checkBorrowID(){
	var userPass = document.getElementById("ip_isbn").value;
	var pts = document.getElementById("borrowTips");
	
	if(userPass.length == 0) {
		pts.innerHTML ="图书ID不能为空";
		pts.style.color="red";
		return false;
	}else if(userPass.length < 7) {
		pts.innerHTML ="图书ID不正确";
		pts.style.color="red";
		return false;
	}

	pts.innerHTML = '';
	return true;
}

function checkBackDate(){
	var userPass = document.getElementById("ip_backdate").value;
	var pts = document.getElementById("borrowTips");
	
	if(userPass.length == 0) {
		pts.innerHTML ="归还日期不能为空";
		pts.style.color="red";
		return false;
	}

	pts.innerHTML = '';
	return true;
}

function checkOrderNumber() {
	var userPass = document.getElementById("ip_amount").value;
	var pts = document.getElementById("orderTips");
	
	if(userPass.length == 0) {
		pts.innerHTML ="预定数量不能为空";
		pts.style.color="red";
		return false;
	}

	pts.innerHTML = '';
	return true;
}