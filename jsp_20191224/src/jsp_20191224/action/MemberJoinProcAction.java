package jsp_20191224.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberVO;

/**
 * Servlet implementation class MemberJoinProcAction
 */
@WebServlet("/member/memeber_join_proc.do")
public class MemberJoinProcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinProcAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("member_join_proc.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("회원가입 처리");
		
		// 인자 처리
		request.getParameterMap().forEach((x,y)-> System.out.println(x+"="+y[0]));
		
		//인자 =>vo => DAO => 성공 /실패
		//페이지 이동이 달라질 수있다.
		
		MemberVO member = new MemberVO();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPassword(request.getParameter("memberPassword"));
		member.setMemberName(request.getParameter("memberName"));
		member.setMemberGender(request.getParameter("memberGender").charAt(0));
		member.setMemberEmail(request.getParameter("memberEmail"));
		member.setMemberPhone(request.getParameter("memberPhone"));
		
		
		member.setMemberBirth(Date.valueOf(request.getParameter("memberBirth")));
		
		String memberZip = request.getParameter("memberZip")==null ?
				"":request.getParameter("memberZip");
		member.setMemberZip(request.getParameter("memberZip"));
		
		String memberAddressBasic = request.getParameter("memberAddressBasic")==null ? 
				"":request.getParameter("memberAddressBasic");
		
		String memberAddressDetail = request.getParameter("memberAddressDetail")==null ? 
				"":request.getParameter("memberAddressDetail");
		
		String memberAddress = memberAddressBasic.contentEquals("") &&
				memberAddressDetail.contentEquals("") ? ""
						:memberAddressBasic +"*" +memberAddressDetail;
		member.setMemberAddress(memberAddress);
		
		System.out.println("memberVO"+member);
		
	}

}























