package Java_02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Detyra3 extends Application {
    //Pane
    //VBox, HBox, StackPane, FlowPane

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane flowPane = new FlowPane();
        for(int i=0; i<4; i++){
            Rectangle rect = new Rectangle(100,100, 50,50);
            rect.setRotate(45);
            flowPane.getChildren().add(rect);
        }
        flowPane.setMaxHeight(150);
        flowPane.setMaxWidth(150);
        Pane pane = new StackPane(flowPane);
        Scene scene= new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }


}
