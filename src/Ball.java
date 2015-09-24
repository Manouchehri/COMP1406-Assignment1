import javafx.scene.canvas.GraphicsContext;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 3:55 PM.
 *         See LICENSE.txt for details.
 */
public class Ball {
    private int radius;

    private Coloring color = new Coloring();
    public Positioning position;

    public Ball(int x, int y, int radius) {
        position = new Positioning(x, y);
//        this.position.setX(x);
//        this.position.setY(y);
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getTop() {
        return this.position.getY() - this.radius;
    }

    public int getBottom() {
        return this.position.getY() + this.radius;
    }

    public int getLeft() {
        return this.position.getX() - this.radius;
    }

    public int getRight() {
        return this.position.getX() + this.radius;
    }

    public void render(GraphicsContext painter) {
        painter.setFill(color.get());
        painter.fillOval(position.getX() - this.getRadius(), /* Draw from the */
                         position.getY() - this.getRadius(), /* top left.     */
                         this.getRadius() * 2,  /* Draw with */
                         this.getRadius() * 2); /* diameter. */
    }

    /* Start of physics code! */

    public enum Direction {LEFT, RIGHT, UP, DOWN} /* Duplicate, remove? */
    private Direction stateX = Direction.RIGHT; /* Default movements. Random instead maybe? */
    private Direction stateY = Direction.DOWN;
    private int speed = 3;

    public void move() {
        if(stateX == Direction.LEFT)
            this.position.setX(this.position.getX() - speed);
        else if(stateX == Direction.RIGHT)
            this.position.setX(this.position.getX() + speed);
        if(stateY == Direction.UP)
            this.position.setY(this.position.getY() - speed);
        else if(stateY == Direction.DOWN)
            this.position.setY(this.position.getY() + speed);
    }

    public boolean bounce() {
        //if(getBottom() > )


        if(getRight() > Frontend.field.getX()) {
            stateX = Direction.LEFT;
            return false;
        }
        else if(getLeft() < 0) {
            stateX = Direction.RIGHT;
            return false;
        }

        if(getBottom() > Frontend.field.getY()) {
            stateY = Direction.UP;
            return false;
        }
        else if(getTop() < 0) {
            stateY = Direction.DOWN;
            return false;
        }

        return false;
    }

    /* End of physics code. */
}
