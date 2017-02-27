<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/freeBoard.css">
<style>


#memberList tr:hover{
background-color: #abe693;
}

#nonhover:hover{
background-color: #c1c1c1 !important;
}
#nonhover{
background-color: #c1c1c1;
}
*{
font-family:한나;
}
.container{
width:100%;
}
#th{
font-size:16pt !important;
}
#memberList td{
font-size:13pt;
}
label{
font-size:13pt;
}
#paging:hover{
background-color: white !important;
}
</style>
<article>
	<div class="container">
		<h1 class="text-center">회원 리스트</h1>
		<hr>

		<form style="margin-left:70%;"class="form-inline" action="memberManage" id="memberSearch"
			method="get">
			<div class="form-group">
				<label for="pwd">회원 이름 :</label> <input type="text"
					class="form-control" id="key" name="key">
			</div>
			<input type="submit" class="btn btn-default" value="검색">
		</form>
			<hr>


		<table id="memberList" class="table table-striped">
			<thead>
				<tr id="nonhover">
					<td id="th">번호</td>
					<td id="th">이름</td>
					<td id="th">이메일</td>
					<td id="th">연락처</td>
					<td id="th">닉네임</td>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${memberListSize<=0}">
						<tr>
							<td width="100%" colspan="5" align="center" height="23">
								There are no registered members.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${memberList}" var="memberVO" varStatus="status">
							<tr>
								<td>${status.count }</td>
								<td class="name">${memberVO.mem_nm}</td>
								<td class="id"><a
									href="<%=request.getContextPath()%>/admin/memberDetail?mem_mail=${memberVO.mem_mail}">${memberVO.mem_mail}</a>
								</td>
								<td class="email">${memberVO.mem_phn}</td>
								<td class="phone">${memberVO.mem_nick}</td>
							</tr>
						</c:forEach>
						<tr id="paging">
							<td colspan="5" style="text-align: center;">${paging}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>


	</div>
</article>
