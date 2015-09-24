import java.util.Random;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 9:05 PM.
 *         See LICENSE.txt for details.
 */

/*
* All positioning is calculated as the center of the object!
* */

public class Positioning {
    private int cord[] = new int[2];

    private static final Random random = new Random();

    public Positioning(){
        throw new IllegalArgumentException("Deal with it."); /* Hopefully remove this later. */
    }

    public Positioning(Field field) {
        this(random.nextInt(field.getX()), random.nextInt(field.getY()));
        /* This is basically the "random" placement. */
    }

    public Positioning(int x, int y) {
        this.cord[0] = x;
        this.cord[1] = y;
    }

    public Positioning(int cord[]) {
        this.cord = cord;
    }

    public int[] getCord() {
        return cord;
    }

    public int getX() {
        return this.cord[0];
    }

    public int getY() {
        return this.cord[1];
    }

    public void setX(int x) {
        this.cord[0] = x;
    }

    public void setY(int y) {
        this.cord[1] = y;
    }

    /* Start of ugly code. I will probably run into issues later. */

    /* So the whole top vs. bottom layout is pretty confusing here. *
     * Basically, top is referring to x = 0, and left is x = 0.     */

/*    public int getTopLeft(Ball ball) {

        return 0;
    }

    public int getTopRight(Ball ball) {

        return 0;
    }

    public int getBottomLeft(Ball ball) {

        return 0;
    }

    public int getBottomRight(Ball ball) {

        return 0;
    }*/

    public int getTop(Ball ball) {

        return 0;
    }

    public int getBottom(Ball ball) {

        return 0;
    }

/*    public int getTopLeft(Paddle paddle) {

        return 0;
    }

    public int getTopRight(Paddle paddle) {

        return 0;
    }

    public int getBottomLeft(Paddle paddle) {

        return 0;
    }

    public int getBottomRight(Paddle paddle) {

        return 0;
    }*/

    public int getTop(Paddle paddle) {

        return 0;
    }

    public int getBottom(Paddle paddle) {

        return 0;
    }

    public int getTop(Net net) {

        return 0;
    }

    public int getBottom(Net net) {

        return 0;
    }

    /* End of ugly code. */
}