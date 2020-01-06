<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 회원정보 조회</title>
</head>
<body>

	<c:forEach var="member" 
			   items="${members}" varStatus="st">
		${st.count}&nbsp; ${member}<br>
	</c:forEach>
	
</body>
</html>