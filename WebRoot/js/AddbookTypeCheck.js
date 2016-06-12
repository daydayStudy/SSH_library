function addbooktyck(){
	 if(!checkbname()){
		return false;
	}else if (!checkday()) {
		return false;
	}else if (!checkprice()){
		return false;
	}
	return true;
}

function falseprice(str3){
    var fp= /^([0-9.]+)$/;
    return fp.test(str3);
}





function falseshuzi(str2){
	var fshu=/^([0-9.]+)$/;
	return fshu.test(str2);
}


function checkbname(){
	var tname = document.getElementById("Tname").value;

	var pts = document.getElementById("namets");
	
	if(tname.length==0)    
	{   
		pts.innerHTML ="图书类型名称不能为空";
		pts.style.color="red";
		return false;
		
	}
	else if(tname.length<0||tname.length>250){
		pts.innerHTML ="图书类型名称长度在250以内";
		pts.style.color="red";
		return false;
	}
		
	pts.innerHTML = '';
	return true;
}

function checkprice(){
	var trice = document.getElementById("Tprice").value;
	var mts = document.getElementById("namets");	
	if(trice.length == 0) {
		mts.innerHTML ="罚款金额不能为空";
		mts.style.color="red";
		return false;
	}
	
	else if(!falseprice(trice)){ 
		  mts.innerHTML="罚款金额输入错误"; 
		  mts.style.color="red"; 
		  return false; 
		  }
		
	mts.innerHTML = '';
	return true;
}




function checkday()    
{
	
	var day = document.getElementById("Tday").value;
	var ts = document.getElementById("namets");
	 
	if(day.length==0)    
	{   
		ts.innerHTML ="罚款天数不能为空";
		ts.style.color="red";
		return false;
		
	}

	  else if(!falseshuzi(day)){ 
		  ts.innerHTML="罚款天数只能是数字"; 
		  ts.style.color="red"; 
		  return false; 
		  }

	ts.innerHTML = '';
	return true;
}



