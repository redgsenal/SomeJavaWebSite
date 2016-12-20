package com.servlet.router.verify;

import com.site.sys.X;
import com.site.utils.NonceList;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerifyUser
 */
@WebServlet("/VerifyUser")
public class VerifyUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// process form post
		X.log("post here");
		// let get the nonce here
		HttpSession sc = request.getSession();
		NonceList nonce = (NonceList) sc.getAttribute("nonce");
		if (nonce != null){
			X.log(nonce.toString());
			if (nonce.validate(request)){
				X.log("this post is valid");
			}
		}else{
			X.log("nonce is null");
		}
	}
}
