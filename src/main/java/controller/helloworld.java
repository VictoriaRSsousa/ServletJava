package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Servlet implementation class helloworld
 */
@WebServlet("/helloworld")
public class helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helloworld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	
		

		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("<HTML>");
		 out.println("<HEAD>");
		 out.println("<TITLE>Hello World Sample Servlet</TITLE>");
		 out.println("</HEAD>");
		 out.println("<BODY>");
		 out.println("<CENTER><H1>Hello World!</H1></CENTER>");
		 out.println("</BODY>");
		 out.println("</HTML>");
		 out.close();
		 }
		 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
