package Java_05;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DetyraBonus extends Application {
    @Override
    public void start(Stage stage) {
        // Create the group shape with circle, cross, and lines
        GroupShape groupShape = new GroupShape(100, 100, 200, 200);

        // Create the event handler for moving and changing color
        ShapeMoveXHandler shapeXEvent = new ShapeMoveXHandler(groupShape.getGroup());

        // Create the animation for the group shape
        ShapeAnimation animation = new ShapeAnimation(groupShape.getGroup(), shapeXEvent);
        animation.start();

        // Create the scene and show the stage
        Scene scene = new Scene(groupShape.getGroup(), 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class GroupShape {
    private Group group;

    public GroupShape(double centerX, double centerY, double width, double height) {
        group = new Group();

        Circle bigCircle = new Circle(centerX, centerY, Math.min(width, height) / 2);
        Circle smallCircle = new Circle(centerX, centerY, Math.min(width, height) / 3);
        smallCircle.setFill(null);
        bigCircle.setFill(null);
        smallCircle.setStroke(Color.BLACK);

        double offset = 0.71; // Adjust this value to make the lines shorter or longer
        Line line1 = new Line(centerX - width / 2 * offset, centerY - height / 2 * offset, centerX + width / 2 * offset, centerY + height / 2 * offset);
        Line line2 = new Line(centerX - width / 2 * offset, centerY + height / 2 * offset, centerX + width / 2 * offset, centerY - height / 2 * offset);
        line1.setStroke(Color.BLACK);
        line2.setStroke(Color.BLACK);

        group.getChildren().addAll(bigCircle, smallCircle, line1, line2);
    }

    public Group getGroup() {
        return group;
    }
}

class ShapeMoveXHandler implements EventHandler<ActionEvent> {
    private Group shape;
    private int stepX;
    private int stepY;
    private int rotate;

    public ShapeMoveXHandler(Group shape) {
        this.shape = shape;
        this.stepX = 1;
        this.stepY = 1;
        this.rotate = 1;
    }

    public void handle(ActionEvent ae) {
        int translateX = (int) shape.getTranslateX();
        int translateY = (int) shape.getTranslateY();

        if (translateX <= 0 && translateY <= 0) {
            stepX =45;
            stepY = 0;
            rotate = 10;
            setStrokeColor(Color.RED);
        } else if (translateX >= 400 && translateY <= 0) {
            stepX = 0;
            stepY = 45;
            rotate = 10;
            setStrokeColor(Color.BLACK);
        } else if (translateX >= 400 && translateY >= 400) {
            stepX = -10;
            stepY = 0;
            rotate = 2;
            setStrokeColor(Color.BLUE);
        } else if (translateX <= 0 && translateY >= 400) {
            stepX = 0;
            stepY = -10;
            rotate = 2;
            setStrokeColor(Color.GREEN);
        }

        shape.setTranslateX(translateX + stepX);
        shape.setTranslateY(translateY + stepY);
        shape.setRotate(shape.getRotate() + rotate);
    }

    private void setStrokeColor(Color color) {
        for (Node node : shape.getChildren()) {
            if (node instanceof Shape) {
                ((Shape) node).setStroke(color);
            }
        }
    }
}

class ShapeAnimation {
    private Group shape;
    private EventHandler<ActionEvent> event;
    private Timeline animation;

    public ShapeAnimation(Group shape, EventHandler<ActionEvent> event) {
        this.shape = shape;
        this.event = event;
        initAnimation();
    }

    private void initAnimation() {
        KeyFrame frame = new KeyFrame(Duration.millis(100), event);
        animation = new Timeline(frame);
        animation.setCycleCount(Timeline.INDEFINITE);
    }

    public void start() {
        animation.play();
    }

    public void stop() {
        animation.stop();
    }
}
