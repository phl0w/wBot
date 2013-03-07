package org.phl0w.updater.version;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Website {

    public static double getVersion() {
        try {
            final InputStream in = getConnection().getInputStream();
            final BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = br.readLine()) != null) {
                double x = Double.parseDouble(line);
                if (x > 3) {
                    return x;
                }
            }
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        }
        return -1;
    }

    private static URLConnection getConnection() {
        URLConnection c = null;
        try {
            final URL website = new URL("http://wbot.nl/version.txt");
            c = website.openConnection();
            return c;
        } catch (final Exception mfe) {
            mfe.printStackTrace();
        }
        return null;
    }

}
