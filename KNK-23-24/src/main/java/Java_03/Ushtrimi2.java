package Java_03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ushtrimi2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        int x=100;
//        int y=100;
//
        int width=350;
        int height =250;
//        Rectangle rectangle = new Rectangle(x, y, width, height);
//        rectangle.setFill(null);
//        rectangle.setStroke(Color.BLACK);
//        Line line1 = new Line(
//                x,y,x+width,y+height
//        );
//        Line line2 = new Line(
//                x+width,y,x,y+height
//        );
        MyCustomRec rect = new MyCustomRec(width, height);
        Pane pane = new StackPane(rect);
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
    class MyCustomRec extends Pane{
        private int width;
        private int height;

        public MyCustomRec(int width, int height){
            this.width=width;
            this.height=height;
            super.setMaxHeight(height);
            super.setMaxWidth(width);
            this.draw();

        }

        private void draw(){
            Rectangle rect = new Rectangle(0,0,width, height);
            rect.setFill(null);
            rect.setStroke(Color.BLACK);
            Line line1 = new Line(0, 0, width, height);
            Line line2 = new Line(width, 0, 0, height);
            super.getChildren().clear();
            super.getChildren().addAll(rect, line1, line2);
        }
    }
}
