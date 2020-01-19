package org.ssm.cxf.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ssm.dufy.entity.User;
import org.ssm.dufy.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


@Component("authInterceptor")
public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	@Autowired
	private IUserService userService;

	public AuthInterceptor() {
		super(Phase.PRE_INVOKE);
	}


	@SuppressWarnings("null")
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		
//		List<Header> headers = message.getHeaders();
//		if(headers==null || headers.size()==0) {
//			throw new Fault(new IllegalArgumentException("没有HEADER,用户密码验证失败！"));
//		}
//		
//		Header firstHeader = headers.get(0);
//		Element el = (Element)firstHeader.getObject();
//		
//		NodeList uList = el.getElementsByTagName("userName");
//		NodeList pList = el.getElementsByTagName("passWord");
//		
//		if(uList.getLength() != 1) {
//			throw new Fault(new IllegalArgumentException("用户格式错误"));
//		}
//		
//		if(pList.getLength() != 1) {
//			throw new Fault(new IllegalArgumentException("密码格式错误"));
//		}
		
//		String userName = uList.item(0).getTextContent();
//		String passWord = pList.item(0).getTextContent();
		HttpServletRequest request = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
		List<String> list = message.getContent(List.class);
		String userName = list.get(0).toString();
		String passWord = list.get(1).toString();
		String oper = list.get(2).toString().trim().toLowerCase();
		
		User u = userService.getUserByName(userName);
		
		if(u==null) {
			throw new Fault(new IllegalArgumentException("用户不存在"));
		}
		
		if(!passWord.equals(u.getPassword())) {
			throw new Fault(new IllegalArgumentException("密码错误"));
		}
		

		List<String> operslist = Arrays.asList(u.getOpers().split(","));
		if(!operslist.contains(oper)) {
			throw new Fault(new IllegalArgumentException("操作:"+oper+",不存在或未授权"));
		}

		request.setAttribute("UserInfo", u);

	}

}
