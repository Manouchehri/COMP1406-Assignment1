/**
 * @author David Manouchehri
 *         Created on 9/24/15 at 1:08 AM.
 *         See LICENSE.txt for details.
 */
public class Field {
    private static final int space[] = new int[2];
    /* The field is the playable area. */

    public Field(int x, int y) {
        space[0] = x;
        space[1] = y;
        /* Apparently Java doesn't want to let me set both at once. */
    }

    public int getX() {
        return space[0];
    }

    public int getY() {
        return space[1];
    }

    public int[] get() {
        return space;
    }
}
