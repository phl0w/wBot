package org.phl0w.updater.update;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Download {

    public static boolean download(final File output, final String source) {
        try {
            output.createNewFile();
            final ReadableByteChannel rbc = Channels.newChannel(new URL(source).openStream());
            final FileOutputStream fos = new FileOutputStream(output);
            fos.getChannel().transferFrom(rbc, 0, 1 << 24);
            fos.close();
            return true;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
