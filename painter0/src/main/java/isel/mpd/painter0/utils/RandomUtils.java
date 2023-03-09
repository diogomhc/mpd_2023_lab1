package isel.mpd.painter0.utils;

import java.awt.*;
import java.util.Random;

public class RandomUtils {
    public static Random random = new Random();

    /**
     * returns a random integer using random variable above, between
     * li (inclusive) and ls (exclusive)
     * @param li
     * @param ls
     * @return
     */
    public static int getRandomInt(int li, int ls) {
        return random.nextInt(li, ls);
    }

    /**
     * returns a random Point with coordinates between 0 (inclusive) and sizeX and sizeY (exclusive)
     * for x and y coordinates
     * @param sizeX
     * @param sizeY
     * @return
     */
    public static Point getRandomPoint(int sizeX, int sizeY) {
        int x = random.nextInt(0, sizeX);
        int y = random.nextInt(0, sizeY);

        return new Point(x, y);
    }
}
