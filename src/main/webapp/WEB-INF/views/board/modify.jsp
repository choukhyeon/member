<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<Title>Insert boardTitle here</Title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  <style>
<style type="text/css">
.input_wrap{
	padding: 5px 20px;
}
label{
    display: block;
    margin: 10px 0;
    font-size: 20px;	
}
input{
	padding: 5px;
    font-size: 17px;
}
textarea{
	width: 800px;
    height: 200px;
    font-size: 15px;
    padding: 10px;
}
.btn{
  	display: inline-block;
    font-size: 22px;
    padding: 6px 12px;
    background-color: #fff;
    border: 1px solid #ddd;
    font-weight: 600;
    width: 140px;
    height: 41px;
    line-height: 39px;
    text-align : center;
    margin-left : 30px;
    cursor : pointer;
}
.btn_wrap{
	padding-left : 80px;
	margin-top : 50px;
}
#delete_btn{
	background-color: red;
}
</style>
</head>
<body>
<h1>수정 페이지</h1>
	<form id="modifyForm" action="/board/modify" method="post">
	<div class="input_wrap">
		<label>게시판 번호</label>
		<input name="boardNo" readonly="readonly" value='<c:out value="${pageInfo.boardNo}"/>' >
	</div>
	<div class="input_wrap">
		<label>게시판 제목</label>
		<input name="boardTitle" value='<c:out value="${pageInfo.boardTitle}"/>' >
	</div>
	<div class="input_wrap">
		<label>게시판 내용</label>
		<textarea rows="3" name="boardContent"><c:out value="${pageInfo.boardContent}"/></textarea>
	</div>
	<div class="input_wrap">
		<label>게시판 작성자</label>
		<input name="boardWriter" readonly="readonly" value='<c:out value="${pageInfo.boardWriter}"/>' >
	</div>
	<div class="input_wrap">
		<label>게시판 등록일</label>
		<input name="boardRegDate" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.boardRegDate}"/>' >
	</div>
	<div class="input_wrap">
		<label>게시판 수정일</label>
		<input name="boardUpdateDate" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.boardUpdateDate}"/>' >
	</div>		
	<div class="btn_wrap">
		<a class="btn" id="blist_btn">목록 페이지</a> 
		<a class="btn" id="modify_btn">수정 완료</a>
		<a class="btn" id="cancel_btn">수정 취소</a>
		<a class="btn" id="delete_btn">게시글 삭제</a>
	</div>
	</form>
	<form id="infoForm" action="/board/modify" method="get">
		<input type="hidden" id="boardNo" name="boardNo" value='<c:out value="${pageInfo.boardNo}"/>'>
		<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
		<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
		<input type="hidden" name="keyword" value="${cri.keyword }"> 
	</form>
	
	
<script>
	let form = $("#infoForm");      // 페이지 이동 Form
	let mform = $("#modifyForm");	// 페이지 데이터 수정Form
	
	//목록으로 이동
	$("#blist_btn").on("click", function(e){
		form.find("#boardNo").remove();
		form.attr("action", "/board/blist");
		form.submit();
	});
	
	// 수정하기 버튼
	$("#modify_btn").on("click", function(e){
		mform.submit();
	});
	
	// 수정 취소버튼
	$("#cancel_btn").on("click", function(e){
		form.attr("action","/board/get");
		form.submit();
	});
	
	// 게시글 삭제 버튼
	$("#delete_btn").on("click", function(e){
        form.attr("action","/board/delete");
        form.attr("method","post");
        form.submit();
    });
	
	
</script>	
</body>
</html>