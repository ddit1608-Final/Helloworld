<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/is/dogBoardList.do">
		<img id="freeLogo"src="<%=request.getContextPath()%>/resources/images/dogboard.png"></a>
	</div>
	<form name="form" method="post" >
		<table class="table table-condensed" id="blt">
			<tr
				style="background-color: gray; font-size: 15pt; color: white; font-family:;">
				<td style="text-align: center;">NO</td>
				<td style="text-align: center;">SUBJECT</td>
				<!-- <th>내용</th> -->
				<td style="text-align: center;">NAME</td>
				<!-- <th>작성자</th> -->
				<td style="text-align: center;">DATE</td>
				<td style="text-align: center;">HITS</td>
			</tr>
			<c:choose>
				<c:when test="${dogBoardListSize<=0}">
					<tr>
						<td width="100%" colspan="6" align="center" height="23">
							There are no registered ifShareboard.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${dogBoardList}" var="dogBoardVO">
						<tr>
							<td style="text-align: center;">${dogBoardVO.dsboard_posting_no}</td>
							<td style="text-align: center;">
							<a href="/world/dog/dogBoardDetail?dsboard_posting_no=
								${dogBoardVO.dsboard_posting_no}"data-toggle="tooltip" data-placement="right"
									title="${dogBoardVO.dsboard_cont}">
								${dogBoardVO.dsboard_title}
								<c:forEach items="${typeList }" var="type" varStatus="status">
									<c:if test="${type.type_key==dogBoardVO.type_key }">
										<span class="label label-default">${type.type_value}</span>
									</c:if> 
								</c:forEach>
									<%-- 댓글 수 하고 싶음
								
									<span class="badge">${isBoardCommListCnt}</span> --%>
									<span class="label label-default">new</span>
								</a>
								
							</td>
							<%-- <td>${freeBoardVO.freeboard_cont}</td> --%>
							<td style="text-align: center;">${dogBoardVO.mem_nick}</td>
							<%-- <td>${loginUser.mem_nick}</td> --%>
							<td style="text-align: center;"><fmt:formatDate
									value="${dogBoardVO.dsboard_wridate}"  /></td>
							<td style="text-align: center;">${ dogBoardVO.dsboard_hits}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" style="text-align: center;">${paging}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		<div id="divdiv">
		<table style="margin: 0 auto;">
			<tr>
				<td>
				<c:if test="${loginUser != null}"> 
				<input type="button" class="btn btn-success btn-sm" value="글쓰기"
					onclick="location.href='<%=request.getContextPath()%>/dog/dogBoardWrite'">
				</c:if>
					<input type="button" class="btn btn-success btn-sm" value="메인"
					onclick="location.href='<%=request.getContextPath()%>/index2.jsp'">
					<%-- <input type="button" value="글쓰기" class="submit"onclick="location.href='<%=request.getContextPath()%>/free/freeBoardWriteForm.do'"> --%>
				</td>
			</tr>
		</table>
				<font color="red">
				<center>♥하늘으l 별은 수도없ol 많지만..LH 사랑은..오직 너뿐Ol야..♥</center>
				</font>
		</div>
	</form>
	<form name="formm" id="formm" method="post">
		<div id="divdiv">
		<table class="table table-condensed" id="blt" style="margin: 0 auto;">
			<tr >
				<td>
				<select id="type" name="type">
					<option value="dsboard_title" selected="selected">제목</option>
					<option value="dsboard_cont">내용</option>
					<option value="mem_nick">작성자</option>
				</select>
				<input type="text" name="key" id="key" placeholder="검색어를 입력해주세요"/>
				<%-- <input type="button" class="btn btn-success btn-sm" value="검색"	onclick="is_src('${is_key}',event)"> --%>
				<input type="button" class="btn btn-success btn-sm" value="검색"	onclick="ds_src()">
				<marquee behavior=alternate width="300" scrollamount="5">
				<span>
				총 (${searchCnt})개의 게시물
				</span>
				</marquee>
				<marquee width="300">←<font color="pink">♥</font>--&lt;</marquee><font size="5">{＼((￣<font color="red">■</font> ￣)</font>
				</td>
				</tr>
				<tr>
					<td style="background: white;">
						<label id="isert_key" style="color:red;"></label>
					</td>
					<td></td>
			</tr>
		</table>
		</div>
	</form>
</article>
