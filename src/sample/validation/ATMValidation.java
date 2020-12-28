package sample.validation;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATMValidation {


    public static boolean textFieldIsNull(TextField inputTextField,Label inputLabel,String validationText){
        boolean isNull = false;
        String validationString = null;

        if (inputTextField.getText().isEmpty()){
            isNull = true;
            validationString = validationText;
        }

        inputLabel.setText(validationString);
        return isNull;
    }

    public static boolean textFieldIsNull(PasswordField inputTextField, Label inputLabel, String validationText){
        boolean isNull = false;
        String validationString = null;

        if (inputTextField.getText().isEmpty()){
            isNull = true;
            validationString = validationText;
        }

        inputLabel.setText(validationString);
        return isNull;
    }

    public static boolean isPasswordNotMatch(TextField inputTextField, TextField inputTextField2, Label inputLabel, String validationText){
        boolean isTrue = false;
        String x = inputTextField.getText();
        String y = inputTextField2.getText();


        if (x.equals(y)){
            isTrue = true;
        }

        else{
            inputLabel.setText(validationText);
        }

        return isTrue;

    }

    public static boolean textAlphabet(TextField inputTextField, Label inputLabel, String validationText) {
        boolean isAlphabet = true;
        String validationString = null;

        if (!inputTextField.getText().matches("[a-z A-Z]+")) {
            isAlphabet = false;
            validationString = validationText;

        }
        inputLabel.setText(validationString);
        return isAlphabet;

    }


    public static boolean emailFormat(TextField inputTextField, Label inputLabel, String validationText) {
        boolean isEmail = true;
        String validationString = null;

        if (!inputTextField.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com")) {
            isEmail = false;
            validationString = validationText;

        }
        inputLabel.setText(validationString);
        return isEmail;

    }

}
