
package com.liniyakamnya.ui.email;

import com.liniyakamnya.ui.entities.Actions;

/**
 * @author a.radkov
 *         Date: 20.07.12
 */
public final class EmailMessageGenerator {

    public static final String OCCURED = " occured";
    public static final String ACTION = "Action ";

    private EmailMessageGenerator() {
    }

    public static String generate(Actions action) {
        return ACTION + action.toString().toLowerCase() + OCCURED;
    }
}

