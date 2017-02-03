<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/inc/headerBase.jsp"%>
<c:set var="browserTitle" value="HFC-해커인증시스템" />
<c:set var="menuTitle" value="오목게임" />
<c:set var="fileName" value="/game/index.do" />
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/resources/include/header.jsp"%>
<script type="text/javascript" charset="UTF-8" src="<c:url value="/resources/js/game.js" />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/game.css" />">
<script type="text/javascript">
function FormChkModule(f){
	if (f.answer.value == ""){
		alert("<spring:message code='field.required.user_answer' />");
		f.answer.focus();
		return false;
	}
	return true;
}
function FormChkModule2(f){
	if (f.w_user_email.value == "") {
		alert("<spring:message code='field.required.email' />");
		f.w_user_email.focus();
		return false;
	} else {
		if (!pattern("email", f.w_user_email.value)){
			alert("<spring:message code='field.error.pattern.email' />");
			f.w_user_email.select();
			f.w_user_email.focus();
			return false;
		}
	}
	return true;
}
</script>
</head>
<body>
<!-- header -->
<header>
<nav>
    <div class="winningRate">
        <ul>
            <li>${memberVO2.win }승</li>
            <li>${memberVO2.lose }패</li>
            <li>승률 ${memberVO2.winner_rate }%</li>
        </ul>
    </div>
    <div class="loginInfo">
        <ul>
            <li>${memberVO2.user_name } 님</li>
            <li><a href="">로그아웃</a></li>
        </ul>
    </div>
</nav>
</header>
<!-- //header -->
<!-- section -->
<section id="gameWrap">
    <!-- gameContents -->
    <div class="gameContents">
        <div class="gameSection">
            <article>
                <!-- game -->
                <div class="gameTop">
                    <img src="<c:url value="/resources/images/thead-bg.png" />" alt="게임가로줄">
                </div>
                <div class="gameLeft">
                    <img src="<c:url value="/resources/images/thead2-bg.png" />" alt="게임세로줄">
                </div>
                <div class="beforeGo"<c:if test="${game.game_no > 0 }"> style="visibility: hidden;"</c:if>>
                 	<form name="startFrm" method="post" action="<c:url value='/game/start.do' />" class="form" onSubmit="return FormChkModule2(this);">
                	<fieldset>
                	<legend>게임 시작</legend>
                	<input type="hidden" name="b_member_no" value="${memberVO2.member_no }" />
                    <div class="goBox">
                        <div class="otherPlayer">
                            <h2>대전 상대 이메일</h2>
                            <span>
                                <label for="other">
                                    <input type="email" id="other" name="w_user_email" required="required" />
                                    <form:errors path="gameVO.w_user_email" cssClass="msgAlert" cssStyle="display:none;" />
                                </label>
                            </span>
                        </div>
                        <div class="goStart">
                            <span>
                                <label for="go">
                                    <input type="submit" id="go" name="go" value="GO">
                                </label>
                            </span>
                        </div>
                    </div>
                    </fieldset>
                    </form>
                </div>
                <div class="game">
                    <table>
                        <tbody>
                    	<c:forEach var="cell" items="${cell }" varStatus="status">
                    		<c:if test="${status.index == 0 || status.index % 10 == 0 }"><tr></c:if>
                    			<c:choose>
                    			<c:when test="${cell.STONE == 'B' }"><td><span class="bigBlack"></span></td></c:when>
                    			<c:when test="${cell.STONE == 'W' }"><td><span class="bigWhite"></span></td></c:when>
                    			<c:when test="${cell.QNA_NO != null }"><td data="${cell.CELL_NO }" name="${cell.CELL_NM }" stone="${game.stone }"></td></c:when>
                    			<c:otherwise><td></td></c:otherwise>
                    			</c:choose>
                    		<c:if test="${status.index % 10 == 9 }"></tr></c:if>
                    	</c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- //game -->
            </article>
            <article>
                <!-- qnaWrap -->
                <section class="qnaWrap">
                    <div class="gameRule">
                        <ul>
                            <li><p>대전할 상대의 ID를 입력한 후 GO 버튼을 눌러 게임을 시작할 수 있습니다.</p></li>
                            <li><p>게임 생성자는 흑돌, 게임 참여자는 흰돌로 표시되며, 게임은 흑돌이 먼저 시작합니다.</p></li>
                            <li><p>게임이 시작되면 돌을 놓을 위치를 클릭하고, 그 위치에 해당되어있는 문제를 풀어야만 돌을 놓을수 있습니다.</p></li>
                            <li><p>오답 제출시 돌을 놓치 못하며, 다음 턴으로 넘어갑니다.</p></li>
                        </ul>
                    </div>
                    <h2>D6</h2>
                    <div class="qna">
                        <div class="questionBox">
                            <h3>Q.</h3>
                            <span>Etiam sit amet sapien ornare, dictum justo non, bibendum justo?</span>
                            <%-- <a><img src="<c:url value="/resources/images/download-icon.png" />" alt="다운로드 아이콘">attatch.txt</a> --%>
                        </div>

                        <form name="saveFrm" method="post" action="<c:url value='/game/save.do' />" class="form" onSubmit="return FormChkModule(this);">
                        <fieldset>
                        <legend>답 제출</legend>
                        <input type="hidden" name="game_no" value="${game.game_no }" />
                        <input type="hidden" name="cell_no" />
                        <input type="hidden" name="qna_no" />
                        <input type="hidden" name="b_member_no" value="${game.b_member_no }" />
                        <input type="hidden" name="w_member_no" value="${game.w_member_no }" />
                        <div class="answerBox">
                            <h3>A.</h3>
                            <span>
	                            <label for="answer">
	                                <input type="text" id="answer" name="answer" placeholder="답을 적어주세요.(단답식)">
	                            </label>
                            </span>
                        </div>
                        <div class="submitBox">
                        	<span>
	                            <label for="submit">
	                                <input type="submit" id="submit" name="submit" value="제출하기">
	                            </label>
                            </span>
                        </div>
                        </fieldset>
                        </form>
                    </div>
                </section>
                <!-- //qnaWrap -->
                <!-- listBox -->
                <section class="listBox">
                    <article class="nowTurn">
                    	<c:if test="${game.w_user_name != null }">
                        <span id="player1">${memberVO2.user_name }</span>
                        <span class="smallBlack"></span>
                        <span id="black" class="${game.stone == 'B'?'on':'off' }"><img src="<c:url value="/resources/images/left.png" />" alt="왼쪽화살표"></span>
                        <span id="white" class="${game.stone == 'W'?'on':'off' }"><img src="<c:url value="/resources/images/right.png" />" alt="오른쪽화살표"></span>
                        <span class="smallWhite"></span>
                        <span id="player2">${game.w_user_name }</span>
                        </c:if>
                    </article>
                    <article class="historyBox">
                    	<c:if test="${history != null }">
                    	<c:forEach items="${history }" var="history">
                        <ul>
                            <li class="dot"><span class="${history.stone == 'B'?'smallBlack':'smallWhite' }"></span></li>
                            <li class="line"><img src="<c:url value="/resources/images/line01.png" />" alt="점선"></li>
                            <li class="dotNum">${history.cell_nm }</li>
                        </ul>
                        </c:forEach>
                        </c:if>
                    </article>
                </section>
                <!-- //listBox -->
            </article>
        </div>
    </div>
    <!-- //gameContents -->
</section>
<!-- //section -->
</body>
</html>