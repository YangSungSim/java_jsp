package com.javateam.jsp.test;

import jsp_20191209.MemberDTO;

public class DTOTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MemberDTO dto = new MemberDTO();
		dto.setId("jsp1345");
		dto.setPw("1345678");
		dto.setName("홍길동");
		dto.setGender("남");
		dto.setAddress("종로구 더조은 학원");
		
		//멤버필드를 개별확인
		//System.out.println("id: "+dto.getId());
		
		// 멤버 필드를 전체 확인
//		System.out.println(dto.toString());
//		System.out.println(dto);
		System.out.println("프릔트");
		
		MemberDTO dto2 = new MemberDTO("jsp134","1345678","홍길동","남","종로구 더조은 학원");
		System.out.println(dto2);
		
		// 두 객체 멤버 필드 들의 내용 비교
		// 1) hashCode
		System.out.println(dto.hashCode());
		System.out.println(dto2.hashCode());
		
		// 2) equals
		System.out.println(dto.equals(dto2));
	}
	

}
