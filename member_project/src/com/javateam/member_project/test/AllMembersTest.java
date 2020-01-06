package com.javateam.member_project.test;

import com.javateam.member_project.dao.MemberDAO;
import com.javateam.member_project.dao.MemberDAOImpl;
import com.javateam.member_project.domain.MemberVO;

public class AllMembersTest {

	public static void main(String[] args) throws Exception {

		MemberDAO dao = MemberDAOImpl.getInstance();
		
		for (MemberVO m : dao.getAllMembers()) {
			System.out.println(m);
		}
	} //

}
