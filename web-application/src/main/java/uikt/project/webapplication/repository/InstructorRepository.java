package uikt.project.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uikt.project.webapplication.model.entities.users.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {

}