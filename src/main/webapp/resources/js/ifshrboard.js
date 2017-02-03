function iswrite_ok(form) {
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
		//$('#isboard_cont').val().replace("\r\n","<br>")
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

	
	
function iswriteComm_go(mem_nick,ifshrboard_posting_no,ifshrboard_comm_contt,event) {
	event.preventDefault();
	var cont={
		"ifshrboard_comm_contt" : ifshrboard_comm_contt,
		"mem_nick": mem_nick,
		"ifshrboard_posting_no":ifshrboard_posting_no
	};
	if (document.formm.ifshrboard_comm_cont.value == "") {
		alert("댓글을 입력해주세요");
		document.formm.ifshrboard_comm_cont.focus();
		return false;
	}else{
		$.ajax({
			url:"writeComm",
			type:"post",
			contentType:'application/json',
			dataType:'json',
			data: JSON.stringify(cont),
			success : function(data) {
				var a;
				$.each(data,function(){
					a = '<tr><td>'+mem_nick+'</td>'+
						'<td>'+ifshrboard_comm_contt+'<input type="button" value="추천">'+
						'<input type="button" value="비추천"></td>'+
					 	'<td></td>'+
					 	'<td><a href="#" onclick="updateIsComm()">수정</a>/'+
						'<a href="#" onclick="deleteIsComm()">삭제</a></td></tr>'
				})
				$('#iscomm_go').append(a);
				$('#ifshrboard_comm_contt').val("");
			},
			error : function(error) {
				alert("22");
			}
		})
	}
}
function updateIsComm(ifshrboard_comm_cont,indexTd, event){
	event.preventDefault();
	var arr = {
			"ifshrboard_comm_cont" : ifshrboard_comm_cont
	};
	
	$.ajax({
		url:"updateIsBoardComm.do",
		type:"get",
		data: arr,
		success : function(data) {
			$('#'+indexTd).html('<input value='+data+'></input>');
		},
		error : function(error) {
			alert("22");
		}
	})
}
function deleteIsComm(ifshrboard_ans_code, indexTdd, event){
	alert("code값 test >>"+ifshrboard_ans_code);
	event.preventDefault();
	var code ={
		"ifshrboard_ans_code" : ifshrboard_ans_code	
	};
	$.ajax({
		url:"deleteIsBoardComm.do",
		type: "post",
		data: code,
		success: function(data){
			$('#'+indexTdd).remove();
		},
		error : function(error){
			alert("실패");
		}
		
	})
	
	
}
/*$(document).ready(function(){
	$('#div1hide').click(function(){
		$('#div1').hide();
		$('#div2').show();
	});
	$('#div2hide').click(function(){
		//$('#div2').val()
		$('#div2').hide();	
		$('#div1').show();
	});
	
})*/
