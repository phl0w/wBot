package org.phl0w.itlobster.jobs;

import bot.script.methods.Camera;
import bot.script.methods.Npcs;
import bot.script.methods.Players;
import bot.script.methods.Walking;
import bot.script.wrappers.NPC;
import org.phl0w.itlobster.event.Job;
import org.phl0w.itlobster.utilities.Condition;
import org.phl0w.itlobster.utilities.Utilities;

public class Fishing extends Job {

    private NPC fish = Npcs.getNearest(321);

    @Override
    public boolean activate() {
        if (fish == null) {
            fish = Npcs.getNearest(321);
        }
        return fish != null;
    }

    @Override
    public void execute() {
        if (fish.distance() > 10.0) {
            Walking.walkTo(fish.getLocation());
            if (Utilities.waitFor(new Condition() {
                @Override
                public boolean validate() {
                    return Players.getLocal().isMoving();
                }
            }, 5000)) {
                Utilities.waitFor(new Condition() {
                    @Override
                    public boolean validate() {
                        return (fish.distance() < 10);
                    }
                }, 5000);
            }
        } else {
            if (fish.isVisible()) {
                if (Players.getLocal().getAnimation() == -1) {
                    if (fish.interact("Cage")) {
                        Utilities.waitFor(new Condition() {
                            @Override
                            public boolean validate() {
                                return Players.getLocal().getAnimation() != -1;
                            }
                        }, 5000);
                    }
                } else {
                    System.out.println(Players.getLocal().getAnimation());
                }
            } else {
                Camera.turnToTile(fish.getLocation());
            }
        }
    }
}
