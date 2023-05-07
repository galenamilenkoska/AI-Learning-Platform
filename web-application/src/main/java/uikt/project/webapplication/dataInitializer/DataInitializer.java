package uikt.project.webapplication.dataInitializer;


import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;
import uikt.project.webapplication.model.entities.base.Person;
import uikt.project.webapplication.model.entities.base.User;
import uikt.project.webapplication.model.entities.courses.Course;
import uikt.project.webapplication.model.entities.users.Administrator;
import uikt.project.webapplication.model.entities.users.Instructor;
import uikt.project.webapplication.model.enumerations.AcademicStatus;
import uikt.project.webapplication.model.enumerations.UserRole;
import uikt.project.webapplication.repository.*;

import java.time.LocalDate;

@Component
@Getter
public class DataInitializer {

    private CourseRepository courseRepository;
    private PersonRepository personRepository;
    private UserRepository userRepository;
    private AdministratorRepository administratorRepository;
    private InstructorRepository instructorRepository;

    public DataInitializer(CourseRepository courseRepository, PersonRepository personRepository, UserRepository userRepository, AdministratorRepository administratorRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.personRepository = personRepository;
        this.userRepository = userRepository;
        this.administratorRepository = administratorRepository;
        this.instructorRepository = instructorRepository;
    }


    @PostConstruct
    public void initData() {
        // Create a Person
        Person person = new Person("John", null, "Doe", AcademicStatus.DOCTORATE, LocalDate.of(1980, 1, 1));
        Person person2 = new Person("Jane", null, "Doe", AcademicStatus.DOCTORATE, LocalDate.of(1990, 1, 1));
        personRepository.save(person);
        personRepository.save(person2);

        // Create a User
        User user = new User("admin", "password1", "admin2@example.com", LocalDate.now(), LocalDate.now(), UserRole.ADMINISTRATOR, person);
        User user2 = new User("instructor", "password2", "instructor2@example.com", LocalDate.now(), LocalDate.of(2023, 6, 1), UserRole.PROFESSOR, person);

        // Create an Administrator
        Administrator administrator = new Administrator();
        administrator.setUsername(user.getUsername());
        administrator.setPassword(user.getPassword());
        administrator.setEmail(user.getEmail());
        administrator.setDateCreated(user.getDateCreated());
        administrator.setDateUpdated(user.getDateUpdated());
        administrator.setUserRole(user.getUserRole());
        administrator.setPerson(person);

        // Save the Administrator
        administratorRepository.save(administrator);

        // Create and save an Instructor
        Instructor instructor = new Instructor();
        instructor.setUsername(user2.getUsername());
        instructor.setPassword(user2.getPassword());
        instructor.setEmail(user2.getEmail());
        instructor.setDateCreated(user2.getDateCreated());
        instructor.setDateUpdated(user2.getDateUpdated());
        instructor.setUserRole(user2.getUserRole());
        instructor.setPerson(person2);
        instructor.setTeachingExperience(6);
        instructorRepository.save(instructor);

        // Create and save a course with the above administrator and instructor
        Course course1 = new Course("dd".getBytes(),"course1","d","Course 1", "Description 1", LocalDate.now(), LocalDate.now().plusDays(7), administrator, instructor);
        courseRepository.save(course1);

        // Create and save another course with the above administrator and instructor
        Course course2 = new Course("dsad".getBytes(),"course2","aa","Course 2", "Description 2", LocalDate.now().plusDays(14), LocalDate.now().plusDays(21), administrator, instructor);
        courseRepository.save(course2);

    }
}