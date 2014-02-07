package com.ets.classes;

import java.net.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMail 
{
	/**
	 * runs only on private network, not on a proxy because org proxy firewall block such communication
	 * @param args
	 */
 
	public boolean sendingMail(String mail, String pass)
	{
		final String username = "queries.lcsolutions@gmail.com"; //replace with queries.lcsolutions@gmail.com
		final String password = "EduTrackSystem";  //enter the login password
 
		// setting the system properties like the smtp(Simple Mail Transfer protocol)
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");   //default port is 587
		
		 // Get the default Session object.
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			MimeMessage message = new MimeMessage(session);
			 // Sender's email ID needs to be mentioned
			message.setFrom(new InternetAddress("queries.lcsolutions@gmail.com"));
			// Recipient's email ID needs to be mentioned.
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(mail));  //pass the recipient emailid as a parameter
			message.setSubject("Forgot Password"); //write the subject as Forgot Password
			message.setText("Your new Password is: "+pass+" \n Please Login with this password."); // insert the new password sent as a parameter here
 
			Transport.send(message);  // this will send the password
			return true;
			//System.out.println("Done");  // to confirm if the message was sent
 
		} 
		catch (MessagingException e) 
		{
			throw new RuntimeException(e);
		}
		
	}
}