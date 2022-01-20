/**
 * member input Data 무결성 확인 function
** member 무결성 확인사항
// ID : 길이(4이상), 영문자,숫자 로만 구성
// password : 길이(4이상), 영문,숫자,특수문자로 구성, 특수문자는 반드시 1개 이상 포함할것
// Name : 길이(2이상), 영문 또는 한글로 만 입력
// Level : select 를 이용 (X)
// BirthDay : 입력 여부 확인  ( length == 10 )
// Point : 정수의 범위  ( 숫자이면서, '.'이 없어야함 )
// Weight: 구간 (20 ~ 200)

** 작성 규칙
   => JavaScript function 으로 정의 하고 
      결과를 true or false 로 return 
 */
function idCheck() {
	var id=$('#id').val(); 	
	if (id.length<4) {
		$('#iMessage').html('~~ id 는 4글자 이상 입니다 ~~');
		return false;
	}else if ( id.replace(/[a-z.0-9]/gi ,'').length > 0 ) {
		$('#iMessage').html('~~ id 는 영문자, 숫자로만 입력 하세요 ~~');
		return false;
	}else {
		$('#iMessage').html('');
		return true;
	}
} //idCheck

function pwCheck() {
	var password=$('#password').val()
	if (password.length<4) {
		$('#pMessage').html('~~ password 는 4글자 이상 입니다 ~~');
		return false;
	}else if ( password.replace(/[!-*.@]/gi,'').length >= password.length ) {
		$('#pMessage').html('~~ password 는 특수문자가 반드시 1개 이상 포함되어야 합니다 ~~');
		return false;
	}else if ( password.replace(/[a-z.0-9.!-*.@]/gi ,'').length > 0 ) {
		$('#pMessage').html('password 는 영문자, 숫자, 특수문자 로만 입력 하세요');
		return false;
	}else {
		$('#pMessage').html('');
		return true;
	}
} //password

function nmCheck() {
	var name=$('#name').val();
	if (name.length<2) {
		$('#nMessage').html(' ~~ name 은 2글자 이상  입니다 ~~');
		return false;
	}else if (name.replace(/[a-z.가-힣]/gi,'').length > 0) {
		$('#nMessage').html(' ~~ name 은 한글 또는 영문 으로만 입력 하세요 ~~');
		return false;
	}else {
		$('#nMessage').html('');
		return true;
	}	
} //name

//function bdCheck() {
//	var birthd=$('#birthd').val();
//	if (birthd.length != 10) {
//		$('#bMessage').html(' ~~ 생년월일을 정확하게 입력 하세요 (yyyy-mm-dd) ~~');
//		return false;
//	}else {
//		$('#bMessage').html('');
//		return true;
//	}	
//} //birthd

function adCheck() {
	var address=$('#address').val();
	if (address.length<10) {
		$('#aMessage').html(' ~~ address 은 10글자 이상  입니다 ~~');
		return false;
//	}else if (address.replace(/[a-z.가-힣]/gi,'').length > 0) {
//		$('#aMessage').html(' ~~ address 은 한글 또는 영문 으로만 입력 하세요 ~~');
//		return false;
	}else {
		$('#aMessage').html('');
		return true;
	}	
} //name

//function poCheck() {
//	var point=$('#point').val();
//	if ( $.isNumeric(point)==false ) {
//		$('#oMessage').html(' ~~ point는 숫자로만 정확하게 입력 하세요 ~~ ');
//		return false;
//	}else if (point.replace(/[.]/g,'').length < point.length) {
//		$('#oMessage').html(' ~~ point는 정수로만 정확하게 입력 하세요 ~~ ');
//		return false;
//	}else {
//		$('#oMessage').html('');
//		return true;
//	}
//} //point

function phCheck() {
	var phone=$('#phone').val()
	if (phone.length<13) {
		$('#oMessage').html('~~ phone number 는  - 포함 13글자 입니다 ~~');
		return false;
	}else if (phone.length>13) {
		$('#oMessage').html('~~ phone number 는  - 포함 13글자 입니다 ~~');
		return false;	
	}else if ( phone.replace(/[0-9]/gi,'').length < 2 ) {
		$('#oMessage').html('~~ phone number 는 -가 반드시 2개 이상 포함되어야 합니다 ~~');
		return false;
	}else if ( phone.replace(/[0-9.-]/gi ,'').length > 0 ) {
		$('#oMessage').html('phone number 는 숫자, - 로만 입력 하세요');
		return false;
	}else {
		$('#oMessage').html('');
		return true;
	}
} //phone

//function weCheck() {
//	var weight=$('#weight').val();
//	if ( $.isNumeric(weight)==false ) {
//		$('#wMessage').html(' ~~ weight는 숫자로만 정확하게 입력 하세요 ~~ ');
//		return false;
//	}else if (parseFloat(weight) < 20 || parseFloat(weight) > 200 ) {
//	// }else if (Number(weight) < 20 || Number(weight) > 200 ) {	
//		$('#wMessage').html('weight 범위를 벗어남: 20~200 사이의 숫자를 입력 하세요');
//		return false;
//	}else {
//		$('#wMessage').html('');
//		return true;
//	}
//} //weight




