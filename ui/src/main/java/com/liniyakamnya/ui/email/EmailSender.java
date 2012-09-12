package com.liniyakamnya.ui.email;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


/**
 * User: a.radkov
 */
public final class EmailSender {

    private static final String SMTP_MAIL_RU = "smtp.mail.ru";
    public static final String LINIYAKAMNYA_MAIL_RU = "liniyakamnya@mail.ru";
    public static final String PASSWORD = "liniyakamnya123";
    public static final String SUBJECT = "Protocoled action on liniyakamnya administration service occured";

    private EmailSender() {
    }

    public static void sendMail(String to, String message) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(SMTP_MAIL_RU);
        email.addTo(to);
        email.setFrom(LINIYAKAMNYA_MAIL_RU);
        email.setAuthentication(LINIYAKAMNYA_MAIL_RU, PASSWORD);
        email.setSubject(SUBJECT);
        email.setMsg(message);
        email.send();
    }
}
