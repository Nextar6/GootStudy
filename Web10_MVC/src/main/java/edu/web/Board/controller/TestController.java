package edu.web.Board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.Board.domain.BoardVO;
import edu.web.Board.persistence.BoardDAO;
import edu.web.Board.persistence.BoardDAOImple;

@WebServlet("/TestController")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BoardDAO dao;

	public TestController() {
		dao = BoardDAOImple.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userid = request.getParameter("userid");
//		String title = request.getParameter("title");
//		String content =request.getParameter("content");
//		BoardVO vo = new BoardVO(0, title, content, userid, null);
		List<BoardVO> list = dao.select();
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
