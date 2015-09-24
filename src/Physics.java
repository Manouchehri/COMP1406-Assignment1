/**
 * @author David Manouchehri
 *         Created on 9/24/15 at 12:51 AM.
 *         See LICENSE.txt for details.
 */

public class Physics extends Positioning {

    public Field field = new Field(750, 250);
    enum Direction {LEFT, RIGHT, UP, DOWN}

    /* This is horrible code. I don't want to write my own physics engine. */
    public boolean collision(Ball ball, Paddle paddle) {
        if(getBottom(ball) > getTop(ball))
            return true;
        return false;

    }

    public Direction collision(Ball ball, Field field) {
        return Direction.DOWN;
    }

    //public byte

    public boolean collision(Ball ball, Net net) {

        return false;
    }
}
