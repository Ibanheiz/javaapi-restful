package com.ibanheiz.expose;

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
@WebServlet("/partials/*")
public class RoutesPartials extends HttpServlet {
	private static final long serialVersionUID = -3110933750855011394L;
	private static final int NOT_FOUND = 404;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public RoutesPartials() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getPathInfo().equals("/cliente")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/src/template/partials/message-validation.html");
			dispatcher.forward(request, response);
		} else {
			response.setStatus(NOT_FOUND);
		}
	}
}
