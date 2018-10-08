package com.soapservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.soapservice.bean.Email;
import com.soapservice.bean.EmailStatus;

@WebService
@SOAPBinding(style = Style.RPC)
public interface EmailService {
	@WebMethod
	EmailStatus sendEmail(@WebParam(name="EmailService")Email email);
}
