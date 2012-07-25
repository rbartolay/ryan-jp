package com.ryan.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ryan.beans.Users;
import com.ryan.bom.AuthenticationBom;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequests(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    	String email = request.getParameter("txtEmail");
    	String password = request.getParameter("txtPassword");
    	
    	AuthenticationBom auth = new AuthenticationBom();
    	Users user = auth.login(email, password);
    	
    	if(user != null) {
    		HttpSession session = request.getSession(true);
    		session.setAttribute("user", user);
    	}
    	
    	response.sendRedirect("index.jsp");
    	//getServletContext().getRequestDispatcher("/jsp/login.form.jsp").forward(request, response);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/jsp/login.form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequests(request, response);
	}

}
