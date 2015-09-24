/**
 * @author David Manouchehri
 *         Created on 9/24/15 at 1:08 AM.
 *         See LICENSE.txt for details.
 */
public class Field {
    private static final int space[] = {250, 350}; /* This is for the canvas size. */

    public Field() {

    }
    public Field(int x, int y) {
        this.space[0] = x;
        this.space[1] = y;
        /* Apparently Java doesn't want to let me set both at once. */
    }

    public int getX() {
        return this.space[0];
    }

    public int getY() {
        return this.space[1];
    }

    public int[] get() {
        return this.space;
    }
}
