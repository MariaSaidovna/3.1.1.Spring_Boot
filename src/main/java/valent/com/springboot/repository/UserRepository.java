package valent.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valent.com.springboot.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(long id);
}