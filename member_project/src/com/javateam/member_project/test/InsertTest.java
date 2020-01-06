package com.javateam.member_project.test;

import java.sql.Date;

import com.javateam.member_project.dao.MemberDAO;
import com.javateam.member_project.dao.MemberDAOImpl;
import com.javateam.member_project.domain.MemberVO;

public class InsertTest {

	public static void main(String[] args) throws Exception {

		MemberDAO dao = MemberDAOImpl.getInstance();
		MemberVO member = new MemberVO();
		member.setMemberId("java12345");
		member.setMemberPassword("123456789");
		member.setMemberName("장길산");
		member.setMemberGender('m');
		member.setMemberEmail("jsp@abcd.com");
		member.setMemberPhone("010-1111-2222");
		member.setMemberBirth(Date.valueOf("2000-01-01"));
		member.setMemberZip("12345");
		member.setMemberAddress("서울 종로구*육의전 빌딩");
		dao.insertMember(member);
	} //

}
