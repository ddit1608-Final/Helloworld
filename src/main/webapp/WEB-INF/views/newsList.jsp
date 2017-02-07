<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
td{
font-family: 돋움;
font-size:12pt;

}
td a{
color:black;
}
</style>

<article>
<div style="margin-top:1%;">
<table class="table table-hover">
	<tbody>
		<c:forEach items="${newsList}" var="b">
			<tr style="border: 1px solid black;">
				<%-- <td>${b.title}</td> --%>
				<td><a href='${b.originallink}'>${b.title}</a></td>
				<%-- <td>${b.description}</td> --%>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	</div>
</article>