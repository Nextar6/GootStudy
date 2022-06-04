package edu.web.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InfoServlet() {
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = ArrayList<>();
		JSONArray jsonArray = new JSONArray();
		for(int i = 0; i < 3; i++) {
			list.add("test" + i);
		}
		JSONArray jsonArray = new JSONArray();
		for(String id : list) {
			JsonObject jsonObject = new JSONObject();
			JsonObject.put("userid", id);
			JsonArray.add(jsonObject);
			
		}
		response.getWriter().append(JsonArray.toString))
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
