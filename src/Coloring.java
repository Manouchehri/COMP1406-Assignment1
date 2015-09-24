import javafx.scene.paint.Color;

import java.util.Random;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 8:46 PM.
 *         See LICENSE.txt for details.
 */
public class Coloring {
    private Color color;
    private byte transparency = 100;

    public Coloring() {
        this.rand();
    }
    public Coloring(Color color) {
        this.color = color;
    }

    public Color get() {
        return color;
    }

    public void set(Color color) {
        this.color = color;
    }

    public void rand() {
        Random rand = new Random();
        this.color = new Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), transparency / 100);
    }

    public byte getTransparency() {
        return this.transparency;
    }

    public void setTransparency(byte transparency) {
        this.transparency = transparency;
        this.color = new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue(), this.transparency / 100);
    }
}