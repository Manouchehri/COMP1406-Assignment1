import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author David Manouchehri
 *         Created on 9/22/15 at 4:38 PM.
 *         See LICENSE.txt for details.
 */
public class UI extends Application {
    @Override
    public void start(Stage stage) {
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

        Canvas canvas = new Canvas(500,500);
        stage.initStyle(StageStyle.DECORATED);

        final Menu fineMenu = new Menu("File");
        fineMenu.getItems().add(aboutMenuItem);
        fineMenu.getItems().add(exitMenuItem);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fineMenu);

        VBox layout = new VBox();
        layout.getChildren().addAll(menuBar);
        layout.getChildren().add(canvas);



        Scene stackScene = new Scene(layout);

        stage.setScene(stackScene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
