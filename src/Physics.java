/**
 * @author David Manouchehri
 *         Created on 9/24/15 at 12:51 AM.
 *         See LICENSE.txt for details.
 */

public class Physics {
    public enum Direction {LEFT, RIGHT, UP, DOWN}
    private Direction stateX;
    private Direction stateY;
    private static final int speed = 3;

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

    private Positioning move(int x, int y, Positioning position) {
        position.setX(position.getX() + x * speed);
        position.setY(position.getY() + y * speed);
        return position;
    }

    public Paddle move(Paddle paddle, Direction direction) {
        if(direction == Direction.LEFT && paddle.position.getX() > 0)
            move(-1, 0, paddle.position);
        else if(direction == Direction.RIGHT && paddle.position.getX() + paddle.getWidth() < Frontend.field.getX())
            move(1, 0, paddle.position);
        else if(direction == Direction.UP && paddle.position.getY() > 0)
            move(0, -1, paddle.position);
        else if(direction == Direction.DOWN && paddle.position.getY() + paddle.getHeight() < Frontend.field.getY())
            move(0, 1, paddle.position);
        return paddle;
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
