package es.ndc.api_movies.controllers;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import es.ndc.api_movies.entities.UserEntity;
import es.ndc.api_movies.models.PasswordUpdateDTO;
import es.ndc.api_movies.models.ResponseDTO;
import es.ndc.api_movies.models.UserDTO;
import es.ndc.api_movies.models.UserRolesDTO;
import es.ndc.api_movies.services.AuthService;
import es.ndc.api_movies.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserControllers {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public ResponseEntity<List<UserRolesDTO>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}/roles")
    public ResponseEntity<UserRolesDTO> getUserRoles(@PathVariable Long userId) {
        return userService.getUserRoles(userId);
    }

    @PatchMapping("/{userId}/name")
    public ResponseEntity<UserDTO> updateName(@PathVariable Long userId, @RequestBody String nameNew) {
        return userService.updateName(userId, nameNew);
    }

    @PatchMapping("/{userId}/email")
    public ResponseEntity<UserDTO> updateEmail(@PathVariable Long userId, @RequestBody String emailNew) {
        return userService.updateEmail(userId, emailNew);
    }

    @PatchMapping("/{userId}/password")
    public ResponseEntity<UserDTO> updatePassword(@PathVariable Long userId,
            @RequestBody PasswordUpdateDTO passwords) {
        return userService.updatePassword(userId, passwords);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseDTO> removeUser(@PathVariable Long userId) {
        return userService.removeUser(userId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable Long userId, @RequestBody UserEntity updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }
}
