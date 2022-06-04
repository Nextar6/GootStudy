package edu.web.Board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import edu.web.Board.domain.ReplyVO;
import edu.web.Board.persistence.ReplyDAO;
import edu.web.Board.persistence.ReplyDAOImple;

@WebServlet("/replies/*") // 서블릿 매핑
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyDAO dao;

	public ReplyController() {
		dao = ReplyDAOImple.getInstance();
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
		System.out.println(requestURI);

		if (requestURI.contains("add")) {
			System.out.println("add 호출 확인");
			replyAdd(request, response);
		} else if(requestURI.contains("all")) {
			System.out.println("all 호출 확인");
			replyList(request, response);
		} else if(requestURI.contains("update")) {
			replyUpdate(request, response);
		} else if(requestURI.contains("delete")) {
			replyDelete(request, response);
		}

	} // controlURI()




	private void replyAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String replyContent = request.getParameter("replyContent");
		String replyId = request.getParameter("replyId");

		ReplyVO vo = new ReplyVO(0, boardNo, replyContent, replyId, "");
		System.out.println(vo);
		int result = dao.insert(vo);
		if(result == 1) {
			response.getWriter().append("success");
		}
	} // end replyAdd()
	
	private void replyList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		List<ReplyVO> list = dao.select(boardNo);
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		JSONArray jsonArray = new JSONArray();
		for(int i = 0; i < list.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("replyNo", list.get(i).getReplyNo());
			jsonObject.put("boardNo", list.get(i).getBoardNo());
			jsonObject.put("replyContent", list.get(i).getReplyContent());
			jsonObject.put("replyId", list.get(i).getReplyId());
			jsonObject.put("replyDate", list.get(i).getReplyDate());
			jsonObject.put("userid",userid);
			jsonArray.add(jsonObject);
			
			
		}
		System.out.println(jsonArray.toString());
		response.getWriter().append(jsonArray.toString()); // 정보를 돌려주는 거
	
	} // end replyList()

	private void replyUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String replyContent = request.getParameter("replyContent");
		ReplyVO vo = new ReplyVO(replyNo, boardNo, replyContent, "", "");
		int result = dao.update(vo);
		if(result == 1) {
			response.getWriter().append("success");
		}
		
		
	} // replyUpdate()
	
	private void replyDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		int result = dao.delete(replyNo, boardNo);
		System.out.println(result);
		if(result == 1) {
			response.getWriter().append("success");
		}
	} // replyDelete() 
	
}
