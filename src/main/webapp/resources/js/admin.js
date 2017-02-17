/**
 * 
 */


function memberUpdate() {
	alert('11111111111');
}

function edit(id) {
	//$('#'+id).attr('readonly', false);
	
}

function cstStart(cstboard_counsel_posting_no) {
	//location.href='cstStart?cstboard_counsel_posting_no='+cstboard_counsel_posting_no;
	
	$.ajax({
		url:"cstStart",
		type:"post",
		data: {"cstboard_counsel_posting_no":cstboard_counsel_posting_no},
		success : function(data) {
			var message = {};
			message.to = data;
			message.message = "컨설팅 진행중"
			wsocket.send(JSON.stringify(message));
		},
		error : function(error) {
			alert("22");
		}
	})
}