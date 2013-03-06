package org.phl0w.itwillows;

import bot.script.BotScript;
import bot.script.enums.Skill;
import bot.script.methods.Skills;
import bot.script.util.Random;
import org.phl0w.itlobster.utilities.Data;
import org.phl0w.itwillows.event.Job;
import org.phl0w.itwillows.jobs.Banking;
import org.phl0w.itwillows.jobs.Chop;
import org.phl0w.itwillows.jobs.WalkBank;
import org.phl0w.itwillows.jobs.WalkTree;

public class iTWillows extends BotScript {

    private static final Job[] nodes = new Job[]{new Banking(), new Chop(), new WalkBank(), new WalkTree()};

    @Override
    public int loop() {
        for (final Job j : nodes) {
            if (j.activate()) {
                j.execute();
            }
        }
        return Random.nextInt(200, 300);
    }

    @Override
    public boolean onStart() {
        Data.startTime = System.currentTimeMillis();
        Data.startXp = Skills.getXp(Skill.WOODCUTTING);
        Data.startLevel = Skills.getLevel(Skill.WOODCUTTING);
        return true;
    }

}
