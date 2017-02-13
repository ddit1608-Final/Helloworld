<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

</head>
<body>
 <h1>채팅페이지</h1>
 <input type="text" id="message"/>
 <input type="button" id="sendMessage" value="메세지보내기" />
 <div id="chatMessage" style="overflow: auto; max-height: 500px;"></div>
</body>


</html>


