<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Hello World - Google AJAX Search API Sample</title>
<link href="http://www.google.com/uds/css/gsearch.css" type="text/css"
	rel="stylesheet" />
<script
	src="http://www.google.com/uds/api?file=uds.js&amp;v=1.0&amp;key=AIzaSyA-u5-kDdc17s5N6utW-ECN-qmX_Ao8wa4"
	type="text/javascript"></script>
	<!-- 병현 TEST중 -->
</head>
<body>
<script type="text/javascript">
 	//<![CDATA[

	function OnLoad() {
		// search control 생성
		var searchControl = new GSearchControl();

		// Add in a full set of searchers
		var localSearch = new GlocalSearch();
		searchControl.addSearcher(localSearch);
		searchControl.addSearcher(new GwebSearch());
		searchControl.addSearcher(new GvideoSearch());
		searchControl.addSearcher(new GblogSearch());
		searchControl.addSearcher(new GnewsSearch());
		searchControl.addSearcher(new GbookSearch());

		// 지도검색을 위한 기준지역 설정 
		localSearch.setCenterPoint("New York, NY");

		// search control 을 페이지에 표시한다. 
		searchControl.draw(document.getElementById("searchcontrol"));

		// 검색을 수행한다. 
		searchControl.execute("리눅스 FireFox");
	}
	GSearch.setOnLoadCallback(OnLoad);

	//]]> 
	var findNum = 0
	$("#searchForm")
			.submit(
					function(event) {
						event.preventDefault();
						var $form = $(this), term = $form.find(
								"input[name='q']").val(), url = $form
								.attr("action");
						var posting = $.post(url, {
							q : term
						});
						$("#searchItems").empty();
						posting
								.done(function(d) {
									var data = $.parseJSON(d);
									findNum = data.response.numFound
									$("#searchNum").text(findNum)
									for (var i = 0; i < data.response.docs.length; i++) {
										var path = data.response.docs[i].path
										var id = data.response.docs[i].id
										var hl = data.highlighting[id]
										var item = [
												'<div class="panel"><h5><a href="http://www.joinc.co.kr/w/'+path+'">',
												data.response.docs[i].title,
												'</a></h5>',
												hl.contents.join("..."),
												'......</div><hr>' ]
										$("#searchItems").append(
												item.join('\n'))
									}
									var maxPage = Math.ceil(findNum / 10)
									for (var i = 1; i < maxPage + 1; i++) {
										$("#paging").append(
												'<li><a href="?page=' + i
														+ '">' + i
														+ '</a></li>')
										if (i == 10) {
											break;
										}
									}
								})
					})
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

	<form id="searchForm" action="POST">
		<div class="row">
			<div class="small-8 columns">
				<div class="row collapse">
					<div class="small-6 columns">
						<input type="text" name="q"/>123
					</div>
					<div class="small-2 columns end">
						<input type="submit" class="button postfix" value="찾기"/>123
					</div>
				</div>
			</div>
		</div>
	</form>
	<div id="searchcontrol">Loading12333</div>
	<gcse:search></gcse:search>
</body>

</html>