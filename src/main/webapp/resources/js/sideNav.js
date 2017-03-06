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
	 	var eachCompanies = $('#worktable .cpyCheck:checked').closest("tr");
	var newTable = $("<table></table>"); 	
 	$.each(eachCompanies, function(idx,temp){
 		var newTr = $(this).clone();
 		$(newTr).data("currentData", $(this).data("currentData"));
 		
 		console.log(JSON.stringify($(newTr).data("currentData")));
 		$(newTable).append(newTr);
 	});
 	//$('#myModal .modal-body').append(JSON.stringify(array));
 	/*$('#myModal .modal-body').html(eachCompanies);*/
 	$('#myModal .modal-body').append(newTable);
   }
   // 무조건 close버튼만 눌러야됨
   function close_go(){
	   $('.modal-body').empty();
   }
   function scrap_go(){
	   var eachCompanies = $('#myModal .cpyCheck:checked').closest("tr");
	   var array = [];
	   $.each(eachCompanies, function(){
	 		array.push($(this).data("currentData"));
	 	});
	   alert(JSON.stringify(array));
	   $.ajax({
		   url:"addScrap",
		   data:JSON.stringify(array),
		   contentType:"application/json",
		   method:"post",
		   dataType:"json",
		   success:function(response){
			   alert(JSON.stringify(response));
			   if(response.success){
				   // 모달창의 스크랩 회사의 정보를 클린.
				   // 모달창 close
				   alert('성공');
			   }else{
				   // 메시지 처리
				   alert('실패');
				   
			   }
		   },
		   error:function(response){
			   //응답상태 코드 확인가능함
			   alert(response.status);
		   }
	   })
   }
   // 체크박스 전체 선택
   $(function(){
	//전체선택 체크박스 클릭 
	  $("#allCheck").click(function(){ 
	  //만약 전체 선택 체크박스가 체크된상태일경우 
	  if($("#allCheck").prop("checked")) { 
	  //해당화면에 전체 checkbox들을 체크해준다 
	  $("#worktable input[type=checkbox]").prop("checked",true); 
	  // 전체선택 체크박스가 해제된 경우 
	  } else { 
	  //해당화면에 모든 checkbox들의 체크를해제시킨다.
	  $("#worktable input[type=checkbox]").prop("checked",false); 
	  } 
	  })
   })
 


   
   
   
   
   
   
   
   
   
   
   
   
   function list_go(){
	   location.href="workNetDetail";
   }
   