package com.javateam.jsp.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javateam.jsp.util.UploadFileUtil;

/**
 * Servlet implementation class FileDownloadAction
 */
@WebServlet("/download.do")
public class FileDownloadAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownloadAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("첨부 파일 다운로드 액션");
		
		String downloadFile = request.getParameter("downloadFile");
		String originalFileName = UploadFileUtil.getOriginalFileName(downloadFile);
		
		// 파일 다운로드시 원래 파일명으로 복원
		System.out.println("파일 다운로드 서비스");
		
		System.out.println("downloadFile : "+downloadFile);
		System.out.println("originalFileName : "+originalFileName);
		
		String filePath = ("d:\\upload\\");
		
		// 저장 폴더
		String sourcePath = filePath + downloadFile;
		File file = new File(sourcePath);
		response.setContentLength((int)file.length());
		
		// 다운로드시 한글 파일 깨짐 현상 방지
		String mimeType= URLConnection.guessContentTypeFromName(originalFileName);
        String header = UploadFileUtil.getBrowser(request);

        if (header.contains("MSIE")) {
        	String docName = URLEncoder.encode(originalFileName,"UTF-8").replaceAll("\\+", "%20");
	        response.setHeader("Content-Disposition", "attachment;filename=" + docName + ";");
        } else if (header.contains("Firefox")) {
	        String docName = new String(originalFileName.getBytes("UTF-8"), "ISO-8859-1");
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
        } else if (header.contains("Opera")) {
	        String docName = new String(originalFileName.getBytes("UTF-8"), "ISO-8859-1");
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
        } else if (header.contains("Chrome")) {
        	String docName = new String(originalFileName.getBytes("UTF-8"), "ISO-8859-1");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
        }
        
        response.setHeader("Content-Type", "application/octet-stream");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Pragma", "no-cache;");
        
        response.setContentType(mimeType);
		
		// 추가
        ServletOutputStream rout = null;
        BufferedInputStream in = null;
        BufferedOutputStream bout = null;
        
		try {
			System.out.println("file Path : " + filePath);
	        System.out.println("source Path : " + sourcePath);
			
	        System.out.println("파일 크기 : "+(int)file.length());
        
	        byte [] buffer = new byte[1024*15];
	        rout = response.getOutputStream();
	        in = new BufferedInputStream(new FileInputStream(file));
	        bout = new BufferedOutputStream(rout);
	        int n = 0;
	        
	        while((n=in.read(buffer, 0, 1024*15)) != -1) {
	              bout.write(buffer, 0, n);
	              bout.flush();
	        }
	        
        } catch (Exception e) {
        	System.out.println("예외 처리");
        	e.printStackTrace();
        } finally {
        	rout.close();
        	in.close();
        	bout.close();
        }
		
		try {
			// 페이지 이동
			String returnPath = "/download.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(returnPath);
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println("예외처리");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	} //

}
