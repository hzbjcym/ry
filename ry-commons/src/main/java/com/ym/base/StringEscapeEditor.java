package com.ym.base;

import java.beans.PropertyEditorSupport;

import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

public class StringEscapeEditor extends PropertyEditorSupport{
	
	private boolean escapeHTML;
	private boolean escapeJavaScript;
	
	
	public StringEscapeEditor(boolean escapeHTML, boolean escapeJavaScript) {
		super();
		this.escapeHTML = escapeHTML;
		this.escapeJavaScript = escapeJavaScript;
	}


	public StringEscapeEditor() {
		super();
	}


	@Override
	public String getAsText() {
		Object value = getValue();
		return value !=null?value.toString():"";
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text ==null){
			setValue(null);
		}else{
			String val = text;
			if(escapeHTML){
				val = HtmlUtils.htmlEscape(val);
			}
			if(escapeJavaScript){
				val = JavaScriptUtils.javaScriptEscape(val);
			}
			setValue(val);
		}
		
	}
	

}
