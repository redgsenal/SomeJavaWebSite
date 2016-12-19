package com.site.taglibs;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;

import com.site.sys.X;
import com.site.utils.NonceList;

public class NonceTag extends HttpServletTag {
	private String nonceName = "";
	
	public void setNoncename(String v){
		this.nonceName = v;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		String nonceValue = "";
		X.log(req.getRequestedSessionId());
		ServletContext sc = req.getServletContext();
		NonceList nonceList = (NonceList) sc.getAttribute("nonce");
		if (nonceList == null) {
			nonceList = new NonceList();
		}
		
		if (nonceName == null || nonceName.isEmpty())
			nonceName = nonceList.generateName();
		nonceValue = nonceList.generateNonce(req.getRequestedSessionId(), nonceName);
		nonceList.add(req.getRequestedSessionId(), nonceName, nonceValue);
		sc.setAttribute("nonce", nonceList);
		
		X.log("nonce setup " + req.getRequestedSessionId() + " " + nonceName + " " + nonceValue);
		X.log("nonce items " + nonceList.toString());

		print("<input type='hidden' name='nonceValue' value='".concat(nonceValue).concat("'/>"));
		print("<input type='hidden' name='nonceName' value='".concat(nonceName).concat("'/>"));
	}
}
