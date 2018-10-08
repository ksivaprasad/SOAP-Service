package com.soapservice.service;

import javax.jws.WebService;

import com.soapservice.bean.Email;
import com.soapservice.bean.EmailStatus;
import com.soapservice.util.SendEmailUtil;

@WebService(endpointInterface = "com.soapservice.service.EmailService")
public class EmailServiceImpl implements EmailService {

	@Override
	public EmailStatus sendEmail(Email email) {
		EmailStatus emailStatus = new EmailStatus();
		try {
			String result = SendEmailUtil.sendMail(email);
			emailStatus.setStatus(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emailStatus;
	}

}
