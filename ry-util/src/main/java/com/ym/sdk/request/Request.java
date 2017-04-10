package com.ym.sdk.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.ym.sdk.response.Response;

public class Request implements Serializable {
	private static final long serialVersionUID = 9180864360692286597L;
	private PostMethod method;
	private HttpClient client;
	
	public Request(String serverUrl, Map<String, String> params) {
		method = new PostMethod(serverUrl);
		if(params!=null && !params.isEmpty()){
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator<String> ite = params.keySet().iterator();
			while(ite.hasNext()){
				String key = ite.next();
				list.add(new NameValuePair(key, params.get(key)));
			}
			NameValuePair[] pairs = new NameValuePair[list.size()];
			for(int i=0;i<list.size();i++){
				pairs[i] = list.get(i);
			}
			method.setRequestBody(pairs);
			method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			client = new HttpClient();
			client.getParams().setContentCharset("UTF-8");
	        client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		}
	}
	
	public Response execute() {
		Response res = new Response();
//		InputStream inputStream = null;
//		BufferedReader br = null;
		try {
			res.setHttpStatus(client.executeMethod(method));
			res.setResponseBody(method.getResponseBodyAsString()); 
			
//			inputStream = method.getResponseBodyAsStream();
//			br = new BufferedReader(new InputStreamReader(inputStream));
//			StringBuffer stringBuffer = new StringBuffer();
//			String str= "";
//			while((str = br.readLine()) != null){ 
//				stringBuffer .append(str );
//			}
//			res.setResponseBody(stringBuffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setHttpStatus(500);
			res.setResponseBody("{\"error_response\":{\"code\":\"sys.error\", \"msg\":\"系统错误\"}}");
		}
		/*finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		return res;
	}

}