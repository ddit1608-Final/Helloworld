<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/mypage.css">
<article>
출력해줘!!!
<table class="table table-striped" id="scrpList">
	<th colspan="4">
		<h1 class="text-center">회원님의 스크랩 내역입니다</h1>
	</th>
	<c:if test="${loginUser!=null}">
	<tr style="font-size:16pt;">
			<td style="width:20%"><input type='checkbox' id='allCheck'>
			<label style="font-size:5pt;">
			<a href="#">전체<br>삭제</a>
			</label>
			회사명</td>
			<td style="width:50%; text-align:center;">제목/내용</td>
			<td style="width:20%">기간</td>
			<td style="width:10%">삭제</td>
	</tr>
	<c:forEach items="${scrapList }" var="scrap" varStatus="status">
	<tr id="pointhover">
		<td>
			<input type="checkbox" value="${scrap.wantedAuthNo }" class="cpyCheck" hidden="hidden">
			
			${scrap.company }
		</td>
		<td style="text-align:center;">
			<a href="#">${scrap.title }</a><br/>
			${scrap.salTpNm } ${scrap.sal }<br/>
			${scrap.region }
		</td>
		<td>${scrap.regDt } ~<br/> ${scrap.closeDt }</td>
		<td><input type="button" class="btn btn-default btn-sm" id="del_scrap${status.count}" value="삭제"	onclick="delete_scrap('${scrap.wantedAuthNo}')"></td>
	</tr>
	</c:forEach>
	</c:if>
	<c:if test="${loginUser==null }">
	<tr>
		<td width="100%" colspan="6" align="center" height="23">
		There are no registered scraplist</td>
	</tr>
	</c:if>
</table>
</article>
<script>
$(function(){
	//전체선택 체크박스 클릭 
	  $("#allCheck").click(function(){ 
	  //만약 전체 선택 체크박스가 체크된상태일경우 
	  if($("#allCheck").prop("checked")) { 
	  //해당화면에 전체 checkbox들을 체크해준다 
	  $("#scrpList input[type=checkbox]").prop("checked",true); 
	  // 전체선택 체크박스가 해제된 경우 
	  } else { 
	  //해당화면에 모든 checkbox들의 체크를해제시킨다.
	  $("#scrpList input[type=checkbox]").prop("checked",false); 
	  } 
	  })
   })
 function delete_scrap(wantedAuthNo){
	alert('삭제할꺼야? >>>>> '+wantedAuthNo);
	var del_key={
			"wantedAuthNo" : wantedAuthNo
	};
	alert(del_key);
	$.ajax({
		url:"deleteScrap",
		data:JSON.stringify(del_key),
		contentType:"application/json",
		method:"post",
		dataType:"json",
		success:function(response){
			alert(JSON.stringify(response));
				if(response.success){
					alert('컨트롤러 goooooo');
				}else{
					//메세지 처리
					alert('오현택');
				}
		},
		error:function(response){
			// error!!!!!!!!
			alert('삭제 안됨!!!!!!!!!!');
		}
		})
}  
</script>