function is_write_ok(form) {
	var result = true;

	//if (is_cont() == false) {
	//}
	//if (is_title() == false) {
		result = is_cont();
		result &= is_title();
		result &= is_pwd();
		result &= is_level();
	if (result == true) {
		form.submit();
	}
}
function is_cont() {
	if (document.form.ifshrboard_cont.value == "      				") {
		document.getElementById("ifshrboard_cont").innerHTML = "<font color='red'>내용을 입력해주세요</font>";
		document.form.ifshrboard_cont.focus();
		return false;
	} else {
		document.getElementById("ifshrboard_cont").innerHTML = "Comment";
		return true;
	}
}
function is_title() {
	if (document.form.ifshrboard_title.value == "") {
		document.getElementById("ifshrboard_title").innerHTML = "<font color='red'>제목을 입력해주세요</font>";
		document.form.ifshrboard_title.focus();
		return false;
	} else {
		document.getElementById("ifshrboard_title").innerHTML = "제목";
		return true;
	}
}
function is_pwd() {
	if (document.form.ifshrboard_pwd.value == "") {
		document.getElementById("ifshrboard_pwd").innerHTML = "<font color='red'>비밀번호를 입력해주세요</font>";
		document.form.ifshrboard_pwd.focus();
		return false;
	} else {
		document.getElementById("ifshrboard_pwd").innerHTML = "비밀번호";
		return true;
	}
}
// 오픈소스 난이도 라디오 체크 
function is_level(){
	var a = document.form.sel1.value;
	var b = document.form.crr_key.value;
	if(a=='2'){
		if(b == '7'){
			alert('하이');
			alert(b);
			document.getElementById("check_radio").innerHTML = "<font color='red'>난이도를 선택해주세요</font>";
			return false;
		}
		else{
			alert('바이');
			alert(b);
			document.getElementById("check_radio").innerHTML = "";
			return true;
	}
	
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
	
function select_is(value) {
	location.href='typeIs?type_key='+value;
}

// 글자수
function isTextCounter(field,countfield,maxlimit){
	if(field.value.length>maxlimit){
		field.value=field.value.substring(0,maxlimit);
	}else if(field.value.length<1){
		countfield.value=maxlimit-field.value.length;
		document.getElementById("ifshrboard_cont").innerHTML = "<font color='red'>내용을 입력해dsd주세요</font>";
	}
}



function select_level(value,event){
	event.preventDefault();

	var tt = $("#sel1 option:selected").val();
	//alert(tt); //==> 2
	
	if(tt == '1'||tt=='3'){
		$.ajax({
			url : "level",
			type : "post",
			data : tt,
			success : function(data) {
				    $('#comboo').remove();
					$('#combo span').html(
						"<span id='check_radio'>" +
						"<input type='radio' id='check_lv' name='crr_key' value='7' checked='checked' hidden='hidden'>"+  
						"</span>"+
						"<div id='comboo'>"+
						"<input type='radio' id='crr_key' name='crr_key' value='4'>下"+
						"<input type='radio' id='crr_key' name='crr_key' value='5'>中"+
						"<input type='radio' id='crr_key' name='crr_key' value='6'>上"+
						"</div>"
					);
					
					$('#comboo').remove();
					alert('1번째');
				},
				error : function(error) {
					alert("메뉴에러!!!!!!!!");
				}
			})
	}
	
	if(tt=='2'){
	$.ajax({
			url : "level",
			type : "post",
			data : tt,
			success : function(data) {
					/*$('#combo').show();
					$('#dio').removeAttr( "disabled" );
					$('#dio4').removeAttr("checked");*/
					$('#comboo').remove();
					$('#check_radio').remove();
					$('#combo span').html(
					"<span id='check_radio'>" +
					"<input type='radio' id='check_lv' name='crr_key' value='7' checked='checked' hidden='hidden'>"+  
					"</span>"+
					"<div id='comboo'>"+
					"<input type='radio' id='crr_key' name='crr_key' value='4'>下"+
					"<input type='radio' id='crr_key' name='crr_key' value='5'>中"+
					"<input type='radio' id='crr_key' name='crr_key' value='6'>上"+
					"</div>"
					);
					alert('2번째');
				},
				error : function(error) {
					alert("메뉴에러!!!!!!!!");
				}
			})
		}
}
function noti_update(notice_cont){
	var updateNotice = $('#notice_cont').val();
	alert(updateNotice);
	$.ajax({
		url:"noticeUpdate",
		type:'json',
		data:updateNotice,
		success : function(data){
			alert('성공');
			$('input[type="text"],textarea').attr('readonly',false);
		},
		error : function(data){
			alert('ddd');
			alert(tt)
		}
		
		
	});
}

	
	
	
	

