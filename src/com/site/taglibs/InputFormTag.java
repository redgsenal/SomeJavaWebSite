package com.site.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;

public class InputFormTag extends SimpleTag {
	
	private String nameAttr = null;
	private String classAttr = null;
	private String idAttr = null;
	private String actionAttr = null;
	
	public void setNameAttr(String nameAttr) {
		this.nameAttr = nameAttr;
	}

	public void setClassAttr(String classAttr) {
		this.classAttr = classAttr;
	}

	public void setIdAttr(String idAttr) {
		this.idAttr = idAttr;
	}

	public void setActionAttr(String actionAttr) {
		this.actionAttr = actionAttr;
	}

	@Override
	public void doTag() throws JspException, IOException {
		print("<form class='".concat(classAttr).concat("' name='").concat(nameAttr).concat("' id='").concat(idAttr).concat("' ").concat("action='").concat(actionAttr).concat("' />"));
	}
	
	protected void print(String s) throws IOException{
		getJspContext().getOut().println(s);
	}
}
