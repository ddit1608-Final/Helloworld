<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <article>
    <h2> 자유게시판 </h2>
	<h3> 자유롭게...머문자리는 아름답게</h3>   
    <form name="formm" method="post">
    <table id="notice">
      <tr>
      	<th>제목</th>
        <td>${freeBoardVO.freeboard_title}</td> 
      </tr>
      <tr>
        <th>등록일</th>
        <td> <fmt:formatDate value="${freeBoardVO.freeboard_wridate}" type="date"/></td>
      </tr>
      <tr>
        <th>내용</th>
        <td>${freeBoardVO.freeboard_cont} 
      </tr>
    </table>
    <div class="clear"></div>
     <div id="buttons" style="float:right">
      <input type="button"  value="목록보기"     class="submit"  onclick="location.href='/free/freeBoardList.do'"> 
      <input type="button"  value="메인으로"  class="cancel"  onclick="location.href='/main/index.do'">  
      </div>
    </form>
  </article>
