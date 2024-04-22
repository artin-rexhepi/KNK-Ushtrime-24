package Java_04;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {
    public void start(Stage stage){
        //1. Krijojme figuren
        Circle circle = new Circle(100,100,100);

        //2. Krijojme eventin
//        EventHandler<ActionEvent> circleEvent = new EventHandler<ActionEvent>() {
//
//            //3. Logjika e event-it
//            @Override
//            public void handle(ActionEvent ae) {
//                circle.setFill(
//                        new Color(Math.random(), Math.random(), Math.random(),1)
//                );
//            }
//        };
        Rectangle rect = new Rectangle(100,100,100,100);
//        EventHandler<ActionEvent> circleEvent = new CircleColorEventHandler(rect);
//        // 4. Shkaktojme eventin, ngjarjen ne menyre periodike
//        KeyFrame frame = new KeyFrame(
//                Duration.millis(1000), circleEvent
//        );
//
//        //5.Krijojme animacionin
//        Timeline animation = new Timeline(frame);
//        animation.setCycleCount(Timeline.INDEFINITE);
//        animation.play();

        ShapeColorAnimation animation = new ShapeColorAnimation(rect);
        animation.start();

        Pane pane = new Pane(rect);
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();

    }

}

class CircleColorEventHandler implements EventHandler<ActionEvent>{
    private Shape shape;
    public CircleColorEventHandler(Shape shape){
        this.shape =shape;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Color color = new Color(Math.random(), Math.random(), Math.random(), 1);
        if(this.shape.getTranslateX()==0){
            this.shape.setTranslateX(50);
        }
        if(this.shape.getTranslateX()>=150){
            this.shape.setTranslateX(-100);
        }

    }
}

class ShapeColorAnimation{
    private Shape shape;
    private EventHandler<ActionEvent> event;
    private KeyFrame frame;
    private Timeline animation;

    public ShapeColorAnimation(Shape shape)
    {
        this.shape=shape;
        this.event= new CircleColorEventHandler(this.shape);
        this.frame=new KeyFrame(Duration.seconds(1), this.event);
        this.animation= new Timeline(this.frame);
        this.animation.setCycleCount(Timeline.INDEFINITE);
    }

    public void start(){
        this.animation.play();
    }
}
