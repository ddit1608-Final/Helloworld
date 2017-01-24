/**
 * 
 */

function checkDepulicateId() {
	var formData = $("#joinForm").serialize();

	$
			.ajax({
				url : "<%=request.getContextPath()%>/member/duplicationCheck",
				type : "post",
				data : formData,
				success : function(data) {
					if (data == 1) {
						document.getElementById("mailCheck").value = "이미 해당 아이디로 가입된 회원가 있습니다.";
					} else {
						if ($("#mem_mail").val().length < 5) {
							document.getElementById("mailCheck").value = "아이디를 5자 이상 입력해주세요.";
						} else {
							document.getElementById("mailCheck").value = "사용 가능한 아이디입니다.";
						}
					}
				},
				error : function(error) {

				}
			});
}

function go_certification() {

	if ($("#mem_mail").val() == null || $("#mem_mail").val() == "") {
		alert("이메일을 입력하세요.");
	} else {
		location.href = "../mail/sendMail?mem_mail=" + $("#mem_mail").val();
	}
}
function free_go_detail(freeboard_posting_no){
	alert("testDA");
	var free = document.form;
	free.action="/freeBoard/freeBoardDetail.do?"+freeboard_posting_no;
	free.submit();
}

function login() {
	alert("66");
	var form = $('#login');
	alert(form);
	form.method = "post";
	form.action = "member/login";
	form.submit();
}

function post_zip() {

	var url = "findZipNum";
	window
			.open(
					url,
					"_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
}