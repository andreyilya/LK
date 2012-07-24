package com.liniyakamnya.engine.email;

import com.liniyakamnya.engine.entities.Actions;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 19.07.12
 * Time: 20:18
 */
public class EmailSenderTest {
    @Test
    public void testSendMail() throws Exception {
        EmailMessageHandler.protocolAction(Actions.CREATE_NOTE);
    }
}
