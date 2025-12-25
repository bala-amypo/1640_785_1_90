// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.User;

// @Repository
// public interface UserRepository extends JpaRepository<User,Long>{

// }

package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;

@Repository
public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findAll();
    User save(User user);
}
