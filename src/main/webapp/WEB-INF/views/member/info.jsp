<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
/Member/info.jsp
<h2>마이페이지</h2>
<table border="1">
	<tr>
		<td>아이디</td>
		<td>${member.memberId }</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${member.memberPassword }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${member.memberName }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${member.memberMail }</td>
	</tr>
	<tr>
		<td>가입일자</td>
		<td>${member.memberRegDate }</td>
	</tr>
	<tr>
		<td>충전금액</td>
		<td>${member.memberMoney }</td>
	</tr>
	<tr>
		<td>포인트</td>
		<td>${member.memberPoint }</td>
	</tr>
</table>
<input type="button" value="메인으로" class="btn" onclick="location.href='/home">
</body>
</html>