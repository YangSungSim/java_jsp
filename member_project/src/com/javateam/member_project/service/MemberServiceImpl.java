package com.javateam.member_project.service;

import java.util.List;

import com.javateam.member_project.dao.MemberDAO;
import com.javateam.member_project.dao.MemberDAOImpl;
import com.javateam.member_project.domain.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	// DAO
	private MemberDAO dao = MemberDAOImpl.getInstance();

	@Override
	public boolean insertMember(MemberVO member) throws Exception {

		boolean flag = false;
		
		if (dao.insertMember(member)==true) {
			flag = true;
		} else {
			flag = false;
		}
		return flag; 
	} //

	@Override
	public MemberVO getMember(String memberId) throws Exception {

		return dao.getMember(memberId);
	}

	@Override
	public List<MemberVO> getAllMembers() throws Exception {
		return dao.getAllMembers();
	}
	/**
	 * 전체 회원 정보 (페이징)
	 * @param page  현재 페이지
	 * @param limit 한계치 (몇 명까지 출력)
	 * @return 회원 정보들
	 * @throws Exception 예외처리
	 */
	@Override
	public List<MemberVO> getAllMemberByPaging(int page, int limit) throws Exception {
		return dao.getAllMemberByPaging(page,limit);
	}

	@Override
	public boolean updateMember(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateMember(member);
	}

	@Override
	public boolean deleteMember(String memberId) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteMember(memberId);
	}

	@Override
	public boolean isMEmber(String memberId) throws Exception {
		return dao.isMEmber(memberId);
	}
}
