import javafx.scene.canvas.GraphicsContext;

/**
 * @author David Manouchehri
 *         Created on 9/24/15 at 1:40 AM.
 *         See LICENSE.txt for details.
 */

public class Net {
    private Coloring color = new Coloring();
    public Positioning position;

    private int width, height;

    public Net(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Positioning(x, y);
        color.setTransparency((byte) 10);
    }

    public void render(GraphicsContext painter) {
        painter.setFill(color.get());
        painter.fillRect(position.getX(),
                         position.getY(),
                         width,
                         height);
    }
}