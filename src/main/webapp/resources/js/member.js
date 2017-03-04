/**
 * 
 */
function change_pw() {
	var result = true;
	
	if (check_pw() == false)
		result = false;
	// 패스워드 확인
	if (check_pwdcheck() == false)
		result = false;
	
	if (result == true) {
		
		$('#changeForm').submit();
		
	}
	
}

function findPw_go() {
	if(check_mail() == true) {
		$('#findPw').submit();
	}
}

function key_enter(event) {
	if (event.which == 13) {
		login_go();
	}
}

function logout_go(event) {
	event.preventDefault();
}

function login_go() {
	var str = document.location.href;
	var index = str.indexOf("?");
	if (index != -1) {
		var paramStr = str.substring(index + 1);
	}
	alert(str); // localhost:8181/world/index
	alert(index); // -1
	alert(paramStr); // undifined
	$('#param').val(paramStr);

	$('#login').submit();
}

function autoHypenLicense() {
	var str = $('#compmem_bsnss_lcse_no').val();

	var length = str.length;

	if (length == 3 || length == 6) {
		$('#compmem_bsnss_lcse_no').val(str + "\-");
	}

}

function go_joinComp() {
	$('#joinCompForm').submit();
}

function go_join(certifi) {
	var result = true;

	// 이메일 유효성 검사
	if (check_mail() == false)
		result = false;
	// 패스워드 유효성 검사
	if (check_pw() == false)
		result = false;
	// 패스워드 확인
	if (check_pwdcheck() == false)
		result = false;

	// 이름 유효성 검사
	if (check_name() == false) {
		result = false;
	}

	// 닉네임 유효성 검사
	if (check_nick() == false) {
		result = false;
	}

	// 닉네임 유효성 검사
	if (check_phn() == false) {
		result = false;
	}

	// 성별 선택 검사
	if (check_sex() == false) {
		result = false;
	}

	// 주소 입력여부 검사
	if (check_addr() == false) {
		result = false;
	}

	if (result == true) {
		// 이메일 인증 검사
		if (certifi == "success") {
			$('#joinForm').submit();
		} else {
			document.getElementById("mailCheck").innerHTML = "이메일 인증을 해야 합니다.";
			return;
		}
	}

}

function go_update() {
	var result = true;

	// 패스워드 유효성 검사
	if (check_pw() == false)
		result = false;
	// 패스워드 확인
	if (check_pwdcheck() == false)
		result = false;

	// 이름 유효성 검사
	if (check_name() == false) {
		result = false;
	}

	// 닉네임 유효성 검사
	if (check_nick() == false) {
		result = false;
	}

	// 닉네임 유효성 검사
	if (check_phn() == false) {
		result = false;
	}

	// 성별 선택 검사
	if (check_sex() == false) {
		result = false;
	}

	// 주소 입력여부 검사
	if (check_addr() == false) {
		result = false;
	}

	if (result == true) {
		$('#updateForm').submit();
	}

}

// 이메일 유효성.
function check_mail() {
	var mail = $('#mem_mail').val();

	var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

	if (regex.test(mail) === false) {
		document.getElementById("mailCheck").innerHTML = "잘못된 이메일 형식입니다.";
		return false;
	} else {
		document.getElementById("mailCheck").innerHTML = "";
		return true;
	}
}

// 패스워드 유효성 검사
function check_pw() {
	var pw = $('#mem_pw').val();

	var regex = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;

	if (!regex.test(pw)) {
		document.getElementById("pwCheck").innerHTML = "(영문, 숫자 혼합하여 6~20자리)";
		return false;
	} else {
		document.getElementById("pwCheck").innerHTML = "";
		return true;
	}

}

// 패스워드 확인 검사
function check_pwdcheck() {
	var pw = $('#mem_pw').val();
	var pwdCheck = $('#pwdCheck').val();

	if (pw == pwdCheck) {
		document.getElementById("pwdCheckCheck").innerHTML = "";
		return true;
	} else {
		document.getElementById("pwdCheckCheck").innerHTML = "패스워드가 일치하지 않습니다.";
		return false;
	}
}

// 이름 유효성 검사
function check_name() {
	var name = $('#mem_nm').val();

	var regex = /^[가-힝]{2,}$/;

	if (regex.test(name) == false) {
		document.getElementById("nameCheck").innerHTML = "잘못된 이름 입니다.";
		return false;
	} else {
		document.getElementById("nameCheck").innerHTML = "";
		return true;
	}
}

// 닉네임 유효성 검사
function check_nick() {
	var nick = $('#mem_nick').val();

	var regex = /^.*(?=.{1,10}).*$/;

	if (!regex.test(nick)) {
		document.getElementById("nickCheck").innerHTML = "(1~10자리)";
		return false;
	} else {
		document.getElementById("nickCheck").innerHTML = "";
		return true;
	}

}

// 핸드폰 유효성 검사
function check_phn() {
	var phn = $('#mem_phn').val();

	var regex = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;

	if (!regex.test(phn)) {
		document.getElementById("phnCheck").innerHTML = "잘못된 번호 입니다. (-를 제외하고 적어주세요)";
		return false;
	} else {
		document.getElementById("phnCheck").innerHTML = "";
		return true;
	}

}

// 성별 선택 체크
function check_sex() {

	var sex = $('input:radio[name=mem_sex]').is(':checked');

	if (sex == true) {
		document.getElementById("sexCheck").innerHTML = "";
		return true;
	} else {
		document.getElementById("sexCheck").innerHTML = "성별을 선택해 주세요.";
		return false;
	}
}

// 주소 선택 체크
function check_addr() {

	var mem_addr = $('#mem_addr').val();

	if (mem_addr == null || mem_addr == "") {
		document.getElementById("addrCheck").innerHTML = "주소를 입력해 주세요.";
		return false;
	} else {
		document.getElementById("addrCheck").innerHTML = "";
		return true;
	}
}

function checkDepulicateId() {
	$
			.ajax({

				url : "duplicationCheck",
				type : "post",
				data : $("#joinForm input").serialize(),
				success : function(data) {
					if (data == "Exit") {
						document.getElementById("mailCheck").innerHTML = "이미 해당 아이디로 가입된 회원가 있습니다.";
					} else {
						if ($("#mem_mail").val().length < 5) {
							document.getElementById("mailCheck").innerHTML = "아이디를 5자 이상 입력해주세요.";
						} else {
							document.getElementById("mailCheck").innerHTML = "";
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
function free_go_detail(freeboard_posting_no) {
	alert("testDA");
	var free = document.form;
	free.action = "/freeBoard/freeBoardDetail.do?" + freeboard_posting_no;
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