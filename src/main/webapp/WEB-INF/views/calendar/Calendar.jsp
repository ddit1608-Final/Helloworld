<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title></title>
</head>
<body>
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
일		월		화		수		  목		   금		  토
========================================================

중요 일자 처리  
		1.<span class="active"> 값 </span> ==> 옥색
		2.<span class="activee"> 값 </span> ==> 빨간색
-->





	<div class="month">
		<ul>
			<li class="prev">&#10094;</li> <!-- < 의미함  -->
			<li class="next">&#10095;</li> <!-- > 의미함  -->
			<li>January <br> <span style="font-size: 18px">2017</span>
			</li>
		</ul>
	</div>
	<ul class="weekdays">
		<li>Sun</li>
		<li>Mon</li>
		<li>Tue</li>
		<li>Wed</li>
		<li>Thu</li>
		<li>Fri</li>
		<li>Sat</li>
	</ul>

	<ul class="days">
		<li><span class="activee">1:신정</span></li>
		<li>2</li>
		<li>3</li>
		<li>4</li>
		<li>5</li>
		<li>6</li>
		<li>7</li>
		<li>8</li>
		<li>9</li>
		<li>10</li>
		<li>11</li>
		<li>12</li>
		<li>13</li>
		<li>14</li>
		<li>15</li>
		<li>16</li>
		<li>17</li>
		<li>18</li>
		<li>19</li>
		<li>20</li>
		<li>21</li>
		<li>22</li>
		<li>23</li>
		<li>24</li>
		<li>25</li>
		<li>26</li>
		<li><span class="activee">27</span></li>
		<li><span class="activee">28:설날</span></li>
		<li><span class="activee">29</span></li>
		<li><span class="activee">30:대체 휴일</span></li>
		<li>31</li>
	</ul>
	<img src="resources/images/month.jpg">
</body>
</html>