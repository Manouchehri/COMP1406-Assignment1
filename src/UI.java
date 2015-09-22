import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

        mainStage.initStyle(StageStyle.DECORATED);
        mainStage.setTitle("ping-pong");

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
        fineMenu.getItems().add(exitMenuItem);
        fineMenu.getItems().add(aboutMenuItem);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fineMenu);

        VBox layout = new VBox();
        layout.getChildren().addAll(menuBar);
        // layout.getChildren().add(canvas);



        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(layout);
        stackPane.getChildren().add(canvas);

        Scene stackScene = new Scene(stackPane);
        mainStage.setScene(stackScene);
        mainStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
