package tech.baseblocks.dataencryption.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import tech.baseblocks.dataencryption.model.User;

import java.util.Optional;

public interface UserRepository extends RevisionRepository<User, Long, Integer>, CrudRepository<User, Long> {

    Optional<User> findByToken(String token);
}
