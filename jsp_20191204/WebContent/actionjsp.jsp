<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
  
//인자 한글 변환 처리: 인자 처리전에 호출
  request.setCharacterEncoding("UTF-8"); // post 방식에 한해서만 적용
 
  String id = request.getParameter("id");
  String pw = request.getParameter("pw");
  String name = request.getParameter("name");
  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디:<%=id %><br>
패스워드:<%=pw %><br>
이름: <%=name %>
</body>
</html>