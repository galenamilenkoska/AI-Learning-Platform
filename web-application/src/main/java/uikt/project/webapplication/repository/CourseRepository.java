package uikt.project.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uikt.project.webapplication.model.entities.courses.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {


}
