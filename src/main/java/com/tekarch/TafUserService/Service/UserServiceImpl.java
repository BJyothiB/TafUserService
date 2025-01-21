package com.tekarch.TafUserService.Service;


import com.tekarch.TafUserService.Models.User;
import com.tekarch.TafUserService.Repositories.UserRepository;
import com.tekarch.TafUserService.Service.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


        @Autowired
        private UserRepository userRepository;

        // Register a new user
        public User registerUser(User user) {
            return userRepository.save(user);
        }

    @Override
    public Object getUser(Long id) {
        return null;
    }


    // Get user details by ID
        public Optional<User> getUserById(Long userId) {
            return userRepository.findById(userId);
        }

        // Update user details
        public User updateUser(Long userId, User userDetails) {
            Optional<User> user = userRepository.findById(userId);
            if (user.isPresent()) {
                User existingUser = user.get();
                existingUser.setUsername(userDetails.getUsername());
                existingUser.setEmail(userDetails.getEmail());
                existingUser.setPhone(userDetails.getPhone());
                return userRepository.save(existingUser);
            }
            throw new RuntimeException("User not found");
        }
    }