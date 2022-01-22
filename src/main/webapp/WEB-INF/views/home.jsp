<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<script src="../resources/myLib/jquery-3.2.1.min.js"></script>
<script src="../resources/myLib/axTest01.js"></script>
<meta charset="utf-8" />
<title>수 플라워</title>
<!-- 부트스트랩 아이콘 사용 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/myLib/strapStyle.css">
</head>
<body>
	<!--navigation -->

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="/">수 플라워 </a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample03" aria-controls="navbarsExample03"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExample03">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/board/blist">꽃정기구독</a></li>
				<li class="nav-item"><a class="nav-link" href="/board/blist">꽃다발</a></li>
				<li class="nav-item"><a class="nav-link" href="/board/blist">Q
						& A</a></li>
				<li class="nav-item"><a class="nav-link" href="/board/session">Session확인</a></li>
			</ul>


			<form class="form-inline my-2 my-md-0">
				<c:if test="${member == null}">
					<a class="bi-person-circle me-1" href="/member/login">로그인</a>&nbsp;&nbsp;
					<br>
					<a class="bi-person-circle me-1" href="/member/join">회원가입</a>&nbsp;&nbsp;
					<br>
				</c:if>
				<c:if test="${member != null}">
					<a class="login_success" style="color: white;">내정보</a>&nbsp;&nbsp;
					<span class="login_success" style="color: white;">회원: ${member.memberName}</span> &nbsp;&nbsp;
					<span class="login_success" style="color: white;">충전금액:<fmt:formatNumber value="${member.memberMoney}" pattern="\#,###,##" /></span> &nbsp;&nbsp;
					<span class="login_success" style="color: white;">포인트: <fmt:formatNumber value="${member.memberPoint}" pattern="#,##" /></span>&nbsp;&nbsp;
					<a href="/member/logout.do">로그아웃</a>
				</c:if>
			</form>
		</div>
	</nav>
	<!--section -->
	<hr>
	<div>내용</div>
	<div>내용</div>
	<div>내용</div>
	<div>내용</div>
	<div>내용</div>
	<div>내용</div>
	<div>내용</div>
	<div>내용</div>
	<div>내용</div>
	<div>내용</div>
	<div>내용</div>
	<div>내용</div>
	<hr>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div>
			<div class="footer">
				<span class="m-0 text-left text-white"><h3>수플라워
						(031-1234-5678)</h3></span> <span class="m-0 text-center text-white">(평일
					10:00 - 13:00, 14:00 - 18:00 / 주말 & 공휴일 제외)</span>
				<hr>
			</div>
			<div class="footer">
				<p class="m-0 text-left text-white">상호명:수..플라워 .. | 사업자
					등록번호:123-45-67891 | 대표자 : 서명원 이재경 조욱현 전성우</p>
				<p class="m-0 text-left text-white">소재지 : 경상북도 구미시 도량2동 4주공아파트
					(송동로128 401/208)</p>
				<p class="m-0 text-left text-white">통신판매 신고번호 | Copyright &copy;
					su...Flower 2022</p>

			</div>
		</div>

	</footer>
</body>
</html>

