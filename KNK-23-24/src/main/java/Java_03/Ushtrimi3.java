package Java_03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ushtrimi3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        int width=350;
        int height =250;

        MyCustomRec2 rect = new MyCustomRec2(width,height);
        Pane pane = new StackPane(rect);
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    class MyCustomRec2 extends Pane{
        Color randomColor = new Color(Math.random(), Math.random(), Math.random(), 1);
        private int width;
        private int height;

        public MyCustomRec2(int width, int height){
            this.width=width;
            this.height=height;
            super.setMaxHeight(height);
            super.setMaxWidth(width);
            this.draw();
        }

        private void draw(){
            Polygon rect1 = new Polygon(0,0, width/2,height/2, 0,height);
            rect1.setStrokeWidth(1);
            rect1.setFill(randomColor);
            Polygon rect2 = new Polygon(0,0, width/2,height/2, width,0);
            rect2.setStrokeWidth(1);
            rect2.setFill(randomColor);
            Polygon rect3 = new Polygon(width,0, width/2,height/2, width,height);
            rect3.setStrokeWidth(1);
            rect3.setFill(randomColor);
            Polygon rect4 = new Polygon(width,height, width/2,height/2, 0,height);
            rect4.setStrokeWidth(1);
            rect4.setFill(randomColor);
            super.getChildren().clear();
            super.getChildren().addAll(rect1, rect2, rect3, rect4);

        }
    }
}
