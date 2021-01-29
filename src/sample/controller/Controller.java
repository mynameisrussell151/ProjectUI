package sample.controller;


import com.google.gson.Gson;
import ddf.minim.*;
import http_request.PostRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.validation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;


public class Controller {
    //Final initialization for Jack en Poy
    private static int aJNP = 0;
    private static final String PAPER = "paper";
    private static final String ROCK = "rock";
    private static final String SCISSOR = "scissor";
    private Image image;
    private static AudioPlayer song;
    private static Minim loader;


    // To-do App
    @FXML
    private TextField nameToDoApp, emailAddToDoApp, emaillogin, passwordToDoApp, passwordToDoApp2;

    @FXML
    private PasswordField passwordToDoAppLogin;

    @FXML
    private Label nameLabel, emailAddLabel, emailAddLabelLogin, passwordLabel, passwordLabelLogin, passwordLabel2;

    //Calculator
    @FXML
    private double input1;

    @FXML
    private String operator = "";

    @FXML
    private boolean isEmpty = true;

    @FXML
    private Label output;

    //ATM
    @FXML
    private TextField nameBank;

    @FXML
    private TextField usernameBank;

    @FXML
    private TextField passwordBank;

    @FXML
    private TextField passwordBank2;

    @FXML
    private TextField addressBank;

    @FXML
    private TextField cardNumberBank;

    @FXML
    private TextField emailAddressBank;

    @FXML
    private Label nameLabelBank;

    @FXML
    private Label usernameLabelBank;

    @FXML
    private Label addressLabelBank;

    @FXML
    private Label emailAddLabelBank;

    @FXML
    private Label passwordLabelBank;

    @FXML
    private Label passwordLabelBank2;

    @FXML
    private TextField usernameBankLogin;

    @FXML
    private TextField passwordBankLogin;

    @FXML
    private Label passwordBankLabelLogin;

    @FXML
    private Label emailAddBankLabelLogin;

    //Jack en Poy
    @FXML
    private ImageView player;

    @FXML
    private Label result;

    @FXML
    private ImageView computer;

    @FXML
    private Label playerScore;

    @FXML
    private Label computerScore;

    @FXML
    private Label round;

    @FXML
    private Label soundLabel;


    //Main UI
    @FXML
    public void lightModeMain(ActionEvent event) {

        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/uiDarkMode.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void lightModeSwitchMain(ActionEvent event) {

        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/ui.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


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

    public void signFailedAlert405() {
        Alert x = new Alert(Alert.AlertType.ERROR);
        Alerts alerts = new Alerts();
        x.setTitle("Login Failed!");
        x.setContentText(alerts.getFailed405());
        x.setHeaderText(null);
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
                PostRequest postRequest = new PostRequest("https://todo-projectx.loca.lt/api/auth/login", x);
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
    public void lightMode(ActionEvent event) {

        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/calculator/calculatorUILightMode.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void lightModeSwitch(ActionEvent event) {

        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/calculator/calculatorUI.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
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
            input1 = Double.parseDouble(output.getText());
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
            output.setText(operation(input1, Double.parseDouble(output.getText()), operator));
            operator = "";
            isEmpty = true;
        }
    }

    @FXML
    private String operation(double input1, double input2, String operator) {
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
            Parent root1 = FXMLLoader.load(getClass().getResource("../ui/login/atmUILogin.fxml"));
            Stage stage = new Stage();
            Image image = new Image(getClass().getResourceAsStream("../images/atm.png"));
            stage.getIcons().add(image);
            stage.setTitle("ApocaBank App");
            stage.setScene(new Scene(root1, 900, 690));
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @FXML
    public void signUpBank(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/form/atmFormUI.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    @FXML
    public void signUpATM(ActionEvent event) throws IOException {
        int repeat = 0;
        String nameATMText;
        String usernameATMText;
        String addressATMText;
        String cardNumberATMText;
        String emailAddressATMText;
        String passwordATMText;
        String passwordATMText2;


        boolean name = ATMValidation.textFieldIsNull(nameBank, nameLabelBank, "Required field!");
        boolean alphabetName = ATMValidation.textAlphabet(nameBank, nameLabelBank, "Please only enter letters from a - z only");

        boolean username = ATMValidation.textFieldIsNull(usernameBank, usernameLabelBank, "Required field!");
        boolean address = ATMValidation.textFieldIsNull(addressBank, addressLabelBank, "Required field!");


        boolean emailAdd = ATMValidation.textFieldIsNull(emailAddressBank, emailAddLabelBank, "Required field!");
        boolean emailValidation = ATMValidation.emailFormat(emailAddressBank, emailAddLabelBank, "Format must be name@emailaddress.com");

        boolean password = ATMValidation.textFieldIsNull(passwordBank, passwordLabelBank, "Required field!");
        boolean password2 = ATMValidation.textFieldIsNull(passwordBank2, passwordLabelBank2, "Required field!");
        boolean passwordMatcher = ATMValidation.isPasswordNotMatch(passwordBank, passwordBank2, passwordLabelBank2, "Password does not match");


        if (name || username || address || emailAdd || password || password2) {
            System.out.println("Please fill in the blanks and follow the required format");
        } else {
            if (alphabetName && emailValidation && passwordMatcher) {
                nameATMText = nameBank.getText();
                usernameATMText = usernameBank.getText();
                addressATMText = addressBank.getText();
                cardNumberATMText = cardNumberBank.getText();
                emailAddressATMText = emailAddressBank.getText();
                passwordATMText = passwordBank.getText();
                passwordATMText2 = passwordBank2.getText();


//        Convert na sa GSON para isend na sa API
                Gson gson = new Gson();
                FormFieldsATM formFields = new FormFieldsATM(nameATMText, usernameATMText, addressATMText, cardNumberATMText, emailAddressATMText, passwordATMText, passwordATMText2);
                String x = gson.toJson(formFields);


//        Establish HTTP Connection
                PostRequest postRequest = new PostRequest("http://localhost:8080/saveATMUser", x);
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
                        Parent root2 = FXMLLoader.load(getClass().getResource("../ui/login/atmUILogin.fxml"));
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

    public void loginBank(ActionEvent event) throws IOException {
        String usernameBankTextLogin = null;
        String passwordBankTextLogin = null;
        boolean username = ATMValidation.textFieldIsNull(usernameBankLogin, emailAddBankLabelLogin, "Required field!");
        boolean password = ATMValidation.textFieldIsNull(passwordBankLogin, passwordBankLabelLogin, "Invalid password");

        if (username || password) {
            System.out.println("Please fill in the blanks and follow the required format");
        } else {

            usernameBankTextLogin = usernameBankLogin.getText();
            passwordBankTextLogin = passwordBankLogin.getText();

            Gson gson = new Gson();
            FormFieldsATM formFields = new FormFieldsATM(usernameBankTextLogin, passwordBankTextLogin);
            String x = gson.toJson(formFields);


            //        Establish HTTP Connection
            PostRequest postRequest = new PostRequest("http://localhost:8080/getATMUser", x);
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
            } else if (responseCode == 405) {
                signFailedAlert405();
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

                //Pag successfull ung signUp balik sa app
                try {
                    Parent root2 = FXMLLoader.load(getClass().getResource("../ui/atm/atmUI.fxml"));
                    Scene scene = new Scene(root2);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(scene);
                    app_stage.show();


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                //New dashboard
            }

        }
    }

    // Jack en Poy Section

    @FXML
    public void onButtonClickJNP(ActionEvent event) throws URISyntaxException {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/jackenpoyUI.fxml"));
            Stage stage = new Stage();
            Image image = new Image(getClass().getResourceAsStream("../images/power1.png"));
            stage.getIcons().add(image);
            stage.setTitle("Jack En Poy");
            stage.setScene(new Scene(root1, 900, 690));
            stage.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void onButtonClickJNPGame(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/jackenpoyGameUI.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void onButtonClickJNPGameOne(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme1/jackenpoyGameUI.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void onButtonClickJNPGameTwo(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme2/jackenpoyGameUI.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void onButtonClickJNPGameThree(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme3/jackenpoyGameUI.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void onButtonClickJNPSettings(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/jackenpoySettings.fxml"));
            Scene scene = new Scene(root2);

            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void onButtonClickJNPSettingsOne(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme1/jackenpoySettings.fxml"));
            Scene scene = new Scene(root2);

            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void onButtonClickJNPSettingsTwo(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme2/jackenpoySettings.fxml"));
            Scene scene = new Scene(root2);

            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void onButtonClickJNPSettingsThree(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme3/jackenpoySettings.fxml"));
            Scene scene = new Scene(root2);

            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    public void onButtonClickJNPBack(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/jackenpoyUI.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void onButtonClickJNPBackOne(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme1/jackenpoyUI.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void onButtonClickJNPBackTwo(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme2/jackenpoyUI.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void onButtonClickJNPBackThree(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme3/jackenpoyUI.fxml"));
            Scene scene = new Scene(root2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @FXML
    public void onButtonClickJNPSound(ActionEvent event) {
        backgroundMusic();
        soundLabel.setText("On");
    }

    public void backgroundMusic() {
//        String musicFile = "muriel.wav";     // For example
//        Media sound = new Media(new File(musicFile).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();
    }

    public void themes(ActionEvent event) {
        boolean isTrue = true;
        int range = aJNP += 1;
        while (isTrue) {
            isTrue = false;

            switch (range) {
                case 1 -> {
                    try {
                        Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme1/jackenpoySettings.fxml"));
                        Scene scene = new Scene(root2);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(scene);
                        app_stage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme1/jackenpoyUI.fxml"));
                        Scene scene = new Scene(root2);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(scene);
                        app_stage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme1/jackenpoyGameUI.fxml"));
                        Scene scene = new Scene(root2);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(scene);
                        app_stage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme2/jackenpoySettings.fxml"));
                        Scene scene = new Scene(root2);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(scene);
                        app_stage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme2/jackenpoyUI.fxml"));
                        Scene scene = new Scene(root2);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(scene);
                        app_stage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme2/jackenpoyGameUI.fxml"));
                        Scene scene = new Scene(root2);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(scene);
                        app_stage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme3/jackenpoySettings.fxml"));
                        Scene scene = new Scene(root2);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(scene);
                        app_stage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme3/jackenpoyUI.fxml"));
                        Scene scene = new Scene(root2);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(scene);
                        app_stage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Parent root2 = FXMLLoader.load(getClass().getResource("../ui/jackenpoy/Themes/Theme3/jackenpoyGameUI.fxml"));
                        Scene scene = new Scene(root2);
                        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        app_stage.setScene(scene);
                        app_stage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            if (aJNP == 3) {
                aJNP = 0;
            }
        }

    }


    public void playerChoice(ActionEvent event) {
        String playerChoice = "";
        switch (((Button) event.getSource()).getId()) {
            case "onButtonClickRock" -> {
                image = new Image(getClass().getResourceAsStream("../images/empowerment.png"));
                playerChoice = ROCK;
            }
            case "onButtonClickPaper" -> {
                image = new Image(getClass().getResourceAsStream("../images/open-hand.png"));
                playerChoice = PAPER;
            }
            case "onButtonClickScissor" -> {
                image = new Image(getClass().getResourceAsStream("../images/peace.png"));
                playerChoice = SCISSOR;
            }
        }
        player.setImage(image);
        winner(playerChoice, computerChoice());
        roundStart();

    }

    public String computerChoice() {
        String computerChoice = null;
        int i = (int) (Math.random() * 3);

        switch (i) {
            case 0:
                image = new Image(getClass().getResourceAsStream("../images/empowerment.png"));
                computerChoice = ROCK;
                break;

            case 1:
                image = new Image(getClass().getResourceAsStream("../images/open-hand.png"));
                computerChoice = PAPER;
                break;


            case 2:
                image = new Image(getClass().getResourceAsStream("../images/peace.png"));
                computerChoice = SCISSOR;
                break;
        }
        computer.setImage(image);
        return computerChoice;
    }

    public void draw() {
        result.setText("Draw");
    }

    public void winComputer() {
        result.setText("Computer Wins!");
        computerScore.setText(String.valueOf(Integer.parseInt(computerScore.getText()) + 1));
    }

    public void winPlayer() {
        result.setText("Player Wins!");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) + 1));
    }

    public void roundStart() {
        round.setText(String.valueOf(Integer.parseInt(round.getText()) + 1));
    }

    public void numberOfRounds() {

    }


    public void winner(String playerChoice, String computerChoice) {

        if (playerChoice.equals(ROCK)) {
            if (computerChoice.equals(PAPER)) {
                winComputer();
            } else if (computerChoice.equals(ROCK)) {
                draw();
            } else {
                winPlayer();
            }
        } else if (playerChoice.equals(PAPER)) {
            if (computerChoice.equals(ROCK)) {
                winPlayer();
            } else if (computerChoice.equals(PAPER)) {
                draw();
            } else {
                winComputer();
            }
        } else {
            if (computerChoice.equals(PAPER)) {
                winPlayer();
            } else if (computerChoice.equals(SCISSOR)) {
                draw();
            } else {
                winComputer();
            }
        }

    }

//

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
