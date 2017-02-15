function meet_write_ok(form) {
	var result=true;
	
	if(meet_cont()==false){
		result= meet_cont();
	}
	if(meet_title()==false){
		result= meet_title;
	}
	if(meet_pwd()==false){
		result= meet_pwd;
	}
	
	if(result==true){
		form.submit();
	}
}	
function meet_cont(){
	if (document.form.meet_board_cont.value == "") {
		document.getElementById("meet_board_cont").innerHTML = "내용을 입력해주세요";
		document.form.meet_board_cont.focus();
		return false;
	}else{
		document.getElementById("meet_board_cont").innerHTML = "";
		return true;
	}
}
function meet_title(){
	if (document.form.meet_board_title.value == "") {
		document.getElementById("meet_board_title").innerHTML = "제목을 입력해주세요";
		document.form.meet_board_title.focus();
		return false;
	}else{
			document.getElementById("meet_board_title").innerHTML = "";
			return true;
	}
}
function meet_pwd(){
	if (document.form.meet_board_pwd.value == "") {
		document.getElementById("meet_board_pwd").innerHTML = "비밀번호를 입력해주세요";
		document.form.meet_board_pwd.focus();
		return false;
	}else{
		document.getElementById("meet_board_pwd").innerHTML = "";
		return true;
	}
}
	
	
function meetWriteComm_go(mem_nick,meet_board_posting_no,meet_board_comm_contt,indexTd,indexTdd,event) {
	event.preventDefault();
	var aa=Number(indexTd)+1;	
	var cont={
			"meet_board_comm_contt" : meet_board_comm_contt,
			"mem_nick": mem_nick,
			"meet_board_posting_no":meet_board_posting_no
		};
		if (document.formm.meet_board_comm_cont.value == "") {
			alert("댓글을 입력해주세요");
			document.formm.meet_board_comm_cont.focus();
			return false;
		}else{
			$.ajax({
				url:"writeComm",
				type:"post",
				contentType:'application/json',
				data: JSON.stringify(cont),
				success : function(data) {
					var a;
					
						a = '<tr><td style="width:100px;text-align:center;"><button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#myModal2">'
							+mem_nick+'</button></td>'+
							'<td style="work-break:break-all;"id="meet_BoardComm_cont'+aa+'">'
							+meet_board_comm_contt+'<input type="button" value="추천"id="chu'+indexTd+'">'+
							'<input type="button" value="비추천" id="bchu"'+indexTd+'></td>'+
						 	'<td>'+data.today+'</td>'+
						 	'<td><a href="#" onclick="updateMeetCommForm('+aa+','+indexTd+',event)" id="aa">수정</a>/'+
							'<a href="#" onclick="deleteMeetComm('+aa+', '+indexTdd+', event)"id="aa">삭제</a></td></tr>'
					
					$('#meetcomm_go').append(a);
					$('#meet_board_comm_contt').val("");
					var message = {};
					message.to = data.mem_mail;
					message.message = "댓글 내용 : "+meet_board_comm_contt;
					wsocket.send(JSON.stringify(message));
				},
				error : function(error) {
					alert("22");
				}
			})
		}
	}
function deletemeetComm(meet_board_ans_code, indexTdd, event){
	alert("code값 test >>"+meet_board_ans_code);
	event.preventDefault();
	var code ={
		"meet_board_ans_code" : meet_board_ans_code	
	};
	$.ajax({
		url:"deleteMeetBoardComm.do",
		type: "post",
		data: code,
		success: function(data){
			$(indexTdd).remove();
		},
		error : function(error){
			alert("실패");
		}
	})
}

function updateMeetCommForm(indexTd,indexTdd , event) {
	event.preventDefault();
	
	var meet_board_comm_cont = $('#meeytBoardComm_cont'+indexTd).text();
	var arr = {
		"meet_board_comm_cont" : meet_board_comm_cont
	};

	$
			.ajax({
				url : "updateMeetBoardCommForm.do",
				type : "post",
				data : arr,
				success : function(data) {
					$('#meetBoardComm_cont' + indexTd)
							.html(
									'<textarea rows="2" cols="150" id="meet_board_comm_cont" name="meet_board_comm_cont">'
											+ data 
											+ '</textarea>'
											+ '<input type="button" value="댓글수정" onclick="updateMeetComm('+indexTd+','+indexTdd+',event)">');
				},
				error : function(error) {
					alert("22");
				}
			})
}



function updateMeetComm(indexTd,indexTdd , event) {
	event.preventDefault();
	var meet_board_ans_code = $('#meet_board_ans_code'+indexTdd).val();
	var meet_board_comm_cont = $('#meet_board_comm_cont').val();
	alert("수정되는내용"+meet_board_comm_cont);
	
	var arr = {
			"#meet_board_ans_code" : meet_board_ans_code,
			"#meet_board_comm_cont" : meet_board_comm_cont
		};
	$
	.ajax({
		url : "updateMeetBoardComm.do",
		type : "post",
		data : arr,
		success : function(data) {
			$('#meet_BoardComm_cont' + indexTd).html(data+'<input type="button" value="추천"id="chu'+indexTd+'">'+
					'<input type="button" value="비추천" id="bchu"'+indexTd+'>');
			
		},
		error : function(error) {
			alert("22");z	
		}
	})
}





function meet_src(){
	formm.action =  "meetBoardSearch.do";
	formm.submit();
}


