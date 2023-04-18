package uikt.project.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uikt.project.webapplication.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
