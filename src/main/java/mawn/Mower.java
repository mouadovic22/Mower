package mawn;

import lombok.Data;

import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class Mower implements IMower {

    private static final Logger LOGGER = Logger.getLogger(Mower.class.getName());
    private int x;
    private int y;
    private char orientation;
    private  Lawn lawn;

    public Mower(int x, int y, char orientation, Lawn lawn) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.lawn = lawn;
    }

    public void move(char direction) {
        if (direction == 'A') {
            switch (this.orientation) {
                case 'N':
                    if (lawn.isValidPosition(x, y + 1)) {
                        y += 1;
                    }
                    break;
                case 'E':
                    if (lawn.isValidPosition(x + 1, y)) {
                        x += 1;
                    }
                    break;
                case 'S':
                    if (lawn.isValidPosition(x, y - 1)) {
                        y -= 1;
                    }
                    break;
                case 'W':
                    if (lawn.isValidPosition(x - 1, y)) {
                        x -= 1;
                    }
                    break;
            }
            LOGGER.log(Level.INFO, "Moved to position ({0}, {1})", new Object[]{x, y});
        } else if (direction == 'D' || direction == 'G') {
            switch (this.orientation) {
                case 'N':
                    this.orientation = direction == 'D' ? 'E' : 'W';
                    break;
                case 'E':
                    this.orientation = direction == 'D' ? 'S' : 'N';
                    break;
                case 'S':
                    this.orientation = direction == 'D' ? 'W' : 'E';
                    break;
                case 'W':
                    this.orientation = direction == 'D' ? 'N' : 'S';
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }
}
