package uikt.project.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uikt.project.webapplication.model.entities.base.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {


}