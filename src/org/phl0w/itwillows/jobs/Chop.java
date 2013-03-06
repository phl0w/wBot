package org.phl0w.itwillows.jobs;

import bot.script.enums.Tab;
import bot.script.methods.*;
import bot.script.util.Random;
import bot.script.wrappers.GameObject;
import org.phl0w.itwillows.event.Job;
import org.phl0w.itwillows.utilities.Constants;

public class Chop extends Job {
    @Override
    public boolean activate() {
        return !Inventory.isFull() && Players.getLocal().getAnimation() == -1 && !Players.getLocal().isMoving();
    }

    @Override
    public void execute() {
        GameObject tree = Objects.getNearest(Constants.WILLOWS);
        if (Calculations.distanceBetween(tree.getLocation(), Players.getLocal().getLocation()) > 5 && Players.getLocal().getAnimation() == -1) {
            Walking.walkTo(tree.getLocation());
            Game.sleep(900, 1700);
        }
        if (tree != null) {
            if (tree.isVisible()) {
                tree.click();
                Game.sleep(1500, 2000);
                performAntiban();
            } else {
                Camera.turnToTile(tree.getLocation());
                Game.sleep(900, 1700);
                while (Players.getLocal().isMoving()) {
                    Game.sleep(500, 800);
                }
            }
        }
    }

    private void performAntiban() {
        int randomint = Random.nextInt(1, 10);
        switch (randomint) {
            case 1:
                Camera.setPitch(Random.nextInt(10, 200));
                break;
            case 2:
                Game.openTab(Tab.SKILLS);
                Game.sleep(800, 1000);
                Mouse.move(712 + Random.nextInt(0, 4), 377 + Random.nextInt(0, 4));
                Game.sleep(4000, 7000);
                Game.openTab(Tab.INVENTORY);
                Game.sleep(800, 1000);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
        }
    }
}
