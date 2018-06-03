package com.mavriksc.socialmedia;

import com.mavriksc.socialmedia.domain.Role;
import com.mavriksc.socialmedia.domain.StoredFile;
import com.mavriksc.socialmedia.domain.User;
import com.mavriksc.socialmedia.repository.StoredFileRepository;
import com.mavriksc.socialmedia.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
@Log
public class SocialMediaApplication {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository,
                                        StoredFileRepository storedFileRepository,
                                        PasswordEncoder encoder){
        //create default user and file
        return strings->{
            if(userRepository.count()==0){
                Set<Role> roles = new HashSet<>();
                roles.add(new Role(Role.Roles.ADMIN));
                roles.add(new Role(Role.Roles.USER));
                User u = new User();
                u.setRoles(roles);
                u.setUsername("root");
                u.setPassword(encoder.encode("password"));
                u.setEnabled(true);
                u.setExpired(false);
                u.setLocked(false);
                u.setExpiredCreds(false);
                u = userRepository.save(u);
                log.info(String.format("created user %s",u.getUsername()));
                StoredFile sf = new StoredFile();
                sf.setFilename("things.txt");
                sf.setOwner(u);
                sf.setUuid(UUID.randomUUID());
                sf.setTags("things stuff");
                storedFileRepository.save(sf);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaApplication.class, args);
    }
}
