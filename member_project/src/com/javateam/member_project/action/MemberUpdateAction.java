package com.javateam.member_project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberUpdateAction
 */
@WebServlet("/member/member_update.do")
public class MemberUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("회원정보수정:");
		String msg = "";
		String returnPath=""; 
		if (request.getParameter("memberId")==null || 
				request.getParameter("memberId").trim().contentEquals("")) {
			   
			msg = "아이디를 입력하십시오";
			request.setAttribute("msg", msg);
			returnPath = "/result/result.jsp";
		} else {
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(returnPath);
		rd.forward(request,response);
		
	}//
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
