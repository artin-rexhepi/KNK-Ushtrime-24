package Java_02;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Detyra01 extends Application  {
    @Override
    public void start(Stage stage) throws Exception {
        //Stage
        //Skena
        //Pane
        //Node
        Node button1 = new Button("Ok!");
//        Button button1 = new Button("Click me!")

        Pane panel1 = new StackPane(button1);
//        panel1.getChildren().add(button1);
//        panel1.getChildren().addAll(button1);

        Scene scene = new Scene(panel1, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Detyra 01");
        stage.show();
    }
}
