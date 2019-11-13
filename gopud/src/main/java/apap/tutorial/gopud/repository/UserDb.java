package apap.tutorial.gopud.repository;

import apap.tutorial.gopud.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDb extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}
