package com.javateam.member_project.action;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class MemberAllViewProcAction
 */
@WebServlet("/member/members_view_all.do")
public class MemberAllViewProcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAllViewProcAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("전체 회원정보 조회");
		MemberService service = new MemberServiceImpl();
		List<MemberVO> members = null;
		try {
			members = service.getAllMembers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("members", members);
		
		RequestDispatcher rd 
		= request.getRequestDispatcher("/member/members_view_all.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
