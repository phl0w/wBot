package org.phl0w.itlobster.utilities;

import bot.script.methods.Game;

public class Utilities {

    public static boolean waitFor(final Condition c, final long timeout) {
        final long startTime = System.currentTimeMillis();
        while (!c.validate() && (System.currentTimeMillis() - startTime) < timeout) {
            Game.sleep(200, 300);
        }
        return c.validate();
    }

    public static String formatTime(final long milliseconds) {
        final long t_seconds = milliseconds / 1000;
        final long t_minutes = t_seconds / 60;
        final long t_hours = t_minutes / 60;
        final long seconds = t_seconds % 60;
        final long minutes = t_minutes % 60;
        final long hours = t_hours % 500;
        return hours + ":" + minutes + ":" + seconds;
    }
}
