package edu.web.Board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.Board.domain.BoardVO;
import edu.web.Board.persistence.BoardDAO;
import edu.web.Board.persistence.BoardDAOImple;
import edu.web.Board.util.PageCriteria;
import edu.web.Board.util.PageMaker;

@WebServlet("*.do") // *.do : ~.do 로 선언된 HTTP 호출에 대해 반응
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BOARD_URL = "WEB-INF/board/";
	private static final String MAIN = "index";
	private static final String LIST = "list";
	private static final String REGISTER = "register";
	private static final String DETAIL = "detail";
	private static final String UPDATE = "update";
	private static final String DELETE = "delete";
	private static final String EXTENSION = ".jsp";
	private static final String SERVER_EXTENSION = ".do";
	private static BoardDAO dao;

	public BoardController() {
		dao = BoardDAOImple.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controlURI(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controlURI(request, response);

	}

	private void controlURI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String requestMethod = request.getMethod();
		System.out.println("호출 경로 : " + requestURI);
		System.out.println("호출 방식 : " + requestMethod);

		if (requestURI.contains(LIST + SERVER_EXTENSION)) { // list
			System.out.println("list 호출 확인");
			list(request, response);
		} else if (requestURI.contains(REGISTER + SERVER_EXTENSION)) { // register
			System.out.println("register 호출 확인");
			if (requestMethod.equals("GET")) {
				registerGET(request, response);

			} else if (requestMethod.equals("POST")) {
				registerPOST(request, response);

			}
		} else if (requestURI.contains(DETAIL + SERVER_EXTENSION)) { // detail
			System.out.println("detail 호출 확인");
			detail(request, response);
		} else if (requestURI.contains(UPDATE + SERVER_EXTENSION)) { // update
			System.out.println("update 호출 확인");
			if (requestMethod.equals("GET")) {
				updateGET(request, response);
			} else if (requestMethod.equals("POST")) {
				updatePOST(request, response);
			}
		} else if (requestURI.contains(DELETE + SERVER_EXTENSION)) { // delete
			System.out.println("delete 호출 확인");
			delete(request, response);
		} else {
			System.out.println("잘못된 경로라고 알려주기!");
		}

	} // end controlURI()

	// 전체 게시판 내용(list)을 DB에서 가져오고, 그 데이터를 list.jsp 페이지에 보내기
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<BoardVO> list = dao.select();
		String page = request.getParameter("page");
		
		PageCriteria criteria = new PageCriteria(); 
		if(page != null) {
			criteria.setPage(Integer.parseInt(page));
		}
		
		List<BoardVO> list = dao.select(criteria);
		String path = BOARD_URL + LIST + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		request.setAttribute("list", list);
		// 페이지 링크 번호에 대한 정보를 구성하여 list.jsp 페이지에 전송
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria); // 시작 페이지 및 한 페이지 당 게시글 정보
		int totalCount = dao.getTotalCounts(); // 전체 게시글 수
		pageMaker.setTotalCount(totalCount); // 전체 게시글 수 저장
		pageMaker.setPageData(); // 저장된 데이터를 바탕으로 page 링크 데이터 생성
		System.out.println("전체 게시글 수 : " + pageMaker.getTotalCount());
		System.out.println("현재 선택된 페이지 : " + criteria.getPage());
		System.out.println("한 페이지 당 게시글 수 : " + criteria.getNumsPerPage());
		System.out.println("페이지 링크 번호 개수 : " + pageMaker.getNumsOfPageLinks());
		System.out.println("시작 페이지 링크 번호 :" + pageMaker.getStartPageNo());
		System.out.println("끝 페이지 링크 번호 : " + pageMaker.getEndPageNo());
		System.out.println("이전 버튼 존재 유무 : " + pageMaker.isHasPrev());
		System.out.println("다음 버튼 존재 유무 :" + pageMaker.isHasNext());
		
		request.setAttribute("pageMaker", pageMaker);
		dispatcher.forward(request, response);

	} // end list()
	PageMaker pageMaker = new PageMaker();

	// register.jsp 경로로 이동
	private void registerGET(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 세션 체크
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		if(userid != null && !userid.equals("")) { // userid 세션 존재(로그인상태) 확인
			String path = BOARD_URL + REGISTER + EXTENSION;
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			
		}else { // userid 세션이 존재하지 않음 (로그아웃 상태)
			// session에 목표 url 정보를 저장
			session.setAttribute("targetURL", REGISTER + ".do"); 
			response.sendRedirect("login.go");
		}
		
				


	} // end registerGET()

	// 전송된 데이타를 DB에 저장
	private void registerPOST(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardVO vo = new BoardVO(0, title, content, userid, null);
		System.out.println(vo);

		int result = dao.insert(vo);
		if (result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('게시글 등록 성공');</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");
		}

	} // end registerPOST()

	// 전송된 bno값에 인덱스에 맞는 게시글 데이터를 DB에서 가져와서 detail.jsp에 전송
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("detail 서블렛메서드");
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardVO vo = dao.select(bno);
		String path = BOARD_URL + DETAIL + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		request.setAttribute("vo", vo);
		dispatcher.forward(request, response);

	} // end detail()

	// bno 번호에 맞는 게시글 데이터를 DB에서 선택하여 update.jsp 페이지로 전송 및 이동
	private void updateGET(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardVO vo = dao.select(bno);
		// TODO null 처리

		String path = BOARD_URL + UPDATE + EXTENSION;
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		request.setAttribute("vo", vo);
		dispatcher.forward(request, response);

	} // end updateGET() 전송된 데이터를 DB에 수정하고 index.jsp로 이동

	private void updatePOST(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardVO vo = new BoardVO(bno, title, content, "", "");
		int result = dao.update(vo);

		if (result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'" + "</head>");
			out.print("<script>alert('게시글 수정 성공');</script>");
			out.print("<script>location.href='" + DETAIL + SERVER_EXTENSION + "?bno=" + bno + "'</script>");
		}

	} // end updatePOST()

	// 전송된 bno 데이터로 DB에서 데이터 삭제 및 index.jsp로 이동
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int result = dao.delete(bno);
		System.out.println(result);

		if (result == 1) {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('게시글 삭제 성공');</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");
		} else {
			PrintWriter out = response.getWriter();
			out.print("<head>" + "<meta charset='UTF-8'>" + "</head>");
			out.print("<script>alert('게시글 삭제 실패');</script>");
			out.print("<script>location.href='" + MAIN + EXTENSION + "';</script>");

		}

	} // end delete()

}
