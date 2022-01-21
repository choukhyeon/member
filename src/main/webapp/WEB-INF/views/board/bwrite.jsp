<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/bwrite" method="post">
		<div class="input_wrap">
			<label>Title</label> <input name="boardTitle">
		</div>
		<div class="input_wrap">
			<label>Content</label>
			<textarea rows="3" name="boardContent"></textarea>
		</div>
		<div class="input_wrap">
			<label>Writer</label> <input name="boardWriter">
		</div>
		<button class="btn"> 전송 </button>
	</form>

<a href="/">[Home]</a>
</body>
</html>