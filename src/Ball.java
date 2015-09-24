import javafx.scene.canvas.GraphicsContext;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 3:55 PM.
 *         See LICENSE.txt for details.
 */
public class Ball {
    private int radius;

    public ColorHex color = new ColorHex();
    public Positioning position;

    public Ball(int radius, int x, int y) {
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
}
