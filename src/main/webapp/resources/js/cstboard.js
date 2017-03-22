function cstwriteComm_go(mem_nick,cstboard_counsel_posting_no,cstboard_ans_contt,event) {
	event.preventDefault();
	var cont={
		"cstboard_ans_contt" : cstboard_ans_contt,
		"mem_nick": mem_nick,
		"cstboard_counsel_posting_no":cstboard_counsel_posting_no
	};
	if (document.formm.cstboard_ans_cont.value == "") {
		document.formm.cstboard_ans_cont.focus();
		return false;
	}else{
		$.ajax({
			url:"writeComm",
			type:"post",
			contentType:'application/json',
			data: JSON.stringify(cont),
			success : function(data) {
				var a;
					a = '<tr><td><span class="glyphicon glyphicon-user"></span></td>'+
						'<td style="work-break:break-all;">'+cstboard_ans_contt+'</td>'+
					 	'<td>'+data.today+'</td>'+
					 	'<td><a href="#" onclick="updateDsComm()">수정</a>/'+
						'<a href="#" onclick="deleteDsComm()">삭제</a></td></tr>'
				
				$('#cstcomm_go').append(a);
				$('#cstboard_comm_contt').val("");
				var message = {};
				message.to = data.mem_mail;
				message.message = "댓글 내용 : "+cstboard_ans_contt;
				wsocket.send(JSON.stringify(message));
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

	$.ajax({
		url : "updateDsBoardCommForm",
		type : "post",
		data : arr,
		success : function(data) {
			$('#dsBoardComm_cont' + indexTd).html(
				'<textarea rows="2" cols="150" id="dsboard_comm_cont" name="dsboard_comm_cont">'+ data
				+ '</textarea><input type="button" value="댓글수정" onclick="updateDsComm('+indexTd+',event)">');
				},
				error : function(error) {
					alert("22");
				}
			})
}



/*function updateDsComm(indexTd, event) {
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
*/
function deleteCstComm(cstboard_ans_code, indexTdd, event){
	event.preventDefault();
	var code ={
		"cstboard_ans_code" : cstboard_ans_code	
	};
	$.ajax({
		url:"deleteCstBoardComm",
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
