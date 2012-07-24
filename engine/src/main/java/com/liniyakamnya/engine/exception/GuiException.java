package com.liniyakamnya.engine.exception;

/**
 * User: Asus
 * Date: 24.07.12
 * Time: 20:12
 */
public class GuiException extends Exception {
    private String msg;

    public GuiException(String msg) {
        this.msg = msg;
    }

    public GuiException(String message, String msg) {
        super(message);
        this.msg = msg;
    }

    public GuiException(String message, Throwable cause, String msg) {
        super(message, cause);
        this.msg = msg;
    }

    public GuiException(Throwable cause, String msg) {
        super(cause);
        this.msg = msg;
    }
}
