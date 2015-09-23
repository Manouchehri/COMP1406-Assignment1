import java.util.Random;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 8:46 PM.
 *         See LICENSE.txt for details.
 */
public class ColorHex {
    private char color[] = new char[6];
    private byte transparency = 100;

    public ColorHex() {
        this.rand();
    }

    public javafx.scene.paint.Color getJ() {
        String colorString = new String(color);
        javafx.scene.paint.Color web = javafx.scene.paint.Color.web(colorString);
        web = new javafx.scene.paint.Color(web.getRed(), web.getGreen(), web.getBlue(), transparency / 100.0);
        return web;
    }

    /* Use HTML colors. */
    public String get() {
        return new String(color);
    }

    public void set(String color) {
        System.arraycopy(color.trim().toCharArray(), 0, this.color, 0, 6);
        /* This allows some error tolerance when entering the colors. */
    }
    public void set(javafx.scene.paint.Color color) {
        System.arraycopy(String.valueOf(color.toString()).toCharArray(), 2, this.color, 0, 6);
        this.transparency = (byte)Math.round(color.getOpacity() * 100);
    }

    public void rand() {
        Random rand = new Random();
        javafx.scene.paint.Color color = new javafx.scene.paint.Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
        set(color);
    }

    public byte getTransparency() {
        return this.transparency;
    }
}