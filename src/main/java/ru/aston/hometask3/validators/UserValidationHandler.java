package ru.aston.hometask3.validators;

import ru.aston.hometask.User;

public abstract class UserValidationHandler {
    protected UserValidationHandler next;

    public void setNext(UserValidationHandler next) {
        this.next = next;
    }

    public abstract void validate(User user) throws Exception;

    protected void validateNext(User user) throws Exception {
        if (next != null) {
            next.validate(user);
        }
    }
}
