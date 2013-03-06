import bot.script.BotScript;
import bot.script.enums.Tab;
import bot.script.methods.*;
import bot.script.util.Random;
import bot.script.wrappers.GameObject;
import bot.script.wrappers.Tile;

public class PAutoChopper extends BotScript {

    public int[] willowTree = {5552, 5551, 1308, 5553};
    public int badWillow = 777;
    public int bankBooth = 2213;
    Tile bankPos = new Tile(3092, 3245);
    Tile chopPos = new Tile(3087, 3237);

    @Override
    public boolean onStart() {
        return true;
    }

    public int loop() {
        if (!Inventory.isFull() && !chopPos.isVisible()) {
            performWalktoTree();
        }
        if (Inventory.isFull() && bankPos.isVisible()) {
            performBank();
        }
        return 1;

    }

    private boolean performWalktoTree() {
        Walking.walkTo(chopPos);
        sleep(3000, 5000);
        return !Inventory.isFull();

    }

    private boolean performBank() {
        Camera.setAngle(494);
        GameObject booth = Objects.getNearest(bankBooth);
        if (booth.isVisible()) {
            booth.interact("Use-quickly");
            sleep(800, 1000);
            if (Bank.isOpen()) {
                Bank.deposit(1520, 28);
                sleep(800, 1000);
            }
        }
        return true;

    }
}