<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<div>
		<a href="<%=request.getContextPath()%>/is/ifShrBoardList.do">
		<img id="freeLogo"src="<%=request.getContextPath()%>/resources/images/ifshrboard.png"></a>
	</div>
	<form name="form" method="post">
		<table class="table table-condensed" id="blt">
			<!-- sort 기능 추가  -->
				<%-- <tr>
				<td style="text-align:center; width:13%;">
				<input type="button" class="btn btn-default btn-sm" value="전체보기"
					onclick="location.href='<%=request.getContextPath()%>/is/ifShrBoardList.do'">
					게시글 분류
				</td>
				<td colspan="3"">
					<select  style="width:25%; class="form-control" id="board_type" name="board_type" onchange="select_is(this.value)">
	        			<c:forEach items="${typeList }" var="posting" varStatus="status">
      						<c:if test="${status.count <= '3'}">
      							<option value="${posting.type_key}"
								<c:if test="${posting.type_key==param.type_key }">
									selected
								</c:if> 
      							>${posting.type_value}</option>	
      						</c:if>
      					</c:forEach>
      				</select>
				</td>
			</tr> --%>
			<!-- sort -->
				<c:forEach items="${notiList}" var="notice" varStatus="status">
					<tr style="text-align: center; border-bottom:2px solid gray; font-size:13pt;">
						<td>${notice.notice_id } 
						</td>
						<td colspan="2">
							<a href="#" data-toggle="modal" data-target="#myModal${status.count}">${notice.notice_title }
							<span class="label label-danger">필독</span></a></td>
						<td>
						<fmt:formatDate value="${notice.notice_wridate}" pattern="yyyy-MM-dd"/></td>
						<td>${notice.mem_nick }</td>
					</tr>
					<!-- modal 영역 -->
			<div class="modal fade" id="myModal${status.count}" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title" style="text-align: center; font-size: 20pt;font-weight: bold;">
									[필독]${notice.notice_id}. ${notice.notice_title }
									</h4>
								</div>
								<div class="modal-body">
									<span style="font-family: 한나; font-size: 15pt;">
										<hr style="border:none;border:5px double gray;"/>
										<c:if test="${loginUser.mem_mail ne 'admin' }">
										<textarea id="notice_cont${status.count }" name="notice_cont${status.count }" readonly="readonly" rows="13" style="width: 100%;border:0;background:clear;">${notice.notice_cont }</textarea>
										</c:if>
										<c:if test="${loginUser.mem_mail eq 'admin' }">
										<%-- <textarea id="notice_cont${status.count }" name="notice_cont${status.count }" rows="13" style="width: 100%;border:0;background:clear;">${notice.notice_cont }</textarea> --%>
										<div id="notice_cont${status.count }">
										${notice.notice_cont }									
										</div>
										
										</c:if>
										<c:set value="${notice.notice_cont}" var="notice_cont"/>
										<c:set value="${notice.notice_id}" var="notice_id"/>
										<c:set value="${status.count }" var="idea"/>
										<c:set value="notice_id${status.count }" var="idex"/>
										
										<br/>
										<hr style="border:none;border:5px double gray;"/>
										<i class="fa fa-user-circle" style="font-size:36px"></i>${notice.mem_nick } 올림
									</span>
									<span id="btnArea">
									<c:if test="${loginUser.mem_mail eq 'admin' }">
										<input type="button" class="btn btn-default btn-xs" value="수정" onclick="update_go('${idea}',event);">
										<input type="button" class="btn btn-default btn-xs" value="삭제" onclick="del_notice();">
									</c:if>
									</span>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default btn-xs"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
			</c:forEach>
					
				<tr
				style="background-color: gray; font-size: 15pt; color: white; font-family:;">
				<td style="text-align: center; width:7%;">번호</td>
				<td style="text-align: center; width:50%;">제목</td>
				<!-- <th>내용</th> -->
				<td style="text-align: center; width:8%;">닉네임</td>
				<!-- <th>작성자</th> -->
				<td style="text-align: center; width:8%;">날짜</td>
				<td style="text-align: center; width:8%;">조회수</td>
			</tr>
		
		
			
			


			<c:choose>
				<c:when test="${ifShrBoardListSize<=0}">
					<tr>
						<td width="100%" colspan="6" align="center" height="23">
							There are no registered ifShareboard.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${ifShrBoardList}" var="ifShrBoardVO">
						<tr>
							<td style="text-align: center;">${ifShrBoardVO.ifshrboard_posting_no}</td>
							<td style="text-align: center; font-family:한나;">
							<a href="/world/is/ifShrBoardDetail.do?ifshrboard_posting_no=
								${ifShrBoardVO.ifshrboard_posting_no}">
								${ifShrBoardVO.ifshrboard_title}
								<c:forEach items="${typeList }" var="type" varStatus="status">
									<c:if test="${type.type_key==ifShrBoardVO.type_key }">
										<span class="label label-default">${type.type_value}&nbsp;:
											<c:forEach var="levelList" items="${levelList }" varStatus="status">
												<c:if test="${ifShrBoardVO.crr_key == levelList.crr_key}">${levelList.crr_value}</c:if>
											</c:forEach>
										</span>
									</c:if> 
								</c:forEach>
									<%-- 댓글 수 하고 싶음
								
									<span class="badge">${isBoardCommListCnt}</span> --%>
								</a>
								
							</td>
							<%-- <td>${freeBoardVO.freeboard_cont}</td> --%>
							<td style="text-align: center;">${ifShrBoardVO.mem_nick}</td>
							<%-- <td>${loginUser.mem_nick}</td> --%>
							<td style="text-align: center;"><fmt:formatDate
									value="${ifShrBoardVO.ifshrboard_wridate}"  /></td>
							<td style="text-align: center;">${ ifShrBoardVO.ifshrboard_hits}</td>
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
					onclick="location.href='<%=request.getContextPath()%>/is/ifShrBoardWriteForm.do'">
				</c:if>
					<input type="button" class="btn btn-success btn-sm" value="메인"
					onclick="location.href='<%=request.getContextPath()%>/index'">
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
					<option value="ifshrboard_title" selected="selected">제목</option>
					<option value="ifshrboard_cont">내용</option>
					<option value="mem_nick">작성자</option>
				</select>
				<input type="text" name="key" id="key" placeholder="검색어를 입력해주세요"/>
				<%-- <input type="button" class="btn btn-success btn-sm" value="검색"	onclick="is_src('${is_key}',event)"> --%>
				<input type="button" class="btn btn-success btn-sm" value="검색"	onclick="is_src()">
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
