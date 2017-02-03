function iswrite_ok(form) {
	var result = true;

	if (cont() == false) {
		result = cont();
	}
	if (title() == false) {
		result = false;
	}
	if (pwd() == false) {
		result = false;
	}

	if (result == true) {
		// $('#isboard_cont').val().replace("\r\n","<br>")
		form.submit();
	}
}
function cont() {
	if (document.form.ifshrboard_cont.value == "") {
		document.getElementById("ifshrboard_cont").innerHTML = "내용을 입력해주세요";
		document.form.ifshrboard_cont.focus();
		return false;
	} else {
		document.getElementById("ifshrboard_cont").innerHTML = "";
		return true;
	}
}
function title() {
	if (document.form.ifshrboard_title.value == "") {
		document.getElementById("ifshrboard_title").innerHTML = "제목을 입력해주세요";
		document.form.ifshrboard_title.focus();
		return false;
	} else {
		document.getElementById("ifshrboard_title").innerHTML = "";
		return true;
	}
}
function pwd() {
	if (document.form.ifshrboard_pwd.value == "") {
		document.getElementById("ifshrboard_pwd").innerHTML = "비밀번호를 입력해주세요";
		document.form.ifshrboard_pwd.focus();
		return false;
	} else {
		document.getElementById("ifshrboard_pwd").innerHTML = "";
		return true;
	}
}

function iswriteComm_go() {
	if (document.formm.ifshrboard_comm_cont.value == "") {
		alert("댓글을 입력해주세요");
		document.formm.ifshrboard_comm_cont.focus();
		return false;
	} else {
		formm.submit();
		return true;
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
				url : "updateIsBoardCommForm.do",
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
	
	alert('ifshrboard_ans_code : '+ifshrboard_ans_code);
	alert('ifshrboard_comm_cont : '+ifshrboard_comm_cont);
	
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
			alert("11");
		},
		error : function(error) {
			alert("22");
		}
	})
}
/*
 * $(document).ready(function(){ $('#div1hide').click(function(){
 * $('#div1').hide(); $('#div2').show(); }); $('#div2hide').click(function(){
 * //$('#div2').val() $('#div2').hide(); $('#div1').show(); }); })
 */
