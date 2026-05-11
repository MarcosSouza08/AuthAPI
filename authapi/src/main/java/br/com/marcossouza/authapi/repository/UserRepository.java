package br.com.marcossouza.authapi.repository;

import br.com.marcossouza.authapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     Optional<User> findByEmail(String email);

}
