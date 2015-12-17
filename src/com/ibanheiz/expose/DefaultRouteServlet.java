package com.ibanheiz.expose;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DefaultServlet
 */
@WebServlet(name = "default-route")
public class DefaultRouteServlet extends HttpServlet {
	private static final long serialVersionUID = -6299431082961224733L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if (path == null || path.contains("index")) {
			InputStream inputStream = getServletContext().getResourceAsStream("/index.html");
			PrintWriter printWriter = response.getWriter();
			Scanner scanner = new Scanner(inputStream);
			
			while (scanner.hasNext()) {
				printWriter.append(scanner.next());
			}
			
			scanner.close();
			response.setStatus(200);
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
		} else if (path == null || !path.equals("/views")) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
//			dispatcher.forward(request, response);
		}
		
//		response.sendRedirect("/java-angular/index.html");
	}
}
