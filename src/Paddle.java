import javafx.scene.canvas.GraphicsContext;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 3:59 PM.
 *         See LICENSE.txt for details.
 */
public class Paddle {
    private Coloring color = new Coloring();
    public Positioning position;

    private int width, height;

    public Paddle(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Positioning(x, y);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void render(GraphicsContext painter) {
        painter.setFill(color.get());
        painter.fillRect(position.getX(),
                         position.getY(),
                         this.width,
                         this.height);
    }
}
