package com.liniyakamnya.engine.email;

import org.apache.commons.mail.EmailException;

/**
 * @author a.radkov
 *         Date: 20.07.12
 */
public final class EmailMessageHandler {
    private EmailMessageHandler() {
    }

    public static void protocolAction(String action) throws EmailException {
        //TODO: cycle for all users

        if (action != null) {
            String message = EmailMessageGenerator.generate(action);
            EmailSender.sendMail("liniyakamnya@gmail.com", message);
        }
    }
}
