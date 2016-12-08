package com.servlet.home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.router.GenericServlet;
import com.site.global.Global;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
	protected static String HOME_FOOTER = "views/home/footer.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super("views/home/home.jsp");		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAttribute(Global.ATTR_SITE_NAME,"HOME");
		this.showContent(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
