package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.entities.Actions;
import org.apache.commons.mail.EmailException;

/**
 * @author a.radkov
 *         Date: 12.09.12
 */
public interface EmailService {
    public void protocolAction(Actions action);
}
