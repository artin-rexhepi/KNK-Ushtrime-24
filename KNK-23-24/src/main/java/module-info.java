module org.example.knk2324 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.knk2324 to javafx.fxml;
    opens Java_02 to javafx.graphics;
    opens Java_03 to javafx.graphics;
    opens Java_04 to javafx.graphics;
    opens Java_05 to javafx.graphics;
    opens Java_06 to javafx.fxml;

    exports org.example.knk2324;
    exports Java_06;
    exports app;
    exports controller;
    opens controller to javafx.fxml;
}