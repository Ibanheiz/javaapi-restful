package com.ibanheiz.expose;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AngularNgView
 */
@WebServlet(name = "ng-view-serlvet")
public class AngularNgView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AngularNgView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		FileInputStream  fileInputStream = new FileInputStream(new File("src/template/cliente.html"));
		

		System.out.println(request.getPathInfo());
		
		if (request.getPathInfo().equals("/cliente")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/src/template/cliente.html");
			dispatcher.forward(request, response);
		} else {
			response.getWriter().append("Tete {{clienteCtl.clientes}}");
		}
		
		System.err.println("Requisição ok");
		
	}
}
