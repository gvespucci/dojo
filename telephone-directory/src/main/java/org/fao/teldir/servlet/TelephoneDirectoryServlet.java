/**
 * 
 */
package org.fao.teldir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TelephoneDirectoryServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 */
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html");
        try {
            PrintWriter out = resp.getWriter();
            out.write("<html><body><h1>GET</h1>"+req.getParameterNames()+"</body></html>");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
	

}
