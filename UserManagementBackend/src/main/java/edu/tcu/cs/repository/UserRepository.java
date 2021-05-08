package edu.tcu.cs.repository;

import edu.tcu.cs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
