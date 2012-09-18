package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.email.EmailMessageGenerator;
import com.liniyakamnya.ui.email.EmailSender;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.User;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;

import java.util.List;

public class EmailThread implements Runnable {
    private final EntityDAO<User> entityDAO;
    private final Actions action;
    private static final Logger LOGGER = Logger.getLogger(EmailThread.class);

    public EmailThread(EntityDAO<User> entityDAO, Actions action) {
        this.entityDAO = entityDAO;
        this.action = action;
    }

    @Override
    public void run() {
        protocolAction();
    }

    private void protocolAction() {
        try {
            List<User> users = entityDAO.getAll();
            for (User user : users) {
                if (user.getActionsForEmail().isProtocol(action)) {
                    String message = EmailMessageGenerator.generate(action);
                    EmailSender.sendMail(user.getEmail(), message);
                }
            }
        } catch (EmailException e) {
            LOGGER.error(e.getMessage());
        } catch (NullPointerException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
