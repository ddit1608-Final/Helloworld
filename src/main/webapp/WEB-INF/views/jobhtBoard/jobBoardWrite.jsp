<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
<form name="formm" method="post" action="jobhtWrite.do"><br>
	mem_mail : <input type="text" name="mem_mail"><br>
	jobhtboard_homep : <input type="text" name="jobhtboard_homep"><br>
	jobhtboard_hope_sal : <input type="text" name="jobhtboard_hope_sal"><br>
	jobhtboard_hope_workp : <input type="text" name="jobhtboard_hope_workp"><br>
	jobhtboard_vltr_kind : <input type="text" name="jobhtboard_vltr_kind"><br>
	jobhtboard_posting_no : <input type="text" name="jobhtboard_posting_no"><br>
	resm_id : <input type="text" name="resm_id"><br>
	com_use_abil_code : <input type="text" name="com_use_abil_code"><br>
	lang_abil_code : <input type="text" name="lang_abil_code"><br>
	<input type="submit" value="구인등록">
</form>
</body>
</html>