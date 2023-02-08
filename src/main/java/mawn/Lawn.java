package mawn;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Lawn {
    private final int x;
    private final int y;
    private Logger logger = Logger.getLogger(Lawn.class.getName());

    public Lawn(int x, int y) {
        this.x = x;
        this.y = y;
        logger.log(Level.INFO, "Lawn created with size {0}x{1}", new Object[]{x, y});
    }
    public boolean isValidPosition(int x, int y) {
        if (x < 0 || x > this.x || y < 0 || y > this.y) {
            logger.log(Level.WARNING, "Invalid position: ({0}, {1})", new Object[]{x, y});
            return false;
        }
        return true;
    }
}
