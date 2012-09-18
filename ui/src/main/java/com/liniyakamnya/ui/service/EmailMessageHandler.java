package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.utils.Parameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author a.radkov
 *         Date: 20.07.12
 */
@Service
@Transactional
public class EmailMessageHandler implements EmailService {
    @Inject
    @Named(Parameters.USER_DAO)
    private EntityDAO<User> userEntityDAO;

    @Override
    public void protocolAction(Actions action) {
        EmailThread emailThread = new EmailThread(userEntityDAO, action);
        Thread thread = new Thread(emailThread);
        thread.start();
    }
}
