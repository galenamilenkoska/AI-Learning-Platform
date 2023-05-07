package uikt.project.webapplication.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uikt.project.webapplication.model.entities.base.Person;
import uikt.project.webapplication.model.entities.base.User;
import uikt.project.webapplication.model.entities.users.Student;
import uikt.project.webapplication.model.enumerations.AcademicStatus;
import uikt.project.webapplication.model.enumerations.UserRole;
import uikt.project.webapplication.model.exceptions.InvalidCredentialsException;
import uikt.project.webapplication.model.exceptions.PersonNotFoundException;
import uikt.project.webapplication.repository.PersonRepository;
import uikt.project.webapplication.repository.UserRepository;
import uikt.project.webapplication.service.IUserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) throws InvalidCredentialsException {
        return userRepository.findByEmail(email).orElseThrow(InvalidCredentialsException::new);
    }

    @Override
    public User findByUsername(String username) throws InvalidCredentialsException {
        return userRepository.findByUsername(username).orElseThrow(InvalidCredentialsException::new);
    }

    @Override
    public User findByPerson(Person person) throws PersonNotFoundException {
        return userRepository.findByPerson(person).orElseThrow(() -> new PersonNotFoundException(person));
    }


    @Transactional
    @Override
    public User register(String username,
                         String email,
                         String password,
                         String repeatPassword,
                         String firstName,
                         String middleName,
                         String lastName,
                         LocalDate dateOfBirth,
                         AcademicStatus academicStatus) throws InvalidCredentialsException{

        if (!password.equals(repeatPassword)) {
            throw new InvalidCredentialsException();
        }
        if (checkIfExists(username, email).isPresent()) {
            throw new InvalidCredentialsException();
        }
        Person person = new Person(firstName, middleName, lastName, academicStatus, dateOfBirth);
        personRepository.save(person);
        Student student = new Student(username, passwordEncoder.encode(password), email,LocalDate.now(), LocalDate.now(), UserRole.STUDENT, person);
        userRepository.save(student);
        return student;
    }

    @Override
    public Optional<User> checkIfExists(String username, String email) throws InvalidCredentialsException {
        try {
            User byUsername = findByUsername(username);
            User byEmail = findByEmail(email);
            if (byUsername != null)
                return Optional.of(byUsername);
            else if (byEmail != null)
                return Optional.of(byEmail);
            else
                return Optional.empty();
        }
        catch (Exception e)
        {
            return Optional.empty();
        }

    }


    @Override
    public User login(String email, String password) throws InvalidCredentialsException {
        User user = findByEmail(email);
        if(passwordEncoder.matches(password, user.getPassword()))
            return user;
        throw new InvalidCredentialsException();

    }


}
