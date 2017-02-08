<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<article>
	<div class="container">
		<h3 class="text-center">MEMBER LIST</h3>

		<form class="form-inline" action="memberManage" id="memberSearch"
			method="get">
			<div class="form-group">
				<label for="pwd">Member Name :</label> <input type="text"
					class="form-control" id="key" name="key">
			</div>
			<input type="submit" class="btn btn-default" value="Search">
		</form>


		<table id="memberList" class="table table-striped">
			<thead>
				<tr>
					<th>Number</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>NickName</th>
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
								<td class="id">${memberVO.mem_mail}
								</td>
								<td class="email">${memberVO.mem_phn}</td>
								<td class="phone">${memberVO.mem_nick}</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="4" style="text-align: center;">${paging}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		

	</div>
</article>
