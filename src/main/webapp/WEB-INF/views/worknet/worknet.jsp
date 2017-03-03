<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/freeBoard.css">
<article>
	<!--						리모콘									  -->
	<%-- 로그인유저가 있을경우에 스크랩 기능을 해야되기때문에 추후 주석 제거 
	<c:if test="${loginUser!=null }"> --%>
	<%-- <div style="position: relative; float: left; width: 80px;">
		<div id="right_section"	style="position: absolute; top: 0px; left: 0px;">
			<table style="border: 1px solid black;width:100px;height:300px;">
				<tr>
				<th style="text-align: center">리모콘</th>
				<td></td>
				</tr>
				<tr>
				<th style="text-align: center">
				<button class="btn btn-success btn-xs" style="font-size:15px;" onclick="chk_chk()">스크랩 <i class="fa fa-cart-plus"></i></button>
				<button class="btn btn-success btn-xs" style="font-size:15px;" onclick="list_go()">내역확인 <i class="fa fa-cart-plus"></i></button>
				 <a href="<%=request.getContextPath()%>/index"><i class="fa fa-home"></i></a>
				</th>
				<td></td>
				</tr>
			</table>
		</div>
	</div> --%>
	<!--						리모콘									  -->
<!-- 	
	<form id="test">
		<input type="hidden" name="authKey" value="asdfasfsadf" />
	</form> 
	-->
	<!--						워크넷 구인정보 찍을위치 시작								
									<< example >>  
				<div style="background-color: red;" id="table"></div> 
	-->
	<table id="table" class="table table-condensed">
		<tr>
			<th>(체크박스)회사명</th>
			<th>제목/임금/근무지역</th>
			<th>학력/경력</th>
			<th>등록일자</th>
			<th>마감일자</th>
		</tr>
	</table>
<!-- 	<button class="btn btn-success btn-xs" style="font-size:15px;" 
		onclick="chk_chk()">스크랩 <i class="fa fa-cart-plus"></i></button> -->
	<table style="margin: auto;">
	<tr>
		<td>
		<button class="btn btn-success btn-xs" style="font-size:15px;" 
			onclick="chk_chk()"data-toggle="modal" data-target="#myModal">스크랩 <i class="fa fa-cart-plus"></i></button>
		<button class="btn btn-success btn-xs" style="font-size:15px;" 
			onclick="list_go()">내역확인 <i class="fa fa-cart-plus"></i></button>
		</td>
	</tr>
	</table>			
		
		
	<!--						워크넷 구인정보 찍을위치 종료									  -->
	<!-- 							Modal													 -->
	<!-- var eachCompanies = $('.cpyCheck:checked').closest("tr");
	 	var array = [];
	 	$.each(eachCompanies, function(){
	 		array.push($(this).data("currentData"));
	 	});
	 	alert(JSON.stringify(array)); -->
	 	<div class="modal fade" id="myModal" role="dialog">
	 					<form action="post" name="addScrap">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">선택된 목록</h4>
								</div>
								<div class="modal-body">
								
								</div>
								<div class="modal-footer">
									<input type="button" class="btn btn-default btn-xs" value="스크랩" onclick="scrap_go();" >
									<button type="button" class="btn btn-default btn-xs"
										data-dismiss="modal" onclick="close_go();">Close</button>
								</div>
							</div>
						</div>
						</form>
					</div>
	 	
	 	
	 	

	<!-- 							Modal													 -->
	
	<!--						워크넷에서 가져온 데이타 스크립트출력									  -->
	<script>
// 		$("스크랩버튼").on("click", function(){
	/* 		var data = $("#test").serialize();
			$.ajax({
				url:"./workNetList",
				data:data,
				dataType:"xml",
				success:function(xmlBody){
					var wanted = $(xmlBody).find("wanted");
					$.each(wanted, function(idx, each){
						var eachCompany = {
							id:$(each).find("wantedAuthNo").text(),
							name:$(each).find("company").text(),
							address:$(each).find("detailAddr").text()
						};
						var ptag = $("<p><span class='name'>"+eachCompany.name+"<span><input type='checkbox' class='cpyCheck' value='"+eachCompany.id+"'/><span class='address'>"+eachCompany.address	+"</span></p>");
						$(ptag).data("currentData", eachCompany);
						$("#table").append(ptag);
					});
				}
			}); */
			var data = $("#test").serialize();
			$.ajax({
				url:"./workNetList",
				data:data,
				dataType:"xml",
				success:function(xmlBody){
					var wanted = $(xmlBody).find("wanted");
					$.each(wanted, function(idx, each){
						var eachCompany = {
							id:$(each).find("wantedAuthNo").text(),
							name:$(each).find("company").text(),
							title:$(each).find("title").text(),
							sal:$(each).find("sal").text(),
							region:$(each).find("region").text(),
							minEdubg:$(each).find("minEdubg").text(),
							career:$(each).find("career").text(),
							start:$(each).find("regDt").text(),
							end:$(each).find("closeDt").text(),
							salTpNm:$(each).find("salTpNm").text()
							/* infoSvc:$(each).find("infoSvc").text() */
						};
						var ptag = 
								$("<tr><td class='yn'>"+
								"<input type='checkbox'class='cpyCheck' value="+eachCompany.id+">"+eachCompany.name+"</td>"+
								"<td class='title'><a>"+eachCompany.title+"</a><br>("+eachCompany.salTpNm+")"+eachCompany.sal+
								"<br>"+eachCompany.region+"</td>"+
								"<td class='start'>"+eachCompany.minEdubg+
								"<br>"+eachCompany.career+"</td>"+
								"<td class='start'>"+eachCompany.start+"</td>"+
								"<td class='end'>"+eachCompany.end+"</td>");
						$(ptag).data("currentData", eachCompany);
						$("#table").append(ptag);
					});
				}
			});	
	</script>
	<!--						워크넷에서 가져온 데이타 스크립트출력문 종료									  -->
	
	
</article>