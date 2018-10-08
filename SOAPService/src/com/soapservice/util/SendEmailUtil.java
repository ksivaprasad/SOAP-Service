package com.soapservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.log4j.Logger;

import com.soapservice.bean.Email;

public class SendEmailUtil {
	private static final Logger logger = Logger.getLogger(SendEmailUtil.class.getName());
	
	public static String sendMail(Email email) {
		Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        //Establishing a session with required user details
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sk.sivaprasadk@gmail.com", "secure@123");
            }
        });
        try {
            MimeMessage msg = new MimeMessage(session);
            //Storing the comma seperated values to email addresses
            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
            addresses in an array of InternetAddress objects*/
            InternetAddress[] address = InternetAddress.parse(email.getTo(), true);
            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
            msg.setSubject(email.getSubject() + timeStamp);
            msg.setSentDate(new Date());
            msg.setText(email.getBody());
            msg.setHeader("XPriority", "1");
            Transport.send(msg);
            return "Success";
        } catch (MessagingException mex) {
            return "Failure";
        }
	}

}
