package tech.baseblocks.dataencryption.repository;

import org.springframework.data.repository.CrudRepository;
import tech.baseblocks.dataencryption.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByToken(String token);
}
