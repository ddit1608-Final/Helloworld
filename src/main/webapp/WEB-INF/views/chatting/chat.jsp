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
input[type=button]{
background-color: #3EAF0E;
color:white;
font-family:한나;
}
input[type=button]:hover{
background-color: #006f00;
color:white;
}
</style>
</head>
<body>
 <h1>CHATTING</h1>
 <input type="text" id="message" style="width:70%;"/>
 <input type="button" id="sendMessage" value="전송" style="border-radius:4px; border:none; height:28px;"/>
 <div id="chatMessage" style="overflow: auto; max-height: 400px; text-align:left; font-family:한나; font-size:12pt"></div><br/>
 <hr style="margin-bottom:15px; border:1px thin red;">
 <input style="margin-bottom:5%;" class="btn" type="button" id="detailBtn" value="채팅CLOSE▲" onClick="chat_detail()"/><br />
</body>


</html>


