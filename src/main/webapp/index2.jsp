<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html>
<head>
<!-- google api 확인용 지우지 마시오  -->
<meta name="google-site-verification" content="AvUOBRHYz0xPy2twmaJhZbGUSi7eYoKlJTseCv1VxJ4" />
<!-- google api 확인용 지우지 마시오  -->
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/hw.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/freeBoard.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
	<%-- 

<!-- 최상단 로고 및 검색바 -->
<header>
<nav class="navbar navbar-inverse" style="border:none;">
<div style="background-color: white;">
<table>
<tr>
	<td><a href="#"><img id="logo" src="<%= request.getContextPath() %>/images/world.png"></a></td>
	<td><input type="search" id="search"></td>
	<td><a href="#">
          <span class="glyphicon glyphicon-search"></span>
        </a></td>
</tr>        
</table>
</div>
</nav>
<!-- 최상단 로고 및 검색바END -->
<!-- 탑메뉴 -->

<nav class="navbar navbar-inverse" style="border:1px solid #003300;">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <!-- <a class="navbar-brand" href="#">Logo</a> -->
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav nav-pills">
        
        <!-- <li><a href="#">
          <span class="glyphicon glyphicon-home"></span>
        </a></li><br> -->
        <li><a href="#">구인구직</a></li>
        <li><a href="#">IT소식</a></li>
        <li><a href="#">자유게시판</a></li>
        <li><a href="#">QnA게시판</a></li>
        <li><a href="#">모임게시판</a></li>
        <li><a href="#">정보공유</a></li>
        <li><a href="#">컨설팅게시판</a></li>
        <li><a href="#">개소리</a></li>
        
    
    	
    </ul>
    </div>
    
    </div>
    
	<div class="collapse navbar-collapse" id="myNavbar" style="background-color: #d9d9d9;">
      <ul class="nav navbar-nav">
        <li><input id="login" type="text" placeholder=" 이메일"></li>
		<li><input id="login" type="password" placeholder=" 비밀번호"></li>
        <li style="margin:auto auto auto -10px;"><a href="#" id="login2">
        <span class="glyphicon glyphicon-log-in"></span>
        <font style="color:black;">&nbsp;Login</font></a></li>
		<li id="check" style="margin:1% auto; width:5%;"><label style="vertical-align: text-top;" for="check2"><input id="check2" type="checkbox" style="vertical-align: text-top;">자동</label></li>
    	<li><a href="<%=request.getContextPath()%>/member/join" id=join>회원가입</a></li>
    	<li><a href="#">아이디/비밀번호 찾기</a></li>
    	<li><a href="#">접속자수</a></li>
    </ul>
    
    </div>
     <!--  <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul> -->
     <!--  <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul> -->
    
   

</nav>
</header>
  <!-- 탑메뉴END -->  --%>

	<!-- <div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav" style="background-color: white;">
				<p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
			</div>
			컨텐트내용
			<div class="col-sm-8 text-left"> -->

	<!-- hot -->
 <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
    <!--   <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li> -->
    </ol>
    
    
	<div class="carousel-inner" role="listbox"
		style="width: 33%; border: 1px solid #9d9d9d; margin: 5px 0 auto 0; float: left;">
		<div class="item active">
			<h2 id="title">자유게시판 HOT</h2>
			<table class="table table-striped">
				<c:forEach items="${freeBoardList}" var="free" begin="1" end="10">
					<tbody>
						<tr>
							<%-- <td>
								${free.freeboard_posting_no}</td> --%>
							<td colspan="4">●<a
								href="/world/free/freeBoardDetail.do?freeboard_posting_no=${free.freeboard_posting_no}">
									${free.freeboard_title }</a>
							</td>
							<%-- <td>${free.mem_nick }</td> --%>
							<%-- <td>
								${free.freeboard_wridate }
								</td> --%>
						</tr>
					</tbody>
				</c:forEach>
			</table>

			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev" style="margin-top:-5%; height:15%; color:#3EAF0E;"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next" style="margin-top:-5%; height:15%; color:#3EAF0E;"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		
		<!-- 두번쨰 캐러샐 -->
		 <div class="item">
        		<div class="item active">
			<a href="<%=request.getContextPath()%>/dog/dogBoardList"><h2 id="title">개소리게시판 HOT</h2></a>
			<table class="table table-striped">
			<c:forEach items="${dogBoardList}" var="dog" begin="1" end="10">
				<tbody>
					<tr>
						<td>●<a
							href="/world/dog/dogBoardDetail.do?dsboard_posting_no=${dog.dsboard_posting_no}">
								${dog.dsboard_title }</a>
						</td>
					</tr>


				</tbody>
			</c:forEach>
		</table>

			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev" style="margin-top:-5%; height:15%; color:#3EAF0E;"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next" style="margin-top:-5%; height:15%; color:#3EAF0E;"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>



      </div>
      
      <!-- QnA게시판 핫 -->
		<div class="item">
        		<div class="item active">
			<a href="<%=request.getContextPath()%>/qna/qnaBoardList.do"><h2 id="title">QnA게시판 HOT</h2></a>
			<table class="table table-striped">
			<c:forEach items="${qnaBoardList}" var="dog" begin="1" end="10">
				<tbody>
					<tr>
						<td>●<a
							href="/world/qna/qnaBoardList.do?qnaboard_posting_no=${qna.qnaqnaboard_posting_no}">
								${qna.qnaboard_title }</a>
						</td>
					</tr>


				</tbody>
			</c:forEach>
		</table>

			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev" style="margin-top:-5%; height:15%;"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next" style="margin-top:-5%; height:15%;"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>



      </div>
		
		<!-- qna게시판 핫 end -->
		
		
		
	</div>
	</div>
	<!-- hot end -->







	<!-- hit  -->
	<div
		style="width: 33%; border: 1px solid #9d9d9d; margin: 5px 0 auto 5px; float: left;">
		<h2 id="title">HIT CONTENTS</h2>
		<table class="table table-striped" id="maint">
			<c:forEach items="${freeBoardList}" var="free" begin="1" end="10">
				<tbody>
					<tr>
						<%-- <td>
								${free.freeboard_posting_no}</td> --%>
						<td colspan="4">●<a
							href="/world/free/freeBoardDetail.do?freeboard_posting_no=${free.freeboard_posting_no}">
								${free.freeboard_title }</a>
						</td>
						<%-- <td>${free.mem_nick }</td> --%>
						<%-- <td>
								${free.freeboard_wridate }
								</td> --%>
					</tr>



				</tbody>
			</c:forEach>
		</table>

	</div>

	<!-- hit end -->

	<!-- new -->
	<div
		style="width: 33.1%; border: 1px solid #9d9d9d; margin: 5px 0 auto 5px; float: left;">
		<h2 id="title">NEW CONTENTS</h2>

		<table class="table table-striped">
			<c:forEach items="${dogBoardList}" var="dog" begin="1" end="10">
				<tbody>
					<tr>
						<td>●<a
							href="/world/dog/dogBoardDetail.do?dsboard_posting_no=${dog.dsboard_posting_no}">
								${dog.dsboard_title }</a>
						</td>
					</tr>


				</tbody>
			</c:forEach>
		</table>

	</div>

	<!-- new end -->

	<!-- news -->
	<div
		style="width: 33%; border: 1px solid #9d9d9d; margin: 5px 0 3% 0%; float: left;">
		<h2 id="title">NEWS</h2>
		<table class="table table-striped">

			<tbody>
				<tr>
					<td>123</td>

				</tr>
				<tr>
					<td>z</td>

				</tr>
				<tr>
					<td>d</td>

				</tr>
				<tr>
					<td>z</td>

				</tr>
				<tr>
					<td>d</td>

				</tr>


			</tbody>
		</table>

	</div>
	<!-- news end -->

	<!-- 구인 -->
	<div
		style="width: 33%; border: 1px solid #9d9d9d; margin: 5px 0 auto 5px; float: left;">
		<h2 id="title">구인</h2>

		<table class="table table-striped">

			<tbody>
				<tr>
					<td>d</td>

				</tr>
				<tr>
					<td>z</td>

				</tr>
				<tr>
					<td>d</td>

				</tr>
				<tr>
					<td>z</td>

				</tr>
				<tr>
					<td>d</td>

				</tr>


			</tbody>
		</table>

	</div>
	<!-- 구인end -->
	<!-- 구직 -->
	<div
		style="width: 33.1%; border: 1px solid #9d9d9d; margin: 5px 0 auto 5px; float: left;">
		<h2 id="title">구직</h2>

		<table class="table table-striped">

			<tbody>
				<tr>
					<td>d</td>

				</tr>
				<tr>
					<td>z</td>

				</tr>
				<tr>
					<td>d</td>

				</tr>
				<tr>
					<td>z</td>

				</tr>
				<tr>
					<td>d</td>

				</tr>


			</tbody>
		</table>

	</div>

	<!-- 구직end -->
	<!-- 	</div>
			컨텐트내용 END

			<div class="col-sm-2 sidenav" style="background-color: white;">

			</div>
		</div>
	</div>
 -->




</body>
</html>



