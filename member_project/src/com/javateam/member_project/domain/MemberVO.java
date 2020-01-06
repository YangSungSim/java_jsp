package com.javateam.member_project.domain;

import java.sql.Date;

public class MemberVO {
	
	/** 아이디 */
	private String memberId;
	/** 패쓰워드 */
	private String memberPassword;
	/** 이름 */
	private String memberName;
	/** 성별 */
	private char memberGender;
	/** 이메일 */
	private String memberEmail;
	/** 연락처 */
	private String memberPhone;
	/** 생년월일 */
	private Date memberBirth;
	/** 우편번호 */
	private String memberZip;
	/** 주소 */
	private String memberAddress;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public char getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(char memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public Date getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberZip() {
		return memberZip;
	}
	public void setMemberZip(String memberZip) {
		this.memberZip = memberZip;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberName=" + memberName
				+ ", memberGender=" + memberGender + ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone
				+ ", memberBirth=" + memberBirth + ", memberZip=" + memberZip + ", memberAddress=" + memberAddress
				+ "]";
	}

}