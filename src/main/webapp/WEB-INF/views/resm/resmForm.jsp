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
	resm_id : <input type="text" name="resm_id"><br>/
	mem_mail : <input type="text" name="mem_mail"><br>/
	sidn_code : <input type="text" name="sidn_code"><br>/
	lcse_code : <input type="text" name="lcse_code"><br>/
	acdmcr_code : <input type="text" name="acdmcr_code"><br>/
	idpic_code : <input type="text" name="idpic_code"><br>/
	resm_regno : <input type="text" name="resm_regno"><br>/
	resm_milit : <input type="text" name="milt_code"><br>/
	resm_hob : <input type="text" name="resm_hob"><br>/
	resm_like : <input type="text" name="resm_like"><br>/
	<input type="submit" value="이력서 등록">
</form>
</body>
</html>