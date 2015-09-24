/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 3:55 PM.
 *         See LICENSE.txt for details.
 */
public class Ball {
    private int radius;
    private double speed;

    public ColorHex color = new ColorHex();
    public Positioning position = new Positioning();

    public Ball() {

    }

    public int getRadius() {
        return this.radius;
    }
}
