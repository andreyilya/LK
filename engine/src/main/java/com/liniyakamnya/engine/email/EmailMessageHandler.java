package com.liniyakamnya.engine.email;

import com.liniyakamnya.engine.dao.UserEntityDAO;
import com.liniyakamnya.engine.entities.Actions;
import com.liniyakamnya.engine.entities.User;
import org.apache.commons.mail.EmailException;

import java.util.List;

/**
 * @author a.radkov
 *         Date: 20.07.12
 */
public final class EmailMessageHandler {
    private EmailMessageHandler() {
    }

    public static void protocolAction(Actions action) throws EmailException {
        UserEntityDAO userEntityDAO = new UserEntityDAO();
        List<User> users = userEntityDAO.getAll();
        for (User user : users) {
            if (user.getActionsForEmail().isProtocol(action)) {
                String message = EmailMessageGenerator.generate(action);
                EmailSender.sendMail(user.getEmail(), message);
            }
        }
    }
}
