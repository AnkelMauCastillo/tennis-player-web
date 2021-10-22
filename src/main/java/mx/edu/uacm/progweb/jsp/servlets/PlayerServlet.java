package mx.edu.uacm.progweb.jsp.servlets;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.edu.uacm.progweb.jsp.dto.Player;
import mx.edu.uacm.progweb.jsp.service.PlayerService;

/**
 * Clase Controladora
 * @author AngelC
 *
 */
@WebServlet(urlPatterns = "/player.do")
public class PlayerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PlayerService service = new
			PlayerService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>" +
	             "<title>Player DB</title>" +
	             "</head>");
	    out.println("<body>" +
	             "<H2>Welcome to the Tennis Players database!</H2>" +
	             "</body>");
	    out.println("</html>");
	    */
		//Recibir Parametros
		String playerName = request.getParameter("name");
		String playerLastName = request.getParameter("lname");
		//Reenviar el valor atraves de un atributo hacia la jsp
		request.setAttribute("name", playerName);
		request.setAttribute("lname", playerLastName);
		//request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		//para enviar un parametro
		request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String playerName = request.getParameter("name");
		String playerLastName = request.getParameter("lname");
		request.setAttribute("name", playerName);
		request.setAttribute("lname", playerLastName);
		Player player = service.getPlayerByName(playerName);
		request.setAttribute("country", player.getNationality());
		request.setAttribute("dob", player.getBirthDate());
		request.setAttribute("titles", player.getTitles());  	
    

		request.getRequestDispatcher("/WEB-INF/views/info.jsp").forward(request, response);
	    
	}
	
	
	

}
