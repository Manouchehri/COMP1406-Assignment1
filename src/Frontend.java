import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 7:01 PM.
 *         See LICENSE.txt for details.
 *         This class should do the least amount of graphics as possible.
 */
public class Frontend extends Application {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Ball> balls = new ArrayList<>();
    private Field field = new Field(300, 700);


    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) {
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("ping-pong");
        stage.setResizable(false); /* Hopefully remove this later. My tiling window manager hates it. */

        VBox vbox = new VBox(); /* Needed for layout. */

        /* Start of menus*/
        MenuItem exitMenuItem = new MenuItem("Exit");

        exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert box = new Alert(Alert.AlertType.INFORMATION);
                box.setTitle("About");
                box.setContentText("David Manouchehri");
                box.showAndWait();
            }
        });

        final Menu fineMenu = new Menu("File");
        fineMenu.getItems().add(aboutMenuItem);
        fineMenu.getItems().add(exitMenuItem);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fineMenu);

        vbox.getChildren().addAll(menuBar);

        /* End of menus. */

        Canvas canvas = new Canvas(field.getX(), field.getY());
        vbox.getChildren().add(canvas);

        players.add(new Player("Dave"));
        balls.add(new Ball(10, 100, 200));

        stage.setScene(new Scene(vbox));
        stage.show();

        paint(canvas);



        for(Player player : players) {
            System.out.printf("Name: " + player.getName() + "\tScore: " + player.score.getScore() + "\n");
        }


    }
    private void paint(Canvas canvas) {
        GraphicsContext painter = canvas.getGraphicsContext2D();

        painter.clearRect(0, 0, field.getX(), field.getY());

        for(Ball ball : balls) {
            ball.render(painter);
        }
    }
}
