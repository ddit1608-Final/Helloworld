function ds_write_ok(form) {
	var result = true;

	if (ds_cont() == false) {
		result = ds_cont();
	}
	if (ds_title() == false) {
		result = ds_title();
	}
	if (ds_pwd() == false) {
		result = ds_pwd();
	}

	if (result == true) {
		// $('#isboard_cont').val().replace("\r\n","<br>")
		form.submit();
	}
}
function ds_cont() {
	if (document.form.dsboard_cont.value == "      				") {
		document.getElementById("dsboard_cont").innerHTML = "<font color='red'>내용을 입력해주세요</font>";
		document.form.dsboard_cont.focus();
		return false;
	} else {
		document.getElementById("dsboard_cont").innerHTML = "Comment";
		return true;
	}
}
function ds_title() {
	if (document.form.dsboard_title.value == "") {
		document.getElementById("dsboard_title").innerHTML = "<font color='red'>제목을 입력해주세요</font>";
		document.form.dsboard_title.focus();
		return false;
	} else {
		document.getElementById("dsboard_title").innerHTML = "제목";
		return true;
	}
}
function ds_pwd() {
	if (document.form.dsboard_pwd.value == "") {
		document.getElementById("dsboard_pwd").innerHTML = "<font color='red'>비밀번호를 입력해주세요</font>";
		document.form.dsboard_pwd.focus();
		return false;
	} else {
		document.getElementById("dsboard_pwd").innerHTML = "비밀번호";
		return true;
	}
}

	
function dswriteComm_go(mem_nick,dsboard_posting_no,dsboard_comm_contt,event) {
	event.preventDefault();
	var cont={
		"dsboard_comm_contt" : dsboard_comm_contt,
		"mem_nick": mem_nick,
		"dsboard_posting_no":dsboard_posting_no
	};
	if (document.formm.dsboard_comm_cont.value == "") {
		document.formm.dsboard_comm_cont.focus();
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
						'<td style="work-break:break-all;">'+dsboard_comm_contt+'<input type="button" value="추천">'+
						'<input type="button" value="비추천"></td>'+
					 	'<td>'+data+'</td>'+
					 	'<td><a href="#" onclick="updateDsComm()">수정</a>/'+
						'<a href="#" onclick="deleteDsComm()">삭제</a></td></tr>'
				
				$('#dscomm_go').append(a);
				$('#dsboard_comm_contt').val("");
			},
			error : function(error) {
				alert("22");
			}
		})
	}
}
function updateDsCommForm(indexTd, event) {
	event.preventDefault();

	var dsboard_comm_cont = $('#dsBoardComm_cont'+indexTd).text();
	
	var arr = {
		"dsboard_comm_cont" : dsboard_comm_cont
	};

	$
			.ajax({
				url : "updateDsBoardCommForm",
				type : "post",
				data : arr,
				success : function(data) {
					$('#dsBoardComm_cont' + indexTd)
							.html(
									'<textarea rows="2" cols="150" id="dsboard_comm_cont" name="dsboard_comm_cont">'
											+ data
											+ '</textarea>'
											+ '<input type="button" value="댓글수정" onclick="updateDsComm('+indexTd+',event)">');
				},
				error : function(error) {
					alert("22");
				}
			})
}



function updateDsComm(indexTd, event) {
	event.preventDefault();
	var dsboard_ans_code = $('#dsboard_ans_code'+indexTd).val();
	var dsboard_comm_cont = $('#dsboard_comm_cont').val();
	var arr = {
			"dsboard_ans_code" : dsboard_ans_code,
			"dsboard_comm_cont" : dsboard_comm_cont
		};
	$
	.ajax({
		url : "updateDsBoardComm",
		type : "post",
		data : arr,
		success : function(data) {
			$('#dsBoardComm_cont' + indexTd)
			.html(data);
		},
		error : function(error) {
			alert("22");
		}
	})
}
function deleteDsComm(dsboard_ans_code, indexTdd, event){
	event.preventDefault();
	var code ={
		"dsboard_ans_code" : dsboard_ans_code	
	};
	$.ajax({
		url:"deleteDsBoardComm",
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
function ds_src(){

	formm.action =  "dogBoardSearch";
	formm.submit();
}
function select_board(value) {
	location.href='typeDoggy?type_key='+value;
}		


// 입력가능한 글자수 확인하기
function dogTextCounter(field,countfield,maxlimit){
	if(field.value.length>maxlimit){
		field.value=field.value.substring(0,maxlimit);
		document.getElementById("dsboard_cont").innerHTML = "<font color='red'>2000자를 초과할수 없습니다.</font>";
	}
	if(field.value.length<maxlimit){
		countfield.value=maxlimit-field.value.length;
		document.getElementById("dsboard_cont").innerHTML = "Comment";
	}
}
function update_go_dog(idea,event){
	event.preventDefault();
	var notice_cont = $('#notice_cont'+idea).text();
	var arr = {
		"notice_cont" : notice_cont,
	};
	$.ajax({
			url : "dogBoardList.do",
			type : "post",
			data : arr,
			success : function(data) {
				$('#notice_cont'+ idea).html(
						'<textarea id="notice_cont" name="notice_cont" rows="13" style="width: 100%;border:0;background:clear;">'
						+ notice_cont
						+ '</textarea>'
						+ '<input type="button" value="완료" onclick="update_noti_meet('+idea+',event)" id="remo">');
				},
				error : function(error) {

				}
			})
}

function update_noti_dog(idea,event){
	event.preventDefault();
	var notice_id = JSON.stringify(idea);
	var notice_cont = $('#notice_cont').val();
	
	alert("수정될 공지사항 넘버"+notice_id);
	alert("수정될 공지사항 내용"+notice_cont);
	var arr = {
			"notice_id" : notice_id,
			"notice_cont" : notice_cont
		};
	$.ajax({
		url : "noticeUpdate",
		type : "post",
		data : arr,
		success : function(data) {
			$('#remo').remove();
			$('#notice_cont'+idea).html(data);
		},
		error : function(error) {
			alert('실패');
		}
	})
	}	
	
	
	
	
	

