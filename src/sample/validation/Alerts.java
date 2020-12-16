package sample.validation;

import java.io.IOException;
import java.net.URL;

public class Alerts {

    public String getSuccess() {
        return "You have successfully created your account";
    }

    public String getSuccessLogin() {
        return "Successfully login!";
    }

    public String getFailed400() {
        return "Unable to create an account! Please try again later";
    }

    public String getFailed400Login() {
        return "The request is invalid due to malformed syntax or invalid data";
    }



    public String getFailed401() {
        return "Incorrect email or password. Please try again!";
    }

    public String getFailed404() {
        return "The page might have been removed or is temporarily available";
    }

    public String getFailed500() {
        return "The server encountered an internal error or misconfiguration and was unable to complete your request";
    }

    public String getFailed502() {
        return "Bad Gateway!";
    }

    public String getFailed503() {
        return "The server is temporary unavailable and to service your request due to maintenance downtime or capacity problems. Please try again later!";
    }

    public String getFailed504() {
        return "Gateway Time-out";
    }







}
