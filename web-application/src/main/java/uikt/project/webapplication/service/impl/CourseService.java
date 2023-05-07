package uikt.project.webapplication.service.impl;

import org.springframework.stereotype.Service;
import uikt.project.webapplication.model.entities.courses.Course;
import uikt.project.webapplication.model.entities.users.Administrator;
import uikt.project.webapplication.model.entities.users.Instructor;
import uikt.project.webapplication.model.exceptions.ResourceNotFoundException;
import uikt.project.webapplication.repository.AdministratorRepository;
import uikt.project.webapplication.repository.CourseRepository;
import uikt.project.webapplication.repository.InstructorRepository;
import uikt.project.webapplication.service.inteface.ICourseService;

import java.time.LocalDate;
import java.util.List;

@Service
public class CourseService implements ICourseService {

    private CourseRepository courseRepository;
    private AdministratorRepository administratorRepository;
    private InstructorRepository instructorRepository;
    public CourseService(CourseRepository courseRepository, AdministratorRepository administratorRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.administratorRepository = administratorRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
    }

    @Override
    public Course updateCourse(Long courseId, Course courseDetails) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));

        course.setName(courseDetails.getName());
        course.setDescription(courseDetails.getDescription());
        course.setStartDate(courseDetails.getStartDate());
        course.setEndDate(courseDetails.getEndDate());
        course.setCreatedBy(courseDetails.getCreatedBy());
        course.setTaughtBy(courseDetails.getTaughtBy());

        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));

        courseRepository.delete(course);
    }

    @Override
    public Course createCourse(String name, String description, LocalDate startDate, LocalDate endDate, Long administratorId, Long instructorId, byte[] content, String fileName, String mimeType) {
        Administrator administrator = this.administratorRepository.findById(administratorId)
                .orElseThrow(() -> new ResourceNotFoundException("Administrator not found with id " + administratorId));
        Instructor instructor = this.instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id " + instructorId));

        Course newCourse = new Course(content,fileName,mimeType,name, description, startDate, endDate, administrator, instructor);

        return courseRepository.save(newCourse);

    }
}
