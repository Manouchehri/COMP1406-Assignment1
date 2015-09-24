import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.KeyEvent;
import java.util.ArrayList;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 7:01 PM.
 *         See LICENSE.txt for details.
 */
public class Frontend extends Application {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Ball> balls = new ArrayList<>();
    public static final Field field = new Field(300, 700);
    private Physics physics = new Physics();

    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) {
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("ping-pong");
        stage.setResizable(false); /* Hopefully remove this later. My tiling window manager hates it. */

        VBox vbox = new VBox(); /* Needed for layout. */

        vbox.getChildren().addAll(buildMenu());

        Canvas canvas = new Canvas(field.getX(), field.getY());
        vbox.getChildren().add(canvas);

        players.add(new Player("Dave"));
        balls.add(new Ball(50, 50, 50));

        stage.setScene(new Scene(vbox));
        stage.show();

        paint(canvas);

        canvas.requestFocus();
        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent key) {
                /* This is really laggy. Why? */
                KeyCode code = key.getCode();
                System.out.println(code);
                if(code == KeyCode.LEFT)
                    players.get(0).paddle = physics.move(players.get(0).paddle, Physics.Direction.LEFT);
                paint(canvas);
                System.out.println(players.get(0).paddle.position.getX());
                key.consume();
            }
        });
    }

    private void paint(Canvas canvas) {
        GraphicsContext painter = canvas.getGraphicsContext2D();

        painter.clearRect(0, 0, field.getX(), field.getY());

        for(Ball ball : balls) {
            ball.render(painter);
        }

        for(Player player : players) {
            player.paddle.render(painter);
            player.net.render(painter);
        }
    }

    public MenuBar buildMenu() {
        MenuItem exitMenuItem = new MenuItem("Exit");

        exitMenuItem.setOnAction(event -> Platform.exit());

        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(event -> {
                Alert box = new Alert(Alert.AlertType.INFORMATION);
                box.setTitle("About");
                box.setContentText("David Manouchehri");
                box.showAndWait();
            }
        );

        final Menu fineMenu = new Menu("File");
        fineMenu.getItems().add(aboutMenuItem);
        fineMenu.getItems().add(exitMenuItem);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fineMenu);

        return menuBar;
    }
}
