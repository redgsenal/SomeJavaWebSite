package com.site.taglibs;

import javax.servlet.jsp.*;
import java.io.*;

public class UrlTag extends PathTag {
	private String path;

	public void setPath(String path) {
		this.path = path;
	}
	
	public void doTag() throws JspException, IOException {
		if (req != null){
			if (path != null) {
				print(super.getBaseUrl().concat("/").concat(path));
			}
		}else{
			print("<!-- url fail: " + path + "-->");
		}
	}
}
