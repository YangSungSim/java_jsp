package com.javateam.member_project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javateam.member_project.domain.MemberVO;
import com.javateam.member_project.service.MemberService;
import com.javateam.member_project.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberViewProcAction
 */
@WebServlet("/member/member_view_proc.do")
public class MemberViewProcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewProcAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 회원 아이디 인자 처리
		String id = request.getParameter("memberId").trim();
		MemberService service = new MemberServiceImpl();
		MemberVO member = null;
		String returnPath = "";
		String addr[] = null; // 주소(분리)
		String addrBasic = ""; // 기본 주소
		String addrDetail = ""; // 상세 주소
		try {
			member = service.getMember(id);
			// 주소 : 기본주소 / 상세주소 분리
			if (member.getMemberAddress()!=null && 
				!member.getMemberAddress().trim().contentEquals("")) { 
				addr = member.getMemberAddress().split("\\*");
				addrBasic = addr[0];
				addrDetail = addr[1];
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 인자 생성
		request.setAttribute("member", member);
		// 주소 : 기본주소 / 상세주소 분리
		request.setAttribute("addrBasic", addrBasic);
		request.setAttribute("addrDetail", addrDetail);
		
		// 페이지 이동
		returnPath = "/member/member_view.jsp";
		RequestDispatcher rd 
			= request.getRequestDispatcher(returnPath);
		rd.forward(request, response);
	} //

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
