import java.util.UUID;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 7:13 PM.
 *         See LICENSE.txt for details.
 */
public class Player {
    private String name;
    private UUID id;
    public ScoreKeeper score;
    public Paddle paddle = new Paddle();

    public Player(String name) {
        this.name = name;
        id = UUID.randomUUID();
        score = new ScoreKeeper();
    }

    public String getName() {
        return this.name;
    }

    public UUID getID() {
        return this.id;
    }
}