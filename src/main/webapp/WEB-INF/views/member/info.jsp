<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<link rel="stylesheet" href="/resources/myLib/memberCss/info.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<body>
<h2>마이페이지</h2>
<table border="1" width="1000px" height="500px">

	<tr >
		<td>아이디</td>
		<td>${member.memberId}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${member.memberName}</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${member.memberMail}</td>
	</tr>
	<tr>
		<td>핸드폰 번호</td>
		<td>${member.memberPhoneNum}</td>
	</tr>
	<tr>
		<td>우편 번호</td>
		<td>${member.memberAddr1}</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>${member.memberAddr2}</td>
	</tr>
	<tr>
		<td>상세 주소</td>
		<td>${member.memberAddr3}</td>
	</tr>
	<tr>
		<td>가입일자</td>
		<td>${member.memberRegDate}</td>
	</tr>
	<tr>
		<td>충전금액</td>
		<td>${member.memberMoney}</td>
	</tr>
	<tr>
		<td>포인트</td>
		<td>${member.memberPoint}</td>
	</tr>
</table>
<c:if test="${not empty message}">
<br>=> ${message}<br><br> 
</c:if>
<input type="button" value="메인으로" class="btn" onclick="location.href='/'"></input>
<input type="button" value="내 정보수정 " class="btn" onclick="location.href='/member/update'"></input>
</body>
</html>