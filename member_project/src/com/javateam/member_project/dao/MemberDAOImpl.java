package com.javateam.member_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javateam.member_project.domain.MemberVO;
import com.javateam.member_project.util.DbUtil;

public final class MemberDAOImpl implements MemberDAO {
	
	// 싱글턴(singleton) 생성 패턴 : GoF 디자인 패턴
	// 보안(캡슐화:은닉)
	// MemberDAO dao = MemberDAOImpl.getInstance();
	private static MemberDAOImpl instance = null;
	private MemberDAOImpl() {}
	
	public static final MemberDAOImpl getInstance() {
		if (instance == null) {
			instance = new MemberDAOImpl();
		}
		return instance;
	}

	@Override
	public boolean insertMember(MemberVO member) { // throws Exception {
		
		// 결과값 
		boolean flag = false;
		// SQL
		String sql = "INSERT INTO member_tbl VALUES "
				   + "(?,?,?,?,?,?,?,?,?)";
		// DB 연결 객체 생성
		Connection con = DbUtil.connect();
		// SQL 처리 객체
		PreparedStatement pstmt = null;
		
		try {
			// SQL 구문 예비 처리(준비)
			pstmt = con.prepareStatement(sql);
			// SQL 인자 처리
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPassword());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender()+"");
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberPhone());
			pstmt.setDate(7, member.getMemberBirth());
			pstmt.setString(8, member.getMemberZip());
			pstmt.setString(9, member.getMemberAddress());
			// SQL 실행
			if (pstmt.executeUpdate() == 1) {
				System.out.println("회원정보 저장에 성공하였습니다.");
				flag = true;
			} else {
				System.out.println("회원정보 저장에 실패하였습니다.");
			}
			
		} catch (SQLException e) {
			System.out.println("insertMember SE : ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("insertMember E : ");
			e.printStackTrace();
		} finally {
			// 자원 반납
			DbUtil.close(con, pstmt, null);
		} //
		
		return flag;
	} //

	@Override
	public MemberVO getMember(String memberId) { // throws Exception {

		// 결과값
		MemberVO member = new MemberVO();
		// SQL
		String sql = "SELECT * FROM member_tbl "
				   // + "WHERE memberId = '" + memberId +"'";
				   + "WHERE memberId = ?";
		// DB 연결 객체 생성
		Connection con = DbUtil.connect();
		// SQL 처리 객체
		PreparedStatement pstmt = null;
		// SQL 결과셋 객체
		ResultSet rs = null;
		
		try {
			// SQL 구문 예비 처리(준비)
			pstmt = con.prepareStatement(sql);
			// SQL 인자 처리
			pstmt.setString(1,  memberId);
			// SQL 실행 => 결과셋
			rs = pstmt.executeQuery();
			
			// 결과셋 => VO
			if (rs.next()) {
				
				// member.setMemberId(rs.getString(1));
				member.setMemberId(rs.getString("memberId"));
				member.setMemberPassword(rs.getString("memberPassword"));
				member.setMemberName(rs.getString("memberName"));
				member.setMemberGender(rs.getString("memberGender").charAt(0));
				member.setMemberEmail(rs.getString("memberEmail"));
				member.setMemberPhone(rs.getString("memberPhone"));
				member.setMemberBirth(rs.getDate("memberBirth"));
				member.setMemberZip(rs.getString("memberZip"));
				member.setMemberAddress(rs.getString("memberAddress"));
			} //
			
		} catch (SQLException e) {
			System.out.println("getMember SE : ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("getMember E : ");
			e.printStackTrace();
		} finally {
			// 자원 반납
			DbUtil.close(con, pstmt, rs);
		} //
		
		return member;
	} //

	@Override
	public List<MemberVO> getAllMembers() throws Exception {

		// 결과값
		List<MemberVO> members = new ArrayList<>();
		// 개별 회원정보
		// MemberVO member = new MemberVO(); // 중복 회원 조회(X)
		MemberVO member = null; // 중복 회원 조회 방지 !
		// 방지법) while문 내에서 회원정보 객체 생성
		// SQL
		String sql = "SELECT * FROM member_tbl";
		// DB 연결 객체 생성
		Connection con = DbUtil.connect();
		// SQL 처리 객체
		PreparedStatement pstmt = null;
		// SQL 결과셋 객체
		ResultSet rs = null;
		
		try {
			// SQL 구문 예비 처리(준비)
			pstmt = con.prepareStatement(sql);
			// SQL 실행 => 결과셋
			rs = pstmt.executeQuery();
			
			// 결과셋 => VO
			while (rs.next()) {
				
				// 중복 회원 조회 방지 대책
				member = new MemberVO();
				
				member.setMemberId(rs.getString("memberId"));
				member.setMemberPassword(rs.getString("memberPassword"));
				member.setMemberName(rs.getString("memberName"));
				member.setMemberGender(rs.getString("memberGender").charAt(0));
				member.setMemberEmail(rs.getString("memberEmail"));
				member.setMemberPhone(rs.getString("memberPhone"));
				member.setMemberBirth(rs.getDate("memberBirth"));
				member.setMemberZip(rs.getString("memberZip"));
				member.setMemberAddress(rs.getString("memberAddress"));
				
				// 개별 회원정보 => 전체 회원정보(리스트)
				members.add(member);
			} //
			
		} catch (SQLException e) {
			System.out.println("getAllMembers SE : ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("getAllMembers E : ");
			e.printStackTrace();
		} finally {
			// 자원 반납
			DbUtil.close(con, pstmt, rs);
		} //
		
		return members;
	} //

	@Override
	public List<MemberVO> getAllMemberByPaging(int page, int limit) throws Exception {
		// 결과값
				List<MemberVO> members = new ArrayList<>();
				MemberVO member = null;
				// SQL
				String sql = "SELECT *  " + 
						"FROM (SELECT ROWNUM,  " + 
						"             m.*,  " + 
						"             FLOOR((ROWNUM - 1) / ? + 1) page   " + 
						"      FROM ( " + 
						"             SELECT * FROM member_tbl  " + 
						"             ORDER BY memberId ASC" + 
						"           ) m   " + 
						"      )   " + 
						"WHERE page = ?";
						   
				// DB 연결 객체 생성
				Connection con = DbUtil.connect();
				// SQL 처리 객체
				PreparedStatement pstmt = null;
				// SQL 결과셋 객체
				ResultSet rs = null;
				
				try {
					// SQL 구문 예비 처리(준비)
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1,limit);
					pstmt.setInt(2,page);
					// SQL 실행 => 결과셋
					rs = pstmt.executeQuery();
					
					// 결과셋 => VO
					while (rs.next()) {
						
						// 중복 회원 조회 방지 대책
						member = new MemberVO();
						
						member.setMemberId(rs.getString("memberId"));
						member.setMemberPassword(rs.getString("memberPassword"));
						member.setMemberName(rs.getString("memberName"));
						member.setMemberGender(rs.getString("memberGender").charAt(0));
						member.setMemberEmail(rs.getString("memberEmail"));
						member.setMemberPhone(rs.getString("memberPhone"));
						member.setMemberBirth(rs.getDate("memberBirth"));
						member.setMemberZip(rs.getString("memberZip"));
						member.setMemberAddress(rs.getString("memberAddress"));
						
						// 개별 회원정보 => 전체 회원정보(리스트)
						members.add(member);
					} //
					
				} catch (SQLException e) {
					System.out.println("getAllMembers SE : ");
					e.printStackTrace();
				} catch (Exception e) {
					System.out.println("getAllMembers E : ");
					e.printStackTrace();
				} finally {
					// 자원 반납
					DbUtil.close(con, pstmt, rs);
				} //
				
				return members;
	}

	@Override
	public boolean updateMember(MemberVO member) throws Exception {
		boolean flag = false;
		// SQL
		String sql = "UPDATE member_tbl SET "
				   + "memberPassword=?,"
				   + "memberEmail=?,"
				   + "memberPhone=?,"
				   + "memberZip=?,"
				   + "memberAddress=? "
				   + "WHERE memberId=?";
		// DB 연결 객체 생성
		Connection con = DbUtil.connect();
		// SQL 처리 객체
		PreparedStatement pstmt = null;
		
		try {
			// SQL 구문 예비 처리(준비)
			pstmt = con.prepareStatement(sql);
			// SQL 인자 처리
			pstmt.setString(1, member.getMemberPassword());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberZip()+"");
			pstmt.setString(5, member.getMemberAddress());
			pstmt.setString(6, member.getMemberId());
			// SQL 실행
			if (pstmt.executeUpdate() == 1) {
				System.out.println("회원정보 수정에 성공하였습니다.");
				flag = true;
			} else {
				System.out.println("회원정보 수정에 실패하였습니다.");
			}
			
		} catch (SQLException e) {
			System.out.println("updateMember SE : ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("updateMember E : ");
			e.printStackTrace();
		} finally {
			// 자원 반납
			DbUtil.close(con, pstmt, null);
		} //
		
		return flag;
	}

	@Override
	public boolean deleteMember(String memberId) throws Exception {
		boolean flag = false;
		// SQL
		String sql = "DELETE member_tbl WHERE memberId=?";
				 
		// DB 연결 객체 생성
		Connection con = DbUtil.connect();
		// SQL 처리 객체
		PreparedStatement pstmt = null;
		
		try {
			// SQL 구문 예비 처리(준비)
			pstmt = con.prepareStatement(sql);
			// SQL 인자 처리
			pstmt.setString(1,memberId);
			
			// SQL 실행
			if (pstmt.executeUpdate() == 1) {
				System.out.println("회원정보 삭제에 성공하였습니다.");
				flag = true;
			} else {
				System.out.println("회원정보 삭제에 실패하였습니다.");
			}
			
		} catch (SQLException e) {
			System.out.println("deleteMember SE : ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("deleteMember E : ");
			e.printStackTrace();
		} finally {
			// 자원 반납
			DbUtil.close(con, pstmt, null);
		} //
		
		return flag;
	}

	@Override
	public boolean isMEmber(String memberId) throws Exception {
		// 결과값
		boolean flag = false;
		// SQL
		String sql = "SELECT count(*) FROM member_tbl "
				   + "WHERE memberId = ?";
		// DB 연결 객체 생성
		Connection con = DbUtil.connect();
		// SQL 처리 객체
		PreparedStatement pstmt = null;
		// SQL 결과셋 객체
		ResultSet rs = null;
		
		try {
			// SQL 구문 예비 처리(준비)
			pstmt = con.prepareStatement(sql);
			// SQL 인자 처리
			pstmt.setString(1,  memberId);
			// SQL 실행 => 결과셋
			rs = pstmt.executeQuery();
			
			// 결과셋 => VO
			if (rs.next()) {
				flag = rs.getInt(1)==1 ? true : false;
			} //
			
		} catch (SQLException e) {
			System.out.println("isMember SE : ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("isMember E : ");
			e.printStackTrace();
		} finally {
			// 자원 반납
			DbUtil.close(con, pstmt, rs);
		} //
		
		return flag;
	}

}
