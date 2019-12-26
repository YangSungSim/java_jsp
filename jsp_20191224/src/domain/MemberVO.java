package domain;

import java.sql.Date;

public class MemberVO {
	
  /**회원아이디
   * 
   */
	private String memberId;
	
	private String memberPassword;
	
	private String memberName;
	
	private char memberGender;
	
	private String memberEmail;
	
	private String memberPhone;
	
	private Date memberBirth;
	
	private String memberZip;
	
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
		return String.format(
				"MemberVO [memberId=%s, memberPassword=%s, memberName=%s, memberGender=%s, memberEmail=%s, memberPhone=%s, memberBirth=%s, memberZip=%s, memberAddress=%s]",
				memberId, memberPassword, memberName, memberGender, memberEmail, memberPhone, memberBirth, memberZip,
				memberAddress);
	}
}
