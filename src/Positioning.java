import java.util.Random;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 9:05 PM.
 *         See LICENSE.txt for details.
 */
public class Positioning {
    private int cord[] = new int[2];
    private static final int space[] = {250, 350}; /* This is for the canvas size. */
    private static final Random random = new Random();

    public Positioning() {
        this(random.nextInt(space[0]), random.nextInt(space[1]));
    }

    public Positioning(int x, int y) {
        this.cord[0] = x;
        this.cord[1] = y;
    }

    public Positioning(int cord[]) {
        this.cord = cord;
    }

    public int[] getCord() {
        return cord;
    }

    public int getX() {
        return this.cord[0];
    }

    public int getY() {
        return this.cord[1];
    }

    public void setX(int x) {
        this.cord[0] = x;
    }

    public void setY(int y) {
        this.cord[1] = y;
    }
}