package org.phl0w.itwillows.jobs;

import bot.script.methods.*;
import bot.script.util.Random;
import bot.script.wrappers.GameObject;
import org.phl0w.itwillows.event.Job;
import org.phl0w.itwillows.utilities.Constants;

public class Banking extends Job {
    @Override
    public boolean activate() {
        return Inventory.isFull() && Constants.BANK_TILE.isVisible();
    }

    @Override
    public void execute() {
        Camera.setAngle(Random.nextInt(490, 498));
        GameObject booth = Objects.getNearest(Constants.BANK_BOOTH);
        if (booth.isVisible()) {
            booth.interact("Use-quickly");
            Game.sleep(800, 1000);
            if (Bank.isOpen()) {
                Bank.deposit(1520, 28);
                Game.sleep(800, 1000);
            }
        }
    }
}
