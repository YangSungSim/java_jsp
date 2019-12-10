<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jsp_20191209.MemberDTO" %>
<%

	request.setCharacterEncoding("UTF-8");

	MemberDTO member = new MemberDTO(request.getParameterMap());
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  아이디: <%=member.getId() %><br>
  패스워드: <%=member.getPw() %><br>
  이름: <%=member.getName() %><br>
  성별: <%=member.getGender() %><br>
  주소: <%=member.getAddress() %>

</body>
</html>