package org.phl0w.itlobster.utilities;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {

    private static Logger log = null;

    public Logging(final String name) {
        if (log == null) {
            log = Logger.getLogger(name);
        }
    }

    public void log(final String entry, final Level l) {
        log.log(l, entry);
    }
}
