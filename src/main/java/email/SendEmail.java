package email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import utilities.ConfigReader;

public class SendEmail {
	private final static String emailFrom;
	private final static String username;
	private final static String password;
	private static Properties properties;
	
	private static Session session;

	static {
		emailFrom = ConfigReader.getProperty("email");
		username = ConfigReader.getProperty("username");
		password = "mllmztlxyimdazae";
		properties = new Properties();
		
	}

	public static void sendEmailTo(
			String to,
			String subject,
			String body) {
		
		setupEmailServer();
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailFrom));
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);
System.out.println("Sending email...");
			Transport.send(message);
System.out.println("Email sent to " + to);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	private static void setupEmailServer() {
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
System.out.println("Email setup complete.");
	}
}
