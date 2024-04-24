package service;

import model.User;
import model.dto.*;
import repository.UserRepository;

public class UserService {

    public static boolean signUp(UserDto userData){
        String password = userData.getPassword();
        String confirmPassword = userData.getConfirmPassword();

        if(!password.equals(confirmPassword)){
            return false;
        }
        String salt = PasswordHasher.generateSalt();
        String passwordHash = PasswordHasher.generateSaltedHash(password,salt);

        CreateUserDto createUserData = new CreateUserDto(
                userData.getFirstName(),
                userData.getLastName(),
                userData.getEmail(),
                salt,
                passwordHash
        );

        return UserRepository.create(createUserData);
    }

    public static boolean login(LoginUserDto loginData){
        User user = UserRepository.getByEmail(loginData.getEmail());
        if (user == null){
            return false;
        }
        String password = loginData.getPassword();
        String salt = user.getSalt();
        String passwordHash = user.getPasswordHash();
        return PasswordHasher.compareSaltedHash(password, salt, passwordHash);
    }

    public static boolean updatePassword(ChangeUserPasswordDto changePassword){
        User user = UserRepository.getByEmail(changePassword.getEmail());
        if(user==null){
            return false;
        }
        String password = changePassword.getPassword();
        String updatePassword = changePassword.getNewPassword();
        String confirmPassword = changePassword.getConfirmPassword();
        if(password.equals(updatePassword)){
            return false;
        }
        if(!updatePassword.equals(confirmPassword)){
            return false;
        }
        String salt = PasswordHasher.generateSalt();
        String passwordHash = PasswordHasher.generateSaltedHash(updatePassword,salt);
        UpdateUserDto updateUser = new UpdateUserDto()
    }
}
