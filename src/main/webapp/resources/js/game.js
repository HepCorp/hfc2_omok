/**
 * 
 */
$(function(){
	$("td[data]").hover(function(){
		showCell($(this));
	}, function(){
		hideCell($(this));
	});
	
	$("td[data]").click(function(){
		var no = $(this).attr("data");
		var stone = $(this).attr("stone");
		var obj = $(this);
		$.ajax({
			url : contextPath +"game/question.do",
			data : {"no":no, "col":stone },
			dataType : "json",
			method : "POST"
		})
		.done(function(question){
			// handle request success
			$("td[data]").unbind("mouseenter").unbind("mouseleave").unbind("click");
			openQuestion(question);
		})
		.pipe(function(data) {
			return data.responseCode != 200 ?
			$.Deferred().reject( data ) :
			data;
		})
		.fail(function(data){
			// handle request failures
			if ( data.responseCode )
				console.log( data.responseCode );
		})
		.always(function(){
			// remove loading image maybe
		});
	});
});

function showCell(obj){
	obj.css("cursor", "pointer");
	var data = obj.attr("data");
	var name = obj.attr("name");
	var span = "<span class=\"nowPlay\" data=\""+ data +"\">"+ name +"</span>";
	obj.append(span);	
}
function hideCell(obj){
	obj.css("cursor", "");
	obj.html("");
}
function openQuestion(question){
	$(".gameRule").hide();
	var wrap = $(".qnaWrap");
	wrap.find("h2").text(question.CELL_NM);
	$(".questionBox>span").text(question.QUESTION);
	$("input[name='cell_no']").val(question.CELL_NO);
	$("input[name='qna_no']").val(question.QNA_NO);
	
	var icon;
	if (question.ATTACH_TYPE == "F"){
		url = contextPath +"game/downloadFile.do?file="+ question.ATTACH_FILE
		icon = "<img src=\""+ contextPath +"resources/images/download-icon.png\" alt=\"다운로드\">";
	} else if (question.ATTACH_TYPE == "U"){
		url = contextPath +"resources/attach/"+ question.ATTACH_FILE
		icon = "<img src=\""+ contextPath +"resources/images/external-link.png\" alt=\"새창열기\">";
	} else {
		icon = null;
	}
	
	$(".questionBox > a").remove();
	if (icon != null) {
		wrap.find(".questionBox").append("<a href=\""+ url +"\" target=\"_blank\">"+ icon + question.ATTACH_FILE +"</a>");
	}	
	
	$("input[name='answer']").focus();
}
//<span class="nowPlay" data="${cell.CELL_NO }" style="display:none;">${cell.CELL_NM }</span>
//{"ANSWER":"HEP{you are hacker}","ATTACH_FILE":"whoami.pcapng","ATTACH_TYPE":"F",
//"CELL_NO":37,"CELL_NM":"D7","QNA_NO":3,"QUESTION":"패킷에 숨겨진 메시지를 찾으시오."}