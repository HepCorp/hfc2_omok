$(function(){
	$(".msgAlert").each(function(){
		alert($(this).text());
		$("input:first").focus();
	});
});

/**
 * name : 공통함수
 * filename : common.js
 * Author : ysy
 * Date : 2016-12-23
 */
function pattern(patt, val){
	var regExp;
	switch (patt) {
	case "email":
		regExp = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
		break;

	default:
		regExp = "";
		break;
	}
	if (regExp != null && regExp != ""){
		var result = regExp.test(val);
		return result;
	}
	return false;
}

function logout(){
	if(confirm("로그아웃 하시겠습니까?")){
		return true;
	} else {
		return false;
	}
}

/**
 * name : contextPath
 * Author : ysy
 * Date : 2016-02-02
 * Description : 전체 컨텍스트패스를 함수로 지정해 사용, 변경시 함께 변경하여 줌.
 */
var contextPath = "/omok/";

/**
 * name : color
 * Author : ysy
 * Date : 2016-02-02
 * Description : 현재 돌의 색깔을 표시
 */
var stone = "black";

/**
 * name : changeStone
 * Author : ysy
 * Date : 2016-02-02
 * Description : 돌의 색깔을 변경
 */
function changeStone(col){
	if (col == "black"){
		stone = "white";
		$("#black").toggleClass("off", "on");
		$("#white").toggleClass("on", "off")
	} else {
		stone = "black";
		$("#black").toggleClass("off", "on");
		$("#white").toggleClass("on", "off");
	}
}