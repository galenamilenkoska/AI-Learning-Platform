package uikt.project.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uikt.project.webapplication.model.entities.base.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

