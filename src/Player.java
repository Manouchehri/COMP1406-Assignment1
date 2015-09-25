// import java.util.UUID;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 7:13 PM.
 *         See LICENSE.txt for details.
 */
public class Player {
    private String name;
    // private UUID id;
    public ScoreKeeper score;
    public Paddle paddle;
    private static final int netDepth = 10;
    public static final Net net = new Net(0, Frontend.field.getY() - netDepth, Frontend.field.getX(), Frontend.field.getY());

    public Player(String name) {
        this.name = name;
        // id = UUID.randomUUID();
        score = new ScoreKeeper();
        int paddleWidth = 100;
        int paddleHeight = 10;
        paddle = new Paddle(Frontend.field.getX() / 2 - paddleWidth / 2,
                            3 * Frontend.field.getY() / 4,
                            paddleWidth,
                            paddleHeight); /* Not the nicest looking. Just put it in the middle-ish. */
    }

    public String getName() {
        return name;
    }

    /*
    public UUID getID() {
        return id;
    }
    */
}
