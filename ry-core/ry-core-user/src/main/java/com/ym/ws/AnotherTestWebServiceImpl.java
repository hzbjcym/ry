package com.ym.ws;

import javax.jws.WebService;

@WebService(  
        endpointInterface = "com.ym.ws.AnotherWebServiceTest",  
        serviceName = "AnotherWebServiceTest") 
public class AnotherTestWebServiceImpl implements AnotherWebServiceTest{

	@Override
	public String AnotherTest(String json) {
		return "111";
	}

}
