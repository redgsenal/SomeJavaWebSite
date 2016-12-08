package com.servlet.router;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServelet
 */
public class GenericServlet extends HttpServlet implements GenericServletActions {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8215282901780313198L;
	protected static String HEADER_PAGE = "views/header.jsp";
	protected static String FOOTER_PAGE = "views/footer.jsp";
	protected String content = "content.jsp"; 
	protected static String PAGE_TITLE = "Very Simple Page";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenericServlet(String content) {
        super();
        this.content = content;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showContent(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void showContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		includeHeader(request, response);
		includeContent(request, response, content);
		includeFooter(request, response);
	}
	
	protected void includeHeader(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		includePage(req, res, HEADER_PAGE);
	}
	
	protected void includeFooter(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		includePage(req, res, FOOTER_PAGE);
	}
	
	protected void includeContent(HttpServletRequest req, HttpServletResponse res, String pageURL) throws ServletException, IOException{
		includePage(req, res, pageURL);
	}
	
	protected void includePage(HttpServletRequest req, HttpServletResponse res, String pageURL) throws ServletException, IOException{
		req.getRequestDispatcher(pageURL).include(req, res);
	}

	public void setAttribute(String keyName, String value) {
		this.getServletContext().setAttribute(keyName, value);		
	}
}
