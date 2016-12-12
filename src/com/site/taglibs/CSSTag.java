package com.site.taglibs;

import javax.servlet.jsp.*;
import java.io.*;

public class CSSTag extends PathTag {
	private String href;

	public void setHref(String href) {
		this.href = href;
	}
	
	public void doTag() throws JspException, IOException {
		if (req != null){
			if (href != null) {
				print("<link rel='stylesheet' href='".concat(super.getBaseUrl()).concat("/").concat(href).concat("'>"));
			}
		}else{
			print("<!-- css fail: " + href + "-->");
		}
	}
}
