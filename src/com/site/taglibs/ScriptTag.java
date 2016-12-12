package com.site.taglibs;

import javax.servlet.jsp.*;
import java.io.*;

public class ScriptTag extends PathTag {
	private String src;

	public void setSrc(String src) {
		this.src = src;
	}
	
	public void doTag() throws JspException, IOException {
		if (req != null){
			if (src != null) {
				print("<script src='".concat(super.getBaseUrl()).concat("/").concat(src).concat("'></script>"));
			}
		}else{
			print("<!-- script fail: " + src + "-->");
		}
	}
}
