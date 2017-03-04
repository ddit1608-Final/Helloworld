// 스크롤링 이벤트 처리
$("document").ready(function() {
		var currentPosition = parseInt($("#right_section").css("top"));

		$(window).scroll(function() {
			var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.  
			$("#right_section").stop().animate({
				"top" : position + currentPosition + "px"
			}, 500);
		});
	

});
$(window).scroll(function()  
{  
    $('#scroll').animate({top:$(window).scrollTop()+"px" },{queue: false, duration: 350});    
});  
$('#scroll').click(function() {  
	$('#scroll').animate({ top:"+=15px",opacity:0 }, "slow");  
});
  
   function chk_chk(){
	 	var eachCompanies = $('.cpyCheck:checked').closest("tr");
 	var array = [];
 	
 	$.each(eachCompanies, function(){
 		array.push($(this).data("currentData"));
 	});
 	//$('#myModal .modal-body').append(JSON.stringify(array));
 	/*$('#myModal .modal-body').html(eachCompanies);*/
 	$('#myModal .modal-body').append(eachCompanies.clone());
   }
   // 무조건 close버튼만 눌러야됨
   function close_go(){
	   $('.modal-body').empty();
   }
   function scrap_go(){
	   var eachCompanies = $('.cpyCheck:checked').closest("tr");
	   var array = [];
	   $.each(eachCompanies, function(){
	 		array.push($(this).data("currentData"));
	 	});
	   alert(JSON.stringify(array));
	   //form.action="./addScrap";
   }
  
   