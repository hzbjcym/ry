package com.ym.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class BaseController {
	protected Logger  logger  = Logger.getLogger(getClass());
	protected HttpHeaders headers = new HttpHeaders();

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false));
    }

    /**
     * @Title: getHeader
     * @Description: 获取http返回的文件头
     * @Return HttpHeaders
     * @Throws
     */
    protected HttpHeaders getHeader() {
        headers.setContentType(MediaType.parseMediaType("text/plain;charset=utf-8"));
        return headers;
    }
   
}
