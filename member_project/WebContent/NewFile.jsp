<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
//post 방식 한글 변환 처리
  request.setCharacterEncoding("UTF-8"); 

%>    
<!DOCTYPE html>
<html lang="ko"> 
<head>
<meta charset="UTF-8">
<title>action</title>
</head>
<body> 
	<!-- 인자 수신 -->
	<jsp:useBean id="member" class="jsp_20191209.MemberDTO" scope="request" />
	<!-- DTO 인스턴스의 멤버필드값 대입: setter  -->
	<jsp:setProperty name="member" property="*" />
	
	<!-- getter -->
	아이디: <jsp:getProperty name="member" property="id" /><br>
	패스워드: <jsp:getProperty name="member" property="pw" /><br>
	이름: <jsp:getProperty name="member" property="name" /><br>
	성별: <jsp:getProperty name="member" property="gender" /><br>
	주소: <jsp:getProperty name="member" property="address" /><br>

</body>
</html>