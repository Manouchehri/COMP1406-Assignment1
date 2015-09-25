import javafx.scene.paint.Color;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 8:46 PM.
 *         See LICENSE.txt for details.
 */
public class Coloring {
    private Color color;
    private byte transparency = 100; /* By default, don't add any transparency. */

    public Coloring() {
        this.rand();
    }

    /*
    public Coloring(Color color) {
        this.color = color; // If the user picks a color, let them use it.
    }
    */

    public void rand() {
        color = new Color(Frontend.rand.nextDouble(), Frontend.rand.nextDouble(), Frontend.rand.nextDouble(), transparency / 100.0);
        /* Manually controlling the transparency seems like a better idea to avoid it being "invisible". */
    }

    public Color get() {
        return color;
    }

    /*
    public void set(Color color) {
        this.color = color; // Maybe changing the colors during the game would be interesting?
    }

    public byte getTransparency() {
        return transparency;
    }
    */

    public void setTransparency(byte transparency) {
        this.transparency = transparency;
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), transparency / 100.0);
        /* This makes it a lot faster to get a random color, and then manually set the transparency. */
    }
}