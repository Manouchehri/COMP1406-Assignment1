/**
 * @author David Manouchehri
 *         Created on 9/24/15 at 12:51 AM.
 *         See LICENSE.txt for details.
 */

public class Controller {
    public enum Direction {LEFT, RIGHT, UP, DOWN}
    private Direction stateX;
    private Direction stateY;
    private static final int speed = 10;

    private Positioning move(int x, int y, Positioning position) {
        position.setX(position.getX() + x * speed);
        position.setY(position.getY() + y * speed);
        return position;
    }

    public Paddle move(Paddle paddle, Direction direction) {
        if(direction == Direction.LEFT && paddle.position.getX() - speed > 0)
            move(-1, 0, paddle.position);
        else if(direction == Direction.RIGHT && paddle.position.getX() + paddle.getWidth() + speed < Frontend.field.getX())
            move(1, 0, paddle.position);
        else if(direction == Direction.UP && paddle.position.getY() - speed > 0)
            move(0, -1, paddle.position);
        else if(direction == Direction.DOWN && paddle.position.getY() + paddle.getHeight() + speed < Frontend.field.getY())
            move(0, 1, paddle.position);
        return paddle;
    }
}
