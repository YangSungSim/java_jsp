package com.javateam.jsp.test;

import jsp_20191209_2.MemberDTO2;

public class DTOTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDTO2 dto = new MemberDTO2();
		dto.setId("jsp13245");
		dto.setPassword("134568");
		dto.setAddress("서울시 강남구");
		dto.setGender("남");
		dto.setName("누룽지");
		
		//개별 실행
		System.out.println(dto.getAddress());
		
		//전부다 실행
		System.out.println(dto);
		
		//id,password,name,gender,address
		MemberDTO2 dto2 = new MemberDTO2("jsp13245","134568","누룽지","남","서울시 강남구");
		System.out.println(dto2);
		
		//hashcode 확인
		System.out.println(dto2.hashCode());
		System.out.println(dto.hashCode());
		
		//equals
		System.out.println(dto.equals(dto2));
	}

}
