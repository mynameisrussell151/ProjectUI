package sample.validation;

public class FormFieldsATM {
    private String name;
    private String username;
    private String address;
    private String cardNumber;
    private String emailAddress;
    private String password;
    private String password2;

    public FormFieldsATM(String name, String username, String address, String cardNumber, String emailAddress, String password, String password2) {
        this.name = name;
        this.username = username;
        this.address = address;
        this.cardNumber = cardNumber;
        this.emailAddress = emailAddress;
        this.password = password;
        this.password2 = password2;
    }

    public FormFieldsATM(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
