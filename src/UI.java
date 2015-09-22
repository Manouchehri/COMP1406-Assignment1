import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 4:38 PM.
 *         See LICENSE.txt for details.
 */
public class UI extends Application {
    @Override
    public void start(Stage mainStage) {
        Canvas canvas = new Canvas(500,500);

        mainStage.initStyle(StageStyle.UNDECORATED);
        mainStage.setTitle("ping-pong");

        MenuItem menuItem = new MenuItem("Exit");

        menuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });


        final Menu menu = new Menu("File");
        menu.getItems().add(menuItem);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(canvas);
        stackPane.getChildren().add(menuBar);

        Scene stackScene = new Scene(stackPane);
        mainStage.setScene(stackScene);
        mainStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
