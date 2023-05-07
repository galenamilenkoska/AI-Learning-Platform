package uikt.project.webapplication.service;

import uikt.project.webapplication.model.entities.base.Person;
import uikt.project.webapplication.model.entities.base.User;
import uikt.project.webapplication.model.enumerations.AcademicStatus;
import uikt.project.webapplication.model.exceptions.EmailOrUsernameAlreadyExistException;
import uikt.project.webapplication.model.exceptions.InvalidCredentialsException;
import uikt.project.webapplication.model.exceptions.PersonNotFoundException;

import javax.security.auth.login.LoginException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IUserService  {

    List<User> findAll();

    User save(User user);

    User findByEmail(String email) throws InvalidCredentialsException;

    User findByUsername(String username) throws InvalidCredentialsException;

    User findByPerson(Person person) throws PersonNotFoundException;

    public User login(String email, String password) throws LoginException, InvalidCredentialsException;

    User register(String username,
                  String email,
                  String password,
                  String repeatPassword,
                  String firstName,
                  String middleName,
                  String lastName,
                  LocalDate dateOfBirth,
                  AcademicStatus academicStatus) throws InvalidCredentialsException, EmailOrUsernameAlreadyExistException;


    Optional<User> checkIfExists(String username, String email) throws InvalidCredentialsException;
}
