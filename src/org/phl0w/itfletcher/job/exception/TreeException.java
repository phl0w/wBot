package org.phl0w.itfletcher.job.exception;

public class TreeException extends Exception {

    public TreeException() {
        super("Invalid Tree instantiation!");
    }

    public TreeException(final String exception) {
        super(exception);
    }

    public TreeException(final Throwable throwable) {
        super(throwable);
    }

    public TreeException(final String exception, final Throwable throwable) {
        super(exception, throwable);
    }
}
