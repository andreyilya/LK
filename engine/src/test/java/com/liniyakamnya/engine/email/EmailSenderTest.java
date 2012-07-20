package com.liniyakamnya.engine.email;

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
        EmailSender.sendMail("liniyakamnya@gmail.com", "<h1 style=\"font-size:25px;\"><b>Test<b></h1>");
    }
}
