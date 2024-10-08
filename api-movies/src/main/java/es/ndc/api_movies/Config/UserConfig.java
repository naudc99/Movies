package es.ndc.api_movies.Config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import es.ndc.api_movies.entities.RoleEntity;
import es.ndc.api_movies.entities.UserEntity;
import es.ndc.api_movies.repositories.RoleRepository;
import es.ndc.api_movies.repositories.UserRepository;

@Component
public class UserConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository) {
        return args -> {
            Optional<RoleEntity> adminRoleOpt = roleRepository.findByName("ADMIN");
            RoleEntity adminRole;
            if (adminRoleOpt.isEmpty()) {
                adminRole = new RoleEntity("ADMIN");
                roleRepository.save(adminRole);
            } else {
                adminRole = adminRoleOpt.get();
            }

            Optional<UserEntity> adminUserOpt = userRepository.findByName("admin");
            if (adminUserOpt.isEmpty()) {
                UserEntity adminUser = new UserEntity();
                adminUser.setName("admin");
                adminUser.setEmail("admin@example.com");
                adminUser.setPassword(passwordEncoder.encode("Admin@1234"));
                adminUser.setRole(adminRole);
                userRepository.save(adminUser);
            }
        };
    }
}
