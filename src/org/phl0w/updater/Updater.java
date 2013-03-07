package org.phl0w.updater;

import org.phl0w.updater.update.Download;
import org.phl0w.updater.version.Jar;
import org.phl0w.updater.version.Website;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Updater {

    private static double web = 0.0, jar = 0.0;
    private static File directory = null;
    private static String path = "", name = "";

    public static void main(final String... args) {
        web = Website.getVersion();
        if (args.length == 1) {
            directory = new File(args[0]);
            if (directory.exists()) {
                System.out.printf("-> Directory found: %s\n", directory.getAbsolutePath());
                for (final File f : directory.listFiles()) {
                    if (f.getName().endsWith(".jar") && !f.getName().contains("asm") && !f.getName().contains("update")) {
                        name = f.getName();
                        path = f.getAbsolutePath();
                        System.out.printf("-> JarFile found: %s\n", f.getAbsolutePath());
                        jar = Jar.getVersion(path);
                        f.delete();
                        break;
                    }
                }
            } else {
                System.out.println("-> Directory does not exist.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please run via the .bat!");
        }
        if (jar > 0.0 && web > 0.0) {
            System.out.printf("-> Website version: %1$.2f\n", web);
            System.out.printf("-> Jar version: %1$.2f\n", jar);

            if (jar == web) {
                System.out.println("--> You currently have the latest wBot!");
            } else {
                if (jar != web) {
                    System.out.println("--> You currently have an outdated version of wBot!");
                    if (Download.download(new File(directory.getPath() + "/" + name), Constants.JAR_DOWNLOAD)) {
                        System.out.println("--> Successfully downloaded the last wBot jar. You are now fully up to date.");
                    }
                }
            }
        } else {
            System.out.println("--> No jar detected! Downloading...");
            if (Download.download(new File(directory.getPath() + "/wbot.jar"), Constants.JAR_DOWNLOAD)) {
                path = directory.getPath() + "/wbot.jar";
                System.out.println("--> Successfully downloaded the last wBot jar. You are now fully up to date.");
            }
        }
        System.out.println("Starting bot...");
        try {
            Runtime.getRuntime().exec("java -jar " + path);
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
