package jyitter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TwitDao;
import model.Twit;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String word = request.getParameter("word");
		TwitDao td = new TwitDao();
		ArrayList<Twit> slist = td.searchTwit(word);
		td.connectionClose();
		HttpSession session = request.getSession();
		session.setAttribute("searchList",slist);
		RequestDispatcher rd = request.getRequestDispatcher("kensaku.jsp");
		rd.forward(request, response);
	}
}
