package sample.controller;


import animatefx.animation.Bounce;
import com.google.gson.Gson;
import http_request.PostRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import sample.validation.Alerts;
import sample.validation.FormFields;
import sample.validation.ToDoAppValidation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class Controller {


    // To-do App
    @FXML
    private TextField nameToDoApp, emailAddToDoApp, emaillogin, passwordToDoApp, passwordToDoApp2;

    @FXML
    private PasswordField passwordToDoAppLogin;

    @FXML
    private Label nameLabel, emailAddLabel, emailAddLabelLogin, passwordLabel, passwordLabelLogin, passwordLabel2;

    //Calculator
    @FXML
    private long input1, input2;

    @FXML
    private String operator = "";

    @FXML
    private boolean isEmpty = true;

    @FXML
    private Label output;


    /* Todo App Section */
    @FXML
    public void onButtonClick(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("../ui/login/loginUI.fxml"));
            Stage stage = new Stage();
            Image image = new Image(getClass().getResourceAsStream("../images/to-do-list.png"));
            stage.getIcons().add(image);
            stage.setTitle("Todo App");
            stage.setScene(new Scene(root1, 900, 690));
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @FXML
    public void signUp(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/form/formUI.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void signUpSuccessAlert() {
        Alert x = new Alert(Alert.AlertType.INFORMATION);
        Alerts alert = new Alerts();
        x.setTitle("Sign Up Success!");
        x.setContentText(alert.getSuccess());
        x.setHeaderText(null);
        x.showAndWait();

    }


    @FXML
    public void signFailedAlert400() {
        Alert x = new Alert(Alert.AlertType.ERROR);
        Alerts alerts = new Alerts();
        x.setTitle("Sign Up Failed!");
        x.setContentText(alerts.getFailed400());
        x.setHeaderText(null);
        x.showAndWait();

    }

    @FXML
    public void signFailedAlert400Login() {
        Alert x = new Alert(Alert.AlertType.ERROR);
        Alerts alerts = new Alerts();
        x.setTitle("Login Failed!");
        x.setHeaderText("HTTP ERROR 400 - Bad Request");
        x.setContentText(alerts.getFailed400Login());
        x.showAndWait();

    }

    public void signFailedAlert401() {
        Alert x = new Alert(Alert.AlertType.ERROR);
        Alerts alerts = new Alerts();
        x.setTitle("Login Failed!");
        x.setContentText(alerts.getFailed401());
        x.setHeaderText(null);
        x.showAndWait();

    }

    public void signFailedAlert404() {
        Alert x = new Alert(Alert.AlertType.ERROR);
        Alerts alerts = new Alerts();
        x.setTitle("Login Failed!");
        x.setContentText(alerts.getFailed404());
        x.setHeaderText("HTTP ERROR 404 - PAGE NOT FOUND");
        x.showAndWait();

    }

    public void signFailedAlert500() {
        Alert x = new Alert(Alert.AlertType.ERROR);
        Alerts alerts = new Alerts();
        x.setTitle("Sign Up Failed!");
        x.setHeaderText("500 INTERNAL SERVER ERROR");
        x.setContentText(alerts.getFailed500());
        x.showAndWait();

    }

    @FXML
    public void signFailedAlert502() {
        Alert x = new Alert(Alert.AlertType.ERROR);
        Alerts alerts = new Alerts();
        x.setTitle("Sign Up Failed!");
        x.setContentText(alerts.getFailed502());
        x.setHeaderText(null);
    }

    @FXML
    public void signFailedAlert503() {
        Alert x = new Alert(Alert.AlertType.ERROR);
        Alerts alerts = new Alerts();
        x.setTitle("Sign Up Failed!");
        x.setHeaderText("HTTP ERROR 503");
        x.setContentText(alerts.getFailed503());
        x.showAndWait();

    }

    @FXML
    public void signFailedAlert504() {
        Alert x = new Alert(Alert.AlertType.ERROR);
        Alerts alerts = new Alerts();
        x.setTitle("Sign Up Failed!");
        x.setContentText(alerts.getFailed504());
        x.setHeaderText(null);
        x.showAndWait();

    }

    @FXML
    public void loginSuccessAlert() {
        Alert x = new Alert(Alert.AlertType.INFORMATION);
        Alerts alert = new Alerts();
        x.setTitle("Login Success!");
        x.setContentText(alert.getSuccessLogin());
        x.setHeaderText(null);
        x.showAndWait();

    }

    @FXML
    public void signUpTwo(ActionEvent event) throws IOException {
        int repeat = 0;
        String nameToDoAppText;
        String emailAddToDoAppText;
        String passwordToDoAppText;
        String passwordToDoAppText2;


        boolean name = ToDoAppValidation.textFieldIsNull(nameToDoApp, nameLabel, "Required field!");
        boolean alphabetName = ToDoAppValidation.textAlphabet(nameToDoApp, nameLabel, "Please only enter letters from a - z only");
        boolean emailAdd = ToDoAppValidation.textFieldIsNull(emailAddToDoApp, emailAddLabel, "Required field!");
        boolean emailValidation = ToDoAppValidation.emailFormat(emailAddToDoApp, emailAddLabel, "Format must be name@emailaddress.com");
        boolean password = ToDoAppValidation.textFieldIsNull(passwordToDoApp, passwordLabel, "Required field!");
        boolean password2 = ToDoAppValidation.textFieldIsNull(passwordToDoApp2, passwordLabel2, "Required field!");
        boolean passwordMatcher = ToDoAppValidation.isPasswordNotMatch(passwordToDoApp, passwordToDoApp2, passwordLabel2, "Password does not match");


        if (name || emailAdd || password || password2) {
            System.out.println("Please fill in the blanks and follow the required format");
        } else {
            if (alphabetName && emailValidation && passwordMatcher) {
                nameToDoAppText = nameToDoApp.getText();
                emailAddToDoAppText = emailAddToDoApp.getText();
                passwordToDoAppText = passwordToDoApp.getText();
                passwordToDoAppText2 = passwordToDoApp2.getText();


//        Convert na sa GSON para isend na sa API
                Gson gson = new Gson();
                FormFields formFields = new FormFields(nameToDoAppText, emailAddToDoAppText, passwordToDoAppText, passwordToDoAppText2);
                String x = gson.toJson(formFields);


//        Establish HTTP Connection
                PostRequest postRequest = new PostRequest("http://d1fb2ed90ffc.ngrok.io/api/auth/register", x);
                postRequest.executePostRequest();
                String response = postRequest.getPostRequestResponse();
                int responseCode = postRequest.getmHttpURLConnection().getResponseCode();
                postRequest.setCode(responseCode);
                if (responseCode == 400) {
                    signFailedAlert400();
                } else if (responseCode == 500) {
                    signFailedAlert500();
                } else if (responseCode == 404) {
                    signFailedAlert404();
                } else if (responseCode == 502) {
                    signFailedAlert502();
                } else if (responseCode == 503) {
                    signFailedAlert503();
                } else if (responseCode == 504) {
                    signFailedAlert504();
                } else {
                    System.out.println(postRequest.getCode());
                    System.out.println(postRequest.getmHttpURLConnection().getResponseCode());
                    System.out.println(response);
                    postRequest.disconnect();
                    signUpSuccessAlert();

                    //Pag successfull ung signUp balik sa app
                    try {
                        Parent root2 = FXMLLoader.load(getClass().getResource("../ui/login/loginUI.fxml"));
                        Scene scene = new Scene(root2);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(scene);
                        app_stage.show();


                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            }

        }
    }



    @FXML
    public void login(ActionEvent event) throws IOException {
        String emailAddToDoAppTextLogin;
        String passwordToDoAppTextLogin;
        boolean emailAdd = ToDoAppValidation.textFieldIsNull(emaillogin, emailAddLabelLogin, "Required field!");
        boolean emailValidation = ToDoAppValidation.emailFormat(emaillogin, emailAddLabelLogin, "Format must be name@emailaddress.com");
        boolean password = ToDoAppValidation.textFieldIsNull(passwordToDoAppLogin, passwordLabelLogin, "Invalid password");

        if (emailAdd || password) {
            System.out.println("Please fill in the blanks and follow the required format");
        } else {
            if (emailValidation) {
                emailAddToDoAppTextLogin = emaillogin.getText();
                passwordToDoAppTextLogin = passwordToDoAppLogin.getText();

                Gson gson = new Gson();
                FormFields formFields = new FormFields(emailAddToDoAppTextLogin, passwordToDoAppTextLogin);
                String x = gson.toJson(formFields);


                //        Establish HTTP Connection
                PostRequest postRequest = new PostRequest("http://d1fb2ed90ffc.ngrok.io/api/auth/login", x);
                postRequest.executePostRequest();
                String response = postRequest.getPostRequestResponse();
                int responseCode = postRequest.getmHttpURLConnection().getResponseCode();
                postRequest.setCode(responseCode);
                if (responseCode == 400) {
                    signFailedAlert400Login();
                } else if (responseCode == 401) {
                    signFailedAlert401();
                } else if (responseCode == 404) {
                    signFailedAlert404();
                } else if (responseCode == 500) {
                    signFailedAlert500();
                } else if (responseCode == 502) {
                    signFailedAlert502();
                } else if (responseCode == 503) {
                    signFailedAlert503();
                } else {
                    System.out.println(postRequest.getCode());
                    System.out.println(postRequest.getmHttpURLConnection().getResponseCode());
                    System.out.println(response);
                    postRequest.disconnect();
                    loginSuccessAlert();

                    //New dashboard
                }
            }
        }

//            //Pag successfull ung signUp balik sa app
//            try {
//                Parent root2 = FXMLLoader.load(getClass().getResource("../ui/login/loginUI.fxml"));
//                Scene scene = new Scene(root2);
//                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                app_stage.setScene(scene);
//                app_stage.show();
//
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }

//        }
    }


    /* Calculator Section */

    @FXML
    public void onButtonClickCalculator(ActionEvent event) {

        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("../ui/calculator/calculatorUI.fxml"));
            Stage stage = new Stage();
            Image image = new Image(getClass().getResourceAsStream("../images/iconfinder_calculator-math-tool-school_2824440.png"));
            stage.getIcons().add(image);
            stage.setTitle("Calculator");
            stage.setScene(new Scene(root1, 300, 500));
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void clearCalculator(ActionEvent event) {
        output.setText("0");
        isEmpty = true;
        operator = "";
    }

    @FXML
    private void processNumPad(ActionEvent event) {
        if (isEmpty) {
            output.setText("");
            isEmpty = false;
        }
        String val = ((Button) event.getSource()).getText();
        output.setText(output.getText() + val);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        if (output.getText().equals("ERROR")) {
            return;
        }
        String val = ((Button) event.getSource()).getText();
        if (!val.equals("=")) {
            if (!operator.isEmpty()) {
                return;
            }
            operator = val;
            input1 = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if (operator.isEmpty()) {
                return;
            }
            if (output.getText().isEmpty()) {
                output.setText("ERROR");
                operator = "";
                isEmpty = true;
                return;
            }
            output.setText(operation(input1, Long.parseLong(output.getText()), operator));
            operator = "";
            isEmpty = true;
        }
    }

    @FXML
    private String operation(long input1, long input2, String operator) {
        switch (operator) {
            case "+":
                return String.valueOf(input1 + input2);


            case "-":
                return String.valueOf(input1 - input2);

            case "×":
                return String.valueOf(input1 * input2);

            case "÷":
                if (input2 == 0) {
                    return "ERROR";
                }
                return String.valueOf(input1 / input2);

            case "%":
                return String.valueOf((input1 % input2));
        }


        return operator;
    }


    /* Tic - Toc - Toe Section */





    /* ATM Section */
    @FXML
    public void onButtonClickATM(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("../ui/atm/atmUI.fxml"));
            Stage stage = new Stage();
            Image image = new Image(getClass().getResourceAsStream("../images/atm.png"));
            stage.getIcons().add(image);
            stage.setTitle("ApocaBank App");
            stage.setScene(new Scene(root1, 1200, 600));
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }






    // Loading Effects Initialization
//    @FXML
//    Circle circle1;
//    @FXML
//    Circle circle2;
//    @FXML
//    Circle circle3;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources){
//        new Bounce(circle1).setCycleCount(3).setDelay(new Duration(200)).play();
//        new Bounce(circle2).setCycleCount(3).setDelay(new Duration(500)).play();
//        new Bounce(circle3).setCycleCount(3).setDelay(new Duration(900)).play();
//    }

}// End
