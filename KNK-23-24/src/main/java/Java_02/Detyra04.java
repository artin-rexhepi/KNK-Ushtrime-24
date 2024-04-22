package Java_02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Detyra04 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();
        Button btn = new Button("OK");
        btn.setStyle("-fx-border-color: blue");
        pane.getChildren().add(btn);
        pane.setRotate(45);

        pane.setStyle("-fx-border-color: red; -fx-background-color: gray");

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Hello");
        stage.show();

    }
}
