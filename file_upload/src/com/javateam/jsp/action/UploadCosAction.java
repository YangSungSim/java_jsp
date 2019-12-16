package com.javateam.jsp.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javateam.jsp.util.BoardFileReNamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UploadCosAction
 */
@WebServlet("/upload_cos.do")
public class UploadCosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadCosAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("업로드 파일 처리 : cos 라이브러리 활용");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 업로드 파일 처리
		String saveFolder = "d:\\upload\\"; // 업로드 폴더
		int fileSize = 5*1024*1024; // 파일 용량 제한 (5MB)
		// saveFolder = request.getServletContext().getRealPath(saveFolder); // 웹 프로젝트 폴더 안의 경로일 경우
		String returnPath = ""; // 이동 페이지
		
		// 업로드 파일 중복 방지 : 고유 파일 정책 으로 변경
		// file format) 파일 형식 : 원본 파일명 + "_" + 날짜 포맷 + 해쉬코드 + 확장자
		MultipartRequest multi 
			= new MultipartRequest(request,
								saveFolder,
								fileSize,
								"UTF-8",
								new BoardFileReNamePolicy());
								 // new DefaultFileRenamePolicy());
		
		// 원래 파일명 
		String originalFilename = multi.getOriginalFileName("uploadFile");
		System.out.println("첨부 원본 파일명  :  " + originalFilename);
		
		// 실제 업로드 파일명
		String uploadFilename = multi.getFilesystemName("uploadFile");
		System.out.println("실제 저장 파일명  :  " + uploadFilename);
		
		// 추후 이 단계에서의 처리) 데이터베이스에 업로드 파일명 저장 : DAO
		
		// 추후 데이터베이스에 파일"명"을 저장할 경우는 원본 파일과 실제 저장 파일명을 다른 데이터베이스 필드
		// 에 저장하는 것이 바람직합니다. 그러나 불가피하게 파일 저장 데이터베이스 필드를 한개만 사용하는 경우는
		// 실제 저장 파일명을 기록하도록 조치하고 추후에 원본 파일명을 유틸리티
		// (가령 UploadFileUtil.getOriginalFileName(String destFileName) 메서드) 등을 
		// 활용하여 원본 파일명을 복원할 수 있습니다.
		
		// 다운로드 페이지로 이동
		// 페이지 이동 : 다운로드
		
		// 파일명 인자 전송
		request.setAttribute("originalFilename", originalFilename);
		request.setAttribute("uploadFilename", uploadFilename);
		
		returnPath = "download.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(returnPath);
		rd.forward(request, response);
		
	} //

}
