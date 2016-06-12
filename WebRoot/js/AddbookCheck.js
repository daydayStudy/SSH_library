function addbookck(){
	 if(!checkISBN()){
		return false;
	}else if (!checkbname()) {
		return false;
	}else if (!checkweiter()){
		return false;
	}else if (!checktranslator()){
		return false;
	}else if (!checkpublisher()){
		return false;
	}else if (!checkprice()){
		return false;
	}else if (!checkdate()){
		return false;
	}
	return true;
}

function falseprice(str3){
    var fp= /^([0-9.]+)$/;
    return fp.test(str3);
}

function falsezhongwen(str){
	var fzw=/^[\u4e00-\u9fa5a-zA-Z]+$/;
	return fzw.test(str);
}

function falsedate(str1){
	var fd=/^(\d{4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
	return fd.test(str1);
}

function falseshuzi(str2){
	var fshu=/^([0-9.]+)$/;
	return fshu.test(str2);
}




function checkISBN()    
{
	
	var isbn = document.getElementById("Aisbn").value;
	var ts = document.getElementById("namets");
	 
	if(isbn.length==0)    
	{   
		ts.innerHTML ="ISBN不能为空";
		ts.style.color="red";
		return false;
		
	}
	else if(isbn.length<10||isbn.length>13){
		ts.innerHTML ="ISBN长度在13以内";
		ts.style.color="red";
		return false;
	}
	

	  else if(!falseshuzi(isbn)){ 
		  ts.innerHTML="ISBN只能是数字"; 
		  ts.style.color="red"; 
		  return false; 
		  }

	ts.innerHTML = '';
	return true;
}

function checkbname(){
	var bname = document.getElementById("Aname").value;

	var pts = document.getElementById("namets");
	
	if(bname.length==0)    
	{   
		pts.innerHTML ="图书名称不能为空";
		pts.style.color="red";
		return false;
		
	}
	else if(bname.length<0||bname.length>250){
		pts.innerHTML ="图书名称长度在250以内";
		pts.style.color="red";
		return false;
	}
		
	pts.innerHTML = '';
	return true;
}

function checkweiter(){
	var writer = document.getElementById("Awriter").value;
	var ats = document.getElementById("namets");
	
	if(writer.length == 0) {
		ats.innerHTML ="作者不能为空";
		ats.style.color="red";
		return false;
	}
	else if(writer.length<1||writer.length>50){
		ats.innerHTML ="作者长度为50位数以内";
		ats.style.color="red";
		return false;
	}
	  else if(!falsezhongwen(writer)){ 
		  ats.innerHTML="作者只能输入中文或英文"; 
		  ats.style.color="red"; 
		  return false; 
		  }
		
	ats.innerHTML = '';
	return true;
}

function checktranslator (){
	var tran = document.getElementById("Atran").value;
	var tts = document.getElementById("namets");	
	if(tran.length == 0) {
		tts.innerHTML ="译者不能为空";
		tts.style.color="red";
		return false;
	}
	else if(tran.length<1 && tran.length>50){		
		tts.innerHTML ="译者长度为50以内";
		tts.style.color="red";
		return false;
	}
	else if(!falsezhongwen(tran)){ 
		  tts.innerHTML="译者只能输入中文或英文"; 
		  tts.style.color="red"; 
		  return false; 
		  }
		
	tts.innerHTML = '';
	return true;
}

function checkpublisher  (){
	var psh = document.getElementById("Apsh").value;
	var qts = document.getElementById("namets");	
	if(psh.length == 0) {
		qts.innerHTML ="出版社不能为空";
		qts.style.color="red";
		return false;
	}
	else if(psh.length<1 && psh.length>50){		
		qts.innerHTML ="出版社长度为50以内";
		qts.style.color="red";
		return false;
	}
	else if(!falsezhongwen(psh)){ 
		  qts.innerHTML="出版社只能输入中文或英文"; 
		  qts.style.color="red"; 
		  return false; 
		  }
		
	qts.innerHTML = '';
	return true;
}

function checkprice(){
	var price = document.getElementById("Aprice").value;
	var mts = document.getElementById("namets");	
	if(price.length == 0) {
		mts.innerHTML ="价格不能为空";
		mts.style.color="red";
		return false;
	}
	
	else if(!falseprice(price)){ 
		  mts.innerHTML="价格输入错误"; 
		  mts.style.color="red"; 
		  return false; 
		  }
		
	mts.innerHTML = '';
	return true;
}

function checkdate(){
	var da = document.getElementById("Adate").value;
	var dts = document.getElementById("namets");	
	if(da.length == 0) {
		dts.innerHTML ="出版日期不能为空";
		dts.style.color="red";
		return false;
	}
	
	else if(!falsedate(da)){ 
		  dts.innerHTML="出版日期输入格式为YYYY-MM-DD"; 
		  dts.style.color="red"; 
		  return false; 
		  }
		
	mts.innerHTML = '';
	return true;
}

