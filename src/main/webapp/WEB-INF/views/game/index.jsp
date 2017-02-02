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
                <div class="gameTop"">
                    <img src="<c:url value="/resources/images/thead-bg.png" />" alt="게임가로줄">
                </div>
                <div class="gameLeft">
                    <img src="<c:url value="/resources/images/thead2-bg.png" />" alt="게임세로줄">
                </div>
                <div class="beforeGo"<c:if test="${game.game_no > 0 }"> style="visibility: hidden;"</c:if>>
                    <div class="goBox">
                        <div class="otherPlayer">
                            <span>대전 상대 ID</span>
                            <form>
                                <label for="other">
                                    <input type="text" id="other" name="other">
                                </label>
                            </form>
                        </div>
                        <div class="goStart">
                            <form>
                                <label for="go">
                                    <input type="button" id="go" name="go" value="GO">
                                </label>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="game">
                    <table>
                        <tbody>
                    	<c:forEach var="cell" items="${cell }" varStatus="status">
                    		<c:if test="${status.index == 0 || status.index % 10 == 0 }"><tr></c:if>
                    			<c:choose>
                    			<c:when test="${cell.B_MEMBER_NO != null }"><td><span class="bigBlack"></span></td></c:when>
                    			<c:when test="${cell.W_MEMBER_NO != null }"><td><span class="bigWhite"></span></td></c:when>
                    			<c:when test="${cell.QNA_NO != null }"><td data="${cell.CELL_NO }" name="${cell.CELL_NM }"></td></c:when>
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
                            <a><img src="<c:url value="/resources/images/download-icon.png" />" alt="다운로드 아이콘">attatch.txt</a>
                        </div>

                        <div class="answerBox">
                            <h3>A.</h3>
                            <form>
                                <label for="answer">
                                    <input type="text" id="answer" name="answer" placeholder="답을 적어주세요.(단답식)">
                                </label>
                            </form>
                        </div>
                        <div class="submitBox">
                            <form>
                                <label for="submit">
                                    <input type="submit" id="submit" name="sumit" value="제출하기">
                                </label>
                            </form>
                        </div>
                    </div>
                </section>
                <!-- //qnaWrap -->
                <!-- listBox -->
                <section class="listBox">
                    <article class="nowTurn">
                        <span id="player1">홍길동</span>
                        <span class="smallBlack"></span>
                        <span id="black" class="on"><img src="<c:url value="/resources/images/left.png" />" alt="왼쪽화살표"></span>
                        <span id="white" class="on"><img src="<c:url value="/resources/images/right.png" />" alt="오른쪽화살표"></span>
                        <span class="smallWhite"></span>
                        <span id="player2">이몽룡</span>
                    </article>
                    <article class="historyBox">
                        <ul>
                            <li class="dot"><span class="smallWhite"></span></li>
                            <li class="line"><img src="<c:url value="/resources/images/line01.png" />" alt="점선"></li>
                            <li class="dotNum">E5</li>
                        </ul>
                        <ul>
                            <li class="dot"><span class="smallBlack"></span></li>
                            <li class="line"><img src="<c:url value="/resources/images/line01.png" />" alt="점선"></li>
                            <li class="dotNum">E6</li>
                        </ul>
                        <ul>
                            <li class="dot"><span class="smallWhite"></span></li>
                            <li class="line"><img src="<c:url value="/resources/images/line01.png" />" alt="점선"></li>
                            <li class="dotNum">F6</li>
                        </ul>
                        <ul>
                            <li class="dot"><span class="smallBlack"></span></li>
                            <li class="line"><img src="<c:url value="/resources/images/line01.png" />" alt="점선"></li>
                            <li class="dotNum">E6</li>
                        </ul>
                        <ul>
                            <li class="dot"><span class="smallWhite"></span></li>
                            <li class="line"><img src="<c:url value="/resources/images/line01.png" />" alt="점선"></li>
                            <li class="dotNum">F6</li>
                        </ul>
                        <ul>
                            <li class="dot"><span class="smallBlack"></span></li>
                            <li class="line"><img src="<c:url value="/resources/images/line01.png" />" alt="점선"></li>
                            <li class="dotNum">E6</li>
                        </ul>
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