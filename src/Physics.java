/**
 * @author David Manouchehri
 *         Created on 9/24/15 at 12:51 AM.
 *         See LICENSE.txt for details.
 */

public class Physics {

    public Field field = new Field(750, 250);
    private enum Direction {LEFT, RIGHT, UP, DOWN}
    private Direction stateX;
    private Direction stateY;

    /* This is horrible code. I don't want to write my own physics engine. */
    public boolean collision(Ball ball, Paddle paddle) {
        // if(getBottom(ball) > getTop(ball))
            return true;
        // return false;
    }

    public Direction collision(Ball ball, Field field) {
        return Direction.DOWN;
    }

    public boolean collision(Ball ball, Net net) {

        return false;
    }

    public void advance(Ball ball) {
        if(stateX == Direction.LEFT)
            ball.position.setX(ball.position.getX() - 1);
        else if(stateX == Direction.RIGHT)
            ball.position.setX(ball.position.getX() + 1);
        if(stateY == Direction.UP)
            ball.position.setY(ball.position.getY() - 1);
        else if(stateY == Direction.DOWN)
            ball.position.setY(ball.position.getY() + 1);
    }
}
