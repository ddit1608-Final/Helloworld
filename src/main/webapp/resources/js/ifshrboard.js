function is_write_ok(form) {
	var result = true;

	if (is_cont() == false) {
		result = is_cont();
	}
	if (is_title() == false) {
		result = is_title();
	}
	if (is_pwd() == false) {
		result = is_pwd();
	}

	if (result == true) {
		// $('#isboard_cont').val().replace("\r\n","<br>")
		form.submit();
	}
}
function is_cont() {
	if (document.form.ifshrboard_cont.value == "") {
		document.getElementById("ifshrboard_cont").innerHTML = "내용을 입력해주세요";
		document.form.ifshrboard_cont.focus();
		return false;
	} else {
		document.getElementById("ifshrboard_cont").innerHTML = "";
		return true;
	}
}
function is_title() {
	if (document.form.ifshrboard_title.value == "") {
		document.getElementById("ifshrboard_title").innerHTML = "제목을 입력해주세요";
		document.form.ifshrboard_title.focus();
		return false;
	} else {
		document.getElementById("ifshrboard_title").innerHTML = "";
		return true;
	}
}
function is_pwd() {
	if (document.form.ifshrboard_pwd.value == "") {
		document.getElementById("ifshrboard_pwd").innerHTML = "비밀번호를 입력해주세요";
		document.form.ifshrboard_pwd.focus();
		return false;
	} else {
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
			data: JSON.stringify(cont),
			success : function(data) {
				var a;
				
					a = '<tr><td>'+mem_nick+'</td>'+
						'<td style="work-break:break-all;">'+ifshrboard_comm_contt+'<input type="button" value="추천">'+
						'<input type="button" value="비추천"></td>'+
					 	'<td>'+data+'</td>'+
					 	'<td><a href="#" onclick="updateIsComm()">수정</a>/'+
						'<a href="#" onclick="deleteIsComm()">삭제</a></td></tr>'
				
				$('#iscomm_go').append(a);
				$('#ifshrboard_comm_contt').val("");
			},
			error : function(error) {
				alert("22");
			}
		})
	}
}
function updateIsCommForm(indexTd, event) {
	event.preventDefault();

	var ifshrboard_comm_cont = $('#isBoardComm_cont'+indexTd).text();
	
	var arr = {
		"ifshrboard_comm_cont" : ifshrboard_comm_cont
	};

	$
			.ajax({
				url : "updateIsBoardCom1mForm.do",
				type : "post",
				data : arr,
				success : function(data) {
					$('#isBoardComm_cont' + indexTd)
							.html(
									'<textarea rows="2" cols="150" id="ifshrboard_comm_cont" name="ifshrboard_comm_cont">'
											+ data
											+ '</textarea>'
											+ '<input type="button" value="댓글수정" onclick="updateIsComm('+indexTd+',event)">');
				},
				error : function(error) {
					alert("22");
				}
			})
}



function updateIsComm(indexTd, event) {
	event.preventDefault();
	var ifshrboard_ans_code = $('#ifshrboard_ans_code'+indexTd).val();
	var ifshrboard_comm_cont = $('#ifshrboard_comm_cont').val();
	alert(ifshrboard_comm_cont);
	var arr = {
			"ifshrboard_ans_code" : ifshrboard_ans_code,
			"ifshrboard_comm_cont" : ifshrboard_comm_cont
		};
	$
	.ajax({
		url : "updateIsBoardComm.do",
		type : "post",
		data : arr,
		success : function(data) {
			$('#isBoardComm_cont' + indexTd)
			.html(data);
		},
		error : function(error) {
			alert("22");
		}
	})
}
function deleteIsComm(ifshrboard_ans_code, indexTdd, event){
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




	
function is_src(){

	formm.action =  "ifShrBoardSearch.do";
	formm.submit();
}
	
		/*}else{
			$.ajax({
				url:"isSearch.do",
				type: "get",
				data: is_key,
				success: function(data){
					document.getElementById("isert_key").innerHTML = "";
					alert('data');
				},
				error : function(error){
					document.getElementById("isert_key").innerHTML = "";
					alert('실패');
				}
			})
		}*/
	
			
		

	
	
	
	
	
	

