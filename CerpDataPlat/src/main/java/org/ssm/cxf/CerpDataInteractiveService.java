package org.ssm.cxf;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name="CerpDataInteractiveService",targetNamespace="http://cxf.ssm.org/")
public interface CerpDataInteractiveService {
	
	public String tslCerpDataInteractive(@WebParam(name="userName")  String userName, @WebParam(name="passWord")  String passWord, @WebParam(name="oper")  String oper, @WebParam(name="xmlData")  String xmlData);
	
	public String tslCerpDataUpdate(@WebParam(name="userName")  String userName, @WebParam(name="passWord")  String passWord, @WebParam(name="oper")  String oper, @WebParam(name="xmlData")  String xmlData);
}
