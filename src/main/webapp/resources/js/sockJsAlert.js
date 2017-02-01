/**
 * 
 */

function onMessage(evt) {
	var data = evt.data;
	alert("서버에서 데이터 받음: " + data);
}
function onClose(evt) {
	alert("연결 끊김");
}