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
<!-- daum 도로명주소 찾기 api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
//우편번호 찾기 버튼 클릭시 발생 이벤트 
function execPostCode() { 
  new daum.Postcode({
	  oncomplete: function(data) {
		// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분. 
		// 도로명 주소의 노출 규칙에 따라 주소를 조합한다. 
		// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다. 
		
		var fullRoadAddr = data.roadAddress;  // 도로명 주소 변수 
		var extraRoadAddr = ''; // 도로명 조합형 주소 변수 
		
		// 법정동명이 있을 경우 추가한다. (법정리는 제외) 
		// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다. 
		if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
			extraRoadAddr += data.bname; 
		}
		
		// 건물명이 있고, 공동주택일 경우 추가한다. 
		if(data.buildingName !== '' && data.apartment === 'Y'){
			extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		}
		
		// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다. 
		if(extraRoadAddr !== ''){
			extraRoadAddr = ' (' + extraRoadAddr + ')'; 
		} 
		
		// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다. 
		if(fullRoadAddr !== ''){
			fullRoadAddr += extraRoadAddr; 
		} 
		
		// 우편번호와 주소 정보를 해당 필드에 넣는다. 
		console.log(data.zonecode); 
		console.log(fullRoadAddr); 

		/* var a = console.log(data.zonecode);
		var b = console.log(fullRoadAddr); 
		if(a == null || b = null){ 
			alert("주소를 확인하세요.");
			return false; 
		} */ 
			
		$("[name=oaddress]").val(data.zonecode); 
		$("[name=address]").val(fullRoadAddr); 
		
		document.getElementById('oaddress').value = data.zonecode; //5자리 새우편번호 사용 
		document.getElementById('address').value = fullRoadAddr; 
		
		//document.getElementById('mem_detailaddress').value = data.jibunAddress;
		 // 커서를 상세주소 필드로 이동한다.
        document.getElementById("detailaddress").focus();
			} 
  }).open(); 
  }

</script>
<body>
<h2>내 정보 수정</h2>
<form action="update_form" method="post">
<table border="1" width="1000px" height="500px">

	<tr >
		<td>I D</td>
		<td><input  type="text" name="id" value="${member.memberId}" readonly></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input  type="text" name="name" value="${member.memberName}"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input  type="text" name="email" value="${member.memberMail}"></td>
	</tr>
	<tr>
		<td>핸드폰 번호</td>
		<td><input  type="text" name="phoneNum" value="${member.memberPhoneNum}"></td>
	</tr>
	<tr>
		<td>우편 번호</td>
		<td><input  type="text" name="oaddress" id="oaddress" value="${member.memberAddr1}" readonly> &nbsp;&nbsp;
		<input  type="button" value="우편번호 찾기" id="" onclick="execPostCode()"><br></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input class="form-control" type="text" name="address" id="address" value="${member.memberAddr2}" readonly><br></td>
	</tr>
	<tr>
		<td>상세 주소</td>
		<td><input class="form-control" type="text" name="detailaddress" id="detailaddress" value="${member.memberAddr3}"></td>
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
</form>
<input type="button" value="메인으로" class="btn" onclick="location.href='/'"></input>
<input type="submit" value="수정">&nbsp;&nbsp;
<c:if test="${not empty message}">
<br>=> ${message}<br><br> 
</c:if>
</body>
</html>