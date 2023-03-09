package painter.app;

import isel.mpd.painter0.utils.RandomUtils;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomUtilsTest {
    @Test
    public void resultWithinLegalBound() {
        int x = RandomUtils.getRandomInt(0, 10);
        assertTrue((x >= 0 && x < 10));
        x = RandomUtils.getRandomInt(10, 20);
        assertTrue((x >= 10 && x < 20));

        Point point = RandomUtils.getRandomPoint(10, 10);
        assertTrue((point.getX() >= 0 && point.getX() < 10 && point.getY() >= 0 && point.getY() < 10));
    }
}
