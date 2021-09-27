package jyitter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TwitDao;
import model.Twit;

/**
 * Servlet implementation class Toukou
 */
@WebServlet("/Toukou")
public class Toukou extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request .getParameter("name");
		String content = request.getParameter("content");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		String twitTime = dtf.format(now);
		Twit twit = new Twit(name,content, twitTime);
		
		TwitDao td = new TwitDao();
		td.addTwit(twit);
		td.connectionClose();
		RequestDispatcher rd = request.getRequestDispatcher("toukou.jsp");
		rd.forward(request, response);
	}

}
