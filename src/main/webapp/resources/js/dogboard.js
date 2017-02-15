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
	if (document.form.dsboard_cont.value == "") {
		document.getElementById("dsboard_cont").innerHTML = "내용을 입력해주세요";
		document.form.dsboard_cont.focus();
		return false;
	} else {
		document.getElementById("dsboard_cont").innerHTML = "";
		return true;
	}
}
function ds_title() {
	if (document.form.dsboard_title.value == "") {
		document.getElementById("dsboard_title").innerHTML = "제목을 입력해주세요";
		document.form.dsboard_title.focus();
		return false;
	} else {
		document.getElementById("dsboard_title").innerHTML = "";
		return true;
	}
}
function ds_pwd() {
	if (document.form.dsboard_pwd.value == "") {
		document.getElementById("dsboard_pwd").innerHTML = "비밀번호를 입력해주세요";
		document.form.dsboard_pwd.focus();
		return false;
	} else {
		document.getElementById("dsboard_pwd").innerHTML = "";
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
		alert("댓글을 입력해주세요");
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
	alert(dsboard_comm_cont);
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

	
	
	
	
	
	

