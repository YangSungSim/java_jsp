<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>개별 회원 수정</title>
<style>
table#member_view_tbl {
	width:800px;
}

/* 필수 항목 아이콘 */
span.req-item { color:red }
</style>

<!-- bootstrap CSS -->  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- popper.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- bootstrap javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div id="wrap" class="mx-auto" style="width:800px;">
	
	<!-- 개별 회원 수정폼 -->
	<form id="member_update_form" name="member_update_form" method="post" action="/member/member_update_proc.do">
		  
		<table id="member_view_tbl"
		       class="table table-bordered">
			<!-- 아이디 -->
			<tr>
				<td>
					<label id="memberId"><span class="req-item">*</span> 아이디 : </label>
				</td>
				<td>${member.memberId}
					 <input type="hidden"
						   id="memberId"
						   name="memberId"
						   size="25"
						   class="form-control" 
						   value="${member.memberId}"/> 
				</td>
			</tr>
			
			<!-- 패쓰워드 -->
			<tr>
				<td>
					<label id="memberPassword"><span class="req-item">*</span> 패쓰워드 : </label>
				</td>
				<td>
					 <input type="text"
						   id="memberPassword"
						   name="memberPassword"
						   size="25"
						   class="form-control"
						   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{8,20}"
						   title="패쓰워드는 영문대소문자/특수문자/숫자 조합하여 8~20자로 입력하십시오"
						   value="${member.memberPassword}"/> 
				</td>
			</tr>
			
			<!-- 신규 패쓰워드 -->
			<tr>
				<td>
					<label id="memberPassword">신규 패쓰워드 : </label>
				</td>
				<td>${member.memberPassword}
					 <input type="hidden"
						   id="memberPassword"
						   name="memberPassword"
						   value="${member.memberPassword}"/> 
				</td>
			</tr>
			
			<!-- 이름 -->
			<tr>
				<td>
					<label id="memberName"><span class="req-item">*</span> 이름 : </label>
				</td>
				<td>${member.memberName}
					<%-- <input type="text"
						   id="memberName"
						   name="memberName"
						   class="form-control" 
						   readonly
						   value="${member.memberName}" /> --%>
				</td>
			</tr>
			
			<!-- 성별 -->
			<tr>
				<td>
					<label id="memberGender"><span class="req-item">*</span> 성별 : </label>
				</td>
				<td><%-- ${member.memberGender} --%>
				    <%-- ${member.memberGender == 'm' ? '남자' : '여자'} : 문제 발생 (ASCII 코드 치환) --%>
				    ${member.memberGender == 109 ? '남자' : '여자'}
					<!-- <div class="row">
						<div class="custom-control custom-radio col-sm-2 ml-3">
							<input type="radio"
								   id="memberGenderMale"
								   name="memberGender"
								   title="성별을 입력하십시오"
								   required
								   class="custom-control-input" 
								   value="m" />
							<label class="custom-control-label" for="memberGenderMale">남</label>	   	
						</div>		   
						<div class="custom-control custom-radio col-sm-2 ml-0">		   
							<input type="radio"
								   id="memberGenderFemale"
								   name="memberGender"
								   title="성별을 입력하십시오"
								   required
								   class="custom-control-input" 
								   value="f"/>
							<label class="custom-control-label" for="memberGenderFemale">여</label>	   		   
						</div>	
					</div>	    -->
				</td>
			</tr>
			
			<!-- 메일  -->
			<tr>
				<td>
					<label for="memberEmail"><span class="req-item">*</span> 이메일 : </label>
				</td>
				<td>${member.memberEmail}
					<%-- <input type="email"
						   id="memberEmail"
						   name="memberEmail"
						   class="form-control" 
						   readonly
						   value="${member.memberEmail}"/> --%>
				</td>
			</tr>
			
			<!-- 연락처  -->
			<tr>
				<td>
					<label for="memberPhone"><span class="req-item">*</span> 연락처 : </label>
				</td>
				<td>${member.memberPhone}
					<%-- <input type="text"
						   id="memberPhone"
						   name="memberPhone"
						   class="form-control" 
						   readonly
						   value="${member.memberPhone}"/> --%>
				</td>
			</tr>
			
			<!-- 생년월일 -->
			<tr>
				<td>
					<label for="memberBirth"><span class="req-item">*</span> 생년월일 : </label>
				</td>
				<td><fmt:formatDate value="${member.memberBirth}" 
							        pattern="yyyy년 M월 d일" />
					<%-- <input type="text"
						   id="memberBirth"
						   name="memberBirth"
						   class="form-control" 
						   readonly 
						   value="${member.memberBirth}"/>	 --%>
				</td>
			</tr>
			
			<!-- 우편번호 -->
			<tr>
				<td>
					<label for="memberZip"> 우편번호 : </label>
				</td>
				<td>${member.memberZip}
					<%-- <div class="row">
						<div class="col-sm-3">
							<input type="text"
								   id="memberZip"
								   name="memberZip"
								   class="form-control"
								   readonly 
								   value="${member.memberZip}"/>
						</div>	  
					</div>	 --%>   	
				</td>
			</tr>
			
			<!-- 기본 주소 -->
			<tr>
				<td>
					<label for="memberAddressBasic"> 기본 주소 : </label>
				</td>
				<td><%-- ${addrBasic}<br> --%>
				${fn:split(member.memberAddress, "*")[0]}
				<%-- ${member.memberAddress} --%>
					<%-- <input type="text"
						   id="memberAddressBasic"
						   name="memberAddressBasic"
						   class="form-control" 
						   readonly 
						   value="${addrBasic}"/>	 --%>
				</td>
			</tr>
			
			<!-- 상세 주소 -->
			<tr>
				<td>
					<label for="memberAddressDetail"> 상세 주소 : </label>
				</td>
				<td><%-- ${addrDetail}<br> --%>
				${fn:split(member.memberAddress, "*")[1]}
					<%-- <input type="text"
						   id="memberAddressDetail"
						   name="memberAddressDetail"
						   class="form-control" 
						   readonly
						   value="${addrDetail}" />	 --%>
				</td>
			</tr>

		</table>	  
		
	</form>
	<!--// 회원 가입폼-->
	
	</div>
	
</body>
</html>