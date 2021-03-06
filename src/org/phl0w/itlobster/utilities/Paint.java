package org.phl0w.itlobster.utilities;

import bot.script.enums.Skill;
import bot.script.methods.Skills;

import java.awt.*;
import java.util.ArrayList;

public class Paint {

    public static void paint(final Graphics2D g) {
        drawString(g);
    }

    private static void drawString(Graphics2D g) {
        int Y = 20;
        int X = 10;
        final int level = Skills.getLevel(Skill.FISHING);
        final int xpGained = Skills.getXp(Skill.FISHING) - Data.startXp;
        final int fished = xpGained / 90;
        ArrayList<String> string = new ArrayList<String>();
        string.add("nLobster v1.00");
        string.add("Fishing level: " + level + "(+" + (level - Data.startLevel) + ")");
        string.add("XP gained: " + xpGained);
        string.add("Fished: " + fished);
        string.add("Time run: " + Utilities.formatTime((System.currentTimeMillis() - Data.startTime)));

        for (String s : string) {
            Y += g.getFontMetrics().getHeight();
            g.setColor(Color.black);
            g.drawString(s, X + 1, Y + 1);
            g.setColor(Color.WHITE);
            g.drawString(s, X, Y);
        }
        g.setColor(Color.red);
    }

}
