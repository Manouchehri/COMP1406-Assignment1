import java.util.Random;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 9:05 PM.
 *         See LICENSE.txt for details.
 */

/*
* All positioning is calculated as the center of the object for circles, and the top left corner for rectangles.
*
* Basically, top is referring to x = 0, and left is x = 0.
* */

public class Positioning {
    private int cord[] = new int[2];

    /*
    private static final Random random = new Random();

    public Positioning(Field field) {
        this(random.nextInt(field.getX()), random.nextInt(field.getY()));
        *//* This is basically the "random" placement. Probably will never be used. *//*
    }
    */

    public Positioning(int x, int y) {
        cord[0] = x;
        cord[1] = y;
    }

    /*
    public Positioning(int cord[]) {
        this.cord = cord;
    }

    public int[] getCord() {
        return cord;
    }
    */

    public int getX() {
        return cord[0];
    }

    public int getY() {
        return cord[1];
    }

    public void setX(int x) {
        cord[0] = x;
    }

    public void setY(int y) {
        cord[1] = y;
    }
}