<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
hr{
border:1px solid #5e5e5e;
}
</style>
<article>
<!--
========================================================  
1월 January  
2월 Febuary 
3월 March 
4월 April 
5월 May 
6월 June 
7월 July  
8월 August 
9월 September
10월 October
11월 November
12월 December
========================================================
Sunday Monday Tuesday Wednesday Thursday Friday Saturday
일      월      화      수        목         금        토
========================================================

중요 일자 처리  
      1.<span class="active"> 값 </span> ==> 옥색
      2.<span class="activee"> 값 </span> ==> 빨간색
-->





   <div class="container" style="margin-left:-1.2%; width:102.4%;">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
  <!--   <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol> -->

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img id="calCar" src="<%=request.getContextPath()%>/resources/images/cal6.png" alt="Chania" width="460" height="345">
      </div>

      <div class="item">
        <img id="calCar" src="<%=request.getContextPath()%>/resources/images/cal5.png" alt="Chania" width="460" height="345">
      </div>
    
      <div class="item">
        <img id="calCar" src="<%=request.getContextPath()%>/resources/images/cal8.png" alt="Flower" width="460" height="345">
      </div>

      <div class="item">
        <img id="calCar" src="<%=request.getContextPath()%>/resources/images/cal7.png" alt="Flower" width="460" height="345">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<!-- -----------------건들지말것----------------------------- -->


	<!-- <div id="weekdatee">
	   <ul class="weekdays">
	      <li style="color:#9b0000;">일</li>
	      <li>월</li>
	      <li>화</li>
	      <li>수</li>
	      <li>목</li>
	      <li>금</li>
	      <li style="color:#9b0000;"><div class="activee">토</div></li>
	   </ul>
	</div> -->
<!-- asdddddddddddddddddddddddddd -->
	<div class="container" style="width:100%; padding:0; margin-top:-1.6%;">
	  <br>
	  <div id="myCarousel1" class="carousel slide" data-ride="carousel">
	    	
	    <!-- Wrapper for slides -->
	    <div class="carousel-inner" role="listbox">
	      <div class="item active">
			 <div id="weekdatee">
			   <ul class="weekdays">
			      <li style="color:#9b0000;">일</li>
			      <li>월</li>
			      <li>화</li>
			      <li>수</li>
			      <li>목</li>
			      <li>금</li>
			      <li style="color:#9b0000;"><div class="activee">토</div></li>
			   </ul>
			</div>
	      </div>
	
	      <!-- <div class="item">
	         <div id="weekdatee">
			   <ul class="weekdays">
			      <li style="color:#9b0000;">일asd</li>
			      <li>월d</li>
			      <li>화a</li>
			      <li>수s</li>
			      <li>목d</li>
			      <li>금s</li>
			      <li style="color:#9b0000;"><div class="activee">토</div></li>
			   </ul>
			</div>
	      </div>
	     -->
	      
	    </div>
	
	    <!-- Left and right controls -->
			<!--  <a class="left carousel-control" href="#myCarousel1" role="button" data-slide="prev">
			      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			      <span class="sr-only">Previous</span>
			    </a>
			    <a class="right carousel-control" href="#myCarousel1" role="button" data-slide="next">
			      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			      <span class="sr-only">Next</span>
			    </a> -->
	  </div>
	</div>










<!-- dddddddddddddddddddddddddddddd -->

       	<div id="datee">
	   <ul class="days">
	      <li><div class="activee"><font style="color:gray; font-size:11pt;">26</font><hr></div></li>
	      <li><font style="color:gray; font-size:11pt;">27</font><hr></li>
	      <li><font style="color:gray; font-size:11pt;">28</font><hr></li>
	      <li><div class="activee">1:삼일절<hr></div></li>
	      <li>2<hr></li>
	      <li>3<hr></li>
	      <li><div class="activee">4<hr></div></li>
	      <li><div class="activee">5<hr></div></li>
	      <li>6<hr></li>
	      <li>7<hr></li>
	      <li>8<hr></li>
	      <li>9<hr></li>
	      <li style="background-color: skyblue;">10(TODAY)<hr></li>
	      <li><div class="activee">11<hr></div></li>
	      <li><div class="activee">12<hr></div></li>
	      <li>13<hr></li>
	      <li>14<hr></li>
	      <li>15<hr></li>
	      <li>16<hr></li>
	      <li>17<hr></li>
	      <li><div class="activee">18<hr></div></li>
	      <li><div class="activee">19<hr></div></li>
	      <li>20<hr></li>
	      <li>21<hr></li>
	      <li>22<hr></li>
	      <li>23<hr></li>
	      <li>24<hr></li>
	      <li><div class="activee">25<hr></div></li>
	      <li><div class="activee">26<hr></div></li>
	      <li>27<hr></li>
	      <li>28<hr></li>
	      <li>29<hr></li>
	      <li>30<hr></li>
	      <li>31<hr></li>
	      
	   </ul>
	</div>
	



<!--  두번쨔 -->
    




</article>