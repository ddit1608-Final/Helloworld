<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
  <script type="text/javascript"
	src="<%=request.getContextPath()%>/js/member.js"></script>
<link href="<%=request.getContextPath()%>/resources/css/hw.css" rel="stylesheet">

</head>


<style>
::selection {
	/* background: #68e234; */
	background:#68e234;
}

@font-face {
	font-family: "한나";
	src: url(../resources/fonts/BM-HANNA.ttf) format("truetype");
}
@font-face {
	font-family: "한나";
	src: url(fonts/BM-HANNA.ttf) format("truetype");
}
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}

.navbar-inverse {
	width: 65%;
	margin: auto;
	background-color: #3EAF0E;
}

#logo {
	width: 60%;
}

#search {
	float: right;
	border: 4px solid #3EAF0E;
	margin: 3% auto auto auto;
}

.glyphicon-search {
	color: white;
	font-size: 15pt;
	background-color: #3EAF0E;
	margin: 3% auto auto auto;
	padding: 16%;
	padding-bottom: 16%;
}

.navbar-nav {
	width: 100%;
	height: 48px;
}

.navbar-nav label {
	margin: 1% auto auto auto;
}

.navbar-nav li a {
	color: black;
}

.navbar-nav li:focus {
	color: black;
}

.navbar-nav li a:hover {
	color: black;
}

.navbar-nav input {
	margin: 7% auto;
}

.nav-pills li a {
	font-family: 한나;
	color: white;
	font-size: 15pt;
}

.nav-pills li {
	margin: auto auto auto 13%;
}

.nav-pills li a:HOVER {
	background-color: #006f00;
}

.nav li a:focus {
	background-color: #1e440e;
}

.login {
	width: 95%;
	float: inherit;
}

/* .glyphicon-log-in{
    color:black;
    font-size:12pt;
    margin:15px 15px 0 5px;
    font-family:한나;
   
    }
    .glyphicon-log-in:hover{
    color:#3EAF0E;
    }
     */
#login2 li a:hover {
	color: #3EAF0E;
}

#check:hover {
	color: #3EAF0E;
}

.navbar-nav {
	margin-left: 15%;
}

.text-center2 {
	width: 65%;
	margin: 0 auto;
	background-color: #d9d9d9;
	color: black;
	font-family: 한나;
}

#aa {
	color: black;
	font-family: 한나;
	font-size: 12pt;
}

#aa:hover {
	color: #3EAF0E;
}

#auto {
	font-family: 한나;
	font-size: 12pt;
}

#loginbtn {
	color: black;
	font-family: 한나;
	margin: 11px 10px auto -5px;
	font-size: 12pt;
	height: 55%;
}

#loginbtn:hover {
	color: #3EAF0E;
}

#mem_mail{
padding-top:13px;

font-family:한나;
font-size:12pt;
color:#a31313;
}

</style>

<body>

<!-- 최상단 로고 및 검색바 -->
<header>
	<nav class="navbar navbar-inverse" style="border: none;">
		<div style="background-color: white;">
			<table>
				<tr>
					<td><a href="#"><img id="logo"
							src="<%=request.getContextPath()%>/images/world2.png" onclick="location.href='<%=request.getContextPath()%>/index2.jsp'"></a></td>
					<td><input type="search" id="search"></td>
					<td><a href="#"> <span class="glyphicon glyphicon-search"></span>
					</a></td>
				</tr>
			</table>
		</div>
	</nav>
	<!-- 최상단 로고 및 검색바END -->
	<!-- 탑메뉴 -->

	<nav class="navbar navbar-inverse"
		style="border-left: 1px solid #3EAF0E; border-bottom: 1px solid #3EAF0E; border-right: 1px solid #3EAF0E; border-top: none;">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- <a class="navbar-brand" href="#">Logo</a> -->
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav nav-pills">

					<!-- <li><a href="#">
          <span class="glyphicon glyphicon-home"></span>
        </a></li><br> -->

        <li><a href="<%=request.getContextPath()%>/worknet/worknet.do">구인구직</a></li>
        <li><a href="#">IT소식</a></li>
        <li><a href="<%=request.getContextPath()%>/free/freeBoardList.do">자유게시판</a></li>
        <li><a href="#">QnA게시판</a></li>
        <li><a href="#">모임게시판</a></li>
        <li><a href="#">정보공유</a></li>
        <li><a href="#">컨설팅게시판</a></li>
        <li><a href="#">개소리</a></li>
        
    
    	
    </ul>
    </div>
    
    </div>
    
	<div class="collapse navbar-collapse" id="myNavbar" style="background-color: #d9d9d9;">
	<form method="post" id="login" name="login" style="margin: 0;" 
			action="<%=request.getContextPath()%>/member/login">
      <ul class="nav navbar-nav">
      	<c:choose>
      		<c:when test="${loginUser eq null }">
      			<li><input class="login" id="login_mem_mail" name="login_mem_mail" type="text" placeholder=" 이메일"></li>
				<li><input class="login" id="login_mem_pw" name="login_mem_pw" type="password" placeholder=" 비밀번호"></li>
		        <li><input type="submit" value="로그인" id="loginbtn"></li>
				<li id="check" style="margin: 13px auto; width: 5%;"><label
					style="vertical-align: text-botom;" for="check2" id="auto">
						<input id="check2" type="checkbox"
						style="vertical-align: text-top;"> 자동
				</label></li>
		    	<li><a href="<%=request.getContextPath()%>/member/join" id="aa">회원가입</a></li>
      		</c:when>
      		<c:otherwise>
      			<li id="mem_mail" name="mem_mail">(Level) ${loginUser.mem_nick } (POINT) </li>
				<li><a href="#" id="aa">접속자수</a></li>
				<li><a href="#" id="aa">반응 ()</a></li>
				<li><a href="<%=request.getContextPath()%>/resm/resmList.do" id="aa">마이페이지</a></li>
				<li><a href="<%=request.getContextPath()%>/member/logout" id="aa">로그아웃</a></li>
      		</c:otherwise>
      	</c:choose>
    	<li><a href="#" id="aa">아이디/비밀번호 찾기</a></li>
    	<li><a href="#" id="aa">접속자수</a></li>
    </ul>
    </form>
    
    </div>
     <!--  <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul> -->
     <!--  <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul> -->
   
   

		<!--  <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul> -->
		<!--  <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul> -->




	</nav>
</header>

<!-- 탑메뉴END -->
<!-- 컨텐트 -->

<div class="container-fluid text-center">
		<div class="row content">
			 <div class="col-sm-2 sidenav" style="background-color: white;">
				<!-- <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p> -->
			</div> 
			<!-- 컨텐트내용 -->
			<div class="col-sm-8 text-left">
			
			
<decorator:body />
	</div>
			<!-- 컨텐트내용 END -->

			<div class="col-sm-2 sidenav" style="background-color: white;">
			</div>
		</div>
	</div>

<!-- 컨텐트end -->
<!-- 풋터 -->
<footer class="container-fluid text-center2">
	<p style="float:right">Copyright © 2016 Apple Inc. 모든 권리 보유</p>
</footer>
<!-- 풋터 END-->
</body>
</html>
