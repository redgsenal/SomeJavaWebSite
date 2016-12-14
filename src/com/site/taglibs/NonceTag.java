package com.site.taglibs;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.jsp.JspException;

import com.site.sys.X;
import com.site.utils.NonceList;
import com.site.utils.SiteRand;

public class NonceTag extends HttpServletTag {
	private String nonceName = "";
	
	public void setNoncename(String v){
		this.nonceName = v;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		String nonceValue = "";
		X.log(req.getRequestedSessionId());
		try {
			nonceValue = SiteRand.generateRandomString(12);
			req.getServletContext().setAttribute("nonce", new NonceList(req.getRequestedSessionId(), nonceName, nonceValue));
			print("<input type='hidden' name='sys_nonce' value='".concat(nonceValue).concat("'/>"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
