package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ConsultaAluno
 */
@WebServlet(urlPatterns = {"/ConsultaAluno",})
public class ConsultaAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	DAO dao = new DAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        String matricula = request.getParameter("matricula");
	        if(matricula == null || matricula.isEmpty()) {
	            out.println("Matrícula do aluno não especificada.");
	            return;
	        }
	        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Academico?useSSL=false", "root", "root");
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM Alunos WHERE matricula = ?");
	            ps.setString(1, matricula);
	            ResultSet rs = ps.executeQuery();
	            
	            if(rs.next()) {
	            	out.println("<!DOCTYPE html>");
	            	out.println("<html>");
	            	out.println("<head>");
	            	out.println("<title>Dados do Aluno</title>");
	            	out.println("</head>");
	            	out.println("<body  style=\"text-align: center;\">");
	            	out.println("<h2 style=\"color: #333;\">Dados do Aluno</h2>");
	            	out.println("<p \"><strong style=\"color: blue;\">Matrícula:</strong> " + rs.getString("matricula") + "</p>");
	            	out.println("<p \"><strong style=\"color: blue;\">Nome:</strong> " + rs.getString("nome") + "</p>");
	            	out.println("<p \"><strong style=\"color: blue;\">Média:</strong> " + rs.getFloat("media") + "</p>");
	            	out.println("<p \"><strong style=\"color: blue;\">Frequência:</strong> " + rs.getInt("frequencia") + "</p>");
	            	out.println("</body>");
	            	out.println("</html>");
	            } else {
	                out.println("Aluno não encontrado.");
	            }
	            
	            con.close();
	        } catch(Exception e) {
	            out.println("Erro ao consultar aluno: " + e.getMessage());
	            e.printStackTrace(); // Adicione esta linha para exibir o stack trace completo do erro no console.
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
