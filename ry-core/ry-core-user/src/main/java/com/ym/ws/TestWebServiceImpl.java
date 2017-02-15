package com.ym.ws;

import javax.jws.WebService;

@WebService(  
        endpointInterface = "com.ym.ws.TestWebService",  
        serviceName = "TestWebService") 
public class TestWebServiceImpl implements TestWebService{

	@Override
	public String Test(String json) {
		return "111";
	}

}
