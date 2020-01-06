package com.javateam.member_project.dao;

import java.util.List;

import com.javateam.member_project.domain.MemberVO;

public interface MemberDAO {
	
	/**
	 * 회원정보 생성
	 * @param member 회원정보 객체
	 * @return 저장 성공 여부
	 * @throws Exception 예외처리
	 */
	boolean insertMember(MemberVO member) throws Exception;
	
	/**
	 * 개별 회원정보 조회
	 * @param memberId 회원 아이디
	 * @return 회원정보 객체
	 * @throws Exception 예외처리
	 */
	MemberVO getMember(String memberId) throws Exception;
	
	/**
	 * 전체 회원정보 조회
	 * @return 전체 회원정보(리스트)
	 * @throws Exception 예외처리
	 */
	List<MemberVO> getAllMembers() throws Exception;
	
	/**
	 * 전체 회원 정보 (페이징)
	 * @param page  현재 페이지
	 * @param limit 한계치 (몇 명까지 출력)
	 * @return 회원 정보들
	 * @throws Exception 예외처리
	 */
	List<MemberVO> getAllMemberByPaging(int page, int limit) throws Exception;
	
	/**
	 * 회원정보 수정
	 * @param member 회원정보 객체 
	 * @return 수정 성공 여부
	 * @throws Exception 예외 처리
	 */
	boolean updateMember(MemberVO member) throws Exception;
	/**
	 * 회원정보 삭제
	 * @param memberId 회원아이디
	 * @return 삭제 성공여부
	 */
	boolean deleteMember(String memberId) throws Exception;
	
	/**
	 * 회원여부점검
	 * @param memberId 멤버아이디
	 * @return 회원여부
	 * @throws Exception
	 */
	boolean isMEmber(String memberId) throws Exception;
}




















