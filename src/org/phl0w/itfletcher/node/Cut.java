package org.phl0w.itfletcher.node;

import bot.script.methods.*;
import bot.script.util.Random;
import org.phl0w.itfletcher.iTFletcher;
import org.phl0w.itfletcher.job.state.Node;

public class Cut extends Node {

    @Override
    public boolean activate() {
        return Inventory.contains(947) && Inventory.contains(iTFletcher.LOG) && !Bank.isOpen() &&
                Players.getLocal().getAnimation() == -1 && Widgets.getComponent(304, 12) == null;
    }

    @Override
    public void execute() {
        final boolean r = Random.nextInt(0, 2) == 1;
        if (r) {
            if (Inventory.getItem(iTFletcher.LOG).interact("Use")) {
                Game.sleep(500, 600);
                if (Inventory.getItem(947).interact("Use")) {
                    Game.sleep(600, 800);
                }
            }
        } else {
            if (Inventory.getItem(947).interact("Use")) {
                Game.sleep(500, 600);
                if (Inventory.getItem(iTFletcher.LOG).interact("Use")) {
                    Game.sleep(600, 800);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "[Node] Cut";
    }

}
