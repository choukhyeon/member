<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 날짜 , 시,분 만 나오게 fmt 라이브러리 추가  -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 목록페이지입니다.</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/myLib/blistStyle.css">

</head>
<style>
</style>
<body>
	<h1>목록페이지입니다.</h1>
	<div class="table_wrap">
		<table>
			<thead>
				<tr>
					<th class="boardNo_width">게시글 번호</th>
					<th class="boardTitle_width">제목</th>
					<th class="boardWriter_width">작성자</th>
					<th class="boardRegDate_width">작성일</th>
					<th class="boardUpdateDate_width">수정일</th>
				</tr>
			</thead>

			<c:forEach items="${blist}" var="blist">
				<tr>
					<td><c:out value="${blist.boardNo}" /></td>
					<td><a class="move" href='<c:out value="${blist.boardNo}"/>'>
							<c:out value="${blist.boardTitle}" />
					</a></td>
					<td><c:out value="${blist.boardWriter}" /></td>
					<td><fmt:formatDate pattern="yyyy.MM.dd hh:mm"
							value="${blist.boardRegDate}" /></td>
					<td><fmt:formatDate pattern="yyyy.MM.dd hh:mm"
							value="${blist.boardUpdateDate}" /></td>
				</tr>
			</c:forEach>
		</table>

		<div class="search_wrap">
			<div class="search_area">
				<input type="text" name="keyword" value="${pageMaker.cri.keyword}">
				<button>검색</button>
			</div>
		</div>
		<div class="pageInfo_wrap">
			<div class="pageInfo_area">
				<ul id="pageInfo" class="pageInfo">
					<!-- 이전 페이지 버튼 -->
					<c:if test="${pageMaker.prev}">
						<li class="pageInfo_btn previous"><a
							href="${pageMaker.startPage-1}">Previous</a></li>
					</c:if>

					<!-- 각 번호 페이지 버튼 -->
					<c:forEach var="num" begin="${pageMaker.startPage}"
						end="${pageMaker.endPage}">
						<li class="pageInfo_btn"><a href="${num}">${num}</a></li>
					</c:forEach>


					<!--  다음 페이지 버튼 -->
					<c:if test="${pageMaker.next}">
						<li class="pageInfo_btn next"><a
							href="${pageMaker.endPage + 1 }">Next</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<form id="moveForm" method="get">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
			<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
		</form>
	</div>
	<hr>
	<a href="/board/bwrite" class="top_btn" id="popbutton">게시판 등록</a>
	<a href="/">[Home]</a>
	


<script type="text/javascript">
   
 		// 등록 완료 alert function 
		$(document).ready(function() {

			var result = '<c:out value="${result}"/>';
			checkModal(result);
			function checkModal(result) {
				if (result === '') {
					return;
				}
				if (result === "bwrite success") {
					alert("작성이 완료됐당..");
				}
				$("#myModal").modal("show");
				if (result === "delete success") {
					$(".modal-body").html("게시글 삭제가 완료되었습니다.");
				}
				$("#myModal").modal("show");
				if (result === "modify success") {
					$(".modal-body").html("게시글 수정이 완료되었습니다.");
				}
				$("#myModal").modal("show");
				if (result === "login check") {
					$(".modal-body").html("로그인후 이용해주세용.");
				}
				$("#myModal").modal("show");

			}
		}); 

		let moveForm = $("#moveForm");
		$(".move").on(
				"click",
				function(e) {
					e.preventDefault();

					moveForm.append("<input type='hidden' name='boardNo' value='"
							+ $(this).attr("href") + "'>");
					moveForm.attr("action", "/board/get");
					moveForm.submit();
				});

		$(".pageInfo a").on("click", function(e) {
			e.preventDefault();
			moveForm.find("input[name='pageNum']").val($(this).attr("href"));
			moveForm.attr("action", "/board/blist");
			moveForm.submit();

		});

		// 검색 기능
		$(".search_area button").on("click", function(e) {
			e.preventDefault();
			let val = $("input[name='keyword']").val();
			moveForm.find("input[name='keyword']").val(val);
			moveForm.find("input[name='pageNum']").val(1);
			moveForm.submit();
		});
	</script>
</body>
</html>