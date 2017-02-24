<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>my site</title>
<link href="www.google.com/uds/css/gsearch.css" type="text/css" rel="stylesheet"/>
<script src="www.google.com/uds/api?file=uds.js&amp;v=1.0&amp;key=838cca9e74f0a55e307af1058d3a653b73625011"></script>

</head>
<body>
<script>
<!-- 병현 TEST중 -->
  (function() {
    var cx = '010330623742097262618:q7wcriavzhg';
    var gcse = document.createElement('script');
    gcse.type = 'text/javascript';
    gcse.async = true;
    gcse.src = 'https://cse.google.com/cse.js?cx=' + cx;
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(gcse, s);
  })();
</script>
<div>게시물 검색하기</div>

<gcse:search></gcse:search>
</body>
</html>