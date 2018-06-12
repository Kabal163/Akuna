package com.akuna.security.validation;

import com.akuna.security.entities.User;
import com.akuna.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator
{
    private static final int MIN_USERNAME_LENGTH = 8;
    private static final int MAX_USERNAME_LENGTH = 32;

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 32;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz)
    {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");

        if (user.getUsername().length() < MIN_USERNAME_LENGTH || user.getUsername().length() < MAX_USERNAME_LENGTH)
        {
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (userService.findByUsername(user.getUsername()) != null)
        {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if (user.getPassword().length() < MIN_PASSWORD_LENGTH || user.getPassword().length() < MAX_PASSWORD_LENGTH)
        {
            errors.rejectValue("password", "Size.userForm.Password");
        }

        if (!user.getPassword().equals(user.getConfirmPassword()))
        {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }

    }
}
