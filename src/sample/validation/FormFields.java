package sample.validation;

public class FormFields {
    private String name;
    private String email;
    private String password;
    private String password_confirmation;

    public FormFields(String name, String emailAdd, String password, String password2) {
        this.name = name;
        this.email = emailAdd;
        this.password = password;
        this.password_confirmation = password2;
    }

    public FormFields(String emailAdd, String password) {
        this.email = emailAdd;
        this.password = password;
    }



}
