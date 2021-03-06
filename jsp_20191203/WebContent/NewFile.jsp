<!--  -->
<%--JSP 주석(comment) --%>
<%-- page 지시어(directive) --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%! 
  //선언부(declaration) : JSE(0) jee(x)
  // 변수, 메서드(함수) 선언
  // 현업에서는 미사용
  //현업에서는 java bean 영역으로 대체
  // JSP 순수 요소들이 잘 안쓰는 이유? 보안적으로 위험 (backend) jsp 전반
  // 예외 발생 => jsp 코드 노출됨. => 좀더 보안적으로 안전한 servlet / 확장된 servlet(spring 모듈을 사용)
  // 프론트엔드용도로 사용.
  String str2 = "Java";
  public void print(String str) {
	  System.out.println("str:" + str);
  }

%>
<%

  //scriptlet(스크립트릿): 변수/구문:JEE 영역(JSP)
  String str = "abcd"; // JSE 
  out.println("str : "+str+"<br>"); // JEE
  // System 클래스의 out 멤버 필드 x 
  // out: JSP 기본(내장) 객체(인스턴스). 웹브라우저 화면 인쇄
  // 객체(인스턴스) 생성 과정 바로 사용할 수 있는 객체
  // 추후 현업에서는 JSTL/EL 혹은 타 태그 라이브러리로 대체되는 경향
  // 여기서 println 메서드는 웹브라우저상의 개행(줄바꿈) 기능 없음
  // 줄바꿈 => br 태그가 담당.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 표현식(Expression) :주의) 마감(종결) 부호(;) 사용하면 안됨. 
     어떤 형태(메서드, 변수, 리터럴(값), 표현...) 값이 반환되는 경우만 됨. void 리턴 의 함수는 안됨.-->
Str : <%= str %><br>
<%=1+2+3 %><br>
<%=Math.random() %> <br>
<%= "오늘은 잠이 솔솔 오는 날이네요" %> <br>
str2: <%= str2 %>
</body>
</html>