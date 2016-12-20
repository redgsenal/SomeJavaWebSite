package com.site.taglibs;

import java.io.IOException;

import javax.servlet.http.HttpSession;
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
		X.log("request");
		if (req == null)
			X.log("req == null");
		else
			X.log("req NOT null");
		X.log("session id");
		X.log(req.getSession().getId());
		HttpSession sc = req.getSession();
		NonceList nonceList = (NonceList) sc.getAttribute("nonce");
		if (nonceList == null) {
			nonceList = new NonceList();
		}
		
		if (nonceName == null || nonceName.isEmpty())
			nonceName = nonceList.generateName();
		nonceValue = nonceList.generateNonce();
		nonceList.add(req.getSession().getId(), nonceName, nonceValue);
		sc.setAttribute("nonce", nonceList);
		
		X.log("nonce setup " + req.getRequestedSessionId() + " " + nonceName + " " + nonceValue);
		X.log("nonce items " + nonceList.toString());

		print("<input type='hidden' name='nonceValue' value='".concat(nonceValue).concat("'/>"));
		print("<input type='hidden' name='nonceName' value='".concat(nonceName).concat("'/>"));
	}
}
