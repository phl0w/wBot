package org.phl0w.itwillows.jobs;

import bot.script.methods.Game;
import bot.script.methods.Inventory;
import bot.script.methods.Walking;
import org.phl0w.itwillows.event.Job;
import org.phl0w.itwillows.utilities.Constants;

public class WalkTree extends Job {
    @Override
    public boolean activate() {
        return !Inventory.isFull() && !Constants.CHOP_TILE.isVisible();
    }

    @Override
    public void execute() {
        Walking.walkTo(Constants.CHOP_TILE);
        Game.sleep(3000, 5000);
    }
}
