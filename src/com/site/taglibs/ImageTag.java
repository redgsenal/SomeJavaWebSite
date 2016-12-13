package com.site.taglibs;

import javax.servlet.jsp.*;
import java.io.*;

public class ImageTag extends PathTag {
	private String path;
	private String className;

	public void setPath(String path) {
		this.path = path;
	}
	
	public void setClassname(String className){
		this.className = className;
	}
	
	public void doTag() throws JspException, IOException {
		if (req != null){
			if (path != null) {
				print("<img class='".concat(className).concat("' src='").concat(super.getBaseUrl()).concat("/").concat(path).concat("'/>"));
			}
		}else{
			print("<!-- url fail: " + path + "-->");
		}
	}
}
