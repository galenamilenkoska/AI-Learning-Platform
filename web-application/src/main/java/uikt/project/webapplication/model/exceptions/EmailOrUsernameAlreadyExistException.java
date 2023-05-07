package uikt.project.webapplication.model.exceptions;

public class EmailOrUsernameAlreadyExistException extends Exception{
    public EmailOrUsernameAlreadyExistException(String usernameOrEmail)
    {
        super(String.format("Username or email %s already exists!", usernameOrEmail));
    }
}
