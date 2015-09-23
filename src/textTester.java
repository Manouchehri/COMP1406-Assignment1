import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 7:01 PM.
 *         See LICENSE.txt for details.
 *         This class should do the least amount of graphs operations possible.
 */
public class textTester extends Application {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Ball> balls = new ArrayList<>();


    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new StackPane()));
        stage.show();

        players.add(new Player("Alice"));
        players.add(new Player("Bob"));

        for(Player player : players) {
            System.out.printf("Name: " + player.getName() + "\tScore: " + player.score.getScore() + "\n");
        }
        balls.add(new Ball());
        balls.get(0).color.rand();
        System.out.println(balls.get(0).color.get());
    }
}
