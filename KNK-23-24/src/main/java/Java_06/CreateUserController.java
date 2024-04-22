package Java_06;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateUserController {
    @FXML
    private TextField txt_Username;
    @FXML
    private TextField txt_FirstName;
    @FXML
    private TextField txt_LastName;
    @FXML
    private PasswordField pwd_Password;

    @FXML
    private void handleSave(ActionEvent ae){
        System.out.println("Username: "+this.txt_Username.getText());
        System.out.println("First Name: "+this.txt_FirstName.getText());
        System.out.println("Last Name: "+this.txt_LastName.getText());
        System.out.println("Password: "+this.pwd_Password.getText());

    }

    @FXML
    private void handleCancel(ActionEvent ae){
        this.txt_Username.clear();
        this.txt_FirstName.clear();
        this.txt_LastName.clear();
        this.pwd_Password.clear();
    }
}
