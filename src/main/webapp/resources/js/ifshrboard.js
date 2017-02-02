function write_ok(form) {
	var result=true;
	
	if(cont()==false){
		result= cont();
	}
	if(title()==false){
		result= false;
	}
	if(pwd()==false){
		result= false;
	}
	
	if(result==true){
		form.submit();
	}
}	
function cont(){
	if (document.form.ifshrboard_cont.value == "") {
		document.getElementById("ifshrboard_cont").innerHTML = "내용을 입력해주세요";
		document.form.ifshrboard_cont.focus();
		return false;
	}else{
		document.getElementById("ifshrboard_cont").innerHTML = "";
		return true;
	}
}
function title(){
	if (document.form.ifshrboard_title.value == "") {
		document.getElementById("ifshrboard_title").innerHTML = "제목을 입력해주세요";
		document.form.ifshrboard_title.focus();
		return false;
	}else{
			document.getElementById("ifshrboard_title").innerHTML = "";
			return true;
	}
}
function pwd(){
	if (document.form.ifshrboard_pwd.value == "") {
		document.getElementById("ifshrboard_pwd").innerHTML = "비밀번호를 입력해주세요";
		document.form.ifshrboard_pwd.focus();
		return false;
	}else{
		document.getElementById("ifshrboard_pwd").innerHTML = "";
		return true;
	}
}

/*	if (document.form.freeboard_pwd.value == "") {
		// alert("게시글 비밀번호를 입력하세요.");
		document.getElementById("freeboard_pwd").innerHTML = "비밀번호를 입력해주세요";
		document.form.freeboard_pwd.focus();
		return false;
	}else {
		document.getElementById("freeboard_pwd").innerHTML = "";
	}

	if (document.form.freeboard_title.value == "") {
		// alert("게시글 제목을 입력하세요.");
		document.getElementById("freeboard_title").innerHTML = "제목을 입력해주세요";
		document.form.freeboard_title.focus();
		return false;
	} else {
		document.getElementById("freeboard_title").innerHTML = "";
	}
	if (document.form.freeboard_cont.value == "") {
		// alert("게시글 내용을 입력하세요.");
		document.getElementById("freeboard_cont").innerHTML = "내용을 입력해주세요";
		document.form.freeboard_cont.focus();
		return false;
	} else {
		document.getElementById("freeboard_cont").innerHTML = "";
	}
	form.submit();
}*/
/*	if (document.form.freeboard_pwd.value == "") {
		if (document.form.freeboard_title.value == "") {
			if (document.form.freeboard_cont.value == "") {
				document.getElementById("freeboard_cont").innerHTML = "내용을 입력해주세요";
				document.form.freeboard_cont.focus();
				return false;
			}else{
				document.getElementById("freeboard_cont").innerHTML = "";
			}
			document.getElementById("freeboard_title").innerHTML = "제목을 입력해주세요";
			document.form.freeboard_title.focus();
			return false;
		}else{
			document.getElementById("freeboard_title").innerHTML = "";
		}
		document.getElementById("freeboard_pwd").innerHTML = "비밀번호를 입력해주세요";
		document.form.freeboard_pwd.focus();
		return false;
	}else{
		document.getElementById("freeboard_pwd").innerHTML = "";
	}
	form.submit();
}	*/
	
	
function writeComm_go() {
	if (document.formm.ifshrboard_comm_cont.value == "") {
		alert("댓글을 입력해주세요");
		document.formm.ifshrboard_comm_cont.focus();
		return false;
	}else{
		formm.submit();
		return true;
	}
}
$(document).ready(function(){
	$('#div1hide').click(function(){
		$('#div1').hide();
		$('#div2').show();
	});
	$('#div2hide').click(function(){
		//$('#div2').val()
		$('#div2').hide();	
		$('#div1').show();
	});
	
})
