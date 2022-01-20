<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설정된 모든 세션을 제거하기</title>
</head>
<body>
<center>
    <h3>[  세션을 제거하는 예제  ]</h3>
</center>
<hr/>
invalidate() 메소드를 사용하여 세션을 삭제하는 예제입니다.
<%
    String s_name;

    String s_value = "저는 세션에 저장된 첫 번째 값이에요 ^o^";
    session.setAttribute("s_name1", s_value);

    s_value = "저는 세션에 저장된 두 번째 갑이에요 ^o^";
    session.setAttribute("s_name2", s_value);

    s_value = "저는 세션에 저장된 세 번째 갑이에요 ^o^";
    session.setAttribute("s_name3", s_value);

    out.print("<hr/><h3>----- 세션값을 삭제하기 전 -----</h3>");
    Enumeration enum_app = session.getAttributeNames();
   
    int i = 0;
   
    while (enum_app.hasMoreElements()) {
       
        i++;
        s_name = enum_app.nextElement().toString();
        s_value = session.getAttribute(s_name).toString();
        out.println("<hr/>얻어온 세션 이름 [ " + i + " ] : " + s_name);
        out.println("<br/>얻어온 세션 값 [ " + i + " ] : " + s_value);
    }
   
    // 설정된 세션의 값들을 모두 사라지도록한다.
   
    // 혹은 invalidate 메소드 대신 setMaxInactiveInterval 메소드를 호출하되
    // 0을 지정하면 유효시간을 0으로 설정한 것이 되므로 세션 아이디가 유효하지 않게 된다.
    // session.setMaxInactiveInterval(0);
   
    out.print("<hr/><h3>----- 세션값을 삭제한 후 -----</h3>");
    out.print("<hr/>과연 세션 아이디가 유효할까요?<br/>");
   
    if (request.isRequestedSessionIdValid() == true) {
        out.print("세션 아이디가 유효합니다.<hr/>");
       
    }
   
    else {
        out.print("세션 아이디가 유효하지 않습니다.<hr/>");
       
    }
%>
</body>
</html>

