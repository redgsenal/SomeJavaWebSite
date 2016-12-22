package com.site.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;

public class InputBaseTag extends HttpServletTag {
	
	private String typeAttr = "text";
	private String nameAttr = null;
	private String classAttr = null;
	private String idAttr = null;
	
	public void setNameAttr(String nameAttr) {
		this.nameAttr = nameAttr;
	}

	public void setClassAttr(String classAttr) {
		this.classAttr = classAttr;
	}

	public void setIdAttr(String idAttr) {
		this.idAttr = idAttr;
	}
	
	public void setTypeAttr(String typeAttr) {
		this.typeAttr = typeAttr;
	}

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb = addBaseAttr("input");
		print(sb.toString());
	}
	
	protected StringBuffer addBaseAttr(String formType) throws IOException{
		StringBuffer sb = new StringBuffer("<");
		sb.append(formType).append(" ");
		concatAttr(sb, "type", typeAttr);
		concatAttr(sb, "name", nameAttr);
		concatAttr(sb, "id", idAttr);
		concatAttr(sb, "class", classAttr);
		return sb;
	}
}
