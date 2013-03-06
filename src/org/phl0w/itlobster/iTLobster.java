package org.phl0w.itlobster;

import bot.script.BotScript;
import bot.script.enums.Skill;
import bot.script.methods.Skills;
import bot.script.util.Random;
import org.phl0w.itlobster.event.Job;
import org.phl0w.itlobster.jobs.Fishing;
import org.phl0w.itlobster.utilities.Data;

public class iTLobster extends BotScript {

    private static final Job[] tasks = new Job[]{new Fishing()};

    @Override
    public int loop() {
        for (final Job j : tasks) {
            if (j.activate()) {
                j.execute();
            }
        }
        return Random.nextInt(200, 300);
    }

    @Override
    public boolean onStart() {
        Data.startTime = System.currentTimeMillis();
        Data.startXp = Skills.getXp(Skill.FISHING);
        Data.startLevel = Skills.getLevel(Skill.FISHING);
        return true;
    }
}
