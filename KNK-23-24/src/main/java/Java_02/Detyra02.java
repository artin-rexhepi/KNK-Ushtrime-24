package Java_02;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Detyra02 extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle(100,100,100);
        Color newColor = new Color(0.3,0.5,0.2,1);
        circle.setFill(null); //Color.RED- opsion tjeter
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
//
//        Rectangle rect = new Rectangle(100,100,50,50);
//
//        Polygon polygon = new Polygon(100,100,200,200,100,300);
//        polygon.setFill(Color.RED);
//        polygon.setStroke(Color.BLACK);
//        polygon.setStrokeWidth(2);
//        polygon.setRotate(100);



          Pane pane= new Pane(circle);

          circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.widthProperty().divide(2));
//        pane.setMaxHeight();
//        pane.setMaxWidth();


        Scene scene = new Scene(pane, 500,500);
        stage.setScene(scene);
        stage.setTitle("Detyra 02");
        stage.show();
    }
}
