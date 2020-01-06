package com.javateam.member_project.test;

import com.javateam.member_project.dao.MemberDAO;
import com.javateam.member_project.dao.MemberDAOImpl;

public class GetMemberTest {

	public static void main(String[] args) throws Exception {

		MemberDAO dao = MemberDAOImpl.getInstance();
		System.out.println(dao.getMember("java12345"));
	}

}
