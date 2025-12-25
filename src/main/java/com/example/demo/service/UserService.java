// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.User;

// public interface UserService {

//     User registerUser(User user);

//     List<User> getAllUsers();

//     User getUser(Long id);

//     String userDelete(Long id);

//     User userUpdate(Long id, User user);
// }
package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;
@Service

public interface UserService {
    User registerUser(User user);
    User getUser(Long id);
    List<User> getAllUsers();
}
