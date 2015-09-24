import javafx.animation.AnimationTimer;
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
import java.util.Random;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 7:01 PM.
 *         See LICENSE.txt for details.
 */
public class Frontend extends Application {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Ball> balls = new ArrayList<>();
    public static final Field field = new Field(500, 750);
    private Controller controller = new Controller(); /* This should be moved to Player. */
    private ScoreBoard scoreBoard = new ScoreBoard();
    private Canvas canvas = new Canvas(field.getX(), field.getY());

    private Random rand = new Random();

    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) {
        stage.initStyle(StageStyle.UTILITY); /* Not needed on Windows. */
        stage.setTitle("ping-pong");
        stage.setResizable(false); /* Hopefully remove this later. My tiling window manager hates it. */

        VBox vbox = new VBox(); /* Needed for layout. */

        vbox.getChildren().addAll(buildMenu()); /* Throw menus in. */
        vbox.getChildren().add(canvas); /* Stick the canvas/playing field below the menus. */

        reset(); /* Right now this simply adds the default player. */

        stage.setScene(new Scene(vbox));
        stage.show();

        canvas.requestFocus();
        startTimer();
        /* Part of this should be forked to Player probably. */
        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent key) {
                /* This is really laggy. Why? */
                KeyCode code = key.getCode();
                switch(code) {
                    case LEFT:
                        players.get(0).paddle = controller.move(players.get(0).paddle, Controller.Direction.LEFT);
                        break; /* This is suboptimal because the player can't press more than one key at a time. */
                    case RIGHT:
                        players.get(0).paddle = controller.move(players.get(0).paddle, Controller.Direction.RIGHT);
                        break;
                    case UP:
                        players.get(0).paddle = controller.move(players.get(0).paddle, Controller.Direction.UP);
                        break;
                    case DOWN:
                        players.get(0).paddle = controller.move(players.get(0).paddle, Controller.Direction.DOWN);
                        break;
                }
                paint(canvas); /* Not really needed, but why not? */
                key.consume();
            }
        });
    }

    public void reset() {
        players.clear(); /* Delete all players */
        balls.clear();   /* and balls. */
        players.add(new Player("Dave")); /* Add the default player. */

        balls.add(new Ball(rand.nextInt(25) + 10));
        paint(canvas);
    }

    private void paint(Canvas canvas) {
        GraphicsContext painter = canvas.getGraphicsContext2D();

        painter.clearRect(0, 0, field.getX(), field.getY()); /* Wipe everything. */

        for(Ball ball : balls) {
            ball.render(painter);
        }

        String scoreHolder = ""; /* This is the text that gets rendered on the canvas. */

        for(Player player : players) {
            player.paddle.render(painter);
            player.net.render(painter);

            scoreHolder += (player.getName() + ": " + player.score.getScore() + "\n");
        }
        scoreBoard.render(painter, scoreHolder);
    }

    public MenuBar buildMenu() {
        /* Everything here should be self-explanatory. */
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(event -> Platform.exit());

        MenuItem resetMenuItem = new MenuItem("Reset");
        resetMenuItem.setOnAction(event -> reset());

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
        fineMenu.getItems().add(resetMenuItem);
        fineMenu.getItems().add(exitMenuItem);

        MenuItem pause = new MenuItem("Pause");
        pause.setOnAction(event -> stopTimer());

        MenuItem resume = new MenuItem("Resume");
        resume.setOnAction(event -> startTimer());

        final Menu statusMenu = new Menu("Status");
        statusMenu.getItems().add(pause);
        statusMenu.getItems().add(resume);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fineMenu);
        menuBar.getMenus().add(statusMenu);

        return menuBar;
    }

    private boolean timerStatus = false;
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            for(Ball ball : balls) {
                ball.move(); /* Move the ball into the next location. */

                for(Player player : players) {
                    player.score.incrementScore(); /* The score is multiplied by the number of balls in the field. */
                    if(ball.bounce(player.net, player.paddle)) {
                        players.remove(player); /* Game over! */

                        if(players.isEmpty()) /* Reset if no players left. */
                            reset();
                    }
                }
            }
            paint(canvas);
        }
    };

    private void startTimer() {
        timer.start();
        timerStatus = true;
    }

    private void stopTimer() {
        timer.stop();
        timerStatus = false;
    }
}