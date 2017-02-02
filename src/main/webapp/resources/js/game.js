/**
 * 
 */
$(function(){
	$("td[data]").hover(function(){
		$(this).css("cursor", "pointer");
		var data = $(this).attr("data");
		var name = $(this).attr("name");
		var span = "<span class=\"nowPlay\" data=\""+ data +"\">"+ name +"</span>";
		$(this).append(span);
	}, function(){
		$(this).css("cursor", "");
		$(this).html("");
	});
	
	$("td[data]").click(function(){
		var data = $(this).attr("data");
		$.ajax({
			url : contextPath +"game/question.do",
			data : {"no":data, "col:":color },
			dataType : "json",
			method : "POST"
		})
		.done(function(question){
			// handle request success
			openQuestion(question);
		})
		.pipe(function(data) {
			return data.responseCode != 200 ?
			$.Deferred().reject( data ) :
			data;
		})
		.fail(function(){
			// handle request failures
			if ( data.responseCode )
				console.log( data.responseCode );
		})
		.always(function(){
			// remove loading image maybe
		});
	});
});

function openQuestion(question){
	$(".gameRule").hide();
	var wrap = $(".qnaWrap");
	wrap.find("h2").text(question.CELL_NM);
	wrap.find(".questionBox span").text(question.QUESTION);
}
//<span class="nowPlay" data="${cell.CELL_NO }" style="display:none;">${cell.CELL_NM }</span>
//{"ANSWER":"HEP{you are hacker}","ATTACH_FILE":"whoami.pcapng","ATTACH_TYPE":"F",
//"CELL_NO":37,"CELL_NM":"D7","QNA_NO":3,"QUESTION":"패킷에 숨겨진 메시지를 찾으시오."}