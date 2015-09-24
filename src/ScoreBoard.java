import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Text;

/**
 * @author David Manouchehri
 *         Created on 9/24/15 at 3:35 PM.
 *         See LICENSE.txt for details.
 */
public class ScoreBoard {
    Text scoreUI;
    private Coloring color = new Coloring();
    private Positioning position = new Positioning(25, 25);

    public void render(GraphicsContext painter, String text) {
        this.scoreUI = new Text(text);
        painter.setFill(this.color.get());
        painter.fillText(text, this.position.getX(), this.position.getY());
    }
}
