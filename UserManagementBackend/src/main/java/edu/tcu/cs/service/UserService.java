package edu.tcu.cs.service;

import edu.tcu.cs.domain.User;
import edu.tcu.cs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(final String id) {
        return userRepository.findById(id).get();
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User product) {
        return userRepository.save(product);
    }
}
