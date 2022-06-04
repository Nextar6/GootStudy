<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
   <%
      File file;
      int maxFileSize = 1024 * 1024 * 500;
      int maxMemSize = 1024 * 1024 * 500;
      ServletContext context = pageContext.getServletContext(); // 현재 페이지의 정보
      String filePath = context.getInitParameter("file-upload");
      // web.xml의 context-param과 매칭
      // getInitParameter() : context에 존재하는 파라미터 값 가져오기
      
      String fileRelativePath = context.getInitParameter("file-relative");
      
      // request에서 contentType 정보 저장
      String contentType = request.getContentType();
      
      if (contentType.indexOf("multipart/form-data") >= 0) { // 파일을 보냈는지 확인
         DiskFileItemFactory factory = new DiskFileItemFactory();
      
         // 메모리에 저장될 최대 사이즈 설정
         factory.setSizeThreshold(maxMemSize);
         
         // 파일의 크기가 maxMemSize를 초과하면 저장될 위치
         factory.setRepository(new File("C:\\tmp"));
         
         // 업로드 핸들러 생성
         ServletFileUpload upload = new ServletFileUpload(factory);
         
         // 업로드될 파일의 최대 사이즈 설정
         upload.setSizeMax(maxFileSize);
         
         try{
            // 파일 아이템들을 reqeust에서 추출
            List<FileItem> fileItems = upload.parseRequest(request);
            
            // 파일 아이템들을 Iterator에 저장
            Iterator<FileItem> iterator = fileItems.iterator();
            
            out.println("<h1>업로드된 파일</h1>");
            while(iterator.hasNext()) {
               FileItem fi = iterator.next(); // 각 파일 정보를 꺼내서 저장
               if(!fi.isFormField()) {
                  // 파일 정보 가져오기
                  String fieldName = fi.getFieldName();
                  String fileName = fi.getName();
                  boolean isInMemory = fi.isInMemory();
                  long sizeInBytes = fi.getSize();
                  System.out.println(filePath);
                  System.out.println(fileName);
                  
                  // 파일 절대 경로 생성
                  file = new File(filePath + "\\" + fileName); // 파일 생성
                  
                  // 파일 절대 경로에 저장하기
                  fi.write(file);
                  
                  // 파일 상대 경로 생성 및 저장
                  file = new File(fileRelativePath + "\\" + fileName);
                  fi.write(file);
                  
                  // 파일 정보 출력
                  out.println("업로드된 파일 : " + filePath + "\\" + fileName);
                  
                  // 다른 jsp 에서 이미지 보기
                  response.sendRedirect("/web07_JSP/16_image_view.jsp");
                  session.setAttribute("fileName", fileName);
                  
               }
            }
            
         } catch(Exception e) {
        	 System.out.print(e.getMessage());
            
         }
      } else{ // 파일이 없을 경우
    	  out.println("<p>업로드된 파일이 존재하지 않습니다.</p>");
    	  
      }
      
   %>
</body>
</html>














