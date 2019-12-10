<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<title>회원 가입(demo)</title>
</head>
<body> 
 
	<form name="member_form" method="post" action="action2.jsp"> 
	
	아이디: <input type="text" id="id" name="id" size="20" maxlength="20"/><br>
	패스워드: <input type="text" id="pw" name="pw" size="20" maxlength="20"/><br>
	이름: <input type="text" id="name" name="name" size="20" maxlength="50"/><br>
	성별: 남<input type="radio" id="gender1" name="gender" value="m" /> &nbsp;
	          여<input type="radio" id="gender1" name="gender" value="f" /><br>
	주소: <input type="text" id="address" name="address" size="50" maxlength="300"><br>
	
	<!-- <button type="submit">가입</button> -->
	<input type="submit" name="submitBtn" value="가입" /> &nbsp;
	<input type="reset" value="취소" />
	
	
	</form>
</body>
</html>