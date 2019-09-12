package pl.miningportal.form;

import lombok.Data;

@Data
public class RegisterForm {

    private String email;
    private String repeatEmail;

    private String nickname;

    private String password;
    private String repeatPassword;

}
