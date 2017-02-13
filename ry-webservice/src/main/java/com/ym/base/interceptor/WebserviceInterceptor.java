package com.ym.base.interceptor;

import java.util.List;

import javax.xml.soap.SOAPException;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.ym.EncryptUtil;
import com.ym.PropertyUtil;

/**
 * 服务端拦截
 * 
 * @ClassName: WebserviceInterceptor
 * @Author cym
 * @Date 2015年2月13日 下午3:53:11
 * @Modify
 * @CopyRight 珍诚医药在线股份有限公司
 */
public class WebserviceInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	
	public WebserviceInterceptor(String phase) {
		// 指定该拦截器在哪个阶段被激发
		// 该拦截器将会在调用之前拦截soap消息
		super(Phase.PRE_INVOKE);
	}

	@Override
	public void handleMessage(SoapMessage msg) throws Fault {
		try {
			/* -------------------------消息头的处理判断start ------------------------- */
			List<Header> headers = msg.getHeaders();
			if (null == headers || headers.size() < 1) {
				throw new Fault(new SOAPException("没有SOAP消息头！"));
			}
			Element element = (Element) headers.get(0).getObject();
			// XMLUtils.printDOM(element);// 打印xml内容到控制台,可删除
			NodeList userIdNode = element.getElementsByTagName("秘钥");
			
			String encryptCode = EncryptUtil.decrypt(userIdNode.item(0).getTextContent());
			// XXX 判断加密内容
			String systemCode = PropertyUtil.getProperty("EncryptCode");
			if (!systemCode.equalsIgnoreCase(encryptCode)) {
				throw new Fault(new SOAPException("SOAP消息头错误,异常调用"));
			}
			/* -------------------------消息头的处理判断end ------------------------- */

		} catch (Exception e) {
			throw new Fault(new IllegalArgumentException(e.getMessage()));
		}
	}

}
