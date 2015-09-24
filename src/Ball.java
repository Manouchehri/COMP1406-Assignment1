import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 3:55 PM.
 *         See LICENSE.txt for details.
 */
public class Ball {
    private int radius;

    private Coloring color = new Coloring();
    public Positioning position;

    public Ball(int radius) {
        Random rand = new Random();
        position = new Positioning(rand.nextInt(Frontend.field.getX()) / 2,
                                   rand.nextInt(Frontend.field.getY()) / 2); /* This should always make the ball reachable. */
        this.radius = radius;
    }

    public Ball(int x, int y, int radius) {
        position = new Positioning(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public int getTop() {
        return position.getY() - radius;
    }

    public int getBottom() {
        return position.getY() + radius;
    }

    public int getLeft() {
        return position.getX() - radius;
    }

    public int getRight() {
        return position.getX() + radius;
    }

    public void render(GraphicsContext painter) {
        painter.setFill(color.get());
        painter.fillOval(position.getX() - getRadius(), /* Draw from the */
                         position.getY() - getRadius(), /* top left.     */
                         getRadius() * 2,  /* Draw with */
                         getRadius() * 2); /* diameter. */
    }

    /* Start of physics code! */

    public enum Direction {LEFT, RIGHT, UP, DOWN} /* Duplicate, remove? */
    private Direction stateX = Direction.RIGHT; /* Default movements. Random instead maybe? */
    private Direction stateY = Direction.DOWN;
    private int speed = 3;

    public void move() {
        if(stateX == Direction.LEFT)
            position.setX(position.getX() - speed);
        else if(stateX == Direction.RIGHT)
            position.setX(position.getX() + speed);
        if(stateY == Direction.UP)
            position.setY(position.getY() - speed);
        else if(stateY == Direction.DOWN)
            position.setY(position.getY() + speed);
    }

    public boolean bounce(Net net, Paddle paddle) {
        if(getBottom() > net.position.getY())
            return true;
        else {
            if(getRight() > Frontend.field.getX()) {
                stateX = Direction.LEFT;
            }
            else if(getLeft() < 0) {
                stateX = Direction.RIGHT;
            }

            if(getBottom() > Frontend.field.getY()) {
                stateY = Direction.UP;
            }
            else if(getTop() < 0) {
                stateY = Direction.DOWN;
            }
            else if(getBottom() >= paddle.position.getY() /* If the ball has touched the paddle. */
                    && (position.getX() > paddle.position.getX()                     /* Make sure the ball is within */
                    && position.getX() < paddle.position.getX() + paddle.getWidth()) /* the width of the paddle.     */
                    && !(getBottom() > paddle.position.getY() + getRadius())) /* If the player tries to "catch" the ball at the last second, */
                stateY = Direction.UP;                                             /* it's only considered valid if less than half the ball has passed. */
        }
        return false;
    }

    /* End of physics code. */
}
