package com.liniyakamnya.engine.email;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.mail.MessagingException;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 19.07.12
 * Time: 20:01
 */
public class EmailSender {
	public EmailSender() {
		super();
	}

	/**
	 * @param to        reciever of the message
	 */
	public void sendMail(String to) throws EmailException {

			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.mail.ru");
			email.addTo("liniyakamnya@gmail.com");
			email.setFrom("liniyakamnya@mail.ru");
			email.setAuthentication("liniyakamnya@mail.ru", "liniyakamnya123");
			email.setSubject("subject");
			String message = createMessage("messagePart");
			email.setMsg(message);
			email.send();

	}

	private String createMessage(String base) {
		StringBuilder message = new StringBuilder("");
		message.append(base);
		return message.toString();
	}

}
