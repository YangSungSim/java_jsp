package jsp_20191209;

public class MemberDTO {
	/* 회원 아이디*/
	private String id;
	/* 회원 패스워드 */
	private String pw;
	/* 회원 이름 */
	private String name;
	/* 회원 성별 */
	private String gender;
	/* 회원 주소*/
	private String address;
	
	public MemberDTO() {
		System.out.println("기본생성자");
	}
	
	// 오버로딩 생성자 setter"s" 의미.  일체형: 인스턴스 생성전에 멤버필드 초기화
	public MemberDTO(String id, String pw, String name, String gender, String address) { 
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.address = address;
	}
	// getter"s" : 객체의 멤버필드들의 내용을 한꺼번에 확인
	@Override
	public String toString() {
		return String.format("MemberDTO [id=%s, pw=%s, name=%s, gender=%s, address=%s]", id, pw, name, gender, address);
	}

	// hashCode(): 객체의 고유값을 쓰는 것이 원래의 기능
	// -> 오버라이딩(변형) : 두 객체간에 멤버 필드들의 값이 같으면
	// 같은 hashcode가 생성됨.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}
	
	// -> 오버라이딩(변형) : 두 객체간에 멤버 필드들의 값이 같으면
	// true, 한 개의 필드값이라도 다르면 false가 나옴 
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MemberDTO)) {
			return false;
		}
		MemberDTO other = (MemberDTO) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (gender == null) {
			if (other.gender != null) {
				return false;
			}
		} else if (!gender.equals(other.gender)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (pw == null) {
			if (other.pw != null) {
				return false;
			}
		} else if (!pw.equals(other.pw)) {
			return false;
		}
		return true;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	// getter(get~ method)  
//	public String getId() {
//		return this.id; this는 자신의 객체 인스턴스를 말하는 것. self.
//	}
//	
//	// setter(set~ method)
//	public void setId(String id) {
//		this.id = id;
//	}
	
}
