package com.mavriksc.socialmedia;

import com.mavriksc.socialmedia.domain.Role;
import com.mavriksc.socialmedia.domain.Tag;
import com.mavriksc.socialmedia.domain.TagType;
import com.mavriksc.socialmedia.domain.User;
import com.mavriksc.socialmedia.dto.FileDTO;
import com.mavriksc.socialmedia.repository.UserRepository;
import com.mavriksc.socialmedia.service.FileService;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
@Log
public class SocialMediaApplication {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository,
                                        FileService fileService,
                                        PasswordEncoder encoder) {
        //create default user and file
        return strings -> {
            if (userRepository.count() == 0) {
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
                log.info(String.format("created user %s", u.getUsername()));
                Set<Tag> t = Arrays.stream("stuff is great about this file".split(" "))
                        .map(s -> new Tag(s)).collect(Collectors.toSet());
                Set<Tag> ct = Arrays.stream("things.txt".split("[^\\w\\d]+"))
                        .map(s -> new Tag(s, TagType.CALCULATED)).collect(Collectors.toSet());
                ct.addAll(t);
                FileDTO file = new FileDTO();
                file.setFilename("things.txt");
                file.setTags(new ArrayList<>());
                file.getTags().addAll(ct);
                file.setOwner(u);
                fileService.saveFile(file);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaApplication.class, args);
    }
}
