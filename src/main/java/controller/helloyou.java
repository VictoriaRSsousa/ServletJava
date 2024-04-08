package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class helloyou
 */
@WebServlet("/helloyou")
public class helloyou extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helloyou() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String nome = req.getParameter("nome");
		 res.setContentType("text/html");
		 PrintWriter out = res.getWriter();
		 out.println("<HTML>");
		 out.println("<HEAD>");
		 out.println("<TITLE>Hello World Sample Servlet</TITLE>");
		 out.println("</HEAD>");
		 out.println("<BODY>");
		 out.println("<CENTER><H1>Hello "+nome+"</H1></CENTER>");
		 out.println("</BODY>");
		 out.println("</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
