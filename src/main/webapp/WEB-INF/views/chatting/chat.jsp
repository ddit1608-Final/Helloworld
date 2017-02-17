<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
h1, input{
font-family:한나;
}

</style>
</head>
<body>
 <h1>CHATTING</h1>
 <input type="text" id="message"/>
 <input type="button" id="sendMessage" value="전송"/>
 <div id="chatMessage" style="overflow: auto; max-height: 400px; text-align:left; font-family:한나; font-size:12pt"></div>
</body>


</html>


