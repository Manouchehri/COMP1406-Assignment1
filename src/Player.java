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
    public Paddle paddle; // = new Paddle();

    public static final Net net = new Net(0, Frontend.field.getY() - 10, Frontend.field.getX(), Frontend.field.getY());
    //

    public Player(String name) {
        this.name = name;
        id = UUID.randomUUID();
        score = new ScoreKeeper();
        paddle = new Paddle(10, 100, 100, 10);
    }

    public String getName() {
        return this.name;
    }

    public UUID getID() {
        return this.id;
    }
}
