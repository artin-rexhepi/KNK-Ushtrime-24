package model.dto;

public class ChangeUserPasswordDto {
    private String email;
    private String password;
    private String newPassword;
    private String confirmPassword;

    public ChangeUserPasswordDto(String email, String password, String newPassword, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
