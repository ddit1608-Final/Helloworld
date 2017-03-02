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
    $('#scroll').click(function()  
    {  
     $('#scroll').animate({ top:"+=15px",opacity:0 }, "slow");  
    });
    
// 워크넷 api checkbox 속성 가져와보기
/* $($('#pageFrame').contents().find(".chkbox:checked")).each(function(){
	 var a =$('#pageFrame').contents().find(".chkbox:checked").size();
	 if(a!=0){
	 		alert('성공');
	 	}
 })   */
   function chk_chk(){
	   //var chk = $('#pageFrame').$("input[type='checkbox']").val();
	 	var a = $('#pageFrame').contents().find(".chkbox:checked").size()
	 	if(chk==true){
	 		alert('123');
	 		alert(chk);
	 	}
	 	if(a!=0){
	 		alert('성공');
	 	}
   }
	 	
    
 /*$(function chk_chk(){
	 	var chk = $('#pageFrame').$("input[type='checkbox']").val();
	 	var a = $('#pageFrame').contents().find(".chkbox:checked").size()
	 	if(chk==true){
	 		alert('123');
	 		alert(chk);
	 	}
	 	if(a!=0){
	 		alert('성공');
	 	}
});*/