package com.lcapp.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public boolean sendEmail(String subject, String message, String to) {

		boolean f = false;

		String from = "rawat2118@gmail.com";
//Hostname for gmail
		String host = "smtp.gmail.com";
//Get System Properties
		Properties properties = System.getProperties();
		System.out.println("Properties=" + properties);

//setting imp info to properties object

		properties.put("mail.smtp.ssl.enable", true);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		String username = "rawat2118";
		String password = "omqbkleanvaaolxc";

//Step 1 to get Session object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}

		});
// Step 2- Compose message
		MimeMessage m = new MimeMessage(session);
		try {

			m.setFrom(new InternetAddress(from));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText(message);
			m.setContent(message, "text/html");
			// Step 3:Send message using Transport class
			Transport.send(m);
			System.out.println("Sent....");
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}
}
