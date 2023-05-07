package uikt.project.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uikt.project.webapplication.model.entities.users.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator,Long> {


}