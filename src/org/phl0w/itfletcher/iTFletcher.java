package org.phl0w.itfletcher;

import bot.script.BotScript;
import bot.script.util.Random;
import org.phl0w.itfletcher.job.Tree;
import org.phl0w.itfletcher.node.ClickWidget;
import org.phl0w.itfletcher.node.Cut;

public class iTFletcher extends BotScript {

    private static Tree tree = null;
    public static final int LOG = 1522;
    public static final boolean SHORT = true;

    @Override
    public boolean onStart() {
        return true;
    }

    @Override
    public int loop() {
        if (tree == null) {
            tree = new Tree(new Cut(), new ClickWidget());
        }
        tree.run();
        return Random.nextInt(400, 600);
    }
}
