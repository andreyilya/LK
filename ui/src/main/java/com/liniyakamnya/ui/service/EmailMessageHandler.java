package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.email.EmailMessageGenerator;
import com.liniyakamnya.ui.email.EmailSender;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.utils.Parameters;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;

/**
 * @author a.radkov
 *         Date: 20.07.12
 */
@Service
@Transactional
public class EmailMessageHandler implements EmailService {
    @Autowired
    @Named(Parameters.USER_DAO)
    EntityDAO<User> userEntityDAO;

    @Override
    public void protocolAction(Actions action) {
        try {
            List<User> users = userEntityDAO.getAll();
            for (User user : users) {
                if (user.getActionsForEmail().isProtocol(action)) {
                    String message = EmailMessageGenerator.generate(action);
                    EmailSender.sendMail(user.getEmail(), message);
                }
            }
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
