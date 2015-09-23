import javafx.scene.paint.Color;
import java.util.Random;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 3:55 PM.
 *         See LICENSE.txt for details.
 */
public class Ball {
    private int x, y;
    private int size;
    private double speed;

    public ColorHex color = new ColorHex();

    private static int spaceX = 250;
    private static int spaceY = 350;
    private static final Random random = new Random();

    public Ball() {
        this(random.nextInt(spaceX), random.nextInt(spaceY));

    }
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
