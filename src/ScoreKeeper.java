/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 6:59 PM.
 *         See LICENSE.txt for details.
 */
public class ScoreKeeper {
    private int score;

    public int getScore() {
        return score;
    }

    /*
    public void resetScore() {
        score = 0;
    }
    */

    public void incrementScore() {
        score++;
    }
}
