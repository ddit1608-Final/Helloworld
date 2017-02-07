<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
	<table style="border: 1px solid black;">
		<c:forEach items="${newsList}" var="b">
			<tr style="border: 1px solid black;">
				<%-- <td>${b.title}</td> --%>
				<td><a href='${b.originallink}'>${b.title}</a></td>
				<%-- <td>${b.description}</td> --%>
			</tr>
		</c:forEach>
	</table>
</body>
</html>