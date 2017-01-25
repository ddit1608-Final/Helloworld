<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/hw.css">	

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>


</style>
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
				<div style="width:33%; border:1px solid #9d9d9d; margin:5px 0 auto 0; float:left;">
					<h2 id="title">HOT CONTENTS</h2>

					<table class="table table-striped">
						
						<tbody>
							<tr>
								<td class="n1">d</td>

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
				<!-- hot end -->
				<!-- hit  -->
				<div style="width:33%; border:1px solid #9d9d9d; margin:5px 0 auto 5px; float:left;">
					<h2 id="title">HIT CONTENTS</h2>

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

				<!-- hit end -->


				<!-- new -->
				<div style="width:33.1%; border:1px solid #9d9d9d; margin:5px 0 auto 5px; float:left;">
					<h2 id="title">NEW CONTENTS</h2>

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
				
				<!-- new end -->
				
				<!-- news -->
				<div style="width:33%; border:1px solid #9d9d9d; margin:5px 0 3% 0%; float:left;">
					<h2 id="title">NEWS</h2>

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
				<!-- news end -->
				
				<!-- 구인 -->
				<div style="width:33%; border:1px solid #9d9d9d; margin:5px 0 auto 5px; float:left;">
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
				<div style="width:33.1%; border:1px solid #9d9d9d; margin:5px 0 auto 5px; float:left;">
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



