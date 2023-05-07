package uikt.project.webapplication.service.inteface;

import uikt.project.webapplication.model.entities.courses.Course;

import java.time.LocalDate;
import java.util.List;

public interface ICourseService {

    List<Course> getAllCourses();

    Course getCourseById(Long courseId);

    Course updateCourse(Long courseId, Course courseDetails);

    void deleteCourse(Long courseId);
    Course createCourse(String name, String description, LocalDate startDate, LocalDate endDate, Long administratorId, Long instructorId, byte[] content, String fileName, String mimeType);


}