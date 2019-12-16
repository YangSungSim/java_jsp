<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다운로드 페이지</title>
<script>
// IE 지원 URI 인코딩
window.onload = function() {
	
	var download_link = document.getElementById("download_link");
	
	// IE일 경우 변환
	// 변환없으면 "유효한 문자들은 RFC 7230과 RFC 3986에 정의되어 있습니다" 에러 유발
	var agent = navigator.userAgent.toLowerCase();

	if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) 
		|| (agent.indexOf("msie") != -1) ) {
	
		alert("인터넷 익스플로러 브라우저 입니다.");
		download_link.href = encodeURI(download_link.href);
	    console.log("download_link.href : "+download_link.href);
	} //
	
} //
</script>
</head>
<body>
	다운로드 파일 : 
	<a id="download_link" href="${pageContext.request.contextPath}/download.do?downloadFile=${uploadFilename}">
		${originalFilename}
	</a> 
</body>
</html>