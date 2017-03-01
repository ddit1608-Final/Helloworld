<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script>
	$(function() { // document ready
		calendarEvent();
	});
	function calendarEvent(eventData){
		$('#calendar').html("");
		var date = new Date();
		var d= date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		var calendar = $('#calendar').fullCalendar({
			schedulerLicenseKey: 'CC-Attribution-NonCommercial-NoDerivatives',
			header: {
				left: '',
				center: 'title',
				right: 'today prev,newxt'
			},
			editable: true,
			titleFormat:{
				month:'yyyy년MMMM',
				week:'[yyyy]MMMdd일{[yyyy]MMM dd일}',
				day: 'yyyy년MMM d일dddd'
			},
			allDayDefault:false,
			defaultView:'month',
			editable:false,
			monthNames:["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
			monthNamesShort:["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
			dayNames:["일요일","월요일","화요일","수요일","목요일","금요일","토요일"],
			dayNames:["일","월","화","수","목","금","토"],
			buttonText:{
				today:"오늘",
				month:"월별",
				week:"주별",
				day:"일별",
			},
			events:eventData,
			timeFormat:"HH:mm",
		});
	}
	/* }
		$('#calendar').fullCalendar({
			schedulerLicenseKey: 'CC-Attribution-NonCommercial-NoDerivatives',
			now: '2017-02-07',
			editable: true,
			aspectRatio: 1.8,
			scrollTime: '00:00',
			
			customButtons: {
				promptResource: {
					text: '+ room',
					click: function() {
						var title = prompt('Room name');
						if (title) {
							$('#calendar').fullCalendar(
								'addResource',
								{ title: title },
								true // scroll to the new resource?
							);
						}
					}
				}
			},
			defaultView: 'timelineDay',
			views: {
				timelineThreeDays: {
					type: 'timeline',
					duration: { days: 3 }
				}
			},
			resourceLabelText: 'Rooms',
			resourceRender: function(resource, cellEls) {
				cellEls.on('click', function() {
					if (confirm('Are you sure you want to delete ' + resource.title + '?')) {
						$('#calendar').fullCalendar('removeResource', resource);
					}
				});
			},
			resources: [
				{ id: 'a', title: 'Auditorium A' },
				{ id: 'b', title: 'Auditorium B', eventColor: 'green' },
				{ id: 'c', title: 'Auditorium C', eventColor: 'orange' },
				{ id: 'd', title: 'Auditorium D', children: [
					{ id: 'd1', title: 'Room D1' },
					{ id: 'd2', title: 'Room D2' }
				] },
				{ id: 'e', title: 'Auditorium E' },
				{ id: 'f', title: 'Auditorium F', eventColor: 'red' },
				{ id: 'g', title: 'Auditorium G' },
				{ id: 'h', title: 'Auditorium H' },
				{ id: 'i', title: 'Auditorium I' },
				{ id: 'j', title: 'Auditorium J' },
				{ id: 'k', title: 'Auditorium K' },
				{ id: 'l', title: 'Auditorium L' },
				{ id: 'm', title: 'Auditorium M' },
				{ id: 'n', title: 'Auditorium N' },
				{ id: 'o', title: 'Auditorium O' },
				{ id: 'p', title: 'Auditorium P' },
				{ id: 'q', title: 'Auditorium Q' },
				{ id: 'r', title: 'Auditorium R' },
				{ id: 's', title: 'Auditorium S' },
				{ id: 't', title: 'Auditorium T' },
				{ id: 'u', title: 'Auditorium U' },
				{ id: 'v', title: 'Auditorium V' },
				{ id: 'w', title: 'Auditorium W' },
				{ id: 'x', title: 'Auditorium X' },
				{ id: 'y', title: 'Auditorium Y' },
				{ id: 'z', title: 'Auditorium Z' }
			],
			events: [
				{ id: '1', resourceId: 'b', start: '2017-02-07T02:00:00', end: '2017-02-07T07:00:00', title: 'event 1' },
				{ id: '2', resourceId: 'c', start: '2017-02-07T05:00:00', end: '2017-02-07T22:00:00', title: 'event 2' },
				{ id: '3', resourceId: 'd', start: '2017-02-06', end: '2017-02-08', title: 'event 3' },
				{ id: '4', resourceId: 'e', start: '2017-02-07T03:00:00', end: '2017-02-07T08:00:00', title: 'event 4' },
				{ id: '5', resourceId: 'f', start: '2017-02-07T00:30:00', end: '2017-02-07T02:30:00', title: 'event 5' }
			]
		});
	
 */
</script>
<style>

/* 	body {
		margin: 0;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	p {
		text-align: center;
	}

	#calendar {
		max-width: 900px;
		margin: 50px auto;
	}

	.fc-resource-area td {
		cursor: pointer;
	} */

</style>
</head>
<body>

	<p>
		HINT: click on a resource to delete it.
	</p>

	<div id='calendar'></div>

</body>
</html>


