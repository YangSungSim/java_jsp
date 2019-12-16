package com.javateam.jsp.util;

import javax.servlet.http.HttpServletRequest;

public class UploadFileUtil {
	
	/**
	 * 웹 브라우저별로 request 헤더 선택
	 * 
	 * @param request 요청 객체
	 * @return 요청 헤더
	 */
	public static String getBrowser(HttpServletRequest request) {
		
		  String header = request.getHeader("User-Agent");

		  if (header.contains("MSIE")) {
			  return "MSIE";
	  	  } else if(header.contains("Trident")) {
	  		  return "MSIE11";
		  } else if(header.contains("Chrome")) {
			  return "Chrome";
		  } else if(header.contains("Opera")) {
			  return "Opera";
		  }

		  return "Firefox";
	} //

	
	/**
	 * 원래 파일명 가져오기 
	 *  
	 * @param destFileName 암호화된 실제 저장 파일
	 * @return 업로드시 원래 파일명
	 */
	public static String getOriginalFileName(String destFileName) {

		String originalFileName;
		
		String[] str = destFileName.split("\\.");
		String ext = str[str.length-1]; // 확장자
		
		System.out.println("확장자 : "+ext);
		
		// "_" 가 여러개가 있을 경우 마지막 위치를 획득
		int index = destFileName.lastIndexOf("_");
		
		originalFileName = destFileName.substring(0,index);
		
		return originalFileName +"."+ext;
	} //
		
	public static void main(String[] args) {
		
		System.out.println(getOriginalFileName("Hydrangeas_201912160848355de515e7.jpg"));
		System.out.println(getOriginalFileName("Desert_77202_20191213_201912160845354647ceb2.jpg"));
	}

}