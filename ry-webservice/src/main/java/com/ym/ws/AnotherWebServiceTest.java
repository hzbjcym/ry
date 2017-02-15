package com.ym.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;

@WebService
public interface AnotherWebServiceTest {

	/*@WSDLDocumentationCollection({
			@WSDLDocumentation("注释一My portType description"),
			@WSDLDocumentation(value = "注释二My top level description", placement = WSDLDocumentation.Placement.TOP),
			@WSDLDocumentation(value = "注释三My binding description", placement = WSDLDocumentation.Placement.BINDING) })*/
	
	@WebMethod
	@WSDLDocumentation("测试webservice2")
	public String AnotherTest(String json);
}
