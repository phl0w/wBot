package org.phl0w.itfletcher.node;

import bot.script.methods.Game;
import bot.script.methods.Inventory;
import bot.script.methods.Keyboard;
import bot.script.methods.Widgets;
import bot.script.util.Random;
import bot.script.wrappers.Component;
import org.phl0w.itfletcher.iTFletcher;
import org.phl0w.itfletcher.job.state.Node;

public class ClickWidget extends Node {

    private Component c = null;
    private Component c2 = null;

    @Override
    public boolean activate() {
        return (c == null ? (c = Widgets.getComponent(304, iTFletcher.SHORT ? 8 : 12)) : c) != null || (c2 == null ?
                (c2 == Widgets.getComponent(548, 83)) : c2) != null;
    }

    @Override
    public void execute() {
        if (c != null) {
            if (c.interact("Make X")) {
                Game.sleep(600, 900);
            }
        } else if (c2 != null) {
            Keyboard.typeText(Integer.toString(Random.nextInt(Inventory.getCount(iTFletcher.LOG, true), 99)), true);
            Game.sleep(1000, 1500);
        }
    }

    @Override
    public String toString() {
        return "[Node] ClickWidget";
    }
}
