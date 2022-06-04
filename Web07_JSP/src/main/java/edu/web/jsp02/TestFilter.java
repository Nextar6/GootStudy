package edu.web.jsp02;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class TestFilter implements Filter {

    /* Filter의 목적
    - 서버에서 리소스에 접근하기 전에 클라이언트의 요청/응답을 인터셉트하는 기능
    - 클라이언트와 서버 간의 요청/ 응답을 조작하기 위해
    
    * Filter의 유형
    - 인증
    - 데이터 압축
    - 암호화
    - 로그/감시
    - 이미지 변환
    - characterEncodingSet
  
    * Filter 사용법
    - web.xml 파일에 필터 태그 추가
   */
    public TestFilter() {
      
    }

    // init() : 필터가 시작할 때 호출
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	// doFilter() : 필터를 사용할 때 마다 호출
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 클라이언트로 부터 IP 얻기
		String ipAddress = request.getRemoteAddr();
		
		// 현재 시간과 IP주소를 출력
		System.out.println("IP : " + ipAddress + ", Time : " + new Date().toString());
		chain.doFilter(request, response);
	}

	// destroy() : 필터가 종료될 때 호출
	public void destroy() {
		// TODO Auto-generated method stub
	}


}
