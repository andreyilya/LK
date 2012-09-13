package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.email.EmailMessageGenerator;
import com.liniyakamnya.ui.email.EmailSender;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.User;
import org.apache.commons.mail.EmailException;

import java.util.List;

public class EmailThread implements Runnable {
    private final EntityDAO<User> entityDAO;
    private final Actions action;

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
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
