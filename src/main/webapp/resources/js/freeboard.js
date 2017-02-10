function free_write_ok(form) {
	var result=true;
	
	if(free_cont()==false){
		result= free_cont();
	}
	if(free_title()==false){
		result= free_title;
	}
	if(free_pwd()==false){
		result= free_pwd;
	}
	
	if(result==true){
		form.submit();
	}
}	
function free_cont(){
	if (document.form.freeboard_cont.value == "") {
		document.getElementById("freeboard_cont").innerHTML = "내용을 입력해주세요";
		document.form.freeboard_cont.focus();
		return false;
	}else{
		document.getElementById("freeboard_cont").innerHTML = "";
		return true;
	}
}
function free_title(){
	if (document.form.freeboard_title.value == "") {
		document.getElementById("freeboard_title").innerHTML = "제목을 입력해주세요";
		document.form.freeboard_title.focus();
		return false;
	}else{
			document.getElementById("freeboard_title").innerHTML = "";
			return true;
	}
}
function free_pwd(){
	if (document.form.freeboard_pwd.value == "") {
		document.getElementById("freeboard_pwd").innerHTML = "비밀번호를 입력해주세요";
		document.form.freeboard_pwd.focus();
		return false;
	}else{
		document.getElementById("freeboard_pwd").innerHTML = "";
		return true;
	}
}
	
	
function freeWriteComm_go(mem_nick,freeboard_posting_no,freeboard_comm_contt,indexTd,indexTdd,event) {
	event.preventDefault();
	var aa=Number(indexTd)+1;	
	var cont={
			"freeboard_comm_contt" : freeboard_comm_contt,
			"mem_nick": mem_nick,
			"freeboard_posting_no":freeboard_posting_no
		};
		if (document.formm.freeboard_comm_cont.value == "") {
			alert("댓글을 입력해주세요");
			document.formm.freeboard_comm_cont.focus();
			return false;
		}else{
			$.ajax({
				url:"writeComm",
				type:"post",
				contentType:'application/json',
				data: JSON.stringify(cont),
				success : function(data) {
					var a;
					
						a = '<tr><td>'+mem_nick+'</td>'+
							'<td style="work-break:break-all;"id="freeBoardComm_cont'+aa+'">'+freeboard_comm_contt+'<input type="button" value="추천">'+
							'<input type="button" value="비추천"></td>'+
						 	'<td>'+data.today+'</td>'+
						 	'<td><a href="#" onclick="updateFreeCommForm('+aa+','+indexTdd+',event)">수정</a>/'+
							'<a href="#" onclick="deleteFreeComm()">삭제</a></td></tr>'
					
					$('#freecomm_go').append(a);
					$('#freeboard_comm_contt').val("");
					alert("본문 작성자 : " +data.mem_mail);
					alert("본문 작성자 session: " +data.wsSession);
				},
				error : function(error) {
					alert("22");
				}
			})
		}
	}
function deleteFreeComm(freeboard_ans_code, indexTdd, event){
	alert("code값 test >>"+freeboard_ans_code);
	event.preventDefault();
	var code ={
		"freeboard_ans_code" : freeboard_ans_code	
	};
	$.ajax({
		url:"deleteFreeBoardComm.do",
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

function updateFreeCommForm(indexTd,indexTdd , event) {
	event.preventDefault();
	
	var freeboard_comm_cont = $('#freeBoardComm_cont'+indexTd).text();
	var arr = {
		"freeboard_comm_cont" : freeboard_comm_cont
	};

	$
			.ajax({
				url : "updateFreeBoardCommForm.do",
				type : "post",
				data : arr,
				success : function(data) {
					$('#freeBoardComm_cont' + indexTd)
							.html(
									'<textarea rows="2" cols="150" id="freeboard_comm_cont" name="freeboard_comm_cont">'
											+ data 
											+ '</textarea>'
											+ '<input type="button" value="댓글수정" onclick="updateFreeComm('+indexTd+','+indexTdd+'event)">');
				},
				error : function(error) {
					alert("22");
				}
			})
}



function updateFreeComm(indexTd,indexTdd , event) {
	event.preventDefault();
	var freeboard_ans_code = $('#'+indexTdd).val();
	var freeboard_comm_cont = $('#freeboard_comm_cont').val();
	alert(freeboard_ans_code);
	alert("123"+freeboard_comm_cont);
	
	var arr = {
			"freeboard_ans_code" : freeboard_ans_code,
			"freeboard_comm_cont" : freeboard_comm_cont
		};
	$
	.ajax({
		url : "updateFreeBoardComm.do",
		type : "post",
		data : arr,
		success : function(data) {
			$('#freeBoardComm_cont' + indexTd)
			.html(data);
		},
		error : function(error) {
			alert("22");
		}
	})
}





function free_src(){
	formm.action =  "freeBoardSearch.do";
	formm.submit();
}


