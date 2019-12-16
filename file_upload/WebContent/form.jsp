<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>

	<form name="fileForm" 
		  enctype="multipart/form-data" 
	  	  method="post"
	  	  action="upload_cos.do">
		
		<input type="file" name="uploadFile" />
		<input type="submit" value="전송" />
		
	</form>
	
</body>
</html>