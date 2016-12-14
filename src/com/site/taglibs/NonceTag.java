package com.site.taglibs;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.jsp.JspException;

import com.site.utils.SiteRand;

public class NonceTag extends SimpleTag {
	@Override
	public void doTag() throws JspException, IOException {
		String nonce = "";
		try {
			nonce = SiteRand.generateString(12);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		print("<input type='hidden' name='sys_nonce' value='".concat(nonce).concat("'/>"));
	}
}
