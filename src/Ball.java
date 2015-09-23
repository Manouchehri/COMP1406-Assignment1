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

    private char color[] = {'1', '2', '3', '4', '5', '6'}; /* This is in hex. */

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

    public Color getColorJ() {
        String colorString = new String(color);
        System.out.println(colorString);
        return Color.web(colorString);
    }

    /* Use HTML colors. */
    public String getColor() {
        return new String(color);
    }

    public void setColor(String color) {
        System.arraycopy(color.trim().toCharArray(), 0, this.color, 0, 6);
        /* This allows some error tolerance when entering the colors. */
    }
}
