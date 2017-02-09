<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form name="formm" method="post" action="resmWrite.do"><br>
	아이디(resm_id) : <input type="text" name="resm_id"><br>/
	이메일(mem_mail) : <input type="text" name="mem_mail"><br>/
	자기소개서(sidn_code) : <input type="text" name="sidn_code"><br>/
	자격증코드(lcse_code) : <input type="text" name="lcse_code"><br>/
	학력코드(acdmcr_Code) : <input type="text" name="acdmcr_code"><br>/
	증명사진(idpic_code) : <input type="text" name="idpic_code"><br>/
	주민등록번호(resm_regno) : <input type="text" name="resm_regno"><br>/
	병역사항(resm_milit) : <input type="text" name="milt_code"><br>/
	취미(resm_hob) : <input type="text" name="resm_hob"><br>/
	특기(resm_like) : <input type="text" name="resm_like"><br>/
	<input type="submit" value="이력서 등록">
</form>
</body>
</html>