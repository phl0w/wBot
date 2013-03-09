package org.phl0w.itfletcher.job.exception;

public class ChangeException extends Exception {

    public ChangeException() {
        super("Tree change invalid!");
    }

    public ChangeException(final String exception) {
        super(exception);
    }

    public ChangeException(final Throwable throwable) {
        super(throwable);
    }

    public ChangeException(final String exception, final Throwable throwable) {
        super(exception, throwable);
    }
}
